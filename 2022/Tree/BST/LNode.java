package Tree.BST;

public class LNode<E> implements BinNode<E> {
    public E data;

    public LNode(E data) {
        this.data = data;
    }

    @Override
    public E element() {
        return data;
    }

    @Override
    public E setElement(E item) {
        return this.data = item;
    }

    @Override
    public BinNode left() {
        return null;
    }

    @Override
    public BinNode right() {
        return null;
    }

    @Override
    public void setLeft(BinNode n) {

    }

    @Override
    public void setRight(BinNode n) {

    }

    @Override
    public boolean isLeaf() {
        return true;
    }


    public String toString() {
        return "This is LNode, Value is ";
    }
}
