package CodingTest.SsgCodingTest;


import java.util.LinkedList;
import java.util.Queue;

public class Question3 {

    private static int[] truck1 = {1, 4, 5, 2, 4};
    private static int[] truck2 = {2, 7, 4, 9};

    private static int[] w1 = {2, 4, 4, 3, 2};
    private static int[] w2 = {7, 6, 8};


/*
왜 큐? 이중 for 문 돌리면 그만이잖슴

 */

    public static void main(String[] args) {
        Question3 question3 = new Question3();
        //question3.solution(truck1, w1);  // [2,3,5,-1,2]
        //question3.solution(truck2, w2);  // [2,4,-1]

        // 시간복잡도
        //question3.reSolution(truck1, w1);
        question3.reSolution(truck2, w2);
    }


    public int[] solution(int[] truck, int[] w) {
        int[] answer = new int[w.length];
        int i = 0;
        Queue<Integer> weightList = new LinkedList<>();

        // weightList 삽입
        for (int j = 0; j < w.length; j++) {
            weightList.offer(w[j]);
        }

        // 트럭에 싣는다
        while (!weightList.isEmpty()) {
            int popped = weightList.poll();

            for (int j = 0; j < truck.length; j++) {
                if ((truck[j] - popped) >= 0){  // 실을 수 있다면
                    truck[j] = (truck[j] - popped);
                    answer[i] = (j+1);
                    break;
                }
            }

            if (answer[i] == 0)
                answer[i] = -1;

            i++;

        }

        return answer;
    }

    // 반례 : 1 ~ 15만  /  15만 ~ 1
    // 반례 : 1 ~ 15만  /  1 ~ 15만 의 선형적인 방법

    public int[] reSolution(int[] truck, int[] weight) {
        int[] result = new int[weight.length];
        int truckIndex = 0;

        for (int i = 0; i < weight.length; i++) {

            if (i != 0) {
                if (weight[i] >= weight[i - 1]) { // 지금 무게랑 전 무게랑 비교 -> 지금 무게가 크거나 같아
                    if (result[i - 1] == -1) { // 다 돌았는데 없다
                        result[i] = -1;
                        continue;
                    }
                    for (int j = truckIndex; j < truck.length; j++) { // 얘가 들어간 트럭부터 시작
                        if (truck[j] - weight[i] >= 0) {
                            truck[j] = truck[j] - weight[i];
                            result[i] = j + 1;
                            truckIndex = j;
                            break;
                        }

                        if (j == truck.length - 1) {
                            result[i] = -1;
                        }
                    }
                } else {  // 지금 무게랑 전 무게랑 비교 -> 지금 무게가 더 작아
                    for (int j = 0; j < truck.length; j++) {
                        if (truck[j] - weight[i] >= 0) {
                            truck[j] = truck[j] - weight[i];
                            result[i] = j + 1;
                            truckIndex = j;
                            break;
                        }

                        if (j == truck.length - 1) {
                            result[i] = -1;
                        }
                    }
                }

            } else {
                for (int j = truckIndex; j < truck.length; j++) {
                    if (truck[j] - weight[i] >= 0) {
                        truck[j] = truck[j] - weight[i];
                        result[i] = j + 1;
                        truckIndex = j;
                        break;
                    }

//                    if (j == truck.length - 1) {
//                        result[i] = -1;
//                        truckIndex = j;
//                    }
                }

            }
        }

        return result;
    }



}













