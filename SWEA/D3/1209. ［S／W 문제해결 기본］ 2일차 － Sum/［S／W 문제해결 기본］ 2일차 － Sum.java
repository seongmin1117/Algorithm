import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
    {
		Scanner sc = new Scanner(System.in);
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T;
			T=sc.nextInt();
            int[][] board = new int[100][100];
            int max = 0;
            for(int i=0; i<100; i++){
                
                int sum = 0;
                for(int j=0; j<100; j++){
                	board[i][j] = sc.nextInt();
                    sum += board[i][j];
                }
                max = Math.max(max,sum);
            }
            for(int j=0; j<100; j++) {
                int sum = 0;
            	for(int i=0; i<100; i++){
                		sum += board[i][j];
            	    }
                max = Math.max(max,sum);
            	}
            int sum1 = 0;
            int sum2 = 0;
            for(int i=0; i<100; i++) {
            	sum1 += board[i][i];
                sum2 += board[i][99-i];
            }
            max = Math.max(max,sum1);
            max = Math.max(max,sum2);
            
            System.out.println("#"+T+" "+max);
		}
	}
}