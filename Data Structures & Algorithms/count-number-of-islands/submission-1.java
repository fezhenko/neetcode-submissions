class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        Set<List<Integer>> visited = new HashSet<>();
        int islands = 0;

        int rowsLength = grid.length;
        int colsLength = grid[0].length;

        List<List<Integer>> directions =
            List.of(List.of(-1, 0), List.of(1, 0), List.of(0, 1), List.of(0, -1));

        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < colsLength; j++) {
                List<Integer> currentCoordinates = List.of(i, j);
                if (grid[i][j] == '1' && !visited.contains(currentCoordinates)) {
                    islands += 1;
                    // bfs
                    visited.add(currentCoordinates);
                    Queue<List<Integer>> queue = new ArrayDeque<>();
                    queue.add(currentCoordinates);

                    while (!queue.isEmpty()) {
                        List<Integer> current = queue.poll();
                        int currentRow = current.get(0);
                        int currentCol = current.get(1);

                        for (List<Integer> direction : directions) {
                            int dr = direction.get(0);
                            int dc = direction.get(1);
                            int r = currentRow + dr;
                            int c = currentCol + dc;
                            List<Integer> coord = List.of(r, c);
                            if ((r >= 0 && r < rowsLength) && (c >= 0 && c < colsLength)
                                && grid[r][c] == '1' && !visited.contains(coord)) {
                                queue.add(coord);
                                visited.add(coord);
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}
