package Programmers.DFS_BFS;

import java.util.*;

public class WordConversion {

    private int answerCnt = 0;
    private boolean isFound = false;
    private String target = null;

    public static void main(String[] args) {
        String begin1 = "hit";
        String begin2 = "hit";

        String target1 = "cog";
        String target2 = "cog";

        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        WordConversion wordConversion = new WordConversion();
        wordConversion.solution(begin1, target1, words1); // return1 = 4
//        wordConversion.solution(begin2, target2, words2); // return2 = 0
    }

    /*
     'hit' -> 'hot' -> 'dot' -> 'dog' -> 'cog'
     */

    public int solution(String begin, String target, String[] words) {
        List<String> visited = new ArrayList<String>();
        this.target = target;
        List<String> newWords = Arrays.asList(words);

        search(begin,newWords,visited,1);

        return answerCnt;
    }

    private void search(String str, List<String> words, List<String> visited, int cnt) {
        if ( isFound )
            return;

        visited.add(str);
        List<String> convertableWords = getConvertableWords(str,words,visited);

        if ( convertableWords.size() < 1 )
            return;

        if ( convertableWords.contains(target) ) {
            answerCnt = cnt;
            isFound = true;
            return;
        }
        for (String word : convertableWords) {
            search(word, words, new ArrayList<>(visited), cnt + 1);
        }
    }

    private List<String> getConvertableWords(String str,List<String> words,List<String> visited) {
        List<String> convertableWords = new ArrayList<String>();

        for (String word : words) {
            if (visited.contains(word))
                continue;
            if (!isConvertable(str, word))
                continue;

            convertableWords.add(word);
        }
        return convertableWords;
    }

    private boolean isConvertable(String str, String target) {
        char[] strChars = str.toCharArray();
        char[] targetChars = target.toCharArray();
        int cnt = 0;
        for ( int i = 0; i < strChars.length; i++ ) {
            if ( strChars[i] == targetChars[i] ) {
                cnt++;
            }
        }
        return cnt == strChars.length - 1 ? true : false;
    }

}
