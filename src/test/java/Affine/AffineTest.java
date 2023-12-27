package Affine;

import org.junit.Test;
import ru.vsu.cs.team4.math.matrix.Matrix3f;
import ru.vsu.cs.team4.math.matrix.Matrix4f;
import ru.vsu.cs.team4.math.utils.Utils;
import ru.vsu.cs.team4.math.vector.Vector3f;
import ru.vsu.cs.team4.render_engine.Affine;

import static org.junit.Assert.assertTrue;

public class AffineTest {

    @Test
    public void rotateTest1() {
        Vector3f vector3f = new Vector3f(0, 0, 0);
        Matrix4f expected = new Matrix4f(new float[] {
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        });
        assertTrue(Utils.equals(Affine.rotate(vector3f), expected));
    }

    @Test
    public void rotateTest2() {
        Vector3f vector3f = new Vector3f(360, 360, 360);
        Matrix4f expected = new Matrix4f(new float[] {
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        });
        assertTrue(Utils.equals(Affine.rotate(vector3f), expected));
    }

    @Test
    public void rotateTest3() {
        Vector3f vector3f = new Vector3f(180, 180, 180);
        Matrix4f expected = new Matrix4f(new float[] {
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        });
        assertTrue(Utils.equals(Affine.rotate(vector3f), expected));
    }

    @Test
    public void rotateTest4() {
        Vector3f vector3f = new Vector3f(-180, -180, -180);
        Matrix4f expected = new Matrix4f(new float[] {
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        });
        assertTrue(Utils.equals(Affine.rotate(vector3f), expected));
    }

    @Test
    public void scaleTest1() {
        Vector3f vector3f = new Vector3f(0, 0, 0);
        Matrix4f expected = new Matrix4f(new float[] {
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 1
        });
        assertTrue(Utils.equals(Affine.scale(vector3f), expected));
    }

    @Test
    public void scaleTest2() {
        Vector3f vector3f = new Vector3f(3, -5, 2);
        Matrix4f expected = new Matrix4f(new float[] {
                3, 0, 0, 0,
                0, -5, 0, 0,
                0, 0, 2, 0,
                0, 0, 0, 1
        });
        assertTrue(Utils.equals(Affine.scale(vector3f), expected));
    }

    @Test
    public void scaleTest3() {
        Vector3f vector3f = new Vector3f(-0.2f, 0.1f, 3.0f);
        Matrix4f expected = new Matrix4f(new float[] {
                -0.2f, 0, 0, 0,
                0, 0.1f, 0, 0,
                0, 0, 3.0f, 0,
                0, 0, 0, 1
        });
        assertTrue(Utils.equals(Affine.scale(vector3f), expected));
    }

    @Test
    public void translateTest1() {
        Vector3f vector3f = new Vector3f(0.0f, 0.0f, 0.0f);
        Matrix4f expected = new Matrix4f(new float[] {
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        });
        assertTrue(Utils.equals(Affine.translate(vector3f), expected));
    }

    @Test
    public void translateTest2() {
        Vector3f vector3f = new Vector3f(1.5f, -0.2f, -3.0f);
        Matrix4f expected = new Matrix4f(new float[] {
                1, 0, 0, 1.5f,
                0, 1, 0, -0.2f,
                0, 0, 1, -3.0f,
                0, 0, 0, 1
        });
        assertTrue(Utils.equals(Affine.translate(vector3f), expected));
    }
}
