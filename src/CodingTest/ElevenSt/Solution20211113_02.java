package CodingTest.ElevenSt;

import java.util.Arrays;

public class Solution20211113_02 {
    public static void main(String[] args) {
        Solution20211113_02 dd = new Solution20211113_02();
//        dd.solution(new String[]{"abc", "bca", "dbe"});    // 0,2,1
        dd.solution(new String[]{"zzzz", "ferz", "zdsr", "fgtd"});  // [0,1,3] or [1,3,0]
//        dd.solution(new String[]{"gr", "sd", "rg"});  // []
//        dd.solution(new String[]{"bdafg", "ceagi"});  // [0,1,2]

        // String 0 "abc"는   String 2 "dbe" 의   같은 "b" 인덱스 1에 있다
    }

    public int[] solution(String[] S) {
        int[] arr = new int[3];
        char compareChar;


        Loop1:
        for (int i = 0; i < S.length; i++) {
            char[] chars = String.valueOf(S[i]).toCharArray(); // zzzz

            for (int l = 0; l < chars.length; l++) {
                char aChar = chars[l];

                for (int j = i+1; j < S.length; j++) {

                    for (int k = 0; k < S[j].length(); k++) {
                        compareChar = S[j].charAt(k);

                        if (l == k) {
                            if (Character.compare(aChar, compareChar) == 0) {
                                arr = new int[]{i, j, k};
                                break Loop1;
                            }
                        }
                    }

                }
            }
        }


        if (equals(arr, new int[]{0, 0, 0})) {
            int[] emptyArr = {};
            return emptyArr;
        }

        return arr;
    }

    static boolean equals(int[] intarray_1, int[] intarray_2) {
        if(intarray_1.length != intarray_2.length) {
            return false;
        }
        for(int i=0; i<(intarray_1.length); i++) {
            if(intarray_1[i] != intarray_2[i]){
                return false;
            }
        }
        return true;
    }
}
