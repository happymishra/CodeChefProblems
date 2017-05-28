// Array implementation of Stack data struture

import java.util.*;

class Stack {
	int stackArray[];
	int top;

	Stack(){
		stackArray = new int[5];
		top = -1; 
	}

	Stack(int size){
		stackArray = new int[size];
		top = -1;
	}

	void push(int x){
		if(top == stackArray.length - 1){
			System.out.println("Stack overflow");
		}else{
			top++;
			stackArray[top] = x;
		}
	}

	boolean empty(){
		if(top == -1){
			return true;
		}else{
			return false;
		}
	}

	int pop(){
		int x;
		x = stackArray[top];
		top--;
		return x;
	}

	void destroy(){
		top = -1;
	}

	void display(){
		System.out.println("Elements of the stack are: ");

		for(int i = top; i >= 0; i--){
			System.out.println(stackArray[i]);
		}
	}	
}// end of Stack class

public class StackMain {
	public static void main(String args[]) {
		Stack s = new Stack();
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