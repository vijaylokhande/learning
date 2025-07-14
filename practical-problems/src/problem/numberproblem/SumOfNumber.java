package problem.numberproblem;

import java.util.Arrays;

public class SumOfNumber {
	
	public int [] sumoftwonum(int [] array ,int num) {
		
		int left=0;
		int right = array.length-1;
		int []out=new int[2];
		
		Arrays.sort(array);
		
		while(left<right) {
			
			int sum=array[left]+array[right];
			
			if(sum==num) {								
				out[0]=array[left];
				out[1]=array[right];
			}
			
			
			if(sum<num) {
				left++;
			}
			else {
				right--;
			}
			
		}
		

		return out;
	}
	
	
	public static void main(String[] args) {
		
		
		int []array = new int[] {1,10,5,6,4,8,3,2};
		
		SumOfNumber sumOfNumber = new SumOfNumber();
		
		int [] out = sumOfNumber.sumoftwonum(array, 9);
		
		System.out.println(out[0]+" , "+out[1]);
		
		
	}

}
