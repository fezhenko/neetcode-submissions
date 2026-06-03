class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueChars = new HashSet<>();

        // "zxyzxyz"
        // set {z,x,y,} left:0; right: 2

        int left = 0;
        int right = 0;
        int maxLength = 0;

        while(right < s.length()) {
            char current = s.charAt(right);
            if (uniqueChars.contains(current)) {
                uniqueChars.remove(s.charAt(left));
                left++;
                continue;
            }

            uniqueChars.add(current);
            right++;
            maxLength = Math.max(maxLength, right - left);
        }
        
        return maxLength;
    }
}
