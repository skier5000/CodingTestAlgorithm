package Programmers.Greedy;

public class AthleticUniform {

    // 전체 학생 수
    private static int n1 = 5;
    private static int n2 = 5;
    private static int n3 = 3;

    // 체육복을 도난당한 학생들의 번호가 담긴 배열
    private static int[] lost1 = {2,4};
    private static int[] lost2 = {2,4};
    private static int[] lost3 = {3};

    // 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열
    private static int[] reserve1 = {1,3,5};
    private static int[] reserve2 = {3};
    private static int[] reserve3 = {1};

    // 결과값
    private static int return1 = 5;
    private static int return2 = 4;
    private static int return3 = 2;

    public static void main(String[] args) {
        int result = solution(n3,lost3, reserve3);
        if(return1 == result)
            System.out.println("합격");
        else
            System.out.println("불합격");
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] nSum = new int[n+2];

        // 체육복을 도난당한 학생들의 번호가 담긴 배열
        for (int i = 0; i < nSum.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if(i == lost[j])
                    nSum[i] = lost[j];
            }
        }

        // 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열
        for (int i = 0; i < nSum.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(i == reserve[j])
                    nSum[i] = reserve[j];
            }
        }

        return answer;
    }
}
