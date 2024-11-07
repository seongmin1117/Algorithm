import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{	
            int n = sc.nextInt();
            int mid = n/2+1;
            int[][] board = new int[n+1][n+1];
            for(int i=1; i<=n; i++) {
                String row = sc.next();
            	for(int j=1; j<=n; j++){
                    board[i][j] = row.charAt(j-1) -'0';
                }
            }
            int sum = 0;
            // 위에서 부터 가운데까지
			for(int i=1; i<=mid; i++) {
            	for(int j=mid-i+1; j<=mid+i-1; j++) {
                	sum += board[i][j];
                }
            }
            // 밑에서부터 가운데(제외)까지
            for(int i=n; i>mid; i--){ 
            	for(int j=mid+i-n; j<=mid-i+n ; j++){
                	sum+= board[i][j];
                }
            }
            System.out.println("#"+test_case+" "+sum);
		}
	}
}