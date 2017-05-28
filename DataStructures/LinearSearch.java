public class LinearSearch {

	public static void main(String[] args) {

		int[] array = {1, 9, 15, 20 ,30, 35};

		int index = linearSearch(array, 1);

		if(-1 == index){
			System.out.println("Element not found");
		}else {
			System.out.println("Element found at position: " + (index + 1));
		}

	}

	/*
	 * Linear search iterates over all the elements to find the element to be searched
	 * Linear search does not requires the array to be sorted
	*/
	public static int linearSearch(int[] array, int elementToBeSearched) {
		int i = 0;

		// While element is not found, iterate over the element
		while(i < array.length && array[i] != elementToBeSearched){
			i++;
		}

		// Element not found return -1
		if (i > array.length-1){
			return -1;
		}else {
		// Element found return the index
			return i;
		}
	}
}