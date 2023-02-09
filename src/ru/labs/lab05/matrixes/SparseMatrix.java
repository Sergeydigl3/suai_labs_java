package ru.labs.lab05.matrixes;

import ru.labs.lab05.cachedlist.CachedList;
// Sparse matrix based on LinkedList

class SparseMatrixElement {
    private final int position;
    public int value;

    public SparseMatrixElement(int position) {
        this.position = position;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPosition() {
        return position;
    }
}

class ColumnsCache extends CachedList<SparseMatrixElement> {
    private int row;

    public ColumnsCache(int row, int size) {
        super(size);
        this.row = row;
    }

    public int getPosition() {
        return row;
    }

    public SparseMatrixElement createElement(int position) {
        return new SparseMatrixElement(row, position);
    }
}

class RowsCache extends CachedList<ColumnsCache> {
    public RowsCache(int size) {
        super(size);
    }

    public ColumnsCache createElement(int position) {
        return new ColumnsCache(position, size);
    }
}

public class SparseMatrix extends Matrix {
    private final RowsCache matrix;
    private int rows;
    private int columns;

    public SparseMatrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new MatrixException("Matrix size is incorrect");
        }

        this.rows = rows;
        this.columns = columns;
        this.matrix = new ColumnCache(columns, rows);
    }

//    public SparseMatrix(SparseMatrix matrix) {
//        this.matrix = matrix.getMatrix();
//        this.rows = matrix.getRows();
//        this.columns = matrix.getColumns();
//
//        this.setCache.iterator = this.matrix.listIterator();
//        this.setCache.row = -1;
//        this.setCache.column = -1;
//
//        this.getCache.iterator = this.matrix.listIterator();
//        this.getCache.row = -1;
//        this.getCache.column = -1;
//    }

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

        if (getCache.iterator == null) {
            getCache.iterator = matrix.listIterator();
            getCache.row = -1;
            getCache.column = -1;
        }

        if (getCache.row == row && getCache.column == column) {
            return getCache.iterator.next().getValue();
        }

        // If rows and columns lower than cache go forward, else backward
        if (getCache.row < row || (getCache.row == row && getCache.column < column)) {
            while (getCache.iterator.hasNext()) {
                SparseMatrixElement element = getCache.iterator.next();
                if (element.getRow() == row && element.getColumn() == column) {
                    getCache.row = row;
                    getCache.column = column;
                    return element.getValue();
                }
                if (element.getRow() > row || (element.getRow() == row && element.getColumn() > column)) {
                    break;
                }
            }
        } else {
            while (getCache.iterator.hasPrevious()) {
                SparseMatrixElement element = getCache.iterator.previous();
                if (element.getRow() == row && element.getColumn() == column) {
                    getCache.row = row;
                    getCache.column = column;
                    return element.getValue();
                }
                if (element.getRow() < row || (element.getRow() == row && element.getColumn() < column)) {
                    break;
                }
            }
        }

        return 0;
    }


//    public LinkedList<SparseMatrixElement> getMatrix() {
//        return matrix;
//    }

    public void setElement(final int row, final int column, int value) {
        if (value == 0) {
            return;
        }

        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new MatrixException("Matrix index is incorrect");
        }

        if (setCache.iterator == null) {
            matrix.addLast(new SparseMatrixElement(row, column, value));
            setCache.iterator = matrix.listIterator();
            setCache.row = row;
            setCache.column = column;
            getCache.iterator = matrix.listIterator();
            getCache.row = row;
            getCache.column = column;
            return;
        }

        if (setCache.row == row && setCache.column == column) {
            setCache.iterator.next().setValue(value);
            return;
        }


        // If rows and columns lower than cache go forward, else backward
        // if element is not found, add it in the right place with "add"
        if (setCache.row < row || (setCache.row == row && setCache.column < column)) {
            while (setCache.iterator.hasNext()) {
                SparseMatrixElement element = setCache.iterator.next();
                if (element.getRow() == row && element.getColumn() == column) {
                    element.setValue(value);
                    setCache.row = row;
                    setCache.column = column;
                    return;
                }
                if (element.getRow() == row && element.getColumn() > column) {
                    setCache.iterator.previous();
                    break;
                }
            }
        } else {
            while (setCache.iterator.hasPrevious()) {
                SparseMatrixElement element = setCache.iterator.previous();
                if (element.getRow() == row && element.getColumn() == column) {
                    element.setValue(value);
                    setCache.row = row;
                    setCache.column = column;
                    return;
                }
                if (element.getRow() == row && element.getColumn() < column) {
                    setCache.iterator.next();
                    break;
                }
            }
        }
        setCache.iterator.add(new SparseMatrixElement(row, column, value));
        setCache.row = row;
        setCache.column = column;
    }

    public void newSetElement(final int row, final int column, int value) {


        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new MatrixException("Matrix index is incorrect");
        }

        SparseMatrixElement element = matrix.setOrCreateCursor(row).setOrCreateCursor(column);
        element.value = value;
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