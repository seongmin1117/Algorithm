class Solution {
    
    public String solution(String s) {
        char[] charArray = s.toUpperCase().toCharArray();
        int idx = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            idx = (c == ' ') ? 0 : idx+1;
            if (idx%2 == 0){
                charArray[i] = Character.toLowerCase(c);
            }
        }
        return String.valueOf(charArray);
    }
    
    
}