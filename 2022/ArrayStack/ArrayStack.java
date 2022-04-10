package ArrayStack;

import List.LinkedList.Link;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    private int maxSize = 10;
    private int top;
    private E[] listArray;

    public void AStack() {
        top = -1;
        listArray = (E[]) new Object[maxSize];
    }

    @Override
    public void clear() {
        AStack();
    }

    @Override
    public void push(E it) {
        if (top == listArray.length - 1) {
            listArray = Arrays.copyOf(listArray, listArray.length * 2);
        }
        listArray[++top] = it;
    }

    @Override
    public E pop() {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return listArray[top--];
    }

    @Override
    public E topValue() {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return listArray[top];
    }

    @Override
    public int length() {
        return top + 1;
    }
}