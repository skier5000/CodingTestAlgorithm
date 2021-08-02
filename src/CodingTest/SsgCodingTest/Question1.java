package CodingTest.SsgCodingTest;

import java.util.Arrays;

public class Question1 {

    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 5;
        int n3 = 4;

        int[][] orders1 = {{10, 60}, {15, 30}, {20, 80}, {30, 40}, {35, 70}, {40, 20}};
        int[][] orders2 = {{7, 35}, {5, 25}, {3, 15}, {1, 5}};
        int[][] orders3 = {{13, 39}, {16, 50}, {50, 17}, {61, 39}, {92, 22}};

        Question1 question1 = new Question1();
        question1.solution(n1, orders1); // 170
//        question1.solution(n2, orders2); // 35
//        question1.solution(n3, orders3); // 128

    }

    public int solution(int n, int[][] orders) {
        int answer = -1;

        Arrays.sort(orders);

        return answer;
    }
}
