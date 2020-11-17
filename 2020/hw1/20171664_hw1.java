import java.util.*;
import java.util.Stack;

// offset

/**
 * Maze Class
 * 
 */

class Maze {

    private int[][] maze; // 2 dim array for maze
    private int[][] mark; // 2 dim array for visit marking

    public Maze(int m, int p) {
        maze = new int[m + 2][p + 2];
        mark = new int[m + 2][p + 2];
        for (int i = 0; i < m + 2; i++)
            for (int j = 0; j < p + 2; j++) {
                maze[i][j] = 1;
                mark[i][j] = 0;
            }
    }

    static class location {
        static int x;
        static int y;
    }

    // create the maze structure
    public void SetWall(int i, int j, int val) {
        maze[i][j] = val;
    }

    public void Path(int m, int p) {
        int directionX[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
        int directionY[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
        // S, SW, W, NW, N, NE, E, SE

        location.x = 1;
        location.y = 1;
        Stack<Integer> stackX = new Stack<>();
        Stack<Integer> stackY = new Stack<>();
        Stack<Integer> printX = new Stack<>();
        Stack<Integer> printY = new Stack<>();
        while (true) {
            for (int i = 0; i <= 8; i++) {
                mark[location.x][location.y] = 1;
                if (i == 8) {
                    if (!stackX.empty() && !stackY.empty()) {
                        location.x = stackX.pop();
                        location.y = stackY.pop();
                        break;
                    } else
                        System.out.println("No path in the maze.");
                }
                if (maze[location.x + directionX[i]][location.y + directionY[i]] == 0
                        && mark[location.x + directionX[i]][location.y + directionY[i]] == 0) {
                    stackX.push(location.x);
                    stackY.push(location.y);
                    location.x += directionX[i];
                    location.y += directionY[i];
                    break;
                }
            }
            if (location.x == m && location.y == p) {
                stackX.push(location.x);
                stackY.push(location.y);
                break;
            }
        }
        while (!stackX.empty() && !stackY.empty()) {
            printX.push(stackX.pop());
            printY.push(stackY.pop());
        }
        while (!printX.empty() && !printY.empty())
            System.out.println("(" + printX.pop() + "," + printY.pop() + ")");
    }

};