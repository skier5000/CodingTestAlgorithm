package CodingTest.SsgCodingTest;

import java.util.LinkedList;
import java.util.Queue;

/*
모든 선수들은 "프로"와 "아마추어" 두 종류로 나뉩니다. 프로와 아마추어가 맞붙으면 항상 프로 선수가 이긴다고 가정합니다.
매치의 두 선수들 중 한 명 이상이 프로인 매치를 "스페셜 매치"라고 부릅니다. 예를 들어, 8명의 선수들 중에서 1번, 4번 그리고 7번이 프로라면, 대진표가 다음과 같게 되어 스페셜 매치는 총 6개가 됩니다. 프로는 빨간색으로 색칠된 원입니다.

    public static void main(String[] args) {
        int[] players1 = {1, 0, 0, 1, 0, 0, 1, 0};
        int[] players2 = {0, 0, 0, 1};
        int[] players3 = {0, 1, 1, 0, 0, 1, 1, 0};

    }

 */
public class Question2 {
    private long[] tree;

    public static void main(String[] args) {
        int[] players1 = {1, 0, 0, 1, 0, 0, 1, 0};
        int[] players2 = {0, 0, 0, 1};
        int[] players3 = {0, 1, 1, 0, 0, 1, 1, 0};
        int[] players4 = {0, 0, 0, 0};

        Question2 question2 = new Question2();
        question2.solution(players1);
//        solution.solution(players2);
//        solution.solution(players4);

    }


    public int solution(int[] players) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        // 큐 생성
        for (int player : players) {
            queue.offer(player);
        }

        while(!queue.isEmpty()) {
            if (queue.size() == 1) {
                break;
            }
            int peekValueNumber1 = queue.poll();
            int peekValueNumber2 = queue.poll();

            if (peekValueNumber1 != peekValueNumber2){ // 하나라도 프로면
                queue.offer(peekValueNumber1);
                count++;
            }
            else if (peekValueNumber1 == peekValueNumber2){ // 둘 다 아마추어 혹은 둘 다 프로면
                queue.offer(peekValueNumber1);  // 하나 위로 올리고
                count++;
            }

        }

        return count;
    }

}
