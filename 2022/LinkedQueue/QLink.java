package LinkedQueue;

public class QLink<E> {
    E item;
    QLink<E> next;

    public QLink(E item, QLink<E> next) {
        this.item = item;
        this.next = next;
    }
}