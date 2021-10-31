package Programmers.Challenge;

public class CountryOf124 {
    public static void main(String[] args) {
        CountryOf124 dd = new CountryOf124();



//        System.out.println(dd.solution(1)); // 1
//        System.out.println(dd.solution(2)); // 2
//        System.out.println(dd.solution(3)); // 4
//        System.out.println(dd.solution(4)); // 11


        System.out.println(dd.solution(10));
    }

    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        int num = n;

        // input 만큼 돌리기
        while(num > 0){
            // remainder 에 num/3 의 나머지
            // num 은 몫
            int remainder = num % 3;
            num = num / 3;

            if(remainder == 0)
                num--;

            answer = numbers[remainder] + answer;
        }

        return answer;
    }
}
