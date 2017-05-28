// Find Maximum value of abs(i – j) * min(arr[i], arr[j]) in an array arr[]
// Given an array of n distinct elements. Find the maximum of product of Minimum of two numbers in the array and absolute difference of their positions, i.e., find maximum value of abs(i – j) * min(arr[i], arr[j]) where i and j vary from 0 to n-1.

// Input : arr[] = {3, 2, 1, 4}
// Output: 9
// // arr[0] = 3 and arr[3] = 4 minimum of them is 3 and 
// // absolute difference between their position is 
// // abs(0-3) = 3. So product is 3*3 = 9

// Input : arr[] = {8, 1, 9, 4}
// Output: 16
// // arr[0] = 8 and arr[2] = 9 minimum of them is 8 and 
// // absolute difference between their position is 
// // abs(0-2) = 2. So product is 8*2 = 16 
public class MaximNumber {
    public static void main(String[] args) {
        int a[] = {3, 2, 1, 4};
		int left = 0, right = a.length - 1, currentProduct = 0, maxProduct = Integer.MIN_VALUE;
		while(left < right)
		{
			if(a[left] < a[right])
			{
				currentProduct = a[left] * (right - left);
				left++;
			}
			else
			{
				currentProduct = a[right] * (right - left);
				right --;
			}
			maxProduct = Math.max(currentProduct, maxProduct);
		}
		System.out.println("Max Product: " + maxProduct);
    }  
}
