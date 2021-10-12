package Programmers.Challenge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Person> personMap = new HashMap<>();
        for (String name : enroll) {
            personMap.put(name, new Person(name, null, 0));
        }

        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-")) {
                continue;
            }
            personMap.get(enroll[i]).parent = personMap.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            personMap.get(seller[i]).CalcProfit(amount[i] * 100);
        }

        int[] result = new int[enroll.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = personMap.get(enroll[i]).profit;
        }

        return result;
    }



    static class Person {
        String name;
        Person parent;
        int profit;

        public Person(String name, Person parent, int profit) {
            this.name = name;
            this.parent = parent;
            this.profit = profit;
        }

        public void CalcProfit(int profit) {
            int profitToParent = profit / 10;
            this.profit += profit - profitToParent;
            if (this.parent != null && profitToParent >= 1) {
                this.parent.CalcProfit(profitToParent);
            }
        }
    }
}
