import java.util.*;

// Name : 이범석
// Student ID : 20171664

@SuppressWarnings("unchecked")
class BST <T extends KeyValue> {
	class TreeNode <U extends KeyValue> {
		U data;	// storage for data : in HW 3, T will be Item
		TreeNode<U> leftChild;	// link to the left Child
		TreeNode<U> rightChild;	// link to the right Child

		// constructors come here
		TreeNode() {
			leftChild = rightChild = null;
		}
		TreeNode(U d) {
			// data is given
			data = d;
			// the leftChild and rightChild field are null
			leftChild = rightChild = null;
		}
	};

	TreeNode <T> root;
	BST() { 
		// BST constructor. 
		root = null;
	}

	void Show() {
		System.out.print( "PRE  Order : ");
		PreOrder(root);
		System.out.println("");
		System.out.print("IN   Order : ");
		InOrder(root);
		System.out.println("");
		System.out.print("POST Order : ");
		PostOrder(root);
		System.out.println("");
		System.out.print("Number of Nodes : ");
		System.out.println( Count(root));
		System.out.print("HEIGHT : ");
		System.out.println( Height(root));
		System.out.println("");
	}

	boolean  Insert(T item)  {
		// first search the key
		if(root == null) {
			root = new TreeNode<T>(item);
			return true;
		}

		TreeNode<T> parent = root;
        
		while(true) {
			if(parent.data.GetKey() < item.GetKey()) {
                if(parent.rightChild == null) {
                    parent.rightChild = new TreeNode<T>(item);
                    break;
                }
                else {
                    parent = parent.rightChild;
                    continue;
                }
            }
            else if(parent.data.GetKey() > item.GetKey()) {
                if(parent.leftChild == null) {
                    parent.leftChild = new TreeNode<T>(item);
                    break;
                }
                else {
                    parent = parent.leftChild;
                    continue;
                }
            }
            else 
                return false;
		}
        return true;
	}

	T Get(T item)  {
		// use the key field of item and find the node
		// do not use val field of item
		TreeNode<T> ptr;
        ptr = root;
        
        while(true) {
            if (ptr.data.GetKey() < item.GetKey()) {
                if(ptr.rightChild == null) 
                    return null;
                else
                    ptr = ptr.rightChild;
            }
            else if(ptr.data.GetKey() > item.GetKey()) {
                if(ptr.leftChild == null) 
                    return null;
                else
                    ptr = ptr.leftChild;
            }
            else
                return ptr.data;
        }
	} 


	boolean Delete(T item)  {
        if(root == null)
			return false;	// non existing key

        TreeNode<T> parent = root;
        TreeNode<T> tmp = root;
        boolean left = false;

        while(true) {
            if(tmp == null) 
                break;
            
            else if (tmp.data.GetKey() < item.GetKey()) {
                parent = tmp;
                tmp = tmp.rightChild;
                left = false;
                continue;
            }

            else if(tmp.data.GetKey() > item.GetKey()) {
                parent = tmp;
                tmp = tmp.leftChild;
                left = true;
                continue;
            }

            else {
                if(tmp.leftChild == null && tmp.rightChild == null) {
                    if(tmp == root) 
                        root = null;
                    else if(left == true) 
                        parent.leftChild = null;
                    else
                        parent.rightChild = null;
                    return true;
                }
                else if(tmp.leftChild == null && tmp.rightChild != null) {
                    if(tmp == root)
                        root = null;
                    else if (left == true)
                        parent.leftChild = tmp.rightChild;
                    else
                        parent.rightChild = tmp.rightChild;
                    return true;
                }
                else if(tmp.leftChild != null && tmp.rightChild == null) {
                    if (left == true)
                        parent.leftChild = tmp.leftChild;
                    else
                        parent.rightChild = tmp.leftChild;
                    return true;
                }
                TreeNode<T> cur = tmp.leftChild;
                while(true) {
                    if(cur.rightChild == null)
                        break;
                    cur = cur.rightChild;
                }
                T a = cur.data;
                Delete(cur.data);
                tmp.data = a;
                return true;
            }
        }
        return false;
	}

	void  PreOrder(TreeNode<T> t)  {
        if(t != null){
             System.out.print("[" + t.data.GetKey() + "(" + t.data.GetValue() + ")" + "]");
             PreOrder(t.leftChild);
             PreOrder(t.rightChild);
        }
	}

	void  InOrder(TreeNode<T> t)  {
        if(t!= null) {
            InOrder(t.leftChild);
            System.out.print("[" + t.data.GetKey() + "(" + t.data.GetValue() + ")" + "]");
            InOrder(t.rightChild);
        }
	}

	void  PostOrder(TreeNode<T> t)  {
        if(t != null) {
            PostOrder(t.leftChild);
            PostOrder(t.rightChild);
            System.out.print("[" + t.data.GetKey() + "(" + t.data.GetValue() + ")" + "]");
        }
	}

	int  Count(TreeNode<T> t)  {
        int cnt = 1;

        if(t == null)
            return 0;

        if(t.leftChild != null)
            cnt += Count(t.leftChild);

        if(t.rightChild != null)
            cnt += Count(t.rightChild);

		return cnt;
	}

	int  Height(TreeNode<T> t)  {
        if(t == null)
            return 0;

        int leftChildHeight = 0;
        int rightChildHeight = 0;

        if(t.leftChild != null)
            leftChildHeight = Height(t.leftChild);

        if(t.rightChild != null)
            rightChildHeight = Height(t.rightChild);

        if(leftChildHeight >= rightChildHeight)
            return leftChildHeight + 1;
        else
            return rightChildHeight + 1;
    }
}
    
