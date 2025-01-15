package main.java.dataStructures.implementations;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private static final Object[] EMPTY_ELEMENT_DATA = {};
    Object[] elementData;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public MyArrayList() {
        this.elementData = EMPTY_ELEMENT_DATA;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != EMPTY_ELEMENT_DATA) {
            int newCapacity = oldCapacity >> 1;
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        return indexOfRange(o, 0, size);
    }

    int indexOfRange(Object o, int start, int end) {
        Object[] es = elementData;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    public E set(int index, E element) {
        checkIndex(index, size);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    private void checkIndex(int index, int size) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + " is out of range.");
    }

    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }

    public boolean add(E e) {
        add(e, elementData, size);
        return true;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = element;
        size = s + 1;
    }


    public E get(int index) {
        checkIndex(index, size);
        return elementData(index);
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    public E remove(int index) {
        checkIndex(index, size);
        final Object[] es = elementData;

        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
        fastRemove(es, index);

        return oldValue;
    }

    public boolean remove(Object o) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found:
        {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

}