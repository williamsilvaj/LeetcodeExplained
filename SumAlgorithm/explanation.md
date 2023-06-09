# Problem 1: Sum of All Numbers in an Array
- [Problem Description]($problem-description)
- [Solution Approach](#solution-approach)
- [Algorithm in Pseudocode](#algorithm-in-pseudocode)
- [Algorithm Complexity Analysis](#algorithm-complexityanalysis)
    - [Time Complexity](#time-complexity)
    - [Space Complexity](#space-complexity)
- [Implementation of the Algorithm](#implementation-of-the-algorithm)

## Problem Description

Given an array `nums` containing `n` real numbers, return the sum of all these numbers

## Solution Approach

To find the sum of all numbers in the array, we can use the built-in `sum()` function in Python. It takes an iterable as input and returns the sum of all elements in that iterable.

## Algorithm in Pseudocode

Note: The following pseudocode represents an algorithmic solution. Please note that, in this pseudocode, array indices and loop iterations are 1-based unless otherwise specified.

```plaintext
Algorithm summation(nums, n):
input: array `nums` containing all numbers and the size of the array `n`
ouput: the sum of all numbers in `nums`

sum := 0
for i = 1 until n do # Iterate from 1 to n (inclusive)
    sum := sum + nums[i]

return sum
```
## Algorithm Complexity Analysis
### Time Complexity

The time complexity of this solution is O(n), where n is the number of elements in the array. This is because we need to iterate through each element once to calculate the sum.

$$T(n) = c_1 + \sum_{i=3}^{n} c_2 = c_1 + \sum_{i=1}^{n-2} c_2 = c_1 + (n-2)c_2 = O(n)$$

### Space Complexity

Space complexity = input space + auxiliary space

Auxiliary Space: the extra space that is taken by an algorithm temporarily to finish its work

Input Space: space taken by the input 

$S(n) = O(n)$

## Implementation of the Algorithm
```java

public class DutchFlag {

	public static void main(String[] args) {

		int[] A = { 2,0,1,0};

		dutchFlagProblem(A);

		for (int e : A) {
			System.out.print(e + " ");
		}

	}

	public static void dutchFlagProblem(int[] A) {

		int low = 0;
		int mid = 0;
		int high = A.length - 1;

		while (mid < high) {

			while (A[low] == 0) {
				low++;
				mid++;
			}

			while (A[mid] == 1) {
				mid++;
			}

			while (A[high] == 2) {
				high--;
			}

			if (mid <= high) {

				if (A[mid] == 0) {
					swap(A, low, mid);
				} else {
					swap(A, mid, high);
				}

			}

		}

	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
```
