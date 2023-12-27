package ru.vsu.cs.team4.math.matrix;


import ru.vsu.cs.team4.math.utils.Utils;
import ru.vsu.cs.team4.math.vector.Vector4f;

public class Matrix4f implements Matrix<Matrix4f>{

    public static final int LENGTH = 16;
    public static final int MINOR_LENGTH = 9;
    private float[] values = new float[LENGTH];

    public Matrix4f(float[] values) {
        this.values = values.clone();
    }

    public Matrix4f(Matrix4f matrix4f) {
        this.values = matrix4f.getValues();
    }

    public Matrix4f() {}

    public static Matrix4f zeroMatrix() {
        return new Matrix4f();
    }

    public static Matrix4f identityMatrix() {
        return new Matrix4f(new float[] {1.0f, 0.0f, 0.0f, 0.0f,
                                         0.0f, 1.0f, 0.0f, 0.0f,
                                         0.0f, 0.0f, 1.0f, 0.0f,
                                         0.0f, 0.0f, 0.0f, 1.0f});
    }

    public float[] getValues() {
        return values.clone();
    }

    public void setValues(float[] values) {
        this.values = values.clone();
    }

    @Override
    public Matrix4f sum(Matrix4f m) {
        Matrix4f resM = new Matrix4f(this.values.clone());
        for (int i = 0; i < LENGTH; i++) {
            resM.values[i] += m.values[i];
        }
        return resM;
    }

    public void sumMut(Matrix4f m) {
        for (int i = 0; i < LENGTH; i++) {
            this.values[i] += m.values[i];
        }
    }

    @Override
    public Matrix4f sub(Matrix4f m) {
        Matrix4f resM = new Matrix4f(this.values.clone());
        for (int i = 0; i < LENGTH; i++) {
            resM.values[i] -= m.values[i];
        }
        return resM;
    }

    public void subMut(Matrix4f m) {
        for (int i = 0; i < LENGTH; i++) {
            this.values[i] -= m.values[i];
        }
    }

    @Override
    public Matrix4f mul(Matrix4f m) {
        Matrix4f resM = new Matrix4f();
        int currRow = 0;
        int currCol = 0;
        for(int i = 0; i < LENGTH; i++) {
            if (i / 4 > currRow) {
                currRow++;
                currCol = 0;
            }
            resM.values[i] = this.values[currRow * 4] * m.values[currCol] + this.values[currRow * 4 + 1] * m.values[currCol + 4]
                    + this.values[currRow * 4 + 2] * m.values[currCol + 8] + this.values[currRow * 4 + 3] * m.values[currCol + 12];
            currCol++;
        }
        return resM;
    }

    public void mulMut(Matrix4f m) {
        int currRow = 0;
        int currCol = 0;
        float[] resValues = new float[LENGTH];
        for(int i = 0; i < LENGTH; i++) {
            if (i / 4 > currRow) {
                currRow++;
                currCol = 0;
            }
            resValues[i] = this.values[currRow * 4] * m.values[currCol] + this.values[currRow * 4 + 1] * m.values[currCol + 4]
                    + this.values[currRow * 4 + 2] * m.values[currCol + 8] + this.values[currRow * 4 + 3] * m.values[currCol + 12];
            currCol++;
        }
        this.setValues(resValues);
    }

    @Override
    public Matrix4f trs() {
        Matrix4f resM = new Matrix4f(this.values.clone());
        resM.swapElement(1, 4);
        resM.swapElement(2, 8);
        resM.swapElement(3, 12);
        resM.swapElement(6, 9);
        resM.swapElement(7, 13);
        resM.swapElement(11, 14);
        return resM;
    }

    public void trsMut() {
        swapElement(1, 4);
        swapElement(2, 8);
        swapElement(3, 12);
        swapElement(6, 9);
        swapElement(7, 13);
        swapElement(11, 14);
    }

    public Vector4f mulV(Vector4f v) {
        float[] vectorValues = new float[4];
        int currRow = 0;
        for (int i = 0; i < LENGTH / 4; i++) {
            vectorValues[i] = this.values[currRow * 4] * v.getX() + this.values[currRow * 4 + 1] * v.getY() +
                    this.values[currRow * 4 + 2] * v.getZ() + this.values[currRow * 4 + 3] * v.getW();
            currRow++;
        }
        return new Vector4f(vectorValues);
    }

    @Override
    public float det() {
        float det = 0;
        for (int i = 0; i < 4; i++) {
            Matrix3f minor = new Matrix3f(getMinor(this.values.clone(), i));
            int sign = i % 2 == 0 ? 1 : -1;
            det += this.values[i] * sign * minor.det();
        }
        return det;
    }

    @Override
    public Matrix4f inverseMatrix() {
        float det = this.det();
        float[] resValues = new float[LENGTH];
        Matrix3f minor = new Matrix3f();
        Matrix4f resMatrix = this.trs();
        for (int i = 0; i < LENGTH; i++) {
            int sign = (i / 4 + i % 4) % 2 == 0 ? 1 : -1;
            minor.setValues(getMinor(resMatrix.getValues(), i));
            resValues[i] = 1 / det * sign * minor.det();
        }
        resMatrix.setValues(resValues);
        return resMatrix;
    }

    private static float[] getMinor(float[] matrix, float index) {
        float[] minor = new float[MINOR_LENGTH];
        int currNum = 0;
        int indexRow = (int) index / 4;
        int indexCol = (int) (index % 4);
        int currRow = 0;
        int currCol = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (i / 4 > currRow) {
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
