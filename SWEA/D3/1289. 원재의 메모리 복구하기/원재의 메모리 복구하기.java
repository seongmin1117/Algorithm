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
            String row = sc.next();
            int color = 0;;
            int answer = 0;
            for(int i=0; i<row.length(); i++){
            	int cur = row.charAt(i)- '0';
                if(color != cur){
                	answer++;
                    if(color==0){
                    	color=1;
                    }else{
                    	color=0;
                    }
                }
            }
			System.out.println("#"+test_case+" "+answer);
		}
	}
}