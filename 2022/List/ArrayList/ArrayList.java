package List.ArrayList;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    private static final int DefaultSize = 10;
    private int listSize;
    private E[] data;

    public ArrayList() {
        this(DefaultSize);
    }

    public ArrayList(int Size) {
        listSize = 0;
        data = (E[]) new Object[Size];
    }

    public void clear() {
        listSize = 0;
    }

    public void insert(int pos, E item) {
        for (int i = listSize; i > pos; i--) data[i] = data[i - 1];
        data[pos] = item;
        listSize++;
    }

    public void append(E item) {
        data[listSize++] = item;
    }

    public void update(int pos, E item) {
        data[pos] = item;
    }

    public E getValue(int pos) {
        return data[pos];
    }

    public E remove(int pos) {
        E ret = data[pos];
        for (int i = pos; i < listSize - 1; i++) data[i] = data[i + 1];
        listSize--;
        return ret;
    }

    public int length() {
        return listSize;
    }

    public static void main(String args[]) {
        ArrayList<Integer> mylist = new ArrayList<>();
        mylist.append(3);
        mylist.append(5);
        mylist.append(6);
        mylist.append(7);
        mylist.append(8);
        mylist.append(9);
        System.out.println(Arrays.toString(mylist.data));
        System.out.println(mylist.length());
    }
}