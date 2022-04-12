package List.DoublyLinkedList;

public class DLink<E> {
    E item;
    DLink<E> next;
    DLink<E> prev;

    public DLink(E item, DLink<E> prev, DLink<E> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }
}