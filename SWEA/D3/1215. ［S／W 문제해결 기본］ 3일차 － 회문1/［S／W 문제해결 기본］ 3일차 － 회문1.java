import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{

        Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();
            int[][] board = new int[8][8];
            for(int i=0; i<8; i++){
            	String row = sc.next();
                for(int j=0; j<8; j++){
                	board[i][j] = row.charAt(j)- 'A';
                }
            }
            int end = 8-n;
            int answer = 0;
            ArrayDeque<Integer> stack;
            ArrayDeque<Integer> q;
            for(int i=0; i<8; i++){
            	for(int start=0; start<=end; start++){
                         stack = new ArrayDeque<>();
            			q = new ArrayDeque<>();
                	for(int mid=start; mid<start+n; mid++){
                    	int cur = board[i][mid];
                        stack.addFirst(cur);
                        q.addLast(cur);
                    }
                    boolean chk = true;
                    for(int k=0; k<n; k++){
                    	int a = stack.pollFirst();
                        int b = q.pollFirst();
                        if(a!=b){
                            chk = false;
                            break;
                    }
                }
                    if(chk){
                     answer++;
                    }
                    stack.clear();
                    q.clear();
            }
		}
            
            //세로
        
            for(int i=0; i<8; i++){
            	for(int start=0; start<=end; start++){
                         stack = new ArrayDeque<>();
            q = new ArrayDeque<>();
                	for(int mid=start; mid<start+n; mid++){
                    	int cur = board[mid][i];
                        stack.addFirst(cur);
                        q.addLast(cur);
                    }
                    boolean chk = true;
                    for(int k=0; k<n; k++){
                    	int a = stack.pollFirst();
                        int b = q.pollFirst();
                        if(a!=b){
                            chk = false;
                            break;
                    }
                }
                    if(chk){
                     answer++;
                    }
            }
		}
            System.out.println("#"+test_case+" "+answer);
	}
}
}