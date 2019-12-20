ass Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n]; 
        return generateMatrix(matrix, n, 0, 0, n); 
    }
    
    private int[][] generateMatrix(int[][] subMatrix, int n, int count, int begin, int end) {
        subMatrix = fillRightLayer(subMatrix, n, count, begin, end); 
        return subMatrix;  
    }
    
    private int[][] fillRightLayer(int[][] subMatrix, int n, int count, int begin, int end) {
        if(count == n*n)  
           return subMatrix; 
    
        // Right layer - row then column 
        for(int i = begin; i < end; i++) {
            subMatrix[begin][i] = ++count;
            if(i + 1 == end) {
                // i is a constant equal to end - 1 in here 
                for(int j = begin + 1; j < end; j++) {
                    subMatrix[j][i] = ++count; 
                }
            }
        }
        
        return fillLeftLayer(subMatrix, n, count, begin, end - 1);  
    }
    
    private int[][] fillLeftLayer(int[][] subMatrix, int n, int count, int begin, int end) {
        if(count == n*n) 
            return subMatrix; 
        
        // column first, then row 
        for(int i = end - 1; i >= begin; i--) {
                subMatrix[end][i] = ++count; 
                if(i == begin) {
                    for(int j = end - 1; j >= begin + 1; j--) {
                        subMatrix[j][i] = ++count; 
                    }
                }
        }
        return fillRightLayer(subMatrix, n, count, begin + 1, end); 
    }
}
