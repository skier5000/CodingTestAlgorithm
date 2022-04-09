package CodingTest.TodaysHouse_20220409;

import java.util.ArrayList;

public class Solution1 {

    private static String path1 = "EEESEEEEEENNNN";
    private static String path2 = "SSSSSSWWWNNNNNN";

    private static String[] result1 = new String[]{"Time 0: Go straight 300m and turn right", "Time 3: Go Straight 100m and turn left", "Time 5: Go Straight 500m and turn left"};
    private static String[] result2 = new String[]{"Time 1: Go straight 300m and turn right", "Time 3: Go Straight 100m and turn left", "Time 5: Go Straight 500m and turn left"};

    private static int cnt = 0;

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        // solution1.solution(path1);
        solution1.solution(path2);
    }

    public String[] solution(String path) {
        ArrayList<String> arrayList = new ArrayList<>();

        // 세팅
        int n = 1;

        // 시작
        char preChar = path.charAt(0);

        // main
        for (int i = 1; i < path.length(); i++) {

            // 같은방향
            if (preChar == path.charAt(i)) {
                n++;
                System.out.println("같은방향");

            } else {
                arrayList.add(answerType(i, n, preChar, path.charAt(i)));
                preChar = path.charAt(i);
                n = 1;
                System.out.println("방향바뀜");
            }
        }

        return arrayList.toArray(new String[arrayList.size()]);
    }

    public String answerType(int x, int y, char preDirection, char willDirection) {
        StringBuilder sb = new StringBuilder();
        String direction = "";

        if (preDirection == 'E' && willDirection == 'S')
            direction = "right";
        if (preDirection == 'E' && willDirection == 'N')
            direction = "left";
        if (preDirection == 'S' && willDirection == 'W')
            direction = "right";
        if (preDirection == 'S' && willDirection == 'E')
            direction = "left";
        if (preDirection == 'W' && willDirection == 'S')
            direction = "left";
        if (preDirection == 'W' && willDirection == 'N')
            direction = "right";
        if (preDirection == 'N' && willDirection == 'W')
            direction = "left";
        if (preDirection == 'N' && willDirection == 'E')
            direction = "right";

        if (y > 5) {
            x = x - (y - 5);
        }


        sb.append("Time ")
                .append(x)
                .append(": Go straight ")
                .append(y*100)
                .append("m and turn ")
                .append(direction);

        return sb.toString();
    }
}
