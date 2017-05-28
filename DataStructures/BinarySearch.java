public class BinarySearch {

	public static void main(String[] args) {

		int[] array = {1, 9, 15, 20 ,30, 35};

		int index = binarySearch(array, 0, array.length-1, 35);
		
		if(-1 == index){
			System.out.println("Element not found");
		}else {
			System.out.println("Element found at position: " + (index + 1));
		}

	}

	/*
	 * Binary search requires the array to be sorted
	 * If the element to be searced is less than array[mid], it means it is present
	 * on the left side of the mid else on the right of the mid
	*/
	public static int binarySearch(int[] array, int left, int right, int elementToBeSearched) {

		// If left exceeds the right it means element is not present
		// Element not found return -1
		if (left > right){
			return -1;
		}

		int mid = (left + right) / 2;

		if(elementToBeSearched == array[mid]){
			return mid; // Found the element. Return the index
		}else{
			// Element to be searched present on the left side of mid
			if(elementToBeSearched < array[mid]){
				return binarySearch(array, left, mid-1, elementToBeSearched);
			}else{
			// Element to be searched present on the right side of mid
				return binarySearch(array, mid+1, right, elementToBeSearched);
			}
		}
	}
}