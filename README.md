# Spiral Matrix II LeetCode # 

## Problem ## 

Given a positive integer *n*, generate a square matrix filled with elements from 1 to *n<sup>2</sup>* in spiral order.

## Solution ## 

In this approach, the algorithm starts by creating an empty n x n matrix and then passess a reference of the matrix into two methods -- ``` fillRightLayer(matrix, n, begin, end)``` and ``` fillLeftLayer(matrix, n, begin, end)```-- that fill different parts of the matrix. Each call each other until the matrix is filled with values 1 through *n<sup>2</sup>*. Those two parts are called "Right Layer" and "Left Layer". Right Layer deals with the top rows, rightmost columns and Left Layer deals with the bottom rows, leftmost columns. Right Layer is computed first, then Left Layer, and so forth until the total number of elements equals *n<sup>2</sup>*. Below steps through ``` Solution.java ``` to illustrate the process and Right / Left Layers. 

 - ```generateMatrix(int n)``` is called. ```int[][] matrix = new int[n][n]``` instatiates a new matrix of size *n<sup>2</sup>*. ```matrix``` is set equal to the matrix returned by ```fillRightLayer(matrix, n, 0, 0, n)``` which begins the recursive loop building the spiral matrix. So after this method is called once,  for ```n = 3```our spiral matrix looks like the following:  
```
[
 [ 0, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 0 ]
]
```
