class MergeSortMain {
	public static void main(String args[]){
		int unsortedArray[] = { 1, 4, 20, 10, 8, 5, 3, 2 };
		MergeSort mergeSortObj = new MergeSort();

		mergeSortObj.mergeSort(unsortedArray);

		for(int i = 0; i < unsortedArray.length; i++){
			System.out.print(unsortedArray[i] + "\t");
		}
	}


}

class MergeSort {
	void merge(int [] leftArray, int[] rightArray, int[] mainArray) {
		int leftArraylength = leftArray.length;
		int rightArraylength = rightArray.length;
		int leftArrayIterator = 0;
		int rightArrayIterator = 0;
		int mainArrayIterator = 0;
		// System.out.println("Main Array");
		// for (int i = 0; i < mainArray.length; i ++){
		// 	System.out.print(mainArray[i] + "\t");
		// }
		// System.out.println();
		// System.out.println("Left Array");
		// for (int i = 0; i < leftArray.length; i ++){
		// 	System.out.print(leftArray[i] + "\t");
		// }
		// System.out.println();
		// System.out.println("Right Array");
		// for (int i = 0; i < rightArray.length; i ++){
		// 	System.out.print(rightArray[i] + "\t");
		// }
		// System.out.println();

		while (leftArrayIterator < leftArraylength && rightArrayIterator < rightArraylength){
			if (leftArray[leftArrayIterator] <= rightArray[rightArrayIterator]){
					mainArray[mainArrayIterator] = leftArray[leftArrayIterator];
					leftArrayIterator = leftArrayIterator + 1;
			}else {
					mainArray[mainArrayIterator] = rightArray[rightArrayIterator];
					rightArrayIterator = rightArrayIterator + 1;
			}
			mainArrayIterator = mainArrayIterator + 1;
		}

		while (leftArrayIterator < leftArraylength) {
			mainArray[mainArrayIterator] = leftArray[leftArrayIterator];
			leftArrayIterator = leftArrayIterator + 1;
			mainArrayIterator = mainArrayIterator + 1;
		}

		while (rightArrayIterator < rightArraylength) {
			mainArray[mainArrayIterator] = rightArray[rightArrayIterator];
			rightArrayIterator = rightArrayIterator + 1;
			mainArrayIterator = mainArrayIterator + 1;
		}

		// System.out.println("Sorted Array");
		// for (int i = 0; i < mainArray.length; i ++){
		// 	System.out.print(mainArray[i] + "\t");
		// }
		// System.out.println();
	}

	void mergeSort (int[] unsortedArray){
		int unsortedArrayLength = unsortedArray.length;
		// //System.out.print(unsortedArrayLength);
		// for (int i = 0; i < unsortedArray.length; i ++){
		// 	System.out.print(unsortedArray[i] + "\t");
		// }
		// System.out.println();

		if(unsortedArrayLength < 2){
			return;
		}

		int mid = unsortedArrayLength / 2;

		int [] leftUnsortedArray = new int [mid];
		int [] rightUnsortedArray = new int [unsortedArrayLength - mid];

		for(int i = 0; i <= mid-1; i++) {
			leftUnsortedArray[i] = unsortedArray[i];
		}

		for (int j = mid; j < unsortedArrayLength; j ++){
			rightUnsortedArray[j - mid] = unsortedArray[j];
		}

		mergeSort(leftUnsortedArray);
		mergeSort(rightUnsortedArray);

		merge(leftUnsortedArray, rightUnsortedArray, unsortedArray);
	}
}