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
			int n = sc.nextInt();
            String row = sc.next();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            int answer = 1;
            for(int i=0; i<n; i++){
            	char ch = row.charAt(i);
                if(ch =='['){
                	stack.addFirst(']');
                }
                if(ch=='{'){
                stack.addFirst('}');
                }
                if(ch=='('){
                stack.addFirst(')');
                }
                if(ch=='<'){
                stack.addFirst('>');
                }
                if( (ch ==']') || (ch=='}') || (ch==')') || (ch=='>') ){
                	if(stack.isEmpty()){
                        answer = 0;
                        break;
                    }
                    char pre = stack.pollFirst();
                    if(pre != ch){
                    	answer = 0;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()){
            answer = 0;
            } else{
                answer = 1;}
            System.out.println("#"+test_case+" "+answer);
		}
	}
}