package CodingTest.TossNextLevel;

public class Question3 {

    public static void main(String[] args) {
        Question3 question3 = new Question3();
//        question3.solution("10000");
//        question3.solution("25,000");
        question3.solution("39,00");
    }

    public boolean solution(String amountText) {
        boolean answer = true;
        int count = 1;

        if (amountText.startsWith(",") || amountText.endsWith(",")) {  // 첫 문자, 끝 문자가 "," 로 될 때
            return false;
        } else if (amountText.startsWith("0")) { // 0으로 시작할 떄
            return false;
        } else if (amountText.matches("^[a-zA-Z]*$") || amountText.matches("^[가-힣]*$")){ // 한글 혹은 영어가 들어가면 false
            return false;
        }

        if (!amountText.contains(",")) { // 이 문자열에 쉼표가 없으면 true
            return answer;
        } else {  //  숫자에 쉼표가 발견될 시 다시 체크
            for (int i = amountText.length(); i > 0; i--) {
                if ((count%4) == 0) { // 단위로 끊어서 쉼표를 쓸 때
                    if (amountText.charAt(i-1) != ',')
                        return false;
                }
                count++;
            }
        }

        return answer;
    }
}
