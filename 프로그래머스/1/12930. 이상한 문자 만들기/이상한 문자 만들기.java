class Solution {
    
    public String solution(String s) {
        return convertString(s);
    }
    
    private static String convertString(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split(" ",-1);
        for (int i = 0; i < words.length; i++) {
            result.append(convertWord(words[i]));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    private static String convertWord(String word) {
        StringBuilder converted = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            converted.append(convertChar(i, word.charAt(i)));
        }
        return converted.toString();
    }

    private static char convertChar(int i, char c) {
        return (i % 2 == 0) ? Character.toUpperCase(c) : Character.toLowerCase(c);
    }
}