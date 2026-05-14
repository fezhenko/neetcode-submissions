class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> valueToFreq = new HashMap<>();
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));

        for (int i = 0; i < nums.length; i++) {
            valueToFreq.put(nums[i], valueToFreq.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: valueToFreq.entrySet()) {
            heap.offer(new int[] {entry.getKey(), entry.getValue()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            int[] current = heap.poll();
            result[i] = current[0];
        }

        return result;
    }
}
