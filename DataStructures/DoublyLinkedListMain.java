import java.util.*;

class Node {
	int data;
	Node next, prev;

	Node(int data){
		this.data = data;
		next = prev = null;
	}
}

class DoublyLinkedList {
	private Node first, last;

	DoublyLinkedList (){
		first = last = null;
	}

	void insertFirst(int data){
		Node newNode = new Node(data);
		first = last = newNode;
	}

	void insertAfter(int data, int positionData) {
		Node p = first,
			 newNode = new Node(data);

		while (p != null){
			if(p.data == positionData){
				break;
			}

			p = p.next;
		}

		if (null == p){
			System.out.println("Required node not found");
		}else{
			if (last == p){
				newNode.prev = last;
				last.next = newNode;
				last = newNode;
			}
			else{
				newNode.next = p.next;
				newNode.prev = p;
				p.next.prev = newNode;
				p.next = newNode;
			}
		}
	}

	public void insertBefore(int data, int positionData){
		Node newNode = new Node(data);
		Node p = first;

		while (p != null){
			if(p.data == positionData){
				break;
			}

			p = p.next;
		}

		if (null == p){
			System.out.println("Required node not found");
		}else{
			if(p == first){
				newNode.next = first;
				first.prev = newNode;
				first = newNode;
			}else{
				newNode.prev = p.prev;
				newNode.next = p;
				p.prev.next = newNode;
				p.prev = newNode;
			}
		}
	}

	public void delete (int data) {
		Node p = first;

		while(p != null){
			if(p.data == data){
				break;
			}

			p = p.next;
		}

		if (null == p){
			System.out.println("Required node not found");
		}else{
			if(p == first && p == last){
				last = first = null;
			}else{
				if( p == first){
					first = first.next;
					first.prev = null;
				}else{
					if(p == last){
						last = last.prev;
						last.next = null;
					}else{
						p.prev.next = p.next;
						p.next.prev = p.prev;
					}
				}
			}
		}
	}

	public void search(int data) {
		Node p = first;

		while(p != null){
			if(p.data == data){
				break;
			}

			p = p.next;
		}

		if(null == p){
			System.out.println("Required node not found");
		}else{
			System.out.println("Required node found at address: " + p);
		}
	}

	public boolean empty(){
		if(null == first){
			return true;
		}else{
			return false;
		}
	}

	public void traverseLeftRight() {
		Node p = first;

		if (null == first){
			System.out.println("Linked list is empty");
		}else{
			p = first;

			while(p != null){
				System.out.println( p.data + " \t ");
				p = p.next;
			}
		}
	}

	public void traverseRightLeft() {
		Node p = last;

		if (null == first){
			System.out.println("Linked list is empty");
		}else{
			while(p != null){
				System.out.println( p.data + " \t ");
				p = p.prev;
			}
		}
	}

	public void count(){
		Node p = first; 
		int count = 0;

		while(p != null){
			count++;
			p = p.next;
		}

		System.out.println("Number of node in the linked list are: " + count);
	}
}

class DoublyLinkedListMain {
	public static void main(String args[]) {
		DoublyLinkedList DSL = new DoublyLinkedList();
		Scanner sc = new Scanner(System.in);
		int choice, data, positionData;
		System.out.println(" \nMenu: \n \n " +
							" 1. Insert first node \n " +
							" 2. Insert Before \n " +
							" 3. Insert After \n " +
							" 4. Delete \n " +
							" 5. Search \n " +
							" 6. Empty \n " +
							" 7. Traverse left to right\n " +
							" 8. Traverse right to left\n " +
							" 9. Count nunber of nodes \n " +
							" 10. Exit program");

		do {
			System.out.println("Enter your choice");

			choice = sc.nextInt();

			switch(choice) {
				case 1: 
						System.out.println("Enter the first node");
						data = sc.nextInt();
						DSL.insertFirst(data);
						break;
				case 2:
						System.out.println("Enter the new node");
						data = sc.nextInt();
						System.out.println("Enter the node before which new node has to be inserted");
						positionData = sc.nextInt();
						DSL.insertBefore(data, positionData);
						break;
				case 3: 
						System.out.println("Enter the new node");
						data = sc.nextInt();
						System.out.println("Enter the node after which new node has to be inserted");
						positionData = sc.nextInt();
						DSL.insertAfter(data, positionData);
						break;
				case 4: 
						System.out.println("Enter the node to be deleted");
						data = sc.nextInt();

						if(DSL.empty()){
							System.out.println("List is empty");
						}else{
							DSL.delete(data);
						}
						break;
				case 5: 
						System.out.println("Enter the node to be searched");
						data = sc.nextInt();

						if(DSL.empty()){
							System.out.println("List is empty");
						}else{
							DSL.search(data);
						}
						break;
				case 6: 
						DSL.empty();
						break;
				case 7:
						if(DSL.empty()){
							System.out.println("List is empty");
						}else{
							DSL.traverseLeftRight();
						}
						break;
				case 8:
						if(DSL.empty()){
							System.out.println("List is empty");
						}else{
							DSL.traverseRightLeft();
						}
						break;
				case 9:
						DSL.count();
						break;
				case 10: 
						break;
				default: 
						System.out.println("Wrong choice");
			}

		}while(choice != 10);
	}
}
