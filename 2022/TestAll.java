import ArrayStack.ArrayStack;
import LinkedQueue.LinkedQueue;
import List.DoublyLinkedList.DList;
import List.DoublyLinkedList.List;
import List.DoublyLinkedList.ListIterator;

public class TestAll {
    public static void TestDList() {
        List<Integer> mylist = new DList<Integer>();

        for (int i = 0; i < 9; i++) {
            mylist.append(i);
            System.out.println("append " + i + ": " + mylist);
        }

        mylist.update(9, 9);
        System.out.println("insert 9 in pos 9: " + mylist);

        mylist.update(2, 10);
        System.out.println("update 10 in pos 2: " + mylist);

        System.out.println("pos 2 value: " + mylist.getValue(2));

        System.out.println("remove pos 1: " + mylist.getValue(1));

        mylist.remove(9);
        System.out.println("remove pos 1: " + mylist);
        System.out.println("Length of the Doubly LinkedList after removing pos 1: " + mylist.length());

        mylist.clear();
        System.out.println("LinkedList after clear: " + mylist);
        System.out.println("Length of the Doubly LinkedList after clear: " + mylist.length());

        ListIterator<Integer> itr = mylist.listIterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void TestArrayStack() {
        ArrayStack<Integer> mylist = new ArrayStack<Integer>();

        for (int i = 0; i < 9; i++) {
            mylist.push(i);
            System.out.println("append " + i + ": " + mylist);
        }

        System.out.println("top value: " + mylist.topValue());

        System.out.println("remove top Value: " + mylist.pop());

        System.out.println("Length of the ArrayStack " + mylist.length());

        mylist.clear();
        System.out.println("ArrayStack after clear: " + mylist);
        System.out.println("Length of the ArrayStack after clear: " + mylist.length());
    }

    public static void TestLinkedQueue() {
        LinkedQueue<Integer> mylist = new LinkedQueue<Integer>();

        for (int i = 0; i < 9; i++) {
            mylist.enqueue(i);
            System.out.println("append " + i + ": " + mylist);
        }

        System.out.println("front value: " + mylist.frontValue());

        System.out.println("remove front Value: " + mylist.dequeue());

        System.out.println("Length of the Linked Queue " + mylist.length());

        mylist.clear();
        System.out.println("Linked Queue after clear: " + mylist);
        System.out.println("Length of the Linked Queue after clear: " + mylist.length());
    }

    public static void main(String[] args) {
        System.out.println("----------------------------------------------\n Test Doubly Linked List");
        TestDList();
        System.out.println("----------------------------------------------\n Test Array Stack");
        TestArrayStack();
        System.out.println("----------------------------------------------\n Test Linked Queue");
        TestLinkedQueue();
    }
}
