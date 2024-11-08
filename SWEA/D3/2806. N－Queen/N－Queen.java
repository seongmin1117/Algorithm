import java.util.*;

class Solution
{
    	static int n,answer;
    	static HashSet<Integer> c,x,y;
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
		 	n = sc.nextInt();
            answer =0;
            c = new HashSet<>();
            x = new HashSet<>();
            y = new HashSet<>();
            bt(0);
            System.out.println("#"+test_case+" "+answer);
		}
	}
    static void bt(int k){
    	if(k==n){
        	answer++;
            return;
        }
        
        	for(int j=0; j<n; j++){
            	if (!c.contains(j) && !x.contains(k + j) && !y.contains(k - j)) {
                // 현재 위치에 퀸을 놓을 수 있으면 셋에 추가
                c.add(j);
                x.add(k + j);
                y.add(k - j);

                bt(k + 1); // 다음 행으로 이동

                // 백트래킹: 셋에서 제거
                c.remove(j);
                x.remove(k + j);
                y.remove(k - j);
            }
            }
        
    }
}