# Spiral Matrix II LeetCode # 

## Problem ## 

Given a positive integer *n*, generate a square matrix filled with elements from 1 to *n<sup>2</sup>* in spiral order.

## Solution ## 

### OVERVIEW ### 
In this approach, the algorithm starts by creating an empty n x n matrix and then passess a reference of the matrix into two methods -- ``` fillRightLayer(matrix, n, count, begin, end)``` and ``` fillLeftLayer(matrix, n, count, begin, end)```-- that fill different parts of the matrix. Each call each other until the matrix is filled with values 1 through *n<sup>2</sup>*. Those two parts are called "Right Layer" and "Left Layer". Right Layer deals with the top rows, rightmost columns and Left Layer deals with the bottom rows, leftmost columns. Right Layer is computed first, then Left Layer, and so forth until the total number of elements equals *n<sup>2</sup>*. Below steps through ``` Solution.java ``` to illustrate the process and Right / Left Layers. Before that, here is the method parameters explained: 

* **matrix**: a reference to the square matrix instatiated in ```generatedMatrix(int n)``` which will be updated recursively until a spiral matrix is created. 
* **n**: Given positive integer. Passed in to ```fillRightLayer(matrix, n, count, begin, end)``` and ```fillLeftLayer(matrix, n, count, begin, end - 1)``` to compute the exiting condition ``` count == n*n``` each time those methods are called. 
* **count**: The number of elements inserted into ```matrix```. 
* **begin**: Used to determine what rows and columns to start with in the right layer. Use to determine when to end a loop in the left layer.  
* **end**:  Use to determine when end a loop in the right layer. Used to determine what rows and columns to start with in the left layer. 

### CODE STEP-THRU ### 
Below illustrates ```Solution.java``` process for input ```n = 3```

 - ```generateMatrix(int n)``` is called. A new matrix of size *n<sup>2</sup>*. ```matrix``` is created. Then it is set equal to the result returned by ```fillRightLayer(matrix, n, 0, 0, n)``` which begins the recursive loop that builds the spiral matrix. So after this method is called once,  for ```n = 3```our spiral matrix looks like the following:  
### matrix: #### 
```
                                       
                                            [ 0, 0, 0 ],
                                            [ 0, 0, 0 ],
                                            [ 0, 0, 0 ]
                                         
```
```count = 0```, ```begin = 0```, ```end = 0```, ```n = 3```, matrix is shown above.  
- ```fillRightLayer(matrix, n, count, begin, end)``` is called. A for loop is called looping over the first row as indicated by the ```begin``` field, then finishing at the index specified by the ```end ``` field. When looping over, the current value of ```count ``` is inserted into the matrix and is incremented.  When the index ```i``` is equal to ```end ```, the inner loop starts. This goes over the column starting from ```begin + 1``` to ```end ```. After, a call to ```fillLeftLayer(matrix, n, count, begin, end - 1)``` is done to compute the bottom half of the matrix. 

### matrix (after fillRight): #### 
```
                                       
                                            [ 1, 2, 3 ],
                                            [ 0, 0, 4 ],
                                            [ 0, 0, 5 ]
                                         
```
```count = 5```, ```begin = 0```, ```end = 2```, ```n = 3```, new matrix is shown above. 

-  ```fillLeftLayer(matrix, n, count, begin, end - 1)``` is called, picking up where ```fillRightLayer(matrix, n, count, begin, end)``` left off. ```end``` is used to determine what row to loop over, as well as what column after the row is computed. Loops decrement down to the ```begin``` or ```begin + 1```  as the spiral order adds elements to the matrix in reverse order. As seen below: 

### matrix (after fillLeft): #### 

```
                                       
                                            [ 1, 2, 3 ],
                                            [ 8, 0, 4 ],
                                            [ 7, 6, 5 ]
                                         
```
```count = 8```, ```begin = 1```, ```end = 2```, ```n = 3```, new matrix is shown above.


### matrix (after fillRight, final): #### 
```
                                       
                                            [ 1, 2, 3 ],
                                            [ 8, 9, 4 ],
                                            [ 7, 6, 5 ]
                                         
```
```count = 9```, ```begin = 1```, ```end = 2```, ```n = 3```, new matrix is shown above.
 At this point, the exiting conditon ``` count == n*n``` is met, so the recursion terminates and returns the completed spiral matrix. 


## SPACE / TIME - ANALYSIS ### 

**Time Complexity**: O(n<sup>2</sup>). Quick Proof: When the recursion starts, operations in ```fillRightLayer(matrix, n, count, begin, end)``` / ```fillLeftLayer(matrix, n, count, begin, end)``` are linear time O(n) but quickly decrease into constant time as ```begin``` and  ``` end``` are increased and decreased respectively. The total runtime is then a sum of the runtime for each method call, yielding O(n + (n - 1) + ... + 1) = O(n<sup>2</sup>).
  
**Space Complexity**:  O(n<sup>2</sup>).  Quick Proof: ```generateMatrix(int n)```  allocates an one matrix of size *n<sup>2</sup>*. Then the recursion loop is entered, until exactly *n<sup>2</sup>* method calls are pushed onto the call stack. 
So total space is *n<sup>2</sup>* + *n<sup>2</sup>* =  2*n<sup>2</sup>*= O(n<sup>2</sup>).
