import java.util.*;

class Node {
	int data;
	Node next;

	Node(int data){
		this.data = data;
		next = null;
	}
}

class StackUsingLinkedList { 
	Node top;

	StackUsingLinkedList() {
		top = null;
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}

	public boolean empty() {
		if(null == top){
			return true;
		}else{
			return false;
		}
	}

	public int pop() {
		int topElement;

		if(empty()){
			System.out.println("Stack underflow");
			return -1;
		}else{
			topElement = top.data;
			top = top.next;
			return topElement;
		}
	}

	public void display() {
		if(empty()){
			System.out.println("Stack empty");
		}else{
			Node p = top;

			while(p != null){
				System.out.println(p.data + "  ");
				p = p.next;
			}
		}
	}

	public void destroy() {
		top = null;
	}
}

public class StackUsingSLLMain {
	public static void main(String args[]) {
		StackUsingLinkedList s = new StackUsingLinkedList();
		Scanner sc = new Scanner(System.in);
		int choice, data;

		do{
			System.out.println(" \nMenu: \n \n 1. Push \n 2. Pop \n 3. Display \n 4. Destroy \n \nExit program");

			System.out.println("Enter your choice");

        	choice = sc.nextInt();

        	switch(choice){
        		case 1: 
        				System.out.println("Enter integer to push");
        				data = sc.nextInt();
        				s.push(data);
        				break;
        		case 2:
        				if(s.empty()){
        					System.out.println("Stack underflow");
        				}else{
        					data = s.pop();
        					System.out.println("Data popped: " + data);
        				}
        				break;
        		case 3: 
        				if(s.empty()){
        					System.out.println("No elements are present in the stack");
        				}else{
        					s.display();
        				}
        				break;
        		case 4: 
        				s.destroy();
        				break;
        				
        		case 5: break;

        		default: 
        				System.out.println("Wrong choice");
        	}
		}while(choice != 5);
	}
}