package linear;

public class Matrix {
	
	public void rotateClockwiseByOneEle(int[][] matrix) {
		
		int row = 0;
		int col = 0;
		
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		
		while (row < m && col < n) {
			
			//remember the first ele of next row
			int first = matrix[row + 1][col];
			//rotate the first row of remaining row
			for (int i = col; i < n - col -2; i ++) {
				int tmp = matrix[row][i+1];
				matrix[row][i+1] = matrix[row][i];
			}
			
		}
	}

}
