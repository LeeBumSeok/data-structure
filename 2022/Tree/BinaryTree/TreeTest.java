package Tree.BinaryTree;

public class TreeTest {
    public static void main(String[] args) {
        BinNode<String> i = new LNode<>("I");
        BinNode<String> o = new LNode<>("O");
        BinNode<String> e = new LNode<>("E");
        BinNode<String> a = new LNode<>("A");
        BinNode<String> y = new LNode<>("Y");
        BinNode<String> g = new LNode<>("G");
        BinNode<String> l = new INode<>("L", i, o);
        BinNode<String> h = new INode<>("H", e, a);
        BinNode<String> n = new INode<>("N", null, g);
        BinNode<String> u = new INode<>("U", y, n);
        BinNode<String> m = new INode<>("M", h, u);
        BinNode<String> v = new INode<>("V", l, m);

        System.out.print("Pre Order: ");
        preorder(v);
        System.out.println();
        System.out.print("In Order: ");
        inorder(v);
        System.out.println();
        System.out.print("Post Order: ");
        postorder(v);
    }

    public static <E> void preorder(BinNode<E> rt) {
        if (rt == null) return;
        System.out.print(rt.element());

        preorder(rt.left());
        preorder(rt.right());
    }

    public static <E> void inorder(BinNode<E> rt) {
        if (rt == null) return;

        inorder(rt.left());
        System.out.print(rt.element());
        inorder(rt.right());
    }

    public static <E> void postorder(BinNode<E> rt) {
        if (rt == null) return;

        postorder(rt.left());
        postorder(rt.right());
        System.out.print(rt.element());
    }
}
