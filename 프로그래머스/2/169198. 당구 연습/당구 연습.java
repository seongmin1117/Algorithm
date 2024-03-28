class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int T = balls.length; //테스트 케이스
        int[] answer = new int[T];
        for(int i=0; i<T; i++){
            int endX = balls[i][0];
            int endY = balls[i][1];
            // 4가지 케이스 , 0-x , 0-y , 2m-x, 2n-y
            int min = Integer.MAX_VALUE;
            if(startY!=endY || startX<endX){
            min = dfs(-startX,startY,endX,endY,min); //왼
            }
            if(startX != endX || startY<endY){
            min = dfs(startX,-startY,endX,endY,min); //아래
            }
            if(startY!=endY || startX>endX){
            min = dfs(2*m-startX,startY,endX,endY,min); //오른쪽
            }
            if(startX != endX || startY>endY){
            min = dfs(startX,2*n-startY,endX,endY,min); //위
            }
            answer[i]= min;
        }
        return answer;
    }
    static int dfs(int x1, int y1, int x2, int y2, int min){
        int x =  Math.abs(x1-x2);
        int y =  Math.abs(y1-y2);
        int dis = x*x + y*y;
        return Math.min(dis,min);
    }
}