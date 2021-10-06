package Programmers.Challenge;

import java.util.ArrayList;

public class 다단계칫솔판매 {
    public static void main(String[] args) {
        int[] solution1 =
                solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                        new String[]{"young", "john", "tod", "emily", "mary"},
                        new int[]{12, 4, 2, 5, 10}
                );

        int[] solution2 =
                solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                        new String[]{"sam", "emily", "jaimie", "edward"},
                        new int[]{2, 3, 5, 4}
                );

        System.out.println(solution1); // [360, 958, 108, 0, 450, 18, 180, 1080]
        System.out.println(solution2); // [0, 110, 378, 180, 270, 450, 0, 0]
    }

    static int dx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int dy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int node[][]; // 그래프 배열
    static int check[][]; // 방문 배열
    static ArrayList<Integer> resultList = new ArrayList<>();
    static String recommendPeople;

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};

        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-"))
                referral[i] = "center";
        }

        for (int i = 0; i < seller.length; i++) {
            String sellerMan = seller[i];        // 판 사람
            int sellerManSale = amount[i] * 100; // 판 금액

            // 그 사람을 추천해준 사람
            for (int j = 0; j < enroll.length; j++) {
                if (enroll[j].equals(sellerMan)) {
                    recommendPeople = referral[j];
                }
            }
        }


        return answer;
    }

    public static String findRecommendPeople (String[] enroll, String[] referral, String[] seller) {

        return null;
    }
}
