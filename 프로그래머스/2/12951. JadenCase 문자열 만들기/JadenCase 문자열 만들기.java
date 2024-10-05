class Solution {
    public String solution(String s) {
        String answer = "";
        String s2 = " " + s;

        for (int i = 1; i < s2.length(); i++){
            if (s2.charAt(i - 1) == ' '){
                answer += Character.toUpperCase(s2.charAt(i));
            } else {
                answer += Character.toLowerCase(s2.charAt(i));
            }
        }

        return answer;
    }
}