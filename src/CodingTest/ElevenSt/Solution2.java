package CodingTest.ElevenSt;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        //solution2.solution(new int[]{1, 1, 2, 3, 3}, 3);
        solution2.solution(new int[]{1, 1, 3}, 2);
    }

    public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("A[i]= " + A[i]);
            System.out.println("A[i+1] = " + A[i + 1]);
            if (A[i] > A[i + 1])
                return false;
        }
        System.out.println("A[0] = " + A[0]);
        System.out.println("A[n-1] = " + A[n - 1]);
        if (A[0] != 1 || A[n - 1] != K)
            return false;
        else
            return true;
    }

    public boolean mainSolution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("A[i] + 1 = " + A[i] + 1);
            System.out.println("A[i+1] = " + A[i + 1]);
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        System.out.println("A[0] = " + A[0]);
        System.out.println("A[n-1] = " + A[n - 1]);
        if (A[0] != 1 && A[n - 1] != K)
            return false;
        else
            return true;
    }
}
