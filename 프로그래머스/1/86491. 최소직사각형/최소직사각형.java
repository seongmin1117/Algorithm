class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for(int[] arr : sizes){
            w = Math.max(w, Math.max(arr[0], arr[1]));
            h = Math.max(h, Math.min(arr[0], arr[1]));
        }
        return w*h;
    }
}