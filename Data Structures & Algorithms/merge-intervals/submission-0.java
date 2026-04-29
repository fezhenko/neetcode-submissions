class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> result = new ArrayList();
        result.add(intervals[0]);

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int lastEnd = result.get(result.size() - 1)[1];
            int[] lastInterval = result.get(result.size() - 1);
            if (start <= lastEnd) {
                lastEnd = Math.max(lastInterval[1], end);
                lastInterval[1] = lastEnd;
            } else {
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
