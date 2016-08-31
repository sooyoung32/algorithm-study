package algorithm.study.ep08;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sooyo on 2016-08-31.
 */
public class OddOccurrInArray {
    public static void main(String[] args) {
        int[] A = new int[7];
        A[0] = 9;
        A[1] = 3;
        A[2] = 9;
        A[3] = 3;
        A[4] = 7;
        A[5] = 9;
        A[6] = 9;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }

        }
        int result = 0;
        for (int key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                result = key;
            }
        }

        System.out.println(result);

    }
}
