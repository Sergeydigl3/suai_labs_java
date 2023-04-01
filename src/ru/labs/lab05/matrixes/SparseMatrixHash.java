package ru.labs.lab05.matrixes;

// Сделать SparseMatrix на HashMap<Element, int> (class Element { int i, int j})
import java.util.HashMap;

public class SparseMatrixHash extends Matrix {

    private HashMap<Element, Integer> elements;

    private final int rows;
    private final int columns;

    public SparseMatrixHash(int rows, int columns) {
        this.elements = new HashMap<>();
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    protected Matrix createMatrix(int rows, int columns) {
        return new SparseMatrix(rows, columns);
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getElement(int row, int column) {
        Element element = new Element(row, column);
        return elements.getOrDefault(element, 0);
    }

    @Override
    public void setElement(int row, int column, int value) {
        Element element = new Element(row, column);
        elements.put(element, value);
    }

    private record Element(int row, int column) {

        @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Element other)) {
                    return false;
                }
                return this.row == other.row && this.column == other.column;
            }

    }
}
