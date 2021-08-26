package Programmers.devMatching2021;

import java.util.ArrayList;
import java.util.List;

public class MatrixTurnExample {
    public static void main(String[] args) {
        int rows1 = 6;
        int rows2 = 3;
        int rows3 = 100;
        int columns1 = 6;
        int columns2 = 3;
        int columns3 = 97;
        int[][] queries1 = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[][] queries2 = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[][] queries3 = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

        MatrixTurnExample matrixTurnExample = new MatrixTurnExample();
        matrixTurnExample.solution(rows1, columns1, queries1);   // [8, 10, 25]
//        matrixTurnExample.solution(rows2, columns2, queries2);   // [1, 1, 5, 3]
//        matrixTurnExample.solution(rows3, columns3, queries3);   // [1]
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int number = 1;
        int[][] matrix = new int[columns][rows];

        // matrix 생성
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = number;
                number++;
            }
        }

        // 1씩 뺀 고유한 인덱스값으로 queries 세팅
        for(int i = 0; i < queries.length; i++) {
            for (int j = 0; j < queries[i].length; j++) {
                queries[i][j] = queries[i][j] - 1;
            }
        }

        int resultIdx = 0;
        for (int i = 0; i < queries.length; i++) {
            answer[resultIdx++] = getMinValue(queries[i], matrix);
        }

        return answer;
    }

    // 메소드
    // 1씩 뺀 queries -> element   /   만들어진 매트릭스 -> matrix
    public int getMinValue(int[] element, int[][] table) {
        List<int[]> rotatingList = getRotatingList(element);
        int tempFirst = table[rotatingList.get(0)[0]][rotatingList.get(0)[1]];
        int min = Integer.MAX_VALUE;
        //4
        for(int i = rotatingList.size() - 1; i > 0 ; i--) {
            if(table[rotatingList.get(i)[0]][rotatingList.get(i)[1]] < min) {
                min = table[rotatingList.get(i)[0]][rotatingList.get(i)[1]];
            }
            if(i == 1) {
                table[rotatingList.get(i)[0]][rotatingList.get(i)[1]] = tempFirst;
                break;
            }
            table[rotatingList.get(i)[0]][rotatingList.get(i)[1]] = table[rotatingList.get(i - 1)[0]][rotatingList.get(i - 1)[1]];
        }
        return min;
    }

    public List<int[]> getRotatingList(int[] element) {
        List<int[]> rotatingList = new ArrayList<>();
        int x1 = element[0];
        int y1 = element[1];
        int x2 = element[2];
        int y2 = element[3];

        //윗줄
        for(int i = y1; i < y2; i++) {
            rotatingList.add(new int[] {x1, i});
        }

        //오른쪽줄
        for(int i = x1; i < x2; i++) {
            rotatingList.add(new int[] {i, y2});
        }

        //아랫줄
        for(int i = y2; i > y1; i--) {
            rotatingList.add(new int[] {x2, i});
        }

        //왼쪽줄
        for(int i = x2; i >= x1; i--) {
            rotatingList.add(new int[] {i, y1});
        }

        return rotatingList;
    }

}
