package ru.vsu.cs.team4.math.matrix;

public interface Matrix<T extends Matrix<T>> {

    T sum(T m);
    T sub(T m);
    T mul(T m);
    T trs();
    float det();
    T inverseMatrix();

}
