package algorithm.study.ep03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sooyoung on 16. 2. 1.
 * 시계 맞추기
 */
public class ClockSync {

    /**
     * 스위치 정보
     * 스위치-시계위치
     */
    static int switchClock[][] = new int[][]{
            {0, 1, 2},
            {3, 7, 9, 11},
            {4, 10, 14, 15},
            {0, 4, 5, 6, 7},
            {6, 7, 8, 10, 12},
            {0, 2, 14, 15},
            {3, 14, 15},
            {4, 5, 7, 14, 15},
            {1, 2, 3, 4, 5},
            {3, 4, 5, 9, 13}
    };

    /**
     * 시계들
     */
    static int clocks[] = new int[16];

    /**
     * @param args 인자
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(reader.readLine().trim());
        while (testCase-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            //create clock
            for (int index = 0; index < 16; index++)
                clocks[index] = Integer.parseInt(tokenizer.nextToken());

            int result = solve(0);

            if (result < NOSOLVE)
                System.out.println(result);
            else
                System.out.println(-1);
        }
    }

    /**
     * 검증 : 완료 되었는가?
     *
     * @return 검증결과
     */
    public static boolean isOK() {
        boolean result = true;
        for (int clock : clocks)
            result &= (clock == 12);
        return result;
    }

    // 버튼 누르기
    public static void push(int switchNumber) {
        for (int index : switchClock[switchNumber]) {
            clocks[index] += 3;//시간을 더해줌.
            if (clocks[index] >= 15)//convert
                clocks[index] = 3;
        }
    }

    static int NOSOLVE = 100000;

    public static int solve(int switchNumber) {
        int result = NOSOLVE;
        if (switchNumber == 10) {
            return isOK() ? 0 : NOSOLVE;
        }

        for (int index = 0; index < 4; index++) {
            result = Math.min(result, index + solve(switchNumber + 1));
            push(switchNumber);
        }

        return result;
    }

}
