public class Surrounding {
    static boolean[][] open;
    static int m, n;
	public void solve(ArrayList<ArrayList<Character>> a) {
	    m = a.size();
	    n = a.get(0).size();
	    open = new boolean[m][n];
	    char[][] board = new char[m][n];
	    
	    //fill the board
	    for(int i = 0; i < m; i++){
	        for(int j = 0; j < n; j++){
	            board[i][j] = a.get(i).get(j);
	        }
	    }
	    
	    for(int j = 0; j < n; j++){
	        //top row
	        if(board[0][j] == 'O')
	            dfs(board, 0, j);
	            
	        // bottom row       
	        if(board[m-1][j] == 'O')
	            dfs(board, m-1, j);
	            
	    }
	    
	    for(int i = 0; i < m; i++){
	        //top row
	        if(board[i][0] == 'O')
	            dfs(board, i, 0);
	            
	        // bottom row       
	        if(board[i][n-1] == 'O')
	            dfs(board, i, n-1);
	            
	    }
	    
	    
	    // replace Os
	    for(int i = 0; i < m; i++){
	        for(int j = 0; j < n; j++){
	            if(a.get(i).get(j) == 'O' && !open[i][j])
	                a.get(i).set(j,'X');
	        }
	    }
	    
	}
	
	public static void dfs(char[][] board, int i, int j){
	    if(board[i][j] != 'O')
	        return;
	        
	    if(open[i][j])
	        return;
	        
	    open[i][j] = true;
	    
	    if(i != 0)
	        dfs(board, i-1, j);
	   
	    if(j != 0)
	        dfs(board, i, j-1);
	        
	    if(i != m-1)
	        dfs(board, i+1, j);
	       
	    if(j != n-1)
	        dfs(board, i, j+1);
	}
}

