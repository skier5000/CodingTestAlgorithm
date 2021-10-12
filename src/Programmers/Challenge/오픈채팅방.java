package Programmers.Challenge;

import java.util.*;

public class 오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};

        오픈채팅방 coo = new 오픈채팅방();
        String[] solution = coo.solution(record);
        if (solution.equals(result))
            System.out.println("정답");
        else
            System.out.println("오답");
    }

    public String[] solution(String[] record) {
        ArrayList<String> chat = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();

        for (String log : record) {
            StringTokenizer st = new StringTokenizer(log);
            String command = st.nextToken();
            String userId = st.nextToken();
            String nickname = "";

            if (!command.equals("Leave")) {
                nickname = st.nextToken();
            }

            switch (command) {
                case "Enter":
                    hm.put(userId, nickname);
                    chat.add(userId + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    chat.add(userId + "님이 나갔습니다.");
                    break;
                case "Change":
                    hm.put(userId, nickname);
                    break;
            }
        }

        String[] answer = new String[chat.size()];
        int idx = 0;

        for (String str : chat) {
            int endOfId = str.indexOf("님");
            String userId = str.substring(0, endOfId);

            answer[idx++] = str.replace(userId, hm.get(userId));
        }

        return answer;
    }
}


