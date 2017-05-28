import java.util.*;
/*
 *As the index here we are starting with 0 
 * leftChild = 2 * parentIndex + 1;
 * rightChild = 2 * parentIndex + 1 or leftChild + 1;
 * parentIndex = (childIndex - 1) / 2
*/

class HeapSort {
	private static final int FRONT = 0;
	int heapArray[], top;

	HeapSort (int heapArray[]) {
		this.heapArray = heapArray;
		top = heapArray.length;
	}

	public void sort () {
		// Create a maximum heap of the given array	
		createMaxHeap();

		for (int i=top-1; i>=0; i--)
        {
           // Popped the maximum element from the array and re max heapify the array
           removeMaximum();
        }
	}

	// Create max heap for the given array
	public void createMaxHeap() {
		for (int pos = ((top - 1)/ 2); pos >= 0; pos--) {
			maxHeapify(pos);
		}
	}

	// Get the parent index
	int getParentIndex(int childIndex) {
		int p = (childIndex - 1) / 2;
		return p;
	}

	// Get the left child index
	int getLeftChildIndex(int parentIndex) {
		return 2*parentIndex + 1;
	}

	// Get the right child index
	int getRightChildIndex(int parentIndex) {
		return 2*parentIndex + 2;
	}

	// Check if the tree is leaf or not
	// for an array of length n leaf nodes will be from n / 2 to n -1
	boolean isLeaf (int position) {
		if (position >=  (top / 2)  &&  position < top) {
			return true;
		}
		return false;
	}

	// swaps the maximum element with the minimum element
	public void removeMaximum() {
		swap(FRONT, --top);
		// Re-heapify the tree after swapping the max elemen with the minimum element
		maxHeapify(FRONT);
	}

	private void maxHeapify(int position) {
			int leftChildIndex = getLeftChildIndex(position);
			int rightChildIndex = leftChildIndex + 1;
			int largest = position;

			// If leftChildIndex element is greater than largest = leftChildIndex
			// leftChildIndex < top is checked so that index is not greater than the length
			// of the array
			if(leftChildIndex < top && heapArray[largest] < heapArray[leftChildIndex]){
				largest = leftChildIndex;
			}

			// If rightChildIndex element is greater than largest = rightChildIndex
			if (rightChildIndex < top && heapArray[largest] < heapArray[rightChildIndex]){
				largest = rightChildIndex;
			}

			// Swap the element only if the largest element is either te left child or 
			// the right child
			if (largest != position){
				swap(position, largest);
				maxHeapify(largest);
			}
	}

	// Swaps elemnt with index1 with the element with index2
	private void swap(int index1,int index2) {
		int tmp = heapArray[index1];
		heapArray[index1] = heapArray[index2];
		heapArray[index2] = tmp;
	}

	// Prints the array in ascending order
	void printArray()
    {
        for (int i=0; i < heapArray.length; i++)
            System.out.print(heapArray[i]+" ");
        System.out.println();
    }
}

class HeapSortMain {
	public static void main (String args[]) {
		int arr[] = {12, 21, 12, 44, 13, 5, 32, 0};

		HeapSort hs = new HeapSort(arr);
        hs.sort();
 
        System.out.println("Sorted array is");
        hs.printArray();
	}
}