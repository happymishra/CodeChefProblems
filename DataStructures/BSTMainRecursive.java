import java.util.*;
import java.lang.*;

class Node {
	int data;
	Node left, right;

	Node(int data){
		this.data = data;
		left = right = null;
	}
}

class BST {
	Node left, right, root;
	int numberOfNodes, numberOfLeafNodes;

	BST() {
		root = left = right = null;
	}

	void callInsert(int data){
		root = insert(root, data);
	}

	Node insert(Node root, int data) {
		if(root == null){
			root = new Node(data);
		}else{
			if (data <= root.data){
				root.left = insert(root.left, data);
			}else {
				root.right = insert(root.right, data);
			}
		}

		return root;
	}

	Node callFindMin(){
		return findMin(root);
	}

	Node findMin(Node root) {
		if (root == null) {
			return null;
		}

		if (root.left == null) {
			return root;
		}

		return findMin(root.left);
	}

	Node callFindMax(){
		return findMax(root);
	}

	Node findMax(Node root) {
		if (root == null) {
			return null;
		}

		if (root.right == null) {
			return root;
		}

		return findMax(root.right);
	}

	int callFindHeight(){
		return findHeight(root);
	}

	int findHeight (Node root) {
		if (root == null) {
			return -1;
		}

		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);

		return (Math.max(leftHeight, rightHeight) + 1); 
	}

	void callSearch(int data){
		if(search(root, data)){
			System.out.println("Node found");
		}else {
			System.out.println("Node not found");
		}
	}

	boolean search (Node root, int data) {
		if (root == null){
			return false;
		}

		if (root.data == data){
			return true;
		}else if(data <=  root.data) {
			return search(root.left, data);
		}else {
			return search (root.right, data);
		}
	}

	boolean isBST (Node root, int data) {
		if (isSubTreeLesser (root.left, data)
			&& isSubTreeGreater (root.right, data)
			&& isBST (root.left, data)
			&& isBST (root.right, data)){
			return true;
		}
		else {
			return false;
		}
	}

	boolean isSubTreeLesser (Node root, int value) {
		if(root == null){
			return true;
		}
		if (root.data <= value
			&& isSubTreeLesser(root.left, value)
			&& isSubTreeLesser(root.right, value)) {
			return true;
		}else {
			return false;
		}
	}


	boolean isSubTreeGreater (Node root, int value) {
		if(root == null){
			return true;
		}
		if (root.data > value
			&& isSubTreeGreater(root.left, value)
			&& isSubTreeGreater(root.right, value)) {
			return true;
		}else {
			return false;
		}
	}

	void callDeleteNode(int data) {
		root = deleteNode(root, data);
	}

	Node deleteNode (Node root, int data) {
		if (root == null) {
			return root;
		}else if (data < root.data){
			root.left = deleteNode(root.left, data);
		}else if (data > root.data){
			root.right = deleteNode (root.right, data);
		}else {
			if (root.left == null && root.right == null) {
				root = null;
				return root;
			}else if (root.left == null) {
				Node tempNode = root;
				root = root.right;
				tempNode = null;
				return root;
			}else if (root.right == null) {
				Node tempNode = root;
				root = root.left;
				tempNode = null;
				return root;
			}else {
				System.out.println("Hello");
				Node tempNode = findMin(root.right);
				root.data =tempNode.data;
				root.right = deleteNode (root.right, tempNode.data);
			}
		}

		return root;
	}

	/* Write the function for inorder successor */
}

class BSTMainRecursive {
	public static void main(String args[]) {
		BST bst = new BST();
		Scanner sc = new Scanner(System.in);
		int choice, data, positionData;
		System.out.println(" \nMenu: \n \n " +
							" 1. Insert new node \n " +
							" 2. Find minimum \n " +
							" 3. Find Maximum \n " +
							" 4. Find height \n " +
							" 5. Delete node \n " +
							" 6. Search \n " +
							" 7. Check if Binary search tree\n " +
							" 8. Exit program");

		do {
			System.out.println("Enter your choice");

			choice = sc.nextInt();

			switch(choice) {
				case 1: 
						System.out.println("Enter the node");
						data = sc.nextInt();
						bst.callInsert(data);
						break;
				case 2:
						Node minNode = bst.callFindMin();
						if (minNode == null){
							System.out.println("Tree is empty");	
						}else {
							System.out.println("Minimum element of the tree is: " + minNode.data);
						}
						
						break;
				case 3:
						Node maxNode = bst.callFindMax();
						if (maxNode == null){
							System.out.println("Tree is empty");	
						}else {
							System.out.println("Maximum element of the tree is: " + maxNode.data);
						}
						break;
				case 4:
						int height = bst.callFindHeight();
						System.out.println("Height of the tree is: " + height);
						break;
				case 5: 
						System.out.println("Enter the node to be deleted");
						data = sc.nextInt();
						bst.callDeleteNode(data);
						break;
				case 6: 
						System.out.println("Enter the node to be searched");
						data = sc.nextInt();
						bst.callSearch(data);
						break;
				case 7: 
						break;
				default: 
						System.out.println("Wrong choice");
			}

		}while(choice != 8);
	}
}
