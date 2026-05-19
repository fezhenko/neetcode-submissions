class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        Set<Integer> uniqueElements = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (uniqueElements.contains(nums[i])) {
                return true;
            }
            uniqueElements.add(nums[i]);
        }

        return false;
    }
}