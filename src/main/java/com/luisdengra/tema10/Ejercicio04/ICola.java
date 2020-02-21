package com.luisdengra.tema10.Ejercicio04;

public interface ICola<T> {
    void add(T e);
    T remove();
    int size();
    T peek();
    boolean isEmpty();
}
