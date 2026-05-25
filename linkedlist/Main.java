package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList newLinkedList = new LinkedList(2);
        newLinkedList.append(3);

//        System.out.println(newLinkedList.removeLast().value);
//        System.out.println(newLinkedList.removeLast().value);
//        System.out.println(newLinkedList.removeLast());

//        newLinkedList.prepend(1);
        newLinkedList.printList();

        System.out.println(newLinkedList.removeFirst().value);
        newLinkedList.printList();
    }
}
