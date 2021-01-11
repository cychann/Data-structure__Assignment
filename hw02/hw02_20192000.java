import java.util.*;

// Name :
// Student ID :

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
		TreeNode<T> node = new TreeNode<T>(item);
		// first search the key
		if(root == null) {
			root = node;
			return true;
		}
		TreeNode<T> ptr, parent;
		ptr = root;
		parent = null;
		
		while(true) {
			if(item.GetKey() == ptr.data.GetKey())	return false;
			parent = ptr;
			if(item.GetKey() < ptr.data.GetKey() ) {
				ptr = ptr.leftChild;
				if(ptr==null) {
					parent.leftChild = node;
					return true;
				}
			}
			else if(item.GetKey() > ptr.data.GetKey()){
				ptr = ptr.rightChild;
				if(ptr==null) {
					parent.rightChild = node;
					return true;
				}
			}
		}
	}

	T Get(T item)  {
		// use the key field of item and find the node
		// do not use val field of item
		TreeNode<T> ptr;
		ptr = root;
		while(true) {
			if(ptr==null)	return null;
			if(ptr.data.GetKey() == item.GetKey()) {
				return ptr.data;
			}
			else if(item.GetKey() < ptr.data.GetKey()) {
				ptr = ptr.leftChild;
			}
			else {
				ptr = ptr.rightChild;
			}
		}
		
	} 


	boolean Delete(T item)  {
		if(root == null)
			return false;	// non existing key
		
		TreeNode<T> ptr, parent;
		ptr = root;
		parent = root;
		boolean left = false;
		
		while(ptr.data.GetKey()!=item.GetKey()) {
			parent = ptr;
			if(ptr.data.GetKey()>item.GetKey()) {
				ptr = ptr.leftChild;
				left = true;
			}
			else {
				ptr = ptr.rightChild;
				left = false;
			}
			if(ptr==null)	return false; 
		}
		//Case 1
		if(ptr.leftChild==null && ptr.rightChild==null) {
			if(ptr==root)	root = null;
			if(left==true)	parent.leftChild = null;
			else	parent.rightChild = null;
		}
		//Case 2-1 left
		else if(ptr.rightChild == null) {
			if(ptr==root)	root = ptr.leftChild;
			else if(left==true)	parent.leftChild = ptr.leftChild;
			else	parent.rightChild = ptr.leftChild;
		}
		//Case 2-2 right
		else if(ptr.leftChild == null) {
			if(ptr==root)	root = ptr.rightChild;
			else if(left==true)	parent.leftChild = ptr.rightChild;
			else	parent.rightChild = ptr.rightChild;
		}
		//Case 3
		else if(ptr.leftChild != null && ptr.rightChild!=null) {
			TreeNode<T> findnode, findp, cur;
			findnode = null;
			findp = null;
			cur = ptr.leftChild;
			while(cur!=null) {
				findp = findnode;
				findnode = cur;
				cur = cur.rightChild;
			}
			ptr.data = findnode.data;
			
			if(findnode.leftChild!=null)	findp.rightChild = findnode.leftChild;
			else	findp.rightChild = null;
		}

	
		return true;
	}

	void  PreOrder(TreeNode<T> t)  {
		if(t==null)	return;
		System.out.print("[" + t.data.GetKey() + "(" + t.data.GetValue() + ")]");
		PreOrder(t.leftChild);
		PreOrder(t.rightChild);

	}

	void  InOrder(TreeNode<T> t)  {
		if(t==null)	return;
		InOrder(t.leftChild);
		System.out.print("[" + t.data.GetKey() + "(" + t.data.GetValue() + ")]");
		InOrder(t.rightChild);
	}

	void  PostOrder(TreeNode<T> t)  {
		if(t==null)	return;
		PostOrder(t.leftChild);
		PostOrder(t.rightChild);
		System.out.print("[" + t.data.GetKey() + "(" + t.data.GetValue() + ")]");
	}

	int  Count(TreeNode<T> t)  {
		if(t==null)	return 0;
		else {
			return Count(t.leftChild) + Count(t.rightChild) + 1;
		}
	}

	int  Height(TreeNode<T> t)  {
		if(t==null)	return 0;
		int left = Height(t.leftChild)+1;
		int right = Height(t.rightChild)+1;
		
		if(left <= right)	return right;
		else	return left;
	}
}

