package algorithm.study.ep08;

/**
 * Created by sooyo on 2016-08-31.
 */
public class CicleArray {
    public static void main(String[] args) {
        int[] A = new int[5];
        A[0] = 3;
        A[1] = 8;
        A[2] = 9;
        A[3] = 7;
        A[4] = 6;

        int K = 1;
        for (int cnt = 0; cnt < K; cnt++) {
            for (int index = A.length-1; index > 0 ; index--) {
                int temp = A[index];
                A[index] = A[index-1];
                A[index-1] = temp;
            }
        }

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ", ");
        }



    }

}
