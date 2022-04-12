package LinkedQueue;

import List.DoublyLinkedList.DLink;
import List.LinkedList.Link;

public class LinkedQueue<E> implements Queue<E> {
    private int size;
    QLink<E> head, tail;

    public void LQueue() {
        head = tail = new QLink<E>(null, null);
        size = 0;
    }

    @Override
    public void clear() {
        head.next = null;
        tail = head;
        size = 0;
    }

    @Override
    public void enqueue(E it) {
        QLink<E> n = new QLink<E>(it, null);
        if (size == 0) {
            head = n;
        } else {
            tail.next = n;
        }

        tail = n;
        size++;
    }

    @Override
    public E dequeue() {
        if (size == 0) {
            return null;
        }

        QLink<E> n = head.next;
        E it = head.item;
        head.item = null;

        head = n;
        size--;

        return it;

    }

    @Override
    public E frontValue() {
        return head.item;
    }

    @Override
    public int length() {
        return size;
    }
}
