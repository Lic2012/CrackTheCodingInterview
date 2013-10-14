package Chapter1ArraysAndStrings;

import java.util.ArrayList;
import java.util.Iterator;

/* QUESTION 1.7
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column is set to 0.
 */
public class Question1_7 {
	public static void main(String[] args){
		int[][] test =  {{1,2,3,0},
				         {4,5,6,7},
				         {2,0,7,19},
				         {1,2,3,4},
				         {0,1,1,1}};
		int[][] zero = setozero(test);
		for(int[] x:zero){
			for(int y:x){
				System.out.print(y+" ");
				
			}
			System.out.println();
		}
	}

	public static int[][] setozero(int[][] matrix){
		// check all integer in matrix and store the coordinate 
		ArrayList<Integer> corRow = new ArrayList<Integer>();
		ArrayList<Integer> corCol = new ArrayList<Integer>();
		int row = matrix.length; // length of row
		int col = matrix[0].length; // length of column
		for (int x = 0; x < row; x++){
			for (int y = 0; y < col; y++){
				if (matrix[x][y] == 0){
					corRow.add(x);
					corCol.add(y);
				}
			}
		}
		
		int[][] zeromatrix = new int[row][col];
		for (int a = 0; a < row; a++){
			for (int b = 0; b < col; b++){
				if (corRow.contains(a) || corCol.contains(b)) zeromatrix[a][b] = 0;
				else zeromatrix[a][b] = matrix[a][b];
			}
		}
		
		return zeromatrix;
	}
}
