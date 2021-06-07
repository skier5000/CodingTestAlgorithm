package Programmers.DFS_BFS;

public class Solution {

    public static void main(String args[]){
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        solution(numbers, target);
    }

    public static int solution(int[] numbers, int target) {
        int answer = backTrack(numbers, target, 0);
        return answer;
    }

    public static int backTrack(int[] numbers, int target, int idx) {
        if (idx == numbers.length) {
            int sum = 0;
            for (int n : numbers) {
                sum = sum + n;
            }

            return (sum == target) ? 1 : 0;
        }

        int res = 0;
        res = res + backTrack(numbers, target, idx + 1);

        numbers[idx] = numbers[idx] * (-1);
        res = res + backTrack(numbers, target, idx + 1);

        numbers[idx] = numbers[idx] * (-1);

        return res;
    }
}
