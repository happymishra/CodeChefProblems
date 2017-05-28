import java.util.*;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}
}

class QueueUsingSinglyLinkedList {
	Node front, rear;

	QueueUsingSinglyLinkedList() {
		front = rear = null;
	}

	public boolean empty() {
		if(front == null){
			return true;
		}else{
			return false;
		}
	}

	void insert(int data) {
		Node newNode = new Node(data);
		if(empty()){
			front = rear = newNode;
		}else{
			rear.next = newNode;
			rear = newNode;
		}
	}

	public int remove() {
		int element;
		if(empty()) {
			System.out.println("Queue underflow");
			return -1;
		}else {
			element = front.data;
			front = front.next;
		}

		if(front == null) {
			rear = null;
		}

		return element;
	}

	public void display() {
		if(empty()){
			System.out.println("Queue empty");
		}else{
			Node p = front;

			while(p != null){
				System.out.println(p.data + " ");
				p = p.next;
			}
		}
	}
}

public class QueueUsingSLLMain {
	public static void main(String args[]) {
		QueueUsingSinglyLinkedList q = new QueueUsingSinglyLinkedList();
		Scanner sc = new Scanner(System.in);
		int choice, data;

		do{
			System.out.println("Menu: \n \n 1. Insert \n 2. Remove \n 3. Display \n \n 4. Exit program");

			System.out.println("Enter your choice");
			System.out.println();

			choice = sc.nextInt();

			switch(choice){
				case 1: 
					System.out.println("Enter integer to insert");
					data = sc.nextInt();
					q.insert(data);
					break;
				case 2:
					if(q.empty()){
						System.out.println("Queue underflow");
					}else{
						data = q.remove();
						System.out.println("Data removed: " + data);
					}
					break;
				case 3: 
					if(q.empty()){
						System.out.println("No elements are present in the queue");
					}else{
						q.display();
					}
					break;
				case 4: break;

				default: 
				System.out.println("Wrong choice");
			}
		}while(choice != 4);
	}
}