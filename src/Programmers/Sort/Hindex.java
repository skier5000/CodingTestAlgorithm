package Programmers.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Hindex {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        //return 3

        solution(citations);
    }

    public static int solution(int[] citations) {
        int answer = 0;
        int avgLevel = 0;

        //System.out.println("citations : " + citations);
        //System.out.println("발표한 논문의 수 : " + citations.length);

        // 정렬 후 평균값
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++) {
            //h를 줄여가면서 검사
            int h = citations.length-i;
            if(citations[i]>=h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

}
