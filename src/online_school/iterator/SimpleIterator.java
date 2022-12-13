package online_school.iterator;

import java.util.NoSuchElementException;

public class SimpleIterator<E> {
    private final E[] arrays;
    private int index;
    private int deleteIndex = -1;

    public SimpleIterator(E[] array) {
        arrays = array;
    }

    public boolean hasNext() {
        return !(index == arrays.length || index < 0 || arrays[index] == null);
    }

    public E next() {
        if (index < 0 || arrays[index] == null) {
            throw new NoSuchElementException("The next object is not found !!!");
        }
        deleteIndex = index;
        return arrays[index++];
    }

    public void remove() {
        if (deleteIndex != index - 1) {
            throw new IllegalStateException("The \"next()\" method was not called !!!");
        } else {
            arrays[deleteIndex] = null;
            for (int i = 0; i < arrays.length - 1; i++) {
                if (arrays[i] == null) {
                    arrays[i] = arrays[i + 1];
                    arrays[i + 1] = null;
                }
            }
        }
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
