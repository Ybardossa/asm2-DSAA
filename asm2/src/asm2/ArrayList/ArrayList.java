/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2.ArrayList;

/**
 *
 * @author gnarl
 */
public class ArrayList<T extends Comparable<T>> {

    private Object[] array;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public ArrayList() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
    }

    public void remove(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[--size] = null;
                return;
            }
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public void sort() {
        // Sorting using a simple bubble sort for demonstration
        // Replace with your preferred sorting algorithm
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T element1 = (T) array[j];
                T element2 = (T) array[j + 1];
                if (element1.compareTo(element2) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }
}

