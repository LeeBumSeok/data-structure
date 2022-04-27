package Tree.BST;

public class INode<E> implements BinNode<E> {
    public E data;
    private BinNode<E> l, r;

    public INode(E data, BinNode<E> l, BinNode<E> r) {
        this.data = data;
        this.l = l;
        this.r = r;
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
    public BinNode<E> left() {
        return l;
    }

    @Override
    public BinNode<E> right() {
        return r;
    }

    @Override
    public void setLeft(BinNode<E> n) {
        this.l = n;
    }

    @Override
    public void setRight(BinNode<E> n) {
        this.r = n;
    }

    @Override
    public boolean isLeaf() {
        return l == null && r == null;
    }

    public String toString() {
        return "This is INode, Value is ";
    }
}
