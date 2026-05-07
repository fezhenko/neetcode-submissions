class Solution {
    List<List<Integer>> results;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.results = new ArrayList<>();
        List<Integer> combs = new ArrayList<>();
        dfs(0, combs, target, nums);
        return results;
    }

    private void dfs(int currentIndex, List<Integer> currentList, int target, int[] nums) {
        if (target == 0) {
            results.add(new ArrayList<>(currentList));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = currentIndex; i < nums.length; i++) {
            currentList.add(nums[i]);
            dfs(i, currentList, target - nums[i], nums);
            currentList.removeLast();
        }
    }
}
