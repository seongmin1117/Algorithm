import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int t = sc.nextInt();
            
          	Queue<Integer> q  = new LinkedList<>();
            
            for(int i=0; i<8; i++) {
            	q.add(sc.nextInt());
            }
            int a = 1;
            while(true){
            	if(a==6) {
                    a =1;
                }
                int cur = q.poll();
                cur -= a;
                if(cur<=0){
                	q.add(0);
                    break;
                }
                q.add(cur);
                a++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#"+t+" ");
            while(!q.isEmpty()){
                String str = String.valueOf(q.poll());
            	sb.append(str+" ");
            }
            sb.append("\n");
            System.out.println(sb);
		}
	}
}