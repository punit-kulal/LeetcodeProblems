import java.util.*;

public class SAPChallenge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            int M = s.nextInt();
            int[][] grid = new int[N + 1][M + 1];
            boolean[][] visited = new boolean[N + 1][M + 1];
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    grid[j][k] = s.nextInt();
                }
            }
            int Di = s.nextInt();
            int Dj = s.nextInt();
            int J = s.nextInt();
            List<Coordinate> answer = dfs(grid, visited, Di, Dj, N, M, J);
            if (answer.size() == 0) {
                System.out.println("NO");
            } else {
                Collections.reverse(answer);
                System.out.println("YES");
                System.out.println(answer.size());
                for (Coordinate c :
                        answer) {
                    System.out.println(c.x + " " + c.y);
                }
            }

        }

    }

    private static List<Coordinate> dfs(int[][] grid, boolean[][] visited, int di, int dj, int N, int M, int j) {
        List<Coordinate> answer;
        if (di == 1 || dj == 1 || di == N || dj == M) {
            answer = new LinkedList<>();
            answer.add(new Coordinate(di, dj));
            return answer;
        }
        visited[di][dj] = true;
        int current = grid[di][dj];

        if (!visited[di + 1][dj] && current >= grid[di + 1][dj] && current - j <= grid[di + 1][dj]) {
            answer = dfs(grid, visited, di + 1, dj, N, M, j);
            if (answer.size() > 0) {
                answer.add(new Coordinate(di, dj));
                return answer;
            }
        }
        if (!visited[di - 1][dj] && current >= grid[di - 1][dj] && current - j <= grid[di - 1][dj]) {
            answer = dfs(grid, visited, di - 1, dj, N, M, j);
            if (answer.size() > 0) {
                answer.add(new Coordinate(di, dj));
                return answer;
            }
        }
        if (!visited[di][dj + 1] && current >= grid[di][dj + 1] && current - j <= grid[di][dj + 1]) {
            answer = dfs(grid, visited, di, dj + 1, N, M, j);
            if (answer.size() > 0) {
                answer.add(new Coordinate(di, dj));
                return answer;
            }
        }
        if (!visited[di][dj - 1] && current >= grid[di][dj - 1] && current - j <= grid[di][dj - 1]) {
            answer = dfs(grid, visited, di, dj - 1, N, M, j);
            if (answer.size() > 0) {
                answer.add(new Coordinate(di, dj));
                return answer;
            }
        }
        return new LinkedList<>();
    }
}

class Coordinate {
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}