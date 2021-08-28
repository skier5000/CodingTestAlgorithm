package CodingTest.Ebay2021NextLevel;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.solution("1011"));   // 2
        System.out.println(solution1.solution("0110011"));   // 1
        System.out.println(solution1.solution("000111"));    // 0
    }
    public int solution(String S) {
        int value = 0, i = 0;
        StringBuilder sb = new StringBuilder(S);

        while (true) {

            if (i == sb.length() - 1 || sb.length() <= 1 )
                break;

            String substring = sb.substring(i, i + 2);
            if (sb.substring(i, i + 2).equals("01") || sb.substring(i, i + 2).equals("10")) {
                sb = sb.delete(i, i + 2);
                System.out.println("sb = " + sb);
                i = 0;
            } else {
                i++;
            }

        }

        return sb.length();
    }

}
