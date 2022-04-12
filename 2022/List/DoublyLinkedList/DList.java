package List.DoublyLinkedList;

public class DList<E> implements List<E> {
    public DLink<E> head, tail, curr;
    int size;

    public void DList() {
        head = tail = curr = new DLink<E>(null, null, null);
        size = 0;
    }


    @Override
    public void clear() {
        head = tail = curr = new DLink<E>(null, null, null);
        size = 0;
    }

    @Override
    public void insert(int pos, E item) {
        if (pos == 0) {
            DLink<E> n = new DLink<E>(item, null, head);
            if (head != null) {
                head.prev = n;
            }
            head = n;
            if (tail == null) {
                tail = n;
            }
        } else {
            DLink<E> curr = head;
            for (int i = 0; i < pos - 1; i++) {
                curr = curr.next;
            }

            curr.next = new DLink<E>(item, curr, curr.next);
            curr.next.next.prev = curr.next;
        }

        size++;
    }

    @Override
    public void append(E item) {
        if (head == null) {
            DLink<E> n = new DLink<E>(item, null, null);
            head = n;
            if (head.next == null) {
                tail = head;
            }
        } else {
            DLink<E> n = new DLink<E>(item, tail, tail.prev);
            tail.next = n;
            n.prev = tail;
            tail = n;
        }

        size++;
    }

    @Override
    public void update(int pos, E item) {
        DLink<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }

        curr.item = item;
    }

    @Override
    public E getValue(int pos) {
        DLink<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }

        return curr.item;
    }

    @Override
    public E remove(int pos) {
        if (pos == 0) {
            E ret = head.item;
            DLink<E> temp = head.next;
            head.item = null;
            head.next = null;

            if (temp != null) {
                temp.prev = null;
            }

            head = temp;

            size--;
            return ret;
        } else {
            DLink<E> curr = head;
            for (int i = 0; i < pos - 1; i++) {
                curr = curr.next;
            }

            E ret = curr.next.item;
            curr.next.next.prev = curr;
            curr.next = curr.next.next;

            size--;
            return ret;
        }
    }

    public String toString() {
        String a = "";
        curr = head;
        for (int i = 0; i < size; i++) {
            a += curr.item + ", ";
            curr = curr.next;
        }

        return a;
    }

    @Override
    public int length() {
        return size;
    }

    public ListIterator<E> listIterator() {
        return new DLinkIterator();
    }

    class DLinkIterator implements ListIterator<E> {
        DLink<E> curr = head;

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
            curr = curr.prev;
            return curr.item;
        }
    }
}

