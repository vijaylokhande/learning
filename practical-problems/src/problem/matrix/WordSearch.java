package problem.matrix;

/*
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
 */

public class WordSearch {
	
	public boolean exist(char[][] board, String word) {
		
		int r=board.length;
		int c=board[0].length;
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				
				if(dfs(board, word, r, c, i, j, i)) {
					return true;
				}
				
			}
		}
		
		
		
		return false;
	}
	
	
	public boolean dfs(char[][] board,String word,int r,int c,int i,int j,int index) {
		
		if(index == word.length()) {
			return true;
		}
		
		if(i<0 || i >= r || j < 0 || j >= c || board[i][j]!=word.charAt(index)) {return false;}
		
		char tmp = board[i][j];
		
		board[i][j]='#';
		
		boolean f= dfs(board,word,r,c,i+1,j,index+1) ||
				   dfs(board,word,r,c,i-1,j,index+1) ||
				   dfs(board,word,r,c,i,j+1,index+1) ||
				   dfs(board,word,r,c,i,j-1,index+1) ;
		
		board[i][j]=tmp;
		
		return f;
		
	}
	
	public static void main(String[] args) {
		
		WordSearch search=new WordSearch();
		char [][] matrix = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "SEE";
		
		System.out.println(search.exist(matrix, word));
		
	}

}
