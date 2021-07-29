package BaekJoon.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
2143
 */
public class Bj1427 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        String result = "";

        String number = Integer.toString(scanner.nextInt()); // "2143"
        for (int i = 0; i < number.length(); i++) {
            arrayList.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }

        Collections.sort(arrayList, Comparator.reverseOrder());
        for (Integer integer : arrayList) {
            result += Integer.toString(integer);
        }
        System.out.println(result);

    }

}
