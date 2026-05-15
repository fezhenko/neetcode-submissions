class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int rob1 = 0;
        int rob2 = 0;

        for (int money : nums) {
            int temp = Math.max(money + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return Math.max(rob1, rob2);
    }
}
