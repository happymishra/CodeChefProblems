/* 
	Write a java program to create a single linked list and perform following operations:
		1. Insert into the list
		2. Delete from the list
		3. Search for a data item into the list
		4. Reverse the linked list
*/

import java.util.*;

class Node {
	int data;
	Node next;

	Node(int data){
		this.data = data;
		next = null;
	}
}

class SinglyLinkedList {
	private Node first;

	SinglyLinkedList(){
		first = null;
	}

	public void insertBeginning(int data) {
		Node newNode = new Node(data);  // {newNode.data = data, newNode.node = null}
		if(null == first){
			first = newNode;
		}else{
			System.out.println("First node already present with value: " + first.data);
		}
	}

	public void insertAfter(int data, int positionData) {
		Node newNode = new Node(data), // {newNode.data = data, newNode.node = null}
		p = first;

		while(p != null){
			if(p.data == positionData){
				break;
			}

			p = p.next;
		}

		if(null == p){
			System.out.println("Required node not found");
		}else{
			newNode.next = p.next;
			p.next = newNode;
		}
	}

	public void insertBefore(int data, int positionData) {
		Node newNode = new Node(data), // {newNode.data = data, newNode.node = null}
		p = first,
		follow = null;

		while(p != null){

			if(p.data == positionData){
				break;
			}

			follow = p;
			p = p.next;
		}

		if(null == p){
			System.out.println("Required node not found");
		}else{

		}

		if(first == p){
			newNode.next = first;
			first = newNode;
		}else{
			follow.next = newNode;
			newNode.next = p;
		}
	}

	public void delete(int data){
		Node p = first,
		follow = null;

		while(p != null){

			if(p.data == data){
				break;
			}

			follow = p;
			p = p.next;

		}

		if(null == p) {
			System.out.println("Required node not found");
		}else{
			if(p == first){
				first = first.next;
			}else{
				follow.next = p.next;
			}
		}
	}

	public void search(int data) {
		Node p = first;
		boolean found = false;

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

	public void reverse() {
		Node p = first, 
			 ahead = null, 
			 follow = null;

		while(p != null) {
			ahead = p.next;
			p.next = follow;
			follow = p;
			p = ahead; 
		}

		first = follow;
	}

	public boolean empty(){
		if(null == first){
			return true;
		}else{
			return false;
		}
	}

	public void traverse() {
		if (null == first){
			System.out.println("Linked list is empty");
		}else{

			System.out.println("Nodes of the linked list are: ");
			Node p = first;

			while(p != null){
				System.out.println( p.data + " \t ");
				p = p.next;
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

	public void destroyList(){
		first = null;
	}
}

class SinglyLinkedListMain {
	public static void main(String args[]) {
		SinglyLinkedList SSL = new SinglyLinkedList();
		Scanner sc = new Scanner(System.in);
		int choice, data, positionData;
		System.out.println(" \nMenu: \n \n " +
							" 1. Insert first node \n " +
							" 2. Insert Before \n " +
							" 3. Insert After \n " +
							" 4. Delete \n " +
							" 5. Search \n " +
							" 6. Reverse \n " +
							" 7. Empty \n " +
							" 8. Traverse \n " +
							" 9. Count nunber of nodes \n " +
							" 10. Destroy \n \n " +
							" 11. Exit program");

		do {
			System.out.println("Enter your choice");

			choice = sc.nextInt();

			switch(choice) {
				case 1: 
						System.out.println("Enter the first node");
						data = sc.nextInt();
						SSL.insertBeginning(data);
						break;
				case 2:
						System.out.println("Enter the new node");
						data = sc.nextInt();
						System.out.println("Enter the node before which new node has to be inserted");
						positionData = sc.nextInt();
						SSL.insertBefore(data, positionData);
						break;
				case 3: 
						System.out.println("Enter the new node");
						data = sc.nextInt();
						System.out.println("Enter the node after which new node has to be inserted");
						positionData = sc.nextInt();
						SSL.insertAfter(data, positionData);
						break;
				case 4: 
						System.out.println("Enter the node to be deleted");
						data = sc.nextInt();

						if(SSL.empty()){
							System.out.println("List is empty");
						}else{
							SSL.delete(data);
						}
						break;
				case 5: 
						System.out.println("Enter the node to be searched");
						data = sc.nextInt();

						if(SSL.empty()){
							System.out.println("List is empty");
						}else{
							SSL.search(data);
						}
						break;
				case 6: 
						if(SSL.empty()){
							System.out.println("List is empty");
						}else{
							SSL.reverse();
						}
						break;
				case 7: 
						SSL.empty();
						break;
				case 8:
						if(SSL.empty()){
							System.out.println("List is empty");
						}else{
							SSL.traverse();
						}
						break;
				case 9:
						SSL.count();
						break;
				case 10:
						SSL.destroyList();
						break;
				case 11: 
						break;
				default: 
						System.out.println("Wrong choice");
			}

		}while(choice != 11);
	}
}
