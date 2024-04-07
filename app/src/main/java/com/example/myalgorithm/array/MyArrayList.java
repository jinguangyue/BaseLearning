package com.example.myalgorithm.array;


import java.util.Arrays;

/**
 * 使用数组实现list
 * @param <T>
 */
public class MyArrayList<T> {
    public int capacity = 16;
    public Object[] arrays;

    public int size;

    public MyArrayList() {
        arrays = new Object[capacity];
        size = 0;
    }

    public void add(T t) {
        increaseCapacity(size + 1);
        arrays[size++] = t;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(arrays, index + 1, arrays, index, size - index - 1);
        arrays[--size] = null;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T)arrays[index];
    }

    public void increaseCapacity(int size) {
        if (size > arrays.length) {
            int newCapacity = arrays.length * 2;
            if (newCapacity < size) {
                newCapacity = size;
            }
            arrays = Arrays.copyOf(arrays, newCapacity);
        }

    }

}
