class Solution {
    public int characterReplacement(String s, int k) {
        int[] chars = new int[26];

        int left = 0;
        int right = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        while (right < s.length()) {
            chars[s.charAt(right) - 'A'] += 1;
            maxFrequency = Math.max(maxFrequency, chars[s.charAt(right) - 'A']);
            int interval = right - left + 1;
            int charsToReplace = interval - maxFrequency;
            if (charsToReplace > k) {
                chars[s.charAt(left) - 'A'] -= 1;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
