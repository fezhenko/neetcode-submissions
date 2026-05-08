class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndex = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (valueIndex.containsKey(diff)) {
                result = new int[] {valueIndex.get(diff), i};
            }
            valueIndex.put(nums[i], i);
        }
        return result;
    }
}
