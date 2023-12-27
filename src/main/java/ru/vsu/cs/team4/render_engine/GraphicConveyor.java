package ru.vsu.cs.team4.render_engine;

import ru.vsu.cs.team4.math.matrix.Matrix4f;
import ru.vsu.cs.team4.math.vector.Vector3f;

public class GraphicConveyor {

    public static Matrix4f rotateScaleTranslate(Vector3f scaleV, Vector3f rotateV, Vector3f translateV) {
        return Affine.translate(translateV).mul(Affine.scale(scaleV)).mul(Affine.rotate(rotateV));
    }

    public static Matrix4f lookAt(Vector3f eye, Vector3f target) {
        return lookAt(eye, target, new Vector3f(0F, 1.0F, 0F));
    }

    public static Matrix4f lookAt(Vector3f eye, Vector3f target, Vector3f up) {

        Vector3f resultZ = Vector3f.sub(target, eye);
        Vector3f resultX = Vector3f.vectorMul(up, resultZ);
        Vector3f resultY = Vector3f.vectorMul(resultZ, resultX);

        resultX.normalize();
        resultY.normalize();
        resultZ.normalize();

        float[] matrix = new float[]{
                resultX.getX(), resultY.getX(), resultZ.getX(),  -resultX.scalarMul(eye),
                resultX.getY(), resultY.getY(), resultZ.getY(), -resultY.scalarMul(eye),
                resultX.getZ(), resultY.getZ(), resultZ.getZ(), -resultZ.scalarMul(eye),
                0, 0, 0, 1};
        return new Matrix4f(matrix);
    }

    public static Matrix4f perspective(
            final float fov,
            final float aspectRatio,
            final float nearPlane,
            final float farPlane) {
        float tangentMinusOnDegree = (float) (1.0F / (Math.tan(fov * 0.5F)));
        return new Matrix4f(new float[] {
            tangentMinusOnDegree / aspectRatio, 0, 0, 0,
                0, tangentMinusOnDegree, 0, 0,
                0, 0, (farPlane + nearPlane) / (farPlane - nearPlane), 2 * farPlane * nearPlane / (nearPlane - farPlane),
                0, 0, 1, 0
        });
    }

}
