import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int t = sc.nextInt();
            String target = sc.next();
            String str = sc.next();
            int size = target.length();
            int n = str.length()-target.length()+1;
            int answer = 0;
            for(int start=0; start<n; start++){
                int idx = 0;
                boolean chk = true;
            	while(idx<size){
                    if(str.charAt(start+idx) != target.charAt(idx)) {
                    	chk = false;
                        break;
                    }
                    idx++;
                }
                if(chk) {
                answer++;
                }
            }
            System.out.println("#"+test_case+" "+answer);
		}
	}
}