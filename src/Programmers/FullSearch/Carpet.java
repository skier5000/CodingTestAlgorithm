package Programmers.FullSearch;

public class Carpet {
    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        carpet.solution(10, 2);
        //carpet.solution(8, 1);
        //carpet.solution(24, 24);
    }

    public int[] solution(int brown, int yellow) {
        int height = 0;
        int width = 0;

        for (height = 3; height <= ((brown + 4) / 2); height++) {

            width = ((brown + 4) / 2) - height;
            if (width < height) {
                break;
            }

            int redCount = (width - 2) * (height - 2);
            if (yellow == redCount) {
                break;
            }
        }

        int[] answer = new int[] {width, height };
        return answer;
    }
}
