package Programmers.KakaoBlindRecruitment2021;

import java.util.*;

public class RankSearch {
    static String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
    static String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

    String language[] = {"cpp","java","python","-"};
    String position[] = {"backend", "frontend","-"};
    String career[] = {"junior","senior","-"};
    String soulfood[] = {"chicken","pizza","-"};
    String joker = "-";

    public static void main(String[] args) {
        RankSearch rankSearch = new RankSearch();
        int[] solutionResult = rankSearch.solution(info, query);


        System.out.println("solutionResult = " + Arrays.toString(solutionResult));
        System.out.println("정답은 = " + "[1,1,1,1,2,4]");
    }

    /**
     * exampleSolution
     * @param info
     * @param query
     * @return
     */
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> infos = new HashMap<>();
        for (String in : info) {
            String[] split = in.split(" ");
            int score = Integer.parseInt(split[4]);

            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) key.append(split[j]);
                }
                infos.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
            }
        }

        List<Integer> empty = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : infos.entrySet())
            entry.getValue().sort(null);

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].replaceAll("-", "").split(" and | ");
            String key = String.join("", split[0], split[1], split[2], split[3]);
            int score = Integer.parseInt(split[4]);

            List<Integer> list = infos.getOrDefault(key, empty);

            int s = 0, e = list.size();

            while (s < e) {
                int mid = (s + e) / 2;

                if (list.get(mid) < score) s = mid + 1;
                else e = mid;
            }

            answer[i] = list.size() - s;
        }

        return answer;
    }









    /**
     * mySolution
     * @param info
     * @param query
     * @return
     */
    //    public int[] solution(String[] info, String[] query) {
    //        HashMap<Integer, InformationEmployee> hmEmployee = new HashMap<>();
    //        HashMap<Integer, InformationEmployee> hmQuery = new HashMap<>();
    //
    //        for (int i = 0; i < info.length; i++) {
    //            String[] infoGagong = info[i].split(" ");
    //            hmEmployee.put(i, new InformationEmployee(infoGagong[0], infoGagong[1], infoGagong[2], infoGagong[3], Integer.parseInt(infoGagong[4])));
    //        }
    //
    //        for (int i = 0; i < query.length; i++) {
    //            query[i] = query[i].replace(" and ", " ");
    //            String[] queryGagong = query[i].split(" ");
    //            hmQuery.put(i, new InformationEmployee(queryGagong[0], queryGagong[1], queryGagong[2], queryGagong[3], Integer.parseInt(queryGagong[4])));
    //        }
    //
    //        int[] answer = new int[hmEmployee.size()];
    //        Iterator<Integer> iteratorHm = hmQuery.keySet().iterator();
    //        while(iteratorHm.hasNext()){
    //            int count = 0;
    //            int key = iteratorHm.next();
    //
    //            for (int i = 0; i < hmEmployee.size(); i++) {
    //                InformationEmployee hmQueryValueChange = new InformationEmployee(hmQuery.get(key).getLan(), hmQuery.get(key).getEnd(), hmQuery.get(key).getHowLong(), hmQuery.get(key).getSoulFood(), hmQuery.get(key).getScore());
    //
    //                if(hmQueryValueChange.getLan().equals("-")){hmQueryValueChange.lan = hmEmployee.get(i).getLan();}
    //                if(hmQueryValueChange.getEnd().equals("-")){hmQueryValueChange.end = hmEmployee.get(i).getEnd();}
    //                if(hmQueryValueChange.getHowLong().equals("-")){hmQueryValueChange.howLong = hmEmployee.get(i).getHowLong();}
    //                if(hmQueryValueChange.getSoulFood().equals("-")){hmQueryValueChange.soulFood = hmEmployee.get(i).getSoulFood();}
    //
    //                if(hmQueryValueChange.getLan().equals(hmEmployee.get(i).getLan()) && hmQueryValueChange.getEnd().equals(hmEmployee.get(i).getEnd()) && hmQueryValueChange.getHowLong().equals(hmEmployee.get(i).getHowLong()) && hmQueryValueChange.getSoulFood().equals(hmEmployee.get(i).getSoulFood())){
    //                    if(hmEmployee.get(i).getScore() >= hmQueryValueChange.getScore()){
    //                        count += 1;
    //                    }
    //                }
    //
    //            }
    //            answer[key] = count;
    //        }
    //
    //        return answer;
    //    }
    //
    //
    //
    //    static class InformationEmployee {
    //        String lan;
    //        String end;
    //        String howLong;
    //        String soulFood;
    //        int score;
    //
    //        public InformationEmployee(String lan, String end, String howLong, String soulFood, int score) {
    //            this.lan = lan;
    //            this.end = end;
    //            this.howLong = howLong;
    //            this.soulFood = soulFood;
    //            this.score = score;
    //        }
    //
    //        public String getLan() {
    //            return lan;
    //        }
    //
    //        public String getEnd() {
    //            return end;
    //        }
    //
    //        public String getHowLong() {
    //            return howLong;
    //        }
    //
    //        public String getSoulFood() {
    //            return soulFood;
    //        }
    //
    //        public int getScore() {
    //            return score;
    //        }
    //    }

}
