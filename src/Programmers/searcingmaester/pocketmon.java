package Programmers.searcingmaester;

import java.util.*;

public class pocketmon {
    static int[] nums1 = {3,1,2,3};
    static int[] nums2 = {3,3,3,2,2,4};
    static int[] nums3 = {3,3,3,2,2,2};

    static int result1 = 2;
    static int result2 = 3;
    static int result3 = 2;

    public static void main(String[] args) {

        int answer = solution(nums2);
        if (answer == result2)
            System.out.println("정답");
        else
            System.out.println("틀렸음");
    }

    public static int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        // HashSet 으로 중복값 제거하면서 저장
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        if(hs.size() > nums.length/2){
            return nums.length/2;
        }

        return hs.size();
    }
}
