package CodingTest.ElevenSt;

import java.util.ArrayList;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        //solution1.solution(28);
        solution1.solution(734);
        solution1.solution(1990);
        solution1.solution(1000);
    }

    public int solution(int N) {
        int answer = 0;

        String NtoString = String.valueOf(N);
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < NtoString.length(); i++) {
            arrayList.add(NtoString.charAt(i));
        }

        int resultCnt = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            resultCnt += Integer.parseInt(String.valueOf(arrayList.get(i)));
        }

        while (true) {
            N++;
            String s = String.valueOf(N);
            ArrayList<Character> arr = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                arr.add(s.charAt(j));
            }

            int result = 0;
            for (int j = 0; j < arr.size(); j++) {
                result += Integer.parseInt(String.valueOf(arr.get(j)));
            }

            if (result == resultCnt) {
                answer = N;
                break;
            }
        }
        return answer;
    }
}
