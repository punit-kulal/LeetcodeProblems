public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0) {
            return count;
        }
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    dfs(visited, grid, i, j);
                }
            }
        }
        return  count;
    }

    private void dfs(int[][] visited, char[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i + 1 <= grid.length && j + 1 <= grid.length) {
            if (visited[i][j] == 0) {
                visited[i][j] = 1;
                if (grid[i][j] == '1') {
                    dfs(visited, grid, i + 1, j);
                    dfs(visited, grid, i - 1, j);
                    dfs(visited, grid, i, j + 1);
                    dfs(visited, grid, i, j - 1);
                }
            }
        }
    }
}
