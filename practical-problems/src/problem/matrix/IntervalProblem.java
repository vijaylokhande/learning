package problem.matrix;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalProblem {

	public static int removeOverlappingIntervals(int[][] intervals) {
		int remove=0;
		int endStart=0;
		
		Arrays.sort(intervals,Comparator.comparing(a->a[1]));
		
		for(int i=0;i<intervals.length;i++) {
			
			int start=intervals[i][0];
			int end=intervals[i][1];
			
			if(start >= endStart) {
				endStart = end;
			}
			else {
				remove++;
			}
			
			
		}
		
		
		return remove;
	}
	
	public static void main(String[] args) {
		
		
		int[][] intervals = {{0, 3}, {9, 12},{4, 5}, {3, 8}, {8, 10}};
        System.out.println(removeOverlappingIntervals(intervals)); 
	}
}
