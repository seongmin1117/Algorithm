class Solution {
    static int min,n;
    public int solution(int storey) {
        String s = String.valueOf(storey); 
        n = s.length();
        min = 100000000;
        int num = storey;
        dfs(0,0,num);
        return min;
    }
    static void dfs(int k, int count, int storey){
        if(storey==1){
            count ++;
        }
        if(k==n || storey==1){
            min = min<count ? min : count;
            return;
        }
            int cur = storey%10;
            storey /= 10;
        
            if(cur==5){
                count += cur;
                dfs(k+1,count,storey+1);
                dfs(k+1,count,storey);
            } else if(cur<5){
                count += cur;
                dfs(k+1,count,storey);
            } else{
                count += (10-cur);
                 
                dfs(k+1,count,storey+1);
                
            }
    }
}