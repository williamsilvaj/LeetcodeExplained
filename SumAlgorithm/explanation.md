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
In our implementation we have two loops, each loop performs only a constant amount of operations like, comparisons, attribuitions, etc. 

Let's call the basic operations of the first loop $c_1$ and for the later loop $c_2$ 

$$T(n) =\sum{i=1}^n c_1 + \sum{i=1}^n c_2 = nc_1 + nc_2 = (c_1 + c_2)n = O(n)$$


### Space Complexity

Space complexity = input space + auxiliary space

Auxiliary Space: the extra space that is taken by an algorithm temporarily to finish its work

Input Space: space taken by the input 

$S(n) = O(n)$

## Implementation of the Algorithm
```java
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the mapping of values to indices
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array and map the elements
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // Iterate through the array and search for the complement
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map and it's not the same element
            if (map.containsKey(complement) && map.get(complement) != i) {
                // Return the indices
                return new int[]{i, map.get(complement)};
            }
        }

        // If no solution is found, return [-1, -1]
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Example usage
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);

        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}


```
