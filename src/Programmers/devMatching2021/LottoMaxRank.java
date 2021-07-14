package Programmers.devMatching2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*

순위	당첨 내용
1	6개 번호가 모두 일치
2	5개 번호가 일치
3	4개 번호가 일치
4	3개 번호가 일치
5	2개 번호가 일치
6(낙첨)	그 외

 */
public class LottoMaxRank {
    // 구매한 로또 번호
    static int[] lottos1 = {44, 1, 0, 0, 31, 25};
    static int[] lottos2 = {0, 0, 0, 0, 0, 0};
    static int[] lottos3 = {45, 4, 35, 20, 3, 9};

    // 당첨번호 6개
    static int[] win_nums1 = {31, 10, 45, 1, 6, 19};
    static int[] win_nums2 = {38, 19, 20, 40, 15, 25};
    static int[] win_nums3 = {20, 9, 3, 45, 4, 35};

    // 최고등수, 최저등수
    static int[] result1 = {3, 5};
    static int[] result2 = {1, 6};
    static int[] result3 = {1, 1};

    public static void main(String[] args) {
//        System.out.println(solution(lottos1, win_nums1));
//        System.out.println(solution(lottos2, win_nums2));
        System.out.println(solution(lottos3, win_nums3));

    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int resultNum = 0;
        int a;

        HashMap<Integer, Integer> hm = new HashMap<>();
        // 해시맵에 넣기
        // for(A:B) → B에서 차례대로 객체를 꺼내서 A에다가 넣겠다
        // hashmap.getOrDefault → 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.
        for (Integer myLottos : lottos) {
            hm.put(myLottos, hm.getOrDefault(myLottos, 0) + 1);
        }

        Iterator iterator = hm.keySet().iterator();

        // iterator 돌면서 같은 key 값 스캔하고 같은 값인거 resultA, resultB에 담기
        while(iterator.hasNext()){
            Integer key = (Integer)iterator.next();
            System.out.println("hashMap Key : " + key);
            for (int i = 0; i < win_nums.length; i++) {
                if(key == win_nums[i]){
                    resultNum += 1;
                    break;
                }
            }
        }

        if(hm.containsKey(0)){
            a = resultNum + hm.get(0);
        } else {
            a = resultNum;
        }

        int b = resultNum;
        switch(a){
            case 6:
                answer[0] = 1;
                break;
            case 5:
                answer[0] = 2;
                break;
            case 4:
                answer[0] = 3;
                break;
            case 3:
                answer[0] = 4;
                break;
            case 2:
                answer[0] = 5;
                break;
            default:
                answer[0] = 6;
                break;
        }

        switch(b){
            case 6:
                answer[1] = 1;
                break;
            case 5:
                answer[1] = 2;
                break;
            case 4:
                answer[1] = 3;
                break;
            case 3:
                answer[1] = 4;
                break;
            case 2:
                answer[1] = 5;
                break;
            default:
                answer[1] = 6;
                break;
        }

        return answer;
    }
}
