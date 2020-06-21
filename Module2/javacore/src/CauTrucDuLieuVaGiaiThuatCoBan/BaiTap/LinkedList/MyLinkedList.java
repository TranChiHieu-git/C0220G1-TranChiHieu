package CauTrucDuLieuVaGiaiThuatCoBan.BaiTap.LinkedList;

public class MyLinkedList<E> {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private Node head;
    private int numberNodes = 0;

    public MyLinkedList() {

    }

    public void add(int index, E e) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node tempNextNext = temp.next;
        Node newNode = new Node(e);
        temp.next = newNode;
        newNode.next = tempNextNext;
        numberNodes++;
    }

    public void addFirst(E e) {
        Node temp = this.head;
        head = new Node(e);
        head.next = temp;
        numberNodes++;
    }

    public void addLast(E e) {
        Node temp = head;
        for (int i = 0; i < numberNodes -1&& temp.next!=null; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(e);
        temp.next = newNode;
        numberNodes++;

    }

    public boolean add(E e) {
        this.addLast(e);
        return true;
    }

    public E removeIndex(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node eRemoved = temp.next;
        temp.next = temp.next.next;
        numberNodes--;
        return (E) eRemoved.getData();
    }

    public boolean removeValue(Object e) {
        Node temp = head;
        Node tempOld = temp;
        for (int i = 0; i < this.numberNodes; i++) {
            if (!e.equals(temp.getData())) {
                tempOld = temp;
                temp = temp.next;
            } else {
                temp = tempOld;
                temp.next = temp.next.next;
                numberNodes--;
                return true;
            }
        }
        return false;
    }

    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    public E getFirst() {
        return (E) head.data;
    }

    public E getLast() {
        Node temp = head;
        for (int i=0;i<numberNodes-1;i++){
            temp=temp.next;
        }
        return (E) temp.data;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public int size() {
        return this.numberNodes;
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> cloneList = new MyLinkedList<>();
        Node temp = head;
        for (int i = 0; i < numberNodes; i++) {
            if (i == 0) {
                cloneList.addFirst((E) temp.getData());
            } else {
                cloneList.addLast((E) temp.getData());
            }
            temp = temp.next;
        }
        return cloneList;
    }

    public boolean contains(E o) {
        Node temp = head;
        while (temp != null) {
            if (temp.getData().equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < numberNodes; i++) {
            if (temp.getData().equals(o)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    public void clear(){
        head=null;
    }
}
