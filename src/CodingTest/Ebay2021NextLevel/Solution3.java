package CodingTest.Ebay2021NextLevel;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
//        System.out.println(solution3.solution(new int[]{1, 2, 3, 4}));
//        System.out.println(solution3.solution(new int[]{1, 2, 4, 1, 2, 3}));
        System.out.println(solution3.solution(new int[]{4, 3, 2, 1, 4}));
//        System.out.println(solution3.solution(new int[]{1, 10, 5, 11, 7}));
    }

    public int solution (int[] prices) {
        int answer = 0;
        int i = 0, j = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int k = 0; k < prices.length; k++) {
            arrayList.add(prices[k]);
        }

        while(!arrayList.isEmpty()){
            int priceBefore = arrayList.get(i);
            int max = 0, idx = 0;

            ArrayList<Score> arrayListSort = new ArrayList<>();
            for (int k = 0; k < arrayList.size(); k++) {
                arrayListSort.add(new Score(arrayList.get(k), k));
            }

            Collections.sort(arrayListSort, new Comparator<Score>() {
                @Override
                public int compare(Score o1, Score o2) {
                    return o1.value - o2.value;
                }
            });

            if (arrayListSort.get(arrayListSort.size() - 1).value > arrayList.get(i)) {
                max = arrayListSort.get(arrayListSort.size() - 1).value;
                idx = arrayListSort.get(arrayListSort.size() - 1).idx;
            }

            arrayList.remove(i);
            if (max != 0) {
                arrayList.remove(idx-1);
                answer += (max - priceBefore);
            }

        }

        return answer;
    }

    static class Score {
        int value;
        int idx;

        public Score(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

}
