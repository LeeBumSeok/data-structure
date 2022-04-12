package List.LinkedList;

public class LinkedList<E> implements List<E> {
    Link<E> head, tail;
    int size;

    public LinkedList() {
        head = tail = new Link<E>(null, null);
        size = 0;
    }

    public void clear() {
        head.next = null;
        tail = head;
        size = 0;
    }

    public void insert(int pos, E item) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }

        Link<E> n = new Link<E>(item, curr.next);
        curr.next = n;

        if (curr == tail) {
            tail = curr.next;
        }

        size++;
    }

    public void append(E item) {
        Link<E> n = new Link<E>(item, null);
        tail.next = n;
        tail = n;
        size++;
    }

    public void update(int pos, E item) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }

        curr.next.item = item;
    }

    public E getValue(int pos) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }

        return curr.next.item;
    }

    public E remove(int pos) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }

        E ret = curr.next.item;

        if (curr.next == tail) {
            tail = curr;
        }

        curr.next = curr.next.next;
        size--;

        return ret;
    }

    public int length() {
        return size;
    }

    public String toString() {
        String a = "";
        Link<E> curr = head;
        for (int i = 0; i < size; i++) {
            a += curr.next.item + ", ";
            curr = curr.next;
        }

        return a;
    }

    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    class LinkedListIterator implements ListIterator<E> {
        Link<E> curr = head;

        public boolean hasNext() {
            return curr != tail;
        }

        public E next() {
            curr = curr.next;
            return curr.item;
        }

        public boolean hasPrevious() {
            return curr != head;
        }

        public E previous() {
            Link<E> tmp = head;
            while (tmp.next != curr) {
                tmp = tmp.next;
            }
            curr = tmp;

            return curr.next.item;
        }
    }

    public static void main(String[] args) {
        List<Integer> mylist = new LinkedList<Integer>();
        for(int i = 0; i < 9; i++) {
            mylist.append(i);
            System.out.println("append " + i + ": " + mylist);
        }

        mylist.insert(9, 9);
        System.out.println("insert 9 in pos 9: " + mylist);

        mylist.update(2, 10);
        System.out.println("update 10 in pos 2: " + mylist);

        System.out.println("pos 2 value: " + mylist.getValue(2));

        mylist.remove(1);
        System.out.println("remove pos 1: " + mylist);
        System.out.println("Length of the LinkedList after removing pos 1: " + mylist.length());

        mylist.clear();
        System.out.println("LinkedList after clear: " + mylist);
        System.out.println("Length of the LinkedList after clear: " + mylist.length());
    }
}
