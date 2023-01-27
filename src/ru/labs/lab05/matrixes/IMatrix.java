package ru.labs.lab05.matrixes;

public interface IMatrix {
    int getRows();

    int getColumns();

    int getElement(final int row, final int column);

    void setElement(final int row, final int column, final int value);

    String toString();

    boolean equals(Object obj);
}
