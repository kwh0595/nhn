public class JBGW08_014_Maze {
    public static void main(String[] args) {
        int[][] maze = {
            {0,0,1,0,0,1,1,1,0,0},
            {1,0,0,0,1,0,0,0,1,1},
            {0,1,1,0,0,0,1,0,1,0},
            {1,0,0,0,0,0,1,0,0,0},
            {0,0,1,0,1,0,1,1,0,0},
            {1,1,1,1,0,0,0,1,1,1},
            {1,1,0,0,1,1,0,0,1,1},
            {1,0,0,1,0,1,1,0,0,1},
            {0,0,0,1,1,1,0,1,0,0},
            {0,0,0,0,0,0,0,0,1,0}
        };
        
        int x = 0, y = 0, cnt = 0;
        maze[x][y] = 5; //경로 표시
        
        while (true) {
            if (x == 9 && y == 9) {
                System.out.println("Pass, " + cnt);
                break;
            }
            if (x + 1 < maze.length && maze[x + 1][y] == 0) { //아래
                x++;
                maze[x][y] = 5;
                cnt++;
            }
            else if (y + 1 < maze[0].length && maze[x][y + 1] == 0) { //오른쪽
                y++;
                maze[x][y] = 5;
                cnt++;
            }
            else if (x - 1 >= 0 && maze[x - 1][y] == 0) { //위
                x--;
                maze[x][y] = 5;
                cnt++;
            }
            else if (y - 1 >= 0 && maze[x][y - 1] == 0) { //왼쪽
                y--;
                maze[x][y] = 5;
                cnt++;
            }
            else {//잘못된 경로로 진입할 경우
                maze[x][y] = 2; //백트랙킹 경로 표시
                cnt++;
            
                if (x - 1 >= 0 && maze[x - 1][y] == 5) { //위
                    x--;
                }
                else if (y + 1 < maze[0].length && maze[x][y + 1] == 5) { //오른쪽
                    y++;
                }
                else if (x + 1 < maze.length && maze[x + 1][y] == 5) { //아래
                    x++;
                }
                else if (y - 1 >= 0 && maze[x][y - 1] == 5) { //왼쪽
                    y--;
                }
                else{
                    System.out.println("Fail, "+cnt);
                    break;
                }
            }
        }
    }
}
