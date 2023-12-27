package vector;


import org.junit.Test;
import ru.vsu.cs.team4.math.utils.Utils;
import ru.vsu.cs.team4.math.vector.Vector2f;

import static org.junit.Assert.assertTrue;

public class Vector2fTest {

    @Test
    public void testSumVectors() {
        Vector2f v = new Vector2f(2.0f, 3.0f);
        Vector2f v1 = new Vector2f(3.0f, -4.0f);
        v.sum(v1);
        assertTrue(Utils.equals(v, new Vector2f(5.0f, -1.0f)));
    }

    @Test
    public void testStaticSumVectors() {
        Vector2f v = new Vector2f(-5.0f, -7.0f);
        Vector2f v1 = new Vector2f(0.0f, 9.0f);
        Vector2f vRes = Vector2f.sum(v, v1);
        assertTrue(Utils.equals(vRes, new Vector2f(-5.0f, 2.0f)));
    }

    @Test
    public void testSumWithValue() {
        Vector2f v = new Vector2f(-1.0f, 0.0f);
        v.sum(5.0f);
        assertTrue(Utils.equals(v, new Vector2f(4.0f, 5.0f)));
    }

    @Test
    public void testStaticSumWithValue() {
        Vector2f v = new Vector2f(-5.0f, -7.0f);
        Vector2f vRes = Vector2f.sum(v, 3.0f);
        assertTrue(Utils.equals(vRes, new Vector2f(-2.0f, -4.0f)));
    }

    @Test
    public void testSubVectors() {
        Vector2f v = new Vector2f(5.0f, 4.0f);
        Vector2f v1 = new Vector2f(3.0f, 4.0f);
        v.sub(v1);
        assertTrue(Utils.equals(v, new Vector2f(2.0f, 0.0f)));
    }

    @Test
    public void testStaticSubVectors() {
        Vector2f v = new Vector2f(9.0f, -4.0f);
        Vector2f v1 = new Vector2f(3.0f, -5.0f);
        Vector2f vRes = Vector2f.sub(v, v1);
        assertTrue(Utils.equals(vRes, new Vector2f(6.0f, 1.0f)));
    }

    @Test
    public void testSubWithValue() {
        Vector2f v = new Vector2f(3.0f, 5.0f);
        v.sub(4.0f);
        assertTrue(Utils.equals(v, new Vector2f(-1.0f, 1.0f)));
    }

    @Test
    public void testStaticSubWithValue() {
        Vector2f v = new Vector2f(-10.0f, -3.0f);
        Vector2f vRes = Vector2f.sub(v, 7.0f);
        assertTrue(Utils.equals(vRes, new Vector2f(-17.0f, -10.0f)));
        assertTrue(Utils.equals(v, new Vector2f(-10.0f, -3.0f)));
    }

    @Test
    public void testMulWithValue() {
        Vector2f v = new Vector2f(2.0f, -1.0f);
        v.mul(3.0f);
        assertTrue(Utils.equals(v, new Vector2f(6.0f, -3.0f)));
    }

    @Test
    public void testStaticMulWithValue() {
        Vector2f v = new Vector2f(-2.0f, 4.0f);
        Vector2f vRes = Vector2f.mul(v, 3.0f);
        assertTrue(Utils.equals(vRes, new Vector2f(-6.0f, 12.0f)));
        assertTrue(Utils.equals(v, new Vector2f(-2.0f, 4.0f)));
    }

    @Test
    public void testDivOnValue() {
        Vector2f v = new Vector2f(6.0f, -2.0f);
        v.div(-2.0f);
        assertTrue(Utils.equals(v, new Vector2f(-3.0f, 1.0f)));
    }

    @Test
    public void testStaticDivOnValue() {
        Vector2f v = new Vector2f(-8.0f, 5.0f);
        Vector2f vRes = Vector2f.div(v, 4.0f);
        assertTrue(Utils.equals(vRes, new Vector2f(-2.0f, 1.25f)));
        assertTrue(Utils.equals(v, new Vector2f(-8.0f, 5.0f)));
    }

    @Test
    public void testLength() {
        Vector2f v = new Vector2f(3.0f, -4.0f);
        assertTrue(Utils.epsEquals(5.0f, v.len()));
    }

    @Test
    public void testNormalize() {
        Vector2f v = new Vector2f(3.0f, -4.0f);
        v.normalize();
        assertTrue(Utils.equals(v, new Vector2f(0.6f, -0.8f)));
    }

    @Test
    public void testNormalizedVectorLength() {
        Vector2f v = new Vector2f(5.0f, -2.0f);
        v.normalize();
        assertTrue(Utils.epsEquals(1.0f, v.len()));
    }

    @Test
    public void testScalarMulVectors() {
        Vector2f v = new Vector2f(3.0f, 0.0f);
        Vector2f v1 = new Vector2f(-5.0f, 2.0f);
        assertTrue(Utils.epsEquals(-15.0f, v.scalarMul(v1)));
    }
}
