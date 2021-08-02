package Programmers.Heap;

import java.util.*;
import java.util.stream.Stream;

public class DoublePriorityQueue {

/*
    이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

    명령어	수신 탑(높이)
    I 숫자	큐에 주어진 숫자를 삽입합니다.
    D 1	큐에서 최댓값을 삭제합니다.
    D -1	큐에서 최솟값을 삭제합니다.

    이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
 */

    public static void main(String[] args) {
        String[] operations1 = {"I 16", "D 1"};
        String[] operations2 = {"I 7", "I 5", "I -5", "D -1"};
        String[] operations3 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations4 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};


        DoublePriorityQueue doublePriorityQueue = new DoublePriorityQueue();
        //doublePriorityQueue.solution(operations1);  // [0,0]
        //doublePriorityQueue.solution(operations2);  // [7,5]
        //doublePriorityQueue.solution(operations3);  // [123,123]
        doublePriorityQueue.solution(operations4);  // [333,-45]

    }


    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        ArrayList<String> operationList = new ArrayList<>();
        ArrayList<String> answerList = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            operationList.add(operations[i]);
        }

        for (int i = 0; i < operationList.size(); i++) {

            String[] what = operationList.get(i).split(" ");

            switch (what[0]) {
                case "I":
                    System.out.println("큐에 주어진 숫자를 삽입합니다.");
                    answerList.add(what[1]);
                    Collections.sort(answerList, Collections.reverseOrder());
                    break;
                case "D":
                    if (what[1].equals("1")){
                        if (answerList.size() == 0) continue;

                        System.out.println("큐에서 최댓값을 삭제합니다");
                        answerList.remove(0);
                        Collections.sort(answerList, Collections.reverseOrder());
                    }
                    else if (what[1].equals("-1")){   // 오름차순으로 바꾸고 poll 하고 다시 내림차순으로
                        if (answerList.size() == 0) continue;
                        System.out.println("큐에서 최솟값을 삭제합니다");
                        answerList.remove(answerList.size() - 1);
                        Collections.sort(answerList, Collections.reverseOrder());
                    }
                    break;
            }

        }

        if (answerList.size() == 0) {  // 비어있으면
            return answer;
        }
        else if(answerList.size() > 0){
            answer[0] = Integer.parseInt(answerList.get(0));
            answer[1] = Integer.parseInt(answerList.get(answerList.size() - 1));
        }

        return answer;
    }
}














