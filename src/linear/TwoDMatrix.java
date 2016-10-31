package linear;

public class TwoDMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
            
        return searchHelper(matrix, target, 0, 0, matrix.length-1, matrix[0].length-1);
    }
    
	private static boolean searchHelper(int[][] matrix, int target, int startI, int startJ, int endI, int endJ) {
        
        if (startI > endI || startJ > endJ)
            return false;
            
        int rows = endI - startI + 1;
        int cols = endJ - startJ + 1;
        int numOfEles = rows * cols;
        int mid = (numOfEles - 1) / 2;
        int mid_i = mid / cols + startI;
        int mid_j = mid % cols + startJ;
        if (matrix[mid_i][mid_j] > target) {
            if (startI == mid_i && startJ == mid_j)
                return false;
            else
                return searchHelper(matrix, target, startI, startJ, mid_i, mid_j);
        }
        else if (matrix[mid_i][mid_j] == target) {
            return true;
        }
        else {
            if (searchHelper(matrix, target, startI, mid_j + 1, endI, endJ))
                return true;
            else
                return searchHelper(matrix, target, mid_i + 1, startJ, endI, mid_j);
        }
        
    }
	 
	public static void main(String[] args) {
		System.out.println(TwoDMatrix.searchMatrix(new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},
				5));
	}
}
