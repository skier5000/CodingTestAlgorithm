package Programmers.Challenge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 크레인인형뽑기게임 {

    /**
     * 반례
     */

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        // result : 4

        // 반례
        int[][] board1 = {{}};
        int[] moves1 = {};

        크레인인형뽑기게임 dd = new 크레인인형뽑기게임();
        dd.solution(board, moves);
    }


    public int solution(int[][] board, int[] moves) {
        int preBoardValue = 0;
        int thisBoardValue = 0;
        int cnt = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int moveIt = moves[i] - 1;   // 움직일 y축

            Loop1:
            for (int j = 0; j < board.length; j++) {
                Loop2:
                for (int k = 0; k < board[j].length; k++) {
                    if (board[j][k] != 0 && k == moveIt) {
                        if (!stack.isEmpty())
                            preBoardValue = stack.peek();
                        stack.push(board[j][k]);

                        thisBoardValue = board[j][k];
                        board[j][k] = 0;
                        break Loop1;
                    }
                }
            }


            if (i != 0 && preBoardValue == thisBoardValue) {
                cnt++;
                stack.pop();
                stack.pop();
            }


        }

        return (cnt*2);
    }
}
