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
        for(int i = 0; i < 9; i++) {
            mylist.append(i);
            System.out.println("append " + i + ": " + Arrays.toString(mylist.data));
        }

        mylist.insert(9, 9);
        System.out.println("insert 9 in pos 9: " + Arrays.toString(mylist.data));

        mylist.update(2, 10);
        System.out.println("update 10 in pos 2: " + Arrays.toString(mylist.data));

        System.out.println("pos 2 value: " + mylist.getValue(2));

        mylist.remove(1);
        System.out.println("Length of the ArrayList after removing pos 1: " + mylist.length());

        mylist.clear();
        System.out.println("Length of the ArrayList after clear: " + mylist.length());
    }
}