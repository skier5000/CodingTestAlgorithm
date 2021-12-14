package CodingTest.SsgCodingTest20211211;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
설계
ctrl 키 눌렀을 때 가장 끝 || 박스쳐져있는 곳으로 가야함
 */
public class Solution01 {
    public static void main(String[] args) {
        Solution01 dd = new Solution01();

        dd.solution(new String[]{"...", "...", "..."}, 3, 3); // 2
//        dd.solution(new String[]{"....","....","#...","...."}, 3, 2); // 2
    }


    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int nx = 0;
    static int ny = 0;
    static int[][] matrix;
    static int[][] check;
    static int[][] toStation;
    static Queue<int[]> queue;
    static int answer = 0;
    
    public int solution(String[] cells, int x, int y) {
        matrix = new int[cells.length][cells.length];
        check = new int[cells.length][cells.length];
        toStation = new int[cells.length][cells.length];

        toStation[x-1][y-1] = 99;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length(); j++) {
                if (String.valueOf(cells[i].charAt(j)).equals("."))
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = 1;
            }
        }

        bfs(0, 0);

        System.out.println(answer);
        System.out.println();

        return answer;
    }


    // BFS 메소드
    public static void bfs (int a, int b) {
        queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        check[a][b] = 1;

        Loop1:
        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            ctrlClick(x, y);

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < matrix.length && ny < matrix.length) {
                    if (matrix[nx][ny] == 0 || matrix[nx][ny] == 1) {
                        if (check[nx][ny] < 1) {
                            queue.add(new int[]{nx, ny});
                            check[nx][ny] = check[x][y] + 1;
                        }
                        if (check[nx][ny] > 0 && toStation[nx][ny] == 99) {
                            answer = check[nx][ny] - 1;
                            break Loop1;
                        }
                    }
                }
            }
        }
    }


    // Ctrl 눌렀을 때
    public static void ctrlClick (int x, int y) {
        for (int i = 0; i < 4; i++) {
//            nx = x + dx[i];
//            ny = y + dy[i];
            nx  = x;
            ny = y;

            // 배열인덱스
//            if (nx < matrix.length && ny < matrix.length && check[nx][ny] < 1) {
//                continue;
//            }

            while (true) {
                nx = nx + dx[i];
                ny = ny + dy[i];

                // 방문했으면 혹은 배열을 벗어나면
                if (nx < 0 || ny < 0 || nx >= matrix.length || ny >= matrix.length) {
                    break;
                }

                if (matrix[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    check[nx][ny] = check[x][y] + 1;
                    break;
                }

                if (i == 0) {
                    if (ny == matrix.length - 1) {
                        queue.offer(new int[]{nx, ny});
                        check[nx][ny] = check[x][y] + 1;
                        break;
                    }
                } else if (i == 1) {
                    if (ny == 0) {
                        queue.offer(new int[]{nx, ny});
                        check[nx][ny] = check[x][y] + 1;
                        break;
                    }
                } else if (i == 2) {
                    if (nx == matrix.length - 1) {
                        queue.offer(new int[]{nx, ny});
                        check[nx][ny] = check[x][y] + 1;
                        break;
                    }
                } else if (i == 3) {
                    if (nx == 0) {
                        queue.offer(new int[]{nx, ny});
                        check[nx][ny] = check[x][y] + 1;
                        break;
                    }
                }

            }

            if (nx >= 0 && ny >= 0 && nx < matrix.length && ny < matrix.length) {
                if (check[nx][ny] > 0 && toStation[nx][ny] == 99) {
                    answer = check[nx][ny] - 1;
                    return;
                }
            }

        }
    }



}
