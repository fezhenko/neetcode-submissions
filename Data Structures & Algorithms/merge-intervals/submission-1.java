class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        List<int[]> results = new ArrayList<>();
        results.add(intervals[0]);

        for (int[] interval : intervals) {
            int[] lastInterval = results.get(results.size() - 1);
            if (lastInterval[1] >= interval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            } else {
                results.add(interval);
            }
        }

        return results.toArray(new int[results.size()][]);
    }
}
