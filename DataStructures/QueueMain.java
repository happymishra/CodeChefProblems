import java.util.*;

class Queue{
	int queueArray[];
	int front, rear;

	Queue(){
		queueArray = new int[5];
		front = 0;
		rear = -1;
	}

	Queue(int size){
		queueArray = new int[size];
		front = 0;
		rear = -1;
	}

	void insert(int x){
		if(rear == queueArray.length - 1){
			System.out.println("Queue overflow");
		}
		else{
			rear++;
			queueArray[rear] = x;
		}
	}

	boolean empty(){
		if(rear < front){
			return true;
		}else{
			return false;
		}
	}

	int remove(){
		int x = queueArray[front];
		front++;
		return x;
	}

	void display(){
		System.out.println("Elements of the queue are: ");

		for(int i = front; i<= rear; i++){
			System.out.println(queueArray[i]);
		}
	}

	void destroy(){
		front = 0;
		rear = -1;
	}
}// end of Queue class

public class QueueMain {
	public static void main(String args[]) {
		Queue q = new Queue();
		Scanner sc = new Scanner(System.in);
		int choice, data;

		do{
			System.out.println("Menu: \n \n 1. Insert \n 2. Remove \n 3. Display \n 4. Destroy \n \nExit program");

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
				case 4: 
					q.destroy();
				break;

				case 5: break;

				default: 
				System.out.println("Wrong choice");
			}
		}while(choice != 5);
	}
}