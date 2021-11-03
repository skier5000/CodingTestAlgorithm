package Programmers.Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;

public class 표편집 {
    public static void main(String[] args) {
        표편집 dd = new 표편집();
        //System.out.println(dd.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println(dd.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));

    }

    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        int rankCnt = 1;
        int idx = 0;
        int cnt = 0;
        int moveIdx = 0;

        ArrayList<CheckValue> node = new ArrayList<>();  // 처음 표의 행 개수 (node)

        for (int i = 0; i < n; i++) {
            node.add(new CheckValue(false, false, 0));

            if (i == k) // 선택된 행은 true 로 표기
                node.set(i, new CheckValue(true, false, 0));
        }

        for (int i = 0; i < cmd.length; i++) {
            String[] commander = cmd[i].split(" ");

            switch (commander[0]) {
                case "U":   // 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
                    idx = whatIndex(node);

                    // 삭제여부 체크, 행 이동
                    cnt = 0;
                    moveIdx = idx;
                    while (true) {
                        moveIdx--;
                        if (node.get(moveIdx).delYn == false && node.get(moveIdx).value == false) {
                            cnt++;
                        }

                        if (cnt == Integer.parseInt(commander[1])) {
                            node.set(moveIdx, new CheckValue(true, false, 0));
                            node.set(idx, new CheckValue(false, false, 0));
                            break;
                        }
                    }

                    break;

                case "D":   // 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
                    idx = whatIndex(node);

                    // 삭제여부 체크, 행 이동
                    cnt = 0;
                    moveIdx = idx;
                    while (true) {
                        moveIdx++;
                        if (node.get(moveIdx).delYn == false && node.get(moveIdx).value == false) {
                            cnt++;
                        }

                        if (cnt == Integer.parseInt(commander[1])) {
                            node.set(moveIdx, new CheckValue(true, false, 0));
                            node.set(idx, new CheckValue(false, false, 0));
                            break;
                        }
                    }

                    break;

                case "C":   // 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
                    idx = whatIndex(node);
                    
                    if (idx != (node.size() - 1)) {   // 바로 아래 행 선택
                        for (int j = idx; j < node.size(); j++) {
                            if (node.get(idx).delYn == false) {
                                node.set(idx + 1, new CheckValue(true, false, 0));
                                break;
                            }
                        }
                    } else {   // 바로 윗 행 선택
                        for (int j = idx; j >= 0; j--) {
                            if (node.get(idx).delYn == false) {
                                node.set(idx - 1, new CheckValue(true, false, 0));
                                break;
                            }
                        }
                    }

                    node.set(idx, new CheckValue(false, true, rankCnt++));

                    break;

                case "Z":   // 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.

                    // 최근에 삭제된 행 탐색
                    int lastDelIdx = 0;
                    for (int j = 0; j < node.size() - 1; j++) {
                        if (node.get(j).rank > node.get(j + 1).rank && node.get(lastDelIdx).rank < node.get(j).rank)
                            lastDelIdx = j;
                        else if (node.get(j).rank < node.get(j + 1).rank && node.get(lastDelIdx).rank < node.get(j+1).rank)
                            lastDelIdx = j + 1;
                    }

                    if (lastDelIdx != 0)
                        node.set(lastDelIdx, new CheckValue(false, false, 0));

                    break;

                default:
                    break;
            }

        }

        for (int i = 0; i < node.size(); i++) {
            if (node.get(i).delYn == false)
                sb.append("O");
            else
                sb.append("X");
        }

        return sb.toString();
    }

    // 선택된 행 찾는 메소드
    public int whatIndex(ArrayList<CheckValue> node) {
        for (int i = 0; i < node.size(); i++) {
            if (node.get(i).value == true) {
                return i;
            }
        }
        return 0;
    }

    static class CheckValue {
        boolean value; // 선택된 행
        boolean delYn; // 삭제여부 (false : 살아, true : 죽어)
        int rank;      // 최근 삭제 순위

        public CheckValue(boolean value, boolean delYn, int rank) {
            this.value = value;
            this.delYn = delYn;
            this.rank = rank;
        }
    }
}
