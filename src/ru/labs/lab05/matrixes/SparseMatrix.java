package ru.labs.lab05.matrixes;

import ru.labs.lab05.cachedlist.CachedList;
import ru.labs.lab05.cachedlist.CachedListElement;
// Sparse matrix based on LinkedList



public class SparseMatrix extends Matrix {
    private final CachedList<CachedList<Integer>> matrix;
    private final int rows;
    private final int columns;

    public SparseMatrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new MatrixException("Matrix size is incorrect");
        }

        this.rows = rows;
        this.columns = columns;
        this.matrix = new CachedList<>(rows);
    }


    protected Matrix createMatrix(int rows, int columns) {
        return new SparseMatrix(rows, columns);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


    public int getElement(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new MatrixException("Matrix index is incorrect");
        }

        CachedListElement<CachedList<Integer>> rowList = matrix.get(row);
        if (rowList == null) {
            return 0;
        }

        CachedListElement<Integer> columnElement = rowList.getElement().get(column);
        if (columnElement == null) {
            return 0;
        }

        return columnElement.getElement();
    }


    public void setElement(final int row, final int column, int value) {


        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new MatrixException("Matrix index is incorrect");
        }

        CachedListElement<CachedList<Integer>> CachedRow = matrix.setOrCreateCursor(row);
        // Check if row does not exist - create it
        if (CachedRow.getElement() == null) {
            CachedRow.setElement(new CachedList<>(columns));
        }
        CachedListElement<Integer> CachedElement = CachedRow.getElement().setOrCreateCursor(column);
        CachedElement.setElement(value);
    }

//    public String toString() {
//        StringBuilder result = new StringBuilder();
//        // from linked list
//        for (SparseMatrixElement element : matrix) {
//            result.append(element.getValue());
//            result.append(" ");
//
//            if (element.getColumn() == columns - 1) {
//                result.append("\n");
//            }
//        }
//
//        return result.toString();
//    }

    public SparseMatrix sum(final SparseMatrix matrix) {
        return (SparseMatrix) super.sum(matrix);
    }

    public SparseMatrix product(final SparseMatrix matrix) {
        return (SparseMatrix) super.product(matrix);
    }

}