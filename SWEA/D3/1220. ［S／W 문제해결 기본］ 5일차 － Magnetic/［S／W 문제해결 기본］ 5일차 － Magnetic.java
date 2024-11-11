import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T= 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int[][] board = new int[n][n];
            for(int i=0; i<n; i++){
            	for(int j=0; j<n; j++){
                	board[i][j] = sc.nextInt();
                }
            }
            
            int answer = 0;
            for(int c=0; c<n; c++){
                boolean red = false;
               
            	for(int r=0; r<n; r++){
                	if(board[r][c]== 1 && !red){
                       red = true;
                }else if(board[r][c]==2 && red){
                    	answer++;
                        red= false;
                    }
                    
            }
                
		}
        System.out.println("#"+test_case+" "+answer);
        
	}
    }
}