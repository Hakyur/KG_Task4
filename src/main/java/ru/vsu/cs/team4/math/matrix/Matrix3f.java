package ru.vsu.cs.team4.math.matrix;


import ru.vsu.cs.team4.math.utils.Utils;
import ru.vsu.cs.team4.math.vector.Vector3f;

public class Matrix3f implements Matrix<Matrix3f> {

    public static final int LENGTH = 9;
    public static final int MINOR_LENGTH = 4;
    private float[] values = new float[LENGTH];

    public Matrix3f(float[] values) {
        this.values = values.clone();
    }

    public Matrix3f() {}

    public static Matrix3f zeroMatrix() {
        return new Matrix3f();
    }

    public static Matrix3f identityMatrix() {
        return new Matrix3f(new float[] {1.0f, 0.0f, 0.0f,
                                         0.0f, 1.0f, 0.0f,
                                         0.0f, 0.0f, 1.0f});
    }

    public float[] getValues() {
        return values.clone();
    }

    public void setValues(float[] values) {
        this.values = values.clone();
    }

    @Override
    public Matrix3f sum(Matrix3f m) {
        Matrix3f resM = new Matrix3f(this.values.clone());
        for(int i = 0; i < LENGTH; i++) {
            resM.values[i] += m.values[i];
        }
        return resM;
    }

    public void sumMut(Matrix3f m) {
        for (int i = 0; i < LENGTH; i++) {
            this.values[i] += m.values[i];
        }
    }

    @Override
    public Matrix3f sub(Matrix3f m) {
        Matrix3f resM = new Matrix3f(this.values.clone());
        for (int i = 0; i < LENGTH; i++) {
            resM.values[i] -= m.values[i];
        }
        return resM;
    }

    public void subMut(Matrix3f m) {
        for (int i = 0; i < LENGTH; i++) {
            this.values[i] -= m.values[i];
        }
    }

    @Override
    public Matrix3f mul(Matrix3f m) {
        Matrix3f resM = new Matrix3f();
        int currRow = 0;
        int currCol = 0;
        for(int i = 0; i < LENGTH; i++) {
            if (i / 3 > currRow) {
                currRow++;
                currCol = 0;
            }
            resM.values[i] = this.values[currRow * 3] * m.values[currCol] + this.values[currRow * 3 + 1] * m.values[currCol + 3]
                    + this.values[currRow * 3 + 2] * m.values[currCol + 6];
            currCol++;
        }
        return resM;
    }

    public void mulMut(Matrix3f m) {
        int currRow = 0;
        int currCol = 0;
        float[] resValues = new float[LENGTH];
        for(int i = 0; i < LENGTH; i++) {
            if (i / 3 > currRow) {
                currRow++;
                currCol = 0;
            }
            resValues[i] = this.values[currRow * 3] * m.values[currCol] + this.values[currRow * 3 + 1] * m.values[currCol + 3]
                    + this.values[currRow * 3 + 2] * m.values[currCol + 6];
            currCol++;
        }
        this.setValues(resValues);
    }

    @Override
    public Matrix3f trs() {
        Matrix3f resM = new Matrix3f(this.values.clone());
        resM.swapElement(1, 3);
        resM.swapElement(2, 6);
        resM.swapElement(5, 7);
        return resM;
    }

    public void trsMul() {
        this.swapElement(1, 3);
        this.swapElement(2, 6);
        this.swapElement(5, 7);
    }

    public Vector3f mulV(Vector3f v) {
        float[] vectorValues = new float[3];
        int currRow = 0;
        for (int i = 0; i < LENGTH / 3; i++) {
            vectorValues[i] = this.values[currRow * 3] * v.getX() + this.values[currRow * 3 + 1] * v.getY() +
                    this.values[currRow * 3 + 2] * v.getZ();
            currRow++;
        }
        return new Vector3f(vectorValues);
    }

    @Override
    public float det() {
        return this.values[0] * this.values[4] * this.values[8] + this.values[1] * this.values[5] * this.values[6] +
                this.values[3] * this.values[7] * this.values[2] - this.values[2] * this.values[4] * this.values[6] -
                this.values[0] * this.values[5] * this.values[7] - this.values[3] * this.values[1] * this.values[8];
    }

    @Override
    public Matrix3f inverseMatrix() {
        float det = this.det();
        float[] resValues = new float[LENGTH];
        float[] minor;
        Matrix3f resMatrix = this.trs();
        for (int i = 0; i < LENGTH; i++) {
            int sign = i % 2 == 0 ? 1 : -1;
            minor = getMinor(resMatrix.getValues(), i);
            resValues[i] = 1 / det * sign * (minor[0] * minor[3] - minor[1] * minor[2]);
        }
        resMatrix.setValues(resValues);
        return resMatrix;
    }


    private static float[] getMinor(float[] matrix, float index) {
        float[] minor = new float[MINOR_LENGTH];
        int currNum = 0;
        int indexRow = (int) index / 3;
        int indexCol = (int) (index % 3);
        int currRow = 0;
        int currCol = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (i / 3 > currRow) {
                currRow++;
                currCol = 0;
            }
            if (currRow != indexRow && currCol != indexCol) {
                minor[currNum] = matrix[i];
                currNum++;
            }
            currCol++;

        }
        return minor;
    }


    public boolean matrixEquals(float[] values2) {
        for (int i = 0; i < LENGTH; i++) {
            if (!Utils.epsEquals(this.values[i], values2[i])) {
                return false;
            }
        }
        return true;
    }

    private void swapElement(int i1, int i2) {
        float num1 = this.values[i1];
        this.values[i1] = this.values[i2];
        this.values[i2] = num1;
    }
}
