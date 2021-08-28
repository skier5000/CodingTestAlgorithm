package Programmers.Hash;

import java.util.HashMap;

public class Weejang {

	public static void main(String[] args) {
		String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

		solution(clothes1);
		solution(clothes2);
	}
	
	

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0 ; i < clothes.length ; i++) {
            System.out.println("clothes["+i+"][1] : " + clothes[i][1]);
            
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
//                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
            else {
                map.put(clothes[i][1], 1);
            }
        }

        for (int i = 0 ; i < clothes.length ; i++) {
            answer *= (map.get(clothes[i][1]) + 1);
            map.put(clothes[i][1], 0);
        }
        
        
        return answer - 1;
    }
    

}
