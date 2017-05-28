class InsertionSort {
	public static void main (String args[]){
		int array[] = {7, 6, 5, 40, 350, 2, 0, 100};

		insertionSort(array);

		for(int i =0; i < array.length; i++){
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}

	/*
	 * Insertion sort method. Sorts the array using insertion sort
	*/
	static void insertionSort (int[] array){
		int arrayLength = array.length;

		for(int i = 1; i < arrayLength-1; i++){
			int temp = array[i];
			int hole = i;

			// Place the element on the sorted side at appropriate place

			// Checks if the hole elements is less the elements on the left hand side elements
			// move the hole on the left hand side
			// hole is place with which we need to swap the temp
			while(hole > 0 && array[hole-1] > temp){
				array[hole] = array[hole-1];
				hole = hole-1;
			}

			array[hole] = temp;
		}
	}
}