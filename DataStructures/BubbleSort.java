class BubbleSort {
	public static void main(String args[]){
		int[] array = {2, 5, 9, 1, 0, 59, 2};
		int length = array.length;

		bubbleSort(array, length);

		System.out.println("Sorted array is:");

		// Prints the sorted array
		for(int i = 0; i < length; i++){
			System.out.print(array[i] + " ");
		}
	}

	/*
	 * Bubble sort method. Sorts the arrays using bubble sort
	*/
	static void bubbleSort(int[] array, int n) {
		/*
		 * k is used for iterating each element of the array
		 * i is used for swapping the adjancents element of the array 
		 * At the end of each k, highest elements gets sorted
		 * flag is used to prevent iterating over already soted array
		 * In the inner loop n-k-1 us used to prevent attempting swappig of elements on already
		 * sorted elements
		*/
		for(int k = 0; k < n ; k++){
			// Checks if the array is already sorted. If no swapping happens it means the 
			// array is sorted
			boolean flag = false;
			// Places each largest element at the end of the array
			for(int i = 0; i < n-k-1; i++){

				// If element is greater swap the elements
				if(array[i] > array[i+1]){
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
				flag = true;
			}
			
			if(!flag){
				break;
			}
		}
	}
}