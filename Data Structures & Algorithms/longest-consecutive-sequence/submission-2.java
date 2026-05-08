class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int resultLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentLength = 0;
            if (!set.contains(nums[i] - 1)) {
                while (set.contains(nums[i]) && i < nums.length) {
                    currentLength += 1;
                    nums[i] += 1;
                }
                resultLength = Math.max(resultLength, currentLength);
            } else {
                currentLength = 1;
            }
        }

        return resultLength;
    }
}
