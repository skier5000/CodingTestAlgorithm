package Programmers.Challenge;

import java.util.HashMap;

public class 숫자문자열과영단어 {
    public static void main(String[] args) {
        String s1 = "one4seveneight";
        String s2 = "23four5six7";
        String s3 = "2three45sixseven";
        String s4 = "123";

        숫자문자열과영단어 dd = new 숫자문자열과영단어();
        //dd.solution(s1);
        dd.solution(s2);
        dd.solution(s3);
        dd.solution(s4);

    }

    public int solution(String s) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            // 숫자이면?
            boolean isNumeric =  sb.toString().matches("[+-]?\\d*(\\.\\d+)?");
            if (isNumeric) {
                if (map.containsKey(Integer.parseInt(sb.toString()))) {
                    result.append(sb);
                    sb.setLength(0);
                    continue;
                }
            }

            // 최소 문자열 3 이상
            if (sb.length() >= 3) {
                for (int j = 0; j < map.size(); j++) {
                    String s1 = map.get(j);
                    if (sb.toString().equals(s1)) {
                        result.append(j);
                        sb.setLength(0);
                        break;
                    }
                }
            }
        }

        return Integer.parseInt(result.toString());
    }
}
