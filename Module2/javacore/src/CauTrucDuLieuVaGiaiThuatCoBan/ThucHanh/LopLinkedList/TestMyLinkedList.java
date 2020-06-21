package CauTrucDuLieuVaGiaiThuatCoBan.ThucHanh.LopLinkedList;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedLIst ll = new MyLinkedLIst(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(5,9);
        ll.add(7,9);
        ll.get(2);
        ll.printList();
    }
}
