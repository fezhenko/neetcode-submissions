class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        int water = 0;
        while (left < right) {
            if (maxLeft < maxRight) {
                left += 1;
                int leftValue = height[left];
                maxLeft = Math.max(maxLeft, leftValue);
                if ((maxLeft - leftValue) > 0) {
                    water += (maxLeft - leftValue);
                }
            } else {
                right -= 1;
                int rightValue = height[right];
                maxRight = Math.max(maxRight, rightValue);
                if ((maxRight - rightValue) > 0) {
                    water += (maxRight - rightValue);
                }
            }
        }
        return water;
    }
}
