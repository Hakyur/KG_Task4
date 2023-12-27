package vector;


import org.junit.Test;
import ru.vsu.cs.team4.math.utils.Utils;
import ru.vsu.cs.team4.math.vector.Vector3f;

import static org.junit.Assert.assertTrue;

public class Vector3fTest {

    @Test
    public void testSumVectors() {
        Vector3f v = new Vector3f(2.0f, 3.0f, -1.0f);
        Vector3f v1 = new Vector3f(-3.0f, 0.0f, -4.0f);
        v.sum(v1);
        assertTrue(Utils.equals(v, new Vector3f(-1.0f, 3.0f, -5.0f)));
    }

    @Test
    public void testStaticSumVectors() {
        Vector3f v = new Vector3f(5.0f, -4.0f, -2.0f);
        Vector3f v1 = new Vector3f(2.0f, 0.0f, -9.0f);
        Vector3f vRes = Vector3f.sum(v, v1);
        assertTrue(Utils.equals(vRes, new Vector3f(7.0f, -4.0f, -11.0f)));
    }


    @Test
    public void testSumWithValue() {
        Vector3f v = new Vector3f(2.0f, 0.0f, -5.0f);
        v.sum(4.0f);
        assertTrue(Utils.equals(v, new Vector3f(6.0f, 4.0f, -1.0f)));
    }

    @Test
    public void testStaticSumWithValue() {
        Vector3f v = new Vector3f(3.0f, -2.5f, 7.2f);
        Vector3f vRes = Vector3f.sum(v, -2.5f);
        assertTrue(Utils.equals(vRes, new Vector3f(0.5f, -5.0f, 4.7f)));
    }

    @Test
    public void testSubVectors() {
        Vector3f v = new Vector3f(0.0f, 4.0f, -2.0f);
        Vector3f v1 = new Vector3f(3.0f, 1.0f, -3.0f);
        v.sub(v1);
        assertTrue(Utils.equals(v, new Vector3f(-3.0f, 3.0f, 1.0f)));
    }

    @Test
    public void testStaticSubVectors() {
        Vector3f v = new Vector3f(0.0f, -9.0f, 5.0f);
        Vector3f v1 = new Vector3f(2.3f, -7.2f, -12.8f);
        Vector3f vRes = Vector3f.sub(v, v1);
        assertTrue(Utils.equals(vRes, new Vector3f(-2.3f, -1.8f, 17.8f)));
    }

    @Test
    public void testSubWithValue() {
        Vector3f v = new Vector3f(3.0f, 5.0f, -2.0f);
        v.sub(4.0f);
        assertTrue(Utils.equals(v, new Vector3f(-1.0f, 1.0f, -6.0f)));
    }

    @Test
    public void testStaticSubWithValue() {
        Vector3f v = new Vector3f(-2.3f, 0.7f, 9.6f);
        Vector3f vRes = Vector3f.sub(v, 2.8f);
        assertTrue(Utils.equals(vRes, new Vector3f(-5.1f, -2.1f, 6.8f)));
    }

    @Test
    public void testMulWithValue() {
        Vector3f v = new Vector3f(2.0f, -1.0f, 0.0f);
        v.mul(5.0f);
        assertTrue(Utils.equals(v, new Vector3f(10.0f, -5.0f, 0.0f)));
    }

    @Test
    public void testStaticMulWithValue() {
        Vector3f v = new Vector3f(4.0f, -3.5f, 3.6f);
        Vector3f vRes = Vector3f.mul(v, 2.0f);
        assertTrue(Utils.equals(vRes, new Vector3f(8.0f, -7.0f, 7.2f)));
        assertTrue(Utils.equals(v, new Vector3f(4.0f, -3.5f, 3.6f)));
    }

    @Test
    public void testDivOnValue() {
        Vector3f v = new Vector3f(0.0f, -2.0f, 3.0f);
        v.div(2.0f);
        assertTrue(Utils.equals(v, new Vector3f(0.0f, -1.0f, 1.5f)));
    }

    @Test
    public void testStaticDivWithValue() {
        Vector3f v = new Vector3f(-8.0f, -5.5f, 10.0f);
        Vector3f vRes = Vector3f.div(v, -4.0f);
        assertTrue(Utils.equals(vRes, new Vector3f(2.0f, 1.375f, -2.5f)));
        assertTrue(Utils.equals(v, new Vector3f(-8.0f, -5.5f, 10.0f)));
    }

    @Test
    public void testLength() {
        Vector3f v = new Vector3f(0.0f, -4.0f, 3.0f);
        assertTrue(Utils.epsEquals(5.0f, v.len()));
    }

    @Test
    public void testNormalize() {
        Vector3f v = new Vector3f(6.0f, 8.0f, 0.0f);
        v.normalize();
        assertTrue(Utils.equals(v, new Vector3f(0.6f, 0.8f, 0.0f)));
    }

    @Test
    public void testNormalizedVectorLength() {
        Vector3f v = new Vector3f(5.0f, -2.0f, 3.0f);
        v.normalize();
        assertTrue(Utils.epsEquals(1.0f, v.len()));
    }

    @Test
    public void testScalarMulVectors() {
        Vector3f v = new Vector3f(3.0f, 0.0f, 1.0f);
        Vector3f v1 = new Vector3f(-5.0f, 2.0f, 4.0f);
        assertTrue(Utils.epsEquals(-11.0f, v.scalarMul(v1)));
    }

    @Test
    public void testVectorMul() {
        Vector3f v = new Vector3f(1.0f, -2.0f, 4.0f);
        Vector3f v1 = new Vector3f(2.0f, 5.0f, -3.0f);
        Vector3f vRes = Vector3f.vectorMul(v, v1);
        assertTrue(Utils.equals(vRes, new Vector3f(-14.0f, 11.0f, 9.0f)));
    }
}