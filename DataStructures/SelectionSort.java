class SelectionSort {
	public static void main(String args[]){
		int[] array = {2, 5, 9, 1, 0, 59, 2};
		int length = array.length;

		selectionSort(array, length);

		System.out.println("Sorted array is:");

		// Prints the sorted array
		for(int i = 0; i < length; i++){
			System.out.print(array[i] + " ");
		}
	}

	/*
	 * Selection sort method. Sorts the arrays using selection sort
	*/
	static void selectionSort(int[] array, int n) {
		int minIndex;  // Tracks the minimum element index for swapping

		// Iterate over all the n-1 elements
		// n-1 elements because the last element will be sorted automatically 
		// if every other element is sorted
		for(int i = 0; i < n-1; i++){
			minIndex = i;

			// Find minimum element index from the remaining elements
			for(int j = i+1; j < n; j++){
				if(array[j] < array[minIndex]){
					minIndex = j;
				}
			}

			// Swap the minimum element with the i th element
			// thus placing the sorted element at its rightfull place
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}
}