import java.util.Scanner;

class Solution
{
    static int num,count;
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
            	int t = sc.nextInt();
            	num = sc.nextInt();
            	count = sc.nextInt();
            int answer = dfs(0);
			System.out.println("#"+test_case+" "+answer);
		}
        
	}
    static int dfs(int k) {
        if(k==count){
        return 1 ;
        }
        return dfs(k+1)*num;
        
    }
}