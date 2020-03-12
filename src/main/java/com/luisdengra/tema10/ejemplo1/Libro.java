package com.luisdengra.tema10.ejemplo1;

import java.util.Comparator;

public class Libro implements Comparable<Libro> {


    private String titulo;
    private int paginas;
    private int isbn;

    public Libro(String titulo, int paginas, int isbn) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public int getIsbn() {
        return isbn;
    }


    @Override
    public int compareTo(Libro libro) {
        return this.titulo.compareTo(libro.getTitulo());
    }

    public static class ComparatorIsbn implements Comparator<Libro>{

        @Override
        public int compare(Libro l1, Libro l2) {
            return l1.getIsbn() - l2.getIsbn();
        }
    }

    public static class ComparatorPaginas implements Comparator<Libro>{

        @Override
        public int compare(Libro l1, Libro l2) {
            return l1.getPaginas() - l2.getPaginas();
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", paginas=" + paginas +
                ", isbn=" + isbn +
                '}' + "\n";
    }
}
