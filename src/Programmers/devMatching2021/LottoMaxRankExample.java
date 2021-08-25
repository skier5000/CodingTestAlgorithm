package Programmers.devMatching2021;

import java.util.HashMap;
import java.util.Iterator;

public class LottoMaxRankExample {
    public static void main(String[] args) {
        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] lottos3 = {45, 4, 35, 20, 3, 9};
        int[] win_nums1 ={31, 10, 45, 1, 6, 19};
        int[] win_nums2 = {38, 19, 20, 40, 15, 25};
        int[] win_nums3 = {20, 9, 3, 45, 4, 35};

        LottoMaxRankExample lottoMaxRankExample = new LottoMaxRankExample();
        //lottoMaxRankExample.solution(lottos1, win_nums1); // [3, 5]
        //lottoMaxRankExample.solution(lottos2, win_nums2); // [1, 6]
        lottoMaxRankExample.solution(lottos3, win_nums3); // [1, 1]

    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int resultNumA = 0;
        int resultNumB = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int lotto : lottos) {
            hm.put(lotto, hm.getOrDefault(lotto, 0) + 1);
        }

        // iterator 돌면서 같은 key 값 스캔하고 같은 값인거 resultA, resultB에 담기
        Iterator iterator = hm.keySet().iterator();
        while(iterator.hasNext()){
            Integer key = (Integer)iterator.next();
            for (int i = 0; i < win_nums.length; i++) {
                if(key == win_nums[i]){
                    resultNumB ++;
                    break;
                }
            }
        }
        if (hm.containsKey(0))
            resultNumA = hm.get(0) + resultNumB;
        else if (!hm.containsKey(0))
            resultNumA = resultNumB;

        int[] answer = new int[]{rank(resultNumA), rank(resultNumB)};


        return answer;
    }

    public static int rank(int resultNum) {
        int returnNum;
        switch (resultNum) {
            case 6:
                returnNum = 1;
                break;
            case 5:
                returnNum = 2;
                break;
            case 4:
                returnNum = 3;
                break;
            case 3:
                returnNum = 4;
                break;
            case 2:
                returnNum = 5;
                break;
            default:
                returnNum = 6;
                break;
        }
        return returnNum;
    }
}
