package matrix;

import org.junit.Test;
import ru.vsu.cs.team4.math.matrix.Matrix4f;
import ru.vsu.cs.team4.math.utils.Utils;
import ru.vsu.cs.team4.math.vector.Vector4f;

import static org.junit.Assert.assertTrue;

public class Matrix4fTest {

    @Test
    public void testSum() {
        Matrix4f m1 = new Matrix4f(new float[] {2.0f, -1.0f, 5.0f, 3.0f,
                0.0f, 3.0f, -4.0f, -1.0f,
                7.0f, 8.0f, 9.0f, -2.0f,
                0.0f, -2.0f, 3.0f, 1.0f});
        Matrix4f m2 = new Matrix4f(new float[] {3.0f, -5.0f, 0.0f, 1.0f,
                1.0f, -2.0f, -1.0f, 0.0f,
                5.0f, -6.0f, 3.0f, -2.0f,
                -2.0f, -3.0f, 5.0f, 2.0f});
        Matrix4f mRes = m1.sum(m2);
        assertTrue(mRes.matrixEquals(new float[]{5.0f, -6.0f, 5.0f, 4.0f,
                1.0f, 1.0f, -5.0f, -1.0f,
                12.0f, 2.0f, 12.0f, -4.0f,
                -2.0f, -5.0f, 8.0f, 3.0f}));
    }


    @Test
    public void testSub() {
        Matrix4f m1 = new Matrix4f(new float[] {2.0f, -1.0f, 5.0f, 3.0f, 0.0f, 3.0f, -4.0f, -1.0f, 7.0f, 8.0f, 9.0f, -2.0f, 0.0f, -2.0f, 3.0f, 1.0f});
        Matrix4f m2 = new Matrix4f(new float[] {3.0f, -5.0f, 0.0f, 1.0f, 1.0f, -2.0f, -1.0f, 0.0f, 5.0f, -6.0f, 3.0f, -2.0f, -2.0f, -3.0f, 5.0f, 2.0f});
        Matrix4f mRes = m1.sub(m2);
        assertTrue(mRes.matrixEquals(new float[]{-1.0f, 4.0f, 5.0f, 2.0f, -1.0f, 5.0f, -3.0f, -1.0f, 2.0f, 14.0f, 6.0f, 0.0f, 2.0f, 1.0f, -2.0f, -1.0f}));
    }

    @Test
    public void testMul() {
        Matrix4f m1 = new Matrix4f(new float[] {2.0f, -1.0f, 5.0f, 3.0f, 0.0f, 3.0f, -4.0f, -1.0f, 7.0f, 8.0f, 9.0f, -2.0f, 0.0f, -2.0f, 3.0f, 1.0f});
        Matrix4f m2 = new Matrix4f(new float[] {3.0f, -5.0f, 0.0f, 1.0f, 1.0f, -2.0f, -1.0f, 0.0f, 5.0f, -6.0f, 3.0f, -2.0f, -2.0f, -3.0f, 5.0f, 2.0f});
        Matrix4f mRes = m1.mul(m2);
        assertTrue(mRes.matrixEquals(new float[]{24.0f, -47.0f, 31.0f, -2.0f, -15.0f, 21.0f, -20.0f, 6.0f, 78.0f, -99.0f, 9.0f, -15.0f, 11.0f, -17.0f, 16.0f, -4.0f}));
    }

    @Test
    public void testTrs() {
        Matrix4f m1 = new Matrix4f(new float[] {0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f});
        Matrix4f mRes = m1.trs();
        assertTrue(mRes.matrixEquals(new float[]{0.0f, 4.0f, 8.0f, 12.0f, 1.0f, 5.0f, 9.0f, 13.0f, 2.0f, 6.0f, 10.0f, 14.0f, 3.0f, 7.0f, 11.0f, 15.0f}));
    }

    @Test
    public void testMulVector() {
        Matrix4f m1 = new Matrix4f(new float[] {3.0f, -2.0f, 5.0f, 0.0f, 1.0f, -5.0f, 7.0f, -4.0f, -1.0f, -3.0f, 2.0f, 9.0f, -2.0f, 5.0f, -10.0f, 11.0f});
        Vector4f v = m1.mulV(new Vector4f(3.0f, -2.0f, 1.0f, 5.0f));
        assertTrue(Utils.epsEquals(18, v.getX()));
        assertTrue(Utils.epsEquals(0, v.getY()));
        assertTrue(Utils.epsEquals(50, v.getZ()));
        assertTrue(Utils.epsEquals(29, v.getW()));
    }

    @Test
    public void testDet() {
        Matrix4f m1 = new Matrix4f(new float[] {2.0f, -1.0f, 5.0f, 3.0f, 0.0f, 3.0f, -4.0f, -1.0f, 7.0f, 8.0f, 9.0f, -2.0f, 0.0f, -2.0f, 3.0f, 1.0f});
        assertTrue(Utils.epsEquals(31, m1.det()));
    }

    @Test
    public void testInverseMatrix() {
        Matrix4f m1 = new Matrix4f(new float[] {1.0f, 2.0f, 3.0f, 4.0f, 2.0f, 3.0f, 1.0f, 2.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 0.0f, -2.0f, -6.0f});
        Matrix4f mRes = m1.inverseMatrix();
        assertTrue(mRes.matrixEquals(new float[]{22.0f, -6.0f, -26.0f, 17.0f, -17.0f, 5.0f, 20.0f, -13.0f, -1.0f, 0.0f, 2.0f, -1.0f, 4.0f, -1.0f, -5.0f, 3.0f}));
    }
}
