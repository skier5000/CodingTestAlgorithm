package Programmers.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ExpressedAsN {
    public static void main(String[] args) {
        ExpressedAsN expressedAsN = new ExpressedAsN();
        System.out.println(expressedAsN.solution(5, 12)); // 4
        System.out.println(expressedAsN.solution(2, 11)); // 3
    }
    public int solution(int N, int number) {
        int answer = -1;
        Set<Integer>[] setArr = new Set[9]; // N은 1 이상 9 이하 이므로
        int t = N;

        for(int i = 1; i < 9; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(t);
            t = t * 10 + N;
        }

        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                for(Integer a : setArr[j]) {
                    for(Integer b : setArr[i - j]) {
                        setArr[i].add(a + b);
                        setArr[i].add(a - b);
                        setArr[i].add(b - a);
                        setArr[i].add(a * b);
                        if(b != 0) {
                            setArr[i].add(a / b);
                        }
                        if(a != 0) {
                            setArr[i].add(b / a);
                        }
                    }
                }
            }
        }

        for(int i = 1; i < 9; i++) {
            if(setArr[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

}


