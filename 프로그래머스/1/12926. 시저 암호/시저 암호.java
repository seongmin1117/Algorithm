class Solution {
    public String solution(String s, int n) {
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            char c = charArray[i];
            if(c == ' ') continue;
            if (Character.isUpperCase(c)) {
                charArray[i] = (char)((c - 'A' + n) % 26 + 'A');
            } else if (Character.isLowerCase(c)) {
                charArray[i] = (char)((c - 'a' + n) % 26 + 'a');
            }
        }
        return String.valueOf(charArray);
    }
}