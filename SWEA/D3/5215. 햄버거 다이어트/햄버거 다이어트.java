import java.util.*;

class Solution
{
    static int n,max,answer;
    static int[][] board;
    static boolean[] selected;
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
            max = sc.nextInt();
            board = new int[n][2];
            selected = new boolean[n];
            answer = 0;
            for(int i=0; i<n; i++){
            	board[i][0] = sc.nextInt();
                board[i][1] = sc.nextInt();
            }
     		bt(0,0,0);
            System.out.println("#"+test_case+" "+answer);
		}
	}
    static void bt(int kcal, int score, int start) {
        if( kcal > max) {
            return;
        }
        for(int i=start; i<n; i++){
        	if(selected[i]) continue;
            
            	kcal += board[i][1];
                score += board[i][0];
            selected[i] = true;
            if(kcal<=max){
            	answer = Math.max(score,answer);
            }
            bt(kcal,score,i+1);
            kcal -= board[i][1];
            score -= board[i][0];
            selected[i] = false;
        }
    }
}