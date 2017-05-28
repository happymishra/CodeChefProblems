class QuickSortMain{
	public static void main(String args[]) {
		int array[] = {7, 6, 5, 4, 3, 2, 1, 0};
		QuickSort quickSortObj = new QuickSort();
		quickSortObj.quickSort(array, 0, array.length-1);

		for(int i =0; i < array.length; i++){
			System.out.print(array[i] + "\t");
		}
		System.out.println();

	}
}

class QuickSort {

	void quickSort(int[] mainArray, int start, int end){
		if(start < end){
			int pivotIndex = partition(mainArray, start, end);
			quickSort(mainArray, start, pivotIndex-1);
			quickSort(mainArray, pivotIndex + 1, end);

		}
	}

	int partition(int[] array, int start, int end){
		int pivot = array[end];
		int partitionIndex = start;

		 for(int i = start; i < end; i++){
		 	if(array[i] <= pivot) {
		 		// Swap if element is lesser than pivot
		 		int temp = array[i];
		 		array[i] = array[partitionIndex];
		 		array[partitionIndex] = temp;
		 		partitionIndex ++;
		 	}
		 }

		 // Swap pivot with elements at partition index
		 int temp = array[partitionIndex];
		 array[partitionIndex] = array[end];
		 array[end] = temp;
		 return partitionIndex;
	}


}