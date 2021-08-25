package CodingTest.TossNextLevel;


import java.util.Objects;

public class Question1 {

    public static void main(String[] args) {
        Question1 question1 = new Question1();
        question1.solution(100, 0, 0);  // 10
        question1.solution(120, 20, 0); // 10
        question1.solution(120, 0, 20); // 10
    }


    // orderAmount : 주문금액
    // taxFreeAmount : 비과세금액
    // serviceFee : 봉사료

/*
부가가치세 : 과세의 대상이 되는 과세금액에서 10%만큼 산정해주시면 됩니다. 참고로 소수점(이하) 첫째자리에서 올림 처리합니다.
과세금액 : 공급가액에서 비과세 금액을 빼주시면 됩니다. 비과세 금액은 말 그대로 부가가치세가 부과되지 않는 금액을 의미해요.
공급가액에 부가가치세를 더한 금액은 공급대가라고도 표현하는데, 보통 봉사료가 없다면 공급대가는 주문금액과 같아요.
하지만 숙박업 등 봉사료가 존재하는 업종의 경우에는 주문금액에서 봉사료를 제한 금액이 공급대가가 됩니다.
공급대가에서 비과세금액을 뺀 남은 금액이 1원이면, 부가가치세를 0원으로 처리


 */
    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        long supplyPrice = 0L;  // 공급대가

        if (Objects.isNull(serviceFee)) { // 봉사료가 없으면
            supplyPrice = orderAmount;
        } else if (!Objects.isNull(serviceFee)){ // 봉사료가 있으면
            supplyPrice = (orderAmount - serviceFee);
        }

        if ((supplyPrice - taxFreeAmount) == 1)
            return 0;

        return (long) Math.ceil(((supplyPrice - taxFreeAmount) * 10) / 100);
    }
}
