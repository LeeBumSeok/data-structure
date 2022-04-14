package Tree.BinaryTree;

public interface BinNode<E> {
    public E element();

    public E setElement(E item);

    public BinNode<E> left();

    public BinNode<E> right();

    public boolean isLeaf();

}
