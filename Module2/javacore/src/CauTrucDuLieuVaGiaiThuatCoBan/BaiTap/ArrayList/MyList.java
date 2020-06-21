package CauTrucDuLieuVaGiaiThuatCoBan.BaiTap.ArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    MyList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    MyList(int capacity) {
        this.size = capacity;
        this.elements = new Object[this.size];
    }

    public void print() {
        for (int i = 0; i < this.getSize(); i++) {
            System.out.print(this.get(i) + " ");
        }
        System.out.println();
    }

    public boolean contains(E o) {
        for (int i = 0; i < this.getSize(); i++) {
            if (o.equals(this.get(i))) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < this.getSize(); i++) {
            if (o.equals(this.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        for (int i = index; i < this.getSize(); i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;
        return (E) this.elements;
    }

    public void add(E element) {
        if (this.getSize() == this.elements.length) {
            this.ensureCapa();
        }
        this.elements[size] = element;
        this.size++;
    }

    public MyList<E> clone() {
        MyList<E> v = new MyList<>();
        v.elements = Arrays.copyOf(this.elements, DEFAULT_CAPACITY);
        v.size = this.size;
        return v;
    }

    public void add(int index, E element) {
        if (index >= this.getSize() || index < 0) {
            throw new IndexOutOfBoundsException("Index phai nam trong pham vi cua ham.Index: " + index + ",Size: " + this.getSize());
        }
        for (int i = this.getSize() - 1; i >= index; i--) {
            this.elements[i + 1] = this.elements[i];
        }
        this.elements[index] = element;
        this.size++;
    }

    public int getSize() {
        return this.size;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ",Size: " + this.size);
        }
        return (E) this.elements[i];
    }

    public void ensureCapa() {
        int newsize = this.elements.length * 2;
        this.elements = Arrays.copyOf(elements, newsize);
    }

    public void ensureCapa(int mincapacity) {
        if (this.elements.length < mincapacity) {
            this.elements = Arrays.copyOf(elements, mincapacity);
        }
    }

    public void clear() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
}
