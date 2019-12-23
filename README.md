# Spiral Matrix II LeetCode # 

## Problem ## 

Given a positive integer *n*, generate a square matrix filled with elements from 1 to *n<sup>2</sup>* in spiral order.

## Solution ## 

In this approach, the algorithm starts by computing the first row of values, then the last column of values (called "Right Layer"), then the last row, first column (called "Left Layer") and so forth until *n<sup>2</sup>* are inserted into the matrix. 

