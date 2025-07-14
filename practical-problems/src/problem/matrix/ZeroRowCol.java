package problem.matrix;

import java.util.HashSet;
import java.util.Set;

public class ZeroRowCol {
	
	
	public void zeroRowCol(int [][] matrix) {
		
		int c= matrix.length;
		int r= matrix[0].length;
				
		Set<Integer> rowset= new HashSet<>();
		Set<Integer> colset= new HashSet<>();
				
		for(int i=0;i<r;i++) {				
			for(int j=0;j< c;j++) {				
				if(matrix[i][j]==0) {		
					rowset.add(i);
					colset.add(j);
				}
			}			
		}
				
		
		for(int ic : colset) {
			for(int i=0;i<r;i++) {						
				matrix[i][ic]=0;				
			}
		}
			
		for(int ir : rowset) {			
			for(int j=0;j<c;j++) {				
				matrix[ir][j]=0;
			}
		}
		
		
		for(int i=0;i<r;i++) {				
			for(int j=0;j< c;j++) {				
				System.out.print(matrix[i][j]+" ");
			}			
			System.out.println();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		ZeroRowCol zeroRowCol = new ZeroRowCol();
		int [][]matrix = new int [][]{{0,2,3},{4,5,6},{7,8,9}};		
		zeroRowCol.zeroRowCol(matrix);
		
		
	}

}
