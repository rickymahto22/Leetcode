class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        int m = maze.length;
        int n = maze[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            
            while(size-- > 0) {
                int[] curr = queue.poll();

                for(int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    if(x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+')
                        continue;
                    if(x == 0 || x == m - 1 || y == 0 || y == n - 1)
                        return steps;
                    maze[x][y] = '+';
                    queue.offer(new int[] {x, y});
                }
            }
        }

        return -1;
    }
}