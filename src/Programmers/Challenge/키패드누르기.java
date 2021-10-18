package Programmers.Challenge;

import java.util.*;

public class 키패드누르기 {
    public static void main(String[] args) {
        int[] numbers1 = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] numbers2 = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        String hand1 = "right";
        String hand2 = "left";
        String hand3 = "right";

        String answer1 = "LRLLLRLLRRL";
        String answer2 = "LRLLRRLLLRR";
        String answer3 = "LLRLLRLLRL";

        키패드누르기 dd = new 키패드누르기();
        dd.solution(numbers1, hand1);
        dd.solution(numbers2, hand2);
        dd.solution(numbers3, hand3);
    }

    /*

    1, 4, 7을 입력할 때는 왼손 엄지손가락 사용

    3, 6, 9를 입력할 때는 오른손 엄지손가락 사용

    2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용
    만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용

     */

    public String solution(int[] numbers, String hand) {
        HashMap<String, int[]> handPosition = new HashMap<>();
        int node[][] = new int[4][3]; // 그래프 배열
        int cnt = 1;
        for (int i = 0; i < node.length; i++) {
            for (int j = 0; j < node[i].length; j++) {
                node[i][j] = cnt;
                cnt++;
            }
        }
        node[3][0] = 10;
        node[3][1] = 0;
        node[3][2] = 10;

        handPosition.put("left", new int[]{3, 0});
        handPosition.put("right", new int[]{3, 2});

        int[] leftSide = new int[]{1, 4, 7};
        int[] rightSide = new int[]{3, 6, 9};
        int[] middleSide = new int[]{2, 5, 8, 0};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {

            int gotoNumber = numbers[i];

            /* 왼손사용 */
            if (Arrays.stream(leftSide).anyMatch(value -> value == gotoNumber)) {
                switch (gotoNumber) {
                    case 1 :
                        handPosition.put("left", new int[]{0, 0});
                        break;
                    case 4 :
                        handPosition.put("left", new int[]{1, 0});
                        break;
                    case 7 :
                        handPosition.put("left", new int[]{2, 0});
                        break;
                    default:
                        break;
                }
                sb.append("L");
                continue;
            }

            /* 오른손사용 */
            else if (Arrays.stream(rightSide).anyMatch(value -> value == gotoNumber)) {
                switch (gotoNumber) {
                    case 3 :
                        handPosition.put("right", new int[]{0, 2});
                        break;
                    case 6 :
                        handPosition.put("right", new int[]{1, 2});
                        break;
                    case 9 :
                        handPosition.put("right", new int[]{2, 2});
                        break;
                    default:
                        break;
                }
                sb.append("R");
                continue;
            }

            /* 가까운 손가락 사용 */
            else if (Arrays.stream(middleSide).anyMatch(value -> value == gotoNumber)) {
                int dx[] = {0,0,1,-1};
                int dy[] = {1,-1,0,0};
                int nx = 0;
                int ny = 0;

                int leftSideBfs = bfs(handPosition.get("left")[0], handPosition.get("left")[1], node, nx, ny, dx, dy, gotoNumber);
                int rightSideBfs = bfs(handPosition.get("right")[0], handPosition.get("right")[1], node, nx, ny, dx, dy, gotoNumber);

                if (leftSideBfs > rightSideBfs) {   // 왼손이 더 멀어 ▶ 오른손으로 누를거야
                    for (int j = 0; j < node.length; j++) {
                        for (int k = 0; k < node[j].length; k++) {
                            if (node[j][k] == gotoNumber)
                                handPosition.put("right", new int[]{j, k});
                        }
                    }
                    sb.append("R");
                } else if (leftSideBfs < rightSideBfs) {   // 오른손이 더 멀어 ▶ 왼손으로 누를거야
                    for (int j = 0; j < node.length; j++) {
                        for (int k = 0; k < node[j].length; k++) {
                            if (node[j][k] == gotoNumber)
                                handPosition.put("left", new int[]{j, k});
                        }
                    }
                    sb.append("L");
                } else if (leftSideBfs == rightSideBfs) {   // 거리가 같다면 ▶ 손잡이에 따라
                    for (int j = 0; j < node.length; j++) {
                        for (int k = 0; k < node[j].length; k++) {
                            if (node[j][k] == gotoNumber)
                                handPosition.put(hand, new int[]{j, k});
                        }
                    }
                    if (hand.equals("right"))
                        sb.append("R");
                    else
                        sb.append("L");
                }

                continue;
            }

        }

        return sb.toString();
    }

    // BFS 메소드
    public static int bfs (int a, int b, int[][] node, int nx, int ny, int[] dx, int[] dy, int endPoint) {
        int check[][] = new int[4][3]; // 방문 배열
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        check[a][b] = 1;

        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < node.length && ny < node[0].length) {
                    if (check[nx][ny] < 1) {
                        queue.add(new int[]{nx, ny});
                        check[nx][ny] = check[x][y] + 1;
                        if (node[nx][ny] == endPoint) {
                            return check[nx][ny];
                        }
                    }
                }
            }
        }

        return 0;
    }

}
