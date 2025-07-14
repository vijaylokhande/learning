package problem.matrix;

import java.util.ArrayList;
import java.util.List;

public class SearchInSortedMatrix {
	
	
	public List<Integer>search(int [][]matrix,int num){
		
		int row= matrix.length;
		int col=matrix[0].length;
		
		int r=row-1,c=0;
		
		while(r >=0 && c < col) {
			
			if(matrix[r][c]==num) {
				return new ArrayList<>(List.of(r,c));
			}
			else if(num < matrix[r][c]) {
				r--;
			}
			else {
				c++;
			}
			
		}
		
		
		

		return new ArrayList<>(List.of(-1,-1));
	}
	
	
	public static void main(String[] args) {
		
		SearchInSortedMatrix searchInSortedMatrix=new SearchInSortedMatrix();
		
		int [][] matrix = new int [][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		
		System.out.println(searchInSortedMatrix.search(matrix, 12));
		
	}

}
