package BaekJoon.단계별로풀어보기.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
마을의 개수, 트럭의 용량, 박스 정보(보내는 마을번호, 받는 마을번호, 박스 개수)가 주어질 때, 트럭 한 대로 배송할 수 있는 최대 박스 수를 구하는 프로그램을 작성하시오

 */
public class 택배 {

    static int truckIndex = 0;
    static int maxBoxesSize;
    static int truckBoxes = 0;  // 트럭에 실려있는 박스들
    static int totalBoxes = 0;  // 총 실은 박스들

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        ArrayList<Integer> homeList = new ArrayList<>();
        ArrayList<matrix> matrixArrayList = new ArrayList<>();
        maxBoxesSize = Integer.parseInt(String.valueOf(s[1]));

        for (int i = 0; i < Integer.parseInt(String.valueOf(s[0])); i++) {
            homeList.add(i+1);
        }

        // 보내는 박스 (for문)
        int forSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < forSize; i++) {
            String[] split = br.readLine().split(" ");
            matrixArrayList.add(new matrix(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }

        // 정렬
        Collections.sort(matrixArrayList, new Comparator<matrix>() {
            @Override
            public int compare(matrix o1, matrix o2) {
                return o1.start - o2.start;
            }
        });

        Loop1:
        while (truckIndex != Integer.parseInt(s[0])) {
            // 트럭 진출
            truckIndex++;
            
            // 배송할 물건 && 트럭이 두번째 진출부터 실행
            if (truckIndex != 1) {
                Loop2:
                for (int i = 0; i < matrixArrayList.size(); i++) {
                    // 해당위치
                    if (matrixArrayList.get(i).end == truckIndex) {
                        truckBoxes -= matrixArrayList.get(i).boxes;
                    }
                }
            }

            
            // 실을 물건
            Loop3:
            for (int i = 0; i < matrixArrayList.size(); i++) {
                
                // 해당위치
                if (matrixArrayList.get(i).start == truckIndex) {
                    
                    // 그 자체로 박스 실을 수 있으면
                    if ((truckBoxes + matrixArrayList.get(i).boxes) <= maxBoxesSize) {
                        truckBoxes += matrixArrayList.get(i).boxes; // 박스 싣기
                        totalBoxes += matrixArrayList.get(i).boxes; // 총합 박스 개수 구하는 변수에 추가
                        System.out.println();
                    }
                    // 그 자체로 박스 실을 수 없으면
                    else {
                        // 맥스보다 크거나 같으면 통과
                        if (truckBoxes >= maxBoxesSize) break Loop3;
                        // 맥스보다 작으면 그만큼 싣기
                        else {
                            System.out.println("maxBoxesSize = " + maxBoxesSize);
                            System.out.println("truckBoxes = " + truckBoxes);
                            System.out.println("matrixArrayList.get(i).boxes = " + matrixArrayList.get(i).boxes);
                            System.out.println("maxBoxesSize - truckBoxes : " + (maxBoxesSize - truckBoxes));
                            if ((matrixArrayList.get(i).boxes) > (maxBoxesSize - truckBoxes)) {
                                System.out.println("(maxBoxesSize - truckBoxes) : " + (maxBoxesSize - truckBoxes));
                                truckBoxes += (maxBoxesSize - truckBoxes); // 박스 싣기
                                totalBoxes += (maxBoxesSize - truckBoxes); // 총합 박스 개수 구하는 변수에 추가
                                System.out.println();
                                break Loop3;
                            } else {
                                System.out.println("2'");
                                truckBoxes += matrixArrayList.get(i).boxes;
                                totalBoxes += matrixArrayList.get(i).boxes; // 총합 박스 개수 구하는 변수에 추가
                            }
                        }
                    }
                    System.out.println();
                    System.out.println();
                }
            }

        }



        System.out.println();

    }

    static class matrix {
        int start;
        int end;
        int boxes;

        public matrix(int start, int end, int boxes) {
            this.start = start;
            this.end = end;
            this.boxes = boxes;
        }
    }
}
