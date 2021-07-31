package Programmers.DFS_BFS;

import java.util.*;

public class TravelRoute {
    static String startTravel = "ICN";
    static String[] temp;
    static String[][] airplanes;
    static boolean[] visited;

    public static void main(String[] args) {
        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        TravelRoute travelRoute = new TravelRoute();
//        travelRoute.solution(tickets1); // return = ["ICN", "JFK", "HND", "IAD"]
        travelRoute.solution(tickets2); // return = ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
    }


    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        String start; // 시작
        String next; // 도착
        airplanes = tickets; // tickets
        visited = new boolean[airplanes.length]; // 방문리스트
        ArrayList<String> result = new ArrayList<>(); // 정답리스트


        for (int i=0; i<airplanes.length; i++) {
            start = airplanes[i][0];
            next = airplanes[i][1];

            if (start.equals("ICN")) {
                //처음 문자가 ICN일때 탐색 시작
                temp = new String[airplanes.length+1];
                temp[0] = start;

                visited[i] = true;
                dfs(start, next, temp, result, 1);
                visited[i] = false;

            }

        }

        Collections.sort(result);

        answer = result.get(0).split(" ");

        return answer;
    }


    public void dfs(String start, String next, String[] temp, ArrayList<String> result, int cnt) {
        temp[cnt] = next;

        if (cnt == airplanes.length) {
            String str = "";
            for (int i=0; i<temp.length; i++) {
                str += temp[i] + " ";
            }
            result.add(str);
        } else {

            for (int i=0; i<airplanes.length; i++) {
                String first = airplanes[i][0];
                String second = airplanes[i][1];

                if (!visited[i] && next.equals(first)) {
                    //방문x
                    //두번째 수와 첫번째 수가 같을 때
                    visited[i] = true;
                    dfs(first, second, temp, result, cnt+1);
                    visited[i] = false;
                }
            }

        }


    }





}
