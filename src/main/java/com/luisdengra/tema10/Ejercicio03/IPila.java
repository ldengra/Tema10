package com.luisdengra.tema10.Ejercicio03;

public interface IPila<T> {

    T push(T e);
    T pop();
    int size();
    T top();
    boolean isEmpty();
}
