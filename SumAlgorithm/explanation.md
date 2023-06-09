# Problem 1: Sum of All Numbers in an Array

## Problem Description

Given an array of integers, calculate the sum of all numbers in the array.

## Approach

To find the sum of all numbers in the array, we can use the built-in `sum()` function in Python. It takes an iterable as input and returns the sum of all elements in that iterable.

## Algorithm

1. Initialize a variable `total` to $0$.
2. Iterate through each element `num` in the given array.
    - Add `num` to `total`.
3. Return the value of `total`.

## Time Complexity Analysis

The time complexity of this solution is O(n), where n is the number of elements in the array. This is because we need to iterate through each element once to calculate the sum.

$T(n) = O(nlogn) + O(n) = O(nlogn)$

The summation from 1 to \(n\) can be represented as:

\[
\sum_{i=1}^{n} i
\]

This represents the sum of all natural numbers from 1 to \(n\).


## Example

**Input:**
