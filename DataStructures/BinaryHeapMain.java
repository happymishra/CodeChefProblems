import java.util.*;

class BinaryHeap {
	private static final int FRONT = 1;
	int heapArray[], top;

	BinaryHeap(int heapSize) {
		heapArray = new int[heapSize + 1];
		top = 0;
		heapArray[0] = Integer.MAX_VALUE;
	}

	void insert(int data) {
		heapArray[++top] = data;
		int current = top, currentParentIndex = getParentIndex(current);

		while(heapArray[current] > heapArray[currentParentIndex]) {
			swap(current, currentParentIndex);
			current = getParentIndex(current);
			currentParentIndex = getParentIndex(current);
		}		
	}

	private void swap(int index1,int index2) {
		int temp = heapArray[index1];
		heapArray[index1] = heapArray[index2];
		heapArray[index2] = temp;
	}

	int getParentIndex(int childIndex) {
		return (childIndex) / 2;
	}

	int getLeftChild(int parentIndex) {
		return 2 * parentIndex;
	}

	int getRightChild(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	boolean isLeaf (int position) {
		if (position >=  (top / 2)  &&  position <= top) {
			return true;
		}
		return false;
	}

	private void maxHeapify(int position) {
		if (!isLeaf(position)){
			if(heapArray[position] < heapArray[getLeftChild(position)] || heapArray[position] < heapArray[getRightChild(position)]){
				if(heapArray[getLeftChild(position)] > heapArray[getRightChild(position)]){
					swap(position, getLeftChild(position));
					maxHeapify(getLeftChild(position));
				}else {
					swap(position, getRightChild(position));
					maxHeapify(getRightChild(position));
				}
			} 
		}
	}

	public void createMaxHeap() {
		for (int pos = (top / 2); pos >= 1; pos--) {
			maxHeapify(pos);
		}
	}

	public int removeMaximum() {
		int popped = heapArray[FRONT];
		heapArray[FRONT] = heapArray[top--]; 
		maxHeapify(FRONT);
		return popped;
	}

	public void print() {
		for (int i = 1; i <= top / 2; i++)
		{
			System.out.print(" PARENT : " + heapArray[i] + " LEFT CHILD : " + heapArray[2*i]
				+ " RIGHT CHILD :" + heapArray[2 * i  + 1]);
			System.out.println();
		}
	}
}

class BinaryHeapMain {
	public static void main (String args[]) {
		BinaryHeap maxHeap = new BinaryHeap(15);

		Scanner sc = new Scanner(System.in);

		int choice, data, positionData;
		System.out.println(" \nMenu: \n \n " +
			" 1. Insert new element in the array \n " +
			" 2. Get Maximum \n " +
			" 3. Print \n " +
			" 4. Exit program");
		do {
			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch(choice) {
				case 1: 
						System.out.println("Enter the new element");
						data = sc.nextInt();
						maxHeap.insert(data);
						maxHeap.createMaxHeap();
						break;
				case 2: 
						int maxEle = maxHeap.removeMaximum();
						System.out.println("Max element is: " + maxEle);
						break;
				case 3:
						maxHeap.print();
				case 4:
						break;
				default:
						System.out.println("Wrong choice");
			}
		}while(choice != 4);
	}
}