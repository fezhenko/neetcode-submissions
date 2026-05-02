class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int stringLength = s.length();
        boolean[] result = new boolean[stringLength + 1];
        result[stringLength] = true;

        for (int i = stringLength - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if ((i + word.length()) <= stringLength) {
                    if (s.substring(i, i + word.length()).equals(word)) {
                        result[i] = result[i + word.length()];
                    }
                }
                if(result[i]) {
                    break;
                }
            }
        }

        return result[0];
    }
}
