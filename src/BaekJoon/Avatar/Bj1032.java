package BaekJoon.Avatar;


import java.util.ArrayList;
import java.util.Scanner;

/*
3
config.sys
config.inf
configures
 */
public class Bj1032 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<>();

        boolean isSame = true;
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            arrayList.add(scanner.next());
        }

        for (int i = 0; i < arrayList.get(0).length(); i++) { // 10번 반복 String length 만큼
            for (int j = 1; j < arrayList.size(); j++) { // 2번 반복 size 만큼
                if (arrayList.get(0).charAt(i) == arrayList.get(j).charAt(i)) {
                    isSame = true;
                } else {
                    isSame = false;
                    break;
                }
            }
            if (isSame == false) {
                sb.append("?");
            } else {
                sb.append(arrayList.get(0).charAt(i));
            }
        }

//        System.out.println("sb = " + sb);
        System.out.println(sb);

    }
}







//public class Bj1032 {
//
//    static String[] strArr;
//    static int count;
//    static String str="";
//    static boolean isSame=true;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//
//        int n=Integer.parseInt(br.readLine().trim());
//        strArr=new String[n];
//
//        for(int i=0;i<n;i++) {
//            strArr[i]=br.readLine();
//        }
//
//        for (int i = 0; i < strArr[0].length(); i++) {
//            for (int j = 1; j < n; j++) {
//                if (strArr[0].charAt(i) == strArr[j].charAt(i)) {
//                    System.out.println("strArr[0].charAt(i) : " + strArr[0].charAt(i));
//                    System.out.println("strArr[j].charAt(i) : " + strArr[j].charAt(i));
//                    isSame = true;
//                } else {
//                    isSame = false;
//                    break;
//                }
//            }
//            if (isSame == false) {
//                str += "?";
//            } else {
//                str += strArr[0].charAt(i);
//            }
//        }
//        System.out.println(str);
//        br.close();
//    }
//
//}