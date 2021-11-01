package Programmers.Challenge;

public class NewsClustering {
    public static void main(String[] args) {
        NewsClustering dd = new NewsClustering();

        System.out.println(dd.solution("FRANCE", "french"));
        System.out.println(dd.solution("handshake", "shake hands"));
        System.out.println(dd.solution("aa1+aa2", "AAAA12"));
        System.out.println(dd.solution("E=M*C^2", "e=m*c^2"));
    }

    /*
    자카드 유사도
    두 집합의 교집합 크기 / 두 집합의 합집합 크기 = 값
    
    ex
    FRANCE, FRENCH
    FR, RA, AN, NC, CE
    FR, RE, EN, NC, CH
    
    교집합
    FR, NC - 2
    합집합
    FR, RA, AN, NC, CE, RE, EN, CH - 8
    답
    2/8 = 0.25  => 0.25 * 65536 = 16384
    16384
    */
    
    public int solution(String str1, String str2) {
        int answer = 0;

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        for (int i = 0; i < str1.length(); i++) {

        }


        return answer;
    }
}
