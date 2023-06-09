# Problem 1: Two Sum
- [Problem Description]($problem-description)
- [Solution Approach](#solution-approach)
- [Algorithm in Pseudocode](#algorithm-in-pseudocode)
- [Algorithm Complexity Analysis](#algorithm-complexityanalysis)
    - [Time Complexity](#time-complexity)
    - [Space Complexity](#space-complexity)
- [Implementation of the Algorithm](#implementation-of-the-algorithm)

## Problem Description

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order.

 
```plaintext
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
```

## Solution Approach

### Quick explanation:

For each number `nums_i`, search for its complement, `complement = target - nums_i`. To overcome the search in the $n-1$ remaining elements, we can use a hashtable to map all values and then search in $O(1)$.

### Detailed explanation:

We are given an array `nums` containing `n` numbers and a target number, such that `nums[i] + nums[j] = target`, and we need to return `i` and `j`.

It's important to notice that we need to return the **indices** and not the value itself. This is a crucial information because if we sort the array, we would end up with incorrect indices as an answer.

#### Intuition

We can solve this problem by searching for the number that, when added to `nums_i`, result in `target`. In other words, we are looking for two numbers that sum up to the target. The number we need to search for is called the complement:

`nums_i + complement = target`
`complement = target - nums_i`

For each number `nums_i`, search for its complement in the remaining $n-1$ elements. However, if we perform this search for each element, we would end up with a quadratic algorithm because we would need to perform a linear search for each element in the remaining `n-1` elements.

Now that we understand the problem, we can see that the main issue is that we need to perform a linear search at each iteration. How can we overcome this problem? Is there a better way to search that is not $O(n)$? Yes, there is! We can use hashtables!

We can create a mapping of all elements `(key, value) -> (nums[j], j)`, and for each `nums_i`, we can look up whether the complement exists in `O(1)`, if the answer is *yes* then we return $i$ and $j$; otherwise we can return $[-1,-1]$ to indicate that no such elements exist.

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
