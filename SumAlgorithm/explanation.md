# Problem 1: Sum of All Numbers in an Array

## Problem Description

Given an array of integers, calculate the sum of all numbers in the array.

## Approach

To find the sum of all numbers in the array, we can use the built-in `sum()` function in Python. It takes an iterable as input and returns the sum of all elements in that iterable. O(nlogn)

## Algorithm

1. Initialize a variable `total` to 0.
2. Iterate through each element `num` in the given array.
    - Add `num` to `total`.
3. Return the value of `total`.

## Time Complexity Analysis

The time complexity of this solution is O(n), where n is the number of elements in the array. This is because we need to iterate through each element once to calculate the sum.

## Example

**Input:**

nums = [1, 2, 3, 4, 5]


## Other Notes

- This solution assumes that the input array only contains integer numbers.
- It uses the built-in `sum()` function, which simplifies the code and improves readability.
- If the array is empty, the result will be 0.


**Output:**

