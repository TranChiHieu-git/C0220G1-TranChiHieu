package CauTrucDuLieuVaGiaiThuatCoBan.ThucHanh.LopList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private int DEFAULT_CAPACITY = 10;
    private Object[] element;

    public MyList() {
        this.element = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if (this.size == this.element.length) {
            ensureCapa();
        }
        this.element[size] = e;
        size++;
    }
    public E get(int i) {
        if (i>=size||i<0) {
            throw new IndexOutOfBoundsException("Index: "+i+",Size: "+this.size);
        }
        return (E) this.element[i];
    }
    public void ensureCapa() {
        int newsize = this.element.length * 2;
        this.element = Arrays.copyOf(element, newsize);
    }
}
