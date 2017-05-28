import java.util.*;

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

	void insert(int data){
		Node newNode = new Node(data);

		if(root == null){
			root = newNode;
		}else{
			Node p = root, follow = null;
			
			while(p != null){
				follow = p;

				if(data <= p.data){
					p = p.left;
				}else{
					p = p.right;
				}
			}

			if(data <= follow.data){
				follow.left = newNode;
			}else{
				follow.right = newNode;
			}
		}
	}

	// Traversal method
	void callPreOrder() {
		preOrder(root);
	}

	void preOrder(Node root) {
		if(root != null) {
			System.out.println(root.data);

			preOrder(root.left);

			preOrder(root.right);
		}
	}

	void callInOrder() {
		inOrder(root);
	}

	void inOrder(Node root) {
		if(root != null){
			inOrder(root.left);

			System.out.println(root.data);

			inOrder(root.right);
		}
	}

	void callPostOrder() {
		postOrder(root);
	}

	void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);

			postOrder(root.right);

			System.out.println(root.data);
		}
	}

	public void deleteNode (int data){
		Node p, follow, t, f;

		p = root;
		follow = null;
		// Find the node to be deleted
		while (p != null) {
			if(p.data == data){
				break;
			}
			follow = p;

			if(data <= p.data){
				p = p.left;
			}else {
				p = p.right;
			}

		}

		if (null == p){
			System.out.println("Required node not found");
		}else {
			// Either a leaf node or empty list

			// Element only have the right child and left child is empty
			if (null == p.left){
				// p is not root
				if (p != root) {
					// p.right - because p.left is null
					if(follow.left == p){
						follow.right = p.right;
					}else {
						follow.right = p.right;
					}
				}else {
					// When left hand side of the root is empty
					root = p.right;
				}
			} else {
				// Element only have the left child and right child is empty
				if (p.right == null) {
					if (p != root) {
						if (follow.left == p){
							follow.left = p.left;
						}else {
							follow.right = p.left;
						}
					}else {
						// p is root and it have only left child. Right child is empty
						root = p.left;
					}
				} else {
					// Element have both the left and right child
					t = p.right;
					f = p;

					while (t.left != null){
						f = t;
						t = t.left;
					}

					// Copy the data from the mimnum node from the right to the node to be deleted
					p.data = t.data;
					// This condition check if the node to be delete is a root node with only one right node
					if(f != p) {
						f.left = t.right;
					} else {
						f.right = t.right;
					}
				}
			}
		}
	}

	public void search (int data) {
		Node p;

		p = root;

		while (p != null) {
			if(p.data == data) {
				break;
			}

			if (data < p.data) {
				p = p.left;
			}else {
				p = p.right;
			}
		}

		if (null == p) {
			System.out.println("Required node not found");
		} else {
			System.out.println("Node found at address: " + p);
		}
	}

	public void levelNode (int data) {
		int level = 0;
		Node p;

		p = root;

		while (p != null) {
			if (p.data == data) {
				break;
			}

			level ++;

			if (data <= p.data) {
				p = p.left;
			} else {
				p = p.right;
			}
		}

		if (null == p) {
			System.out.println ("Required node not found");
		}else {
			System.out.println("Level of node is: " + level);
		}
	}

	public void callNodeCount(){
		numberOfNodes = 0;
		countNode(root);
		System.out.println ("Number of nodes is: " + numberOfNodes);
	}

	void countNode(Node root) {
		if (root != null) {
			countNode(root.left);
			numberOfNodes ++;
			countNode(root.right);
		}
	}

	public void callLeafNodeCount(){
		numberOfLeafNodes = 0;
		countLeafNode(root);

		System.out.println ("Number of leaf nodes is: " + numberOfLeafNodes);
	}

	void countLeafNode(Node root) {
		if (root != null) {
			countLeafNode(root.left);
			if (root.left == null && root.right == null) {
				numberOfNodes ++;
			}
			countLeafNode(root.right);
		}
	}

	void findSmallest () {
		Node p;

		if (root != null) {
			p = root;

			while(p.left != null) {
				p = p.left;
			}

			System.out.println ("Smallest node data is: " + p.data);
		}else {
			System.out.println ("Tree is empty");
		}
	}

	void findLargest () {
		Node p;

		if (root != null) {
			p = root;

			while(p.right != null) {
				p = p.right;
			}

			System.out.println ("Largest node data is: " + p.data);
		}else {
			System.out.println ("Tree is empty");
		}
	}
}

class BSTMain {
	public static void main(String args[]) {
		BST bst = new BST();
		Scanner sc = new Scanner(System.in);
		int choice, data, positionData;
		System.out.println(" \nMenu: \n \n " +
							" 1. Insert new node \n " +
							" 2. Pre order traversal \n " +
							" 3. In order traversal \n " +
							" 4. Post order traversal \n " +
							" 5. Delete \n " +
							" 6. Search \n " +
							" 7. Find level of the node \n " +
							" 8. Find number of nodes \n " +
							" 9. Find number of leaf nodes \n " +
							" 10. Find smallest node \n " +
							" 11. Find largest node \n \n " +
							" 12. Exit program");

		do {
			System.out.println("Enter your choice");

			choice = sc.nextInt();

			switch(choice) {
				case 1: 
						System.out.println("Enter the node");
						data = sc.nextInt();
						bst.insert(data);
						break;
				case 2:
						System.out.println("Pre order traversal of the tree:");
						bst.callPreOrder();
						break;
				case 3:
						System.out.println("Post order traversal of the tree:");
						bst.callInOrder();
						break;
				case 4:
						System.out.println("In order traversal of the tree:");
						bst.callPostOrder();
						break;
				case 5: 
						System.out.println("Enter the node to be deleted");
						data = sc.nextInt();
						bst.deleteNode(data);
						break;
				case 6: 
						System.out.println("Enter the node to be searched");
						data = sc.nextInt();
						bst.search(data);
						break;
				case 7: 
						System.out.println("Enter the node to get its level in tree");
						data = sc.nextInt();
						bst.levelNode(data);
						break;
				case 8: 
						System.out.println("Number of nodes in the tree are: ");
						bst.callNodeCount();
						break;
				case 9:
						System.out.println("Number of leaf nodes in the tree are: ");
						bst.callLeafNodeCount();
						break;
				case 10:
						System.out.println("Smallest node in the tree is: ");
						bst.findSmallest();
						break;
				case 11:
						System.out.println("largest nodes in the tree is: ");
						bst.findLargest();
						break;
				case 12: 
						break;
				default: 
						System.out.println("Wrong choice");
			}

		}while(choice != 12);
	}
}

