package online_school.generic;

import online_school.course.model.Model;

import java.util.Arrays;

public class SchoolArray<E extends Model> {
    private E[] array;

    public SchoolArray(E[] array) {
        this.array = array;
    }

    public int size() {
        return array.length;
    }

    public boolean isEmpty() {
        return array[0] == null;
    }

    public E get(int index) {
        E result = null;
        for (int i = 0; i < size(); i++) {
            if (i == index) {
                result = array[i];
                break;
            }
        }
        return result;
    }

    public void add(E element) {
        for (int i = 0; i < size(); i++) {
            if (array[i] == null) {
                array[i] = element;
                break;
            } else if (array[i] != null && i == size() - 1) {
                magnificationOfArray();
            }
        }
    }

    public void add(int index, E element) {
        if (array[index] == null) {
            array[index] = element;
        } else {
            array[index] = element;
            System.out.println("Об'єкт замінено на новий !!!");
        }

    }

    public void remove(int index) {
        array[index] = null;
        for (int i = index; i < size(); i++) {
            if (array[i] == null) {
                array[i] = array[i + 1];
                array[i + 1] = null;
            }
        }
    }

    public void showAllObject() {
        for (int i = 0; i < size(); i++) {
            if (array[i] == null) {
                break;
            } else {
                System.out.println(array[i]);
            }
        }
    }

    public E[] getArray() {
        return array;
    }

    public void magnificationOfArray() {
        array = Arrays.copyOf(array, (size() * 3) / 2 + 1);
        System.out.format("Масив збільшено, довжина: %d об'єктів!!!\n", (size()));
    }
}
