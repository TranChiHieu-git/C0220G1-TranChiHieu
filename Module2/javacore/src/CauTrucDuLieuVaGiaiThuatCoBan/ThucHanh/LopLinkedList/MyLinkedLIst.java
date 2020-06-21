package CauTrucDuLieuVaGiaiThuatCoBan.ThucHanh.LopLinkedList;

public class MyLinkedLIst {
    public class Node {
        public Node next;
        public Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private Node head;
    private int numNodes = 0;

    public MyLinkedLIst(Object data) {
        this.head = new Node(data);
    }

    public void add(int i, Object data) {
        Node temp = this.head;
        Node holder;
        for (int index = 0; index < i - 1 && temp.next != null; index++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        this.numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void get(int i) {
        Node temp = head;
        for (int index = 0; index < i; index++) {
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
