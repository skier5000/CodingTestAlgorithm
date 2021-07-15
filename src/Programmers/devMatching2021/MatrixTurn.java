package Programmers.devMatching2021;

import java.util.*;

import static java.util.Arrays.*;

public class MatrixTurn {
    public static void main(String[] args) {
        int rows1 = 6;
        int rows2 = 3;
        int rows3 = 100;

        int columns1 = 6;
        int columns2 = 3;
        int columns3 = 97;

        int[][] queries1 = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[][] queries2 = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};
        int[][] queries3 = {{1, 1, 100, 97}};

        /*
        result1 -> [8, 10, 25]
        result2 -> [1, 1, 5, 3]
        result3 -> [1]
         */
        MatrixTurn matrixTurn = new MatrixTurn();
        int[] a = matrixTurn.solution(rows1, columns1, queries1);
        System.out.println("a = " + Arrays.toString(a));
//        System.out.println(solution(rows2, columns2, queries2));
//        System.out.println(solution(rows3, columns3, queries3));

    }


    /**
     * example Solution
     * @param rows
     * @param columns
     * @param queries
     * @return
     */
    public int[] solution(int rows, int columns, int[][] queries) {
        int num = 1;
        int[] result = new int[queries.length];
        int[][] matrix = new int[rows][columns];

        // 2차원 매트릭스 생성
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }

        // 로직
        int resultIdx = 0;
        for(int i = 0; i < queries.length; i++) {
            int[] element = minusOneFromElement(queries[i]); // 1씩 뺀 값을 element 배열(int)에 저장
            result[resultIdx++] = getMinValue(element, matrix);
        }

        return result;
    }


    // 메소드
    // 1씩 뺀 값을 element 배열(int)에 저장
    public int[] minusOneFromElement(int[] query) {
        for(int i = 0; i < query.length; i++) {
            query[i] -= 1;
        }
        return query;
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


    // 메소드
    // 1씩 뺀 queries -> element
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







    /**
     * my Solution
     * @param rows
     * @param columns
     * @param queries
     * @return
     */
//    public static int[] solution(int rows, int columns, int[][] queries) {
//        int[] answer = {};
//        int[][] turnNum;
//
//        // 2차원 Matrix make
//        int[][] matrix = new int[rows][columns];
//        int num = 1;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                matrix[i][j] = num;
//                num++;
//            }
//        }
//
//        // 회전
//        queries = minusQueries(queries);
//        turnMatrix(matrix, queries);
//
//        return answer;
//    }
//
//    // queries 하나씩 빼기
//    public static int[][] minusQueries(int[][] queries) {
//        for (int[] ints : queries) {
//            for (int j = 0; j < ints.length; j++) {
//                ints[j] = ints[j]-1;
//            }
//        }
//        return queries;
//    }
//
//    // Matrix 돌리기
//    public static int[][] turnMatrix(int[][] matrix, int[][] queries) {
//        System.out.println();
//
//        for (int i = 0; i < queries.length; i++) {
//            for (int j = 0; j < queries[i].length; j++) {
//                System.out.println(matrix[j][queries[i][j]]); //{1,1}
//
//            }
//        }
//
//        return queries;
//    }


}
