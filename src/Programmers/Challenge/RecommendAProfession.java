package Programmers.Challenge;

import java.util.*;

public class RecommendAProfession {
    public static void main(String[] args) {
        String[] table1 = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] table2 = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};

        String[] languages1 = {"PYTHON", "C++", "SQL"};
        String[] languages2 = {"JAVA", "JAVASCRIPT"};

        int[] preference1 = {7, 5, 5};
        int[] preference2 = {7, 5};

        RecommendAProfession recommendAProfession = new RecommendAProfession();
        System.out.println(recommendAProfession.solution(table1, languages1, preference1)); // "HARDWARE"
        //System.out.println(recommendAProfession.solution(table2, languages2, preference2)); // "PORTAL"
    }

    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int score=-1;
        for(String str : table){
            String[] t = str.split(" ");
            String tname = t[0];
            int tscore = 0;
            for(int i=0;i<languages.length;i++){
                int idx = Arrays.asList(t).indexOf(languages[i]);
                if(idx>-1) tscore+=preference[i]*(6-idx);
            }
            if(score ==tscore && answer.compareTo(tname)>0) answer=tname;
            if(score<tscore){
                score =tscore;
                answer= tname;
            }
        }
        return answer;
    }

}
