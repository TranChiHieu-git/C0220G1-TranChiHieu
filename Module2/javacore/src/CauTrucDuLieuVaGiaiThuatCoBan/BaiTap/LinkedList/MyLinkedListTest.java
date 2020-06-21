package CauTrucDuLieuVaGiaiThuatCoBan.BaiTap.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(15);
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(5);
        myLinkedList.printList();
        System.out.println();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.printList();
        System.out.println();
//        System.out.println(myLinkedList.get(0));
//        System.out.println(myLinkedList.get(1));
//        System.out.println(myLinkedList.get(2));
//        myLinkedList.add(1, 50);
//        myLinkedList.add(1, 100);
//        myLinkedList.add(8, 200);
//        myLinkedList.printList();
//        System.out.println();
        System.out.println("Phan tu bi xoa khoi mang la: " + myLinkedList.removeIndex(1));
        System.out.println("Phan tu bi xoa khoi mang la: " + myLinkedList.removeIndex(4));
        myLinkedList.printList();
//        System.out.println();
//        System.out.println(myLinkedList.removeValue(5));
//        System.out.println(myLinkedList.removeValue(1));
//        myLinkedList.printList();
        System.out.println();
//        System.out.println("Size of linkedlist: " + myLinkedList.size());
        MyLinkedList<Integer> cloneList = new MyLinkedList<>();
        cloneList = myLinkedList.clone();
        System.out.print("node of cloneList: ");
        cloneList.printList();
        System.out.println();
        System.out.println("gia tri 25 co nam trong linkedlist? " + myLinkedList.contains(25));
//        System.out.println("vi tri xuat hien dau tien cua gia tri 15: " + myLinkedList.indexOf(15));
//        System.out.println(myLinkedList.add(999));
//        myLinkedList.printList();
//        System.out.println();
//        System.out.println("first value: ");
//        System.out.println(myLinkedList.getFirst());
//        System.out.println("last value: ");
//        System.out.println(myLinkedList.getLast());
//        myLinkedList.clear();
//        myLinkedList.addFirst(1);
//        myLinkedList.addLast(2);
//        myLinkedList.addLast(3);
//        myLinkedList.addLast(4);
//        myLinkedList.printList();
    }
}
