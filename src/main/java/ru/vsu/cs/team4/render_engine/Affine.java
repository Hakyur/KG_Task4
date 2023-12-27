package ru.vsu.cs.team4.render_engine;

import ru.vsu.cs.team4.math.matrix.Matrix4f;
import ru.vsu.cs.team4.math.vector.Vector3f;

public class Affine {

    public static Matrix4f scale(Vector3f scaleV) {
        return new Matrix4f(new float[] {
                scaleV.getX(), 0, 0, 0,
                0, scaleV.getY(), 0, 0,
                0, 0, scaleV.getZ(), 0,
                0, 0, 0, 1
        });
    }

    public static Matrix4f rotate(Vector3f rotateV) {
        float thetaX = (float) Math.toRadians(rotateV.getX());
        float thetaY = (float) Math.toRadians(rotateV.getY());
        float thetaZ = (float) Math.toRadians(rotateV.getZ());
        float sinX = (float) Math.sin(thetaX);
        float cosX = (float) Math.cos(thetaX);
        float sinY = (float) Math.sin(thetaY);
        float cosY = (float) Math.cos(thetaY);
        float sinZ = (float) Math.sin(thetaZ);
        float cosZ = (float) Math.cos(thetaZ);

        return new Matrix4f(new float[] {
                cosY * cosZ, -1 * sinZ * cosY, sinY, 0,
                sinX * sinY * cosZ + sinZ * cosX, -1 * sinX * sinY * sinZ + cosX * cosZ, -1 * sinX * cosY, 0,
                sinX * sinZ - sinY * cosX * cosZ, sinX * cosZ + sinY * sinZ * cosX, cosX * cosY, 0,
                0, 0, 0, 1
        });
    }

    public static Matrix4f translate(Vector3f translateV) {
        return new Matrix4f(new float[] {
                1, 0, 0, translateV.getX(),
                0, 1, 0, translateV.getY(),
                0, 0, 1, translateV.getZ(),
                0, 0, 0, 1
        });
    }


}
