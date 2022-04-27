package Tree.BST;

public class BSTTest extends BST {
    public static void main(String[] args) {
        Dictionary<Integer, String> bst = new BST<>();

        bst.insert(11, "a");
        bst.insert(3, "b");
        bst.insert(5, "c");
        bst.insert(2, "d");

        bst.remove(3);
        bst.removeAny();

        System.out.println(bst.find(2));
        System.out.println(bst.find(3));
        System.out.println(bst.find(5));
        System.out.println(bst.find(11));

        bst.clear();
        System.out.println(bst.find(2));
        System.out.println(bst.find(3));
        System.out.println(bst.find(5));
        System.out.println(bst.find(11));

        bst.insert(50, "V");
        bst.insert(40, "L");
        bst.insert(25, "I");
        bst.insert(45, "O");
        bst.insert(70, "M");
        bst.insert(60, "H");
        bst.insert(85, "U");
        bst.insert(55, "E");
        bst.insert(65, "A");
        bst.insert(80, "Y");
        bst.insert(100, "N");
        bst.insert(200, "G");

        bst.printInorder();
    }


}
