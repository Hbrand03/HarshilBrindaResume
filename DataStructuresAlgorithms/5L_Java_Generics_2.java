package GenericsPractice;

import java.util.ArrayList;

/**
 * A generic Matrix class representing a two-dimensional arrangement of elements.
 *
 * @param <T> the type of elements in the matrix
 */
public class Matrix<T> {
    /**
     * The internal representation of matrix elements using an ArrayList of ArrayLists.
     */
    private ArrayList<ArrayList<T>> elements;

    /**
     * The number of rows in the matrix.
     */
    private int rows;

    /**
     * The number of columns in the matrix.
     */
    private int columns;

    /**
     * Constructs a Matrix with the specified number of rows and columns.
     *
     * @param rows    the number of rows in the matrix
     * @param columns the number of columns in the matrix
     */
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        elements = new ArrayList<>();


        for (int i = 0; i < rows; i++) {
            ArrayList<T> row = new ArrayList<>();
            for (int j = 0; j < columns; j++)
                row.add(null);

            elements.add(row);
        }
    }

    /**
     * Gets the element at the specified row and column indices.
     *
     * @param row    the row index
     * @param column the column index
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the indices are out of bounds
     */
    public T get(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IndexOutOfBoundsException("Invalid row or column index");
        }
        return elements.get(row).get(column);
    }

    /**
     * Sets the element at the specified row and column indices.
     *
     * @param row    the row index
     * @param column the column index
     * @param value  the value to be set at the specified position
     * @throws IndexOutOfBoundsException if the indices are out of bounds
     */
    public void put(int row, int column, T value) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IndexOutOfBoundsException("Invalid row or column index");
        }
        elements.get(row).set(column, value);
    }

    /**
     * Gets the number of rows in the matrix.
     *
     * @return the number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Gets the number of columns in the matrix.
     *
     * @return the number of columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Gets the internal representation of matrix elements.
     *
     * @return the array list of array lists representing the matrix
     */
    public ArrayList<ArrayList<T>> getElements() {
        return elements;
    }

    /**
     * Sets the internal representation of matrix elements.
     *
     * @param elements the array list of array lists representing the matrix
     */
    public void setElements(ArrayList<ArrayList<T>> elements) {
        this.elements = elements;
    }
}
