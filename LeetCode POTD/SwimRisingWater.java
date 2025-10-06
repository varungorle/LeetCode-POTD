class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean[][] visited = new boolean[n][n];
        
        java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>(new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int r = current[1];
            int c = current[2];
            
            if (r == n - 1 && c == n - 1)
                return time;
            
            if (visited[r][c]) continue;
            visited[r][c] = true;
            
            for (int i = 0; i < 4; i++) {
                int nr = r + directions[i][0];
                int nc = c + directions[i][1];
                
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    int nextTime = time > grid[nr][nc] ? time : grid[nr][nc];
                    pq.offer(new int[]{nextTime, nr, nc});
                }
            }
        }
        
        return -1;
    }
}

public class SwimRisingWater {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] grid = {{0, 2}, {1, 3}};
        int result = obj.swimInWater(grid);
        System.out.println(result); // Output: 3
    }
}
