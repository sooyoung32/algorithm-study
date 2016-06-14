package algorithm.study.ep07;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by sooyoung on 16. 5. 16.
 */
public class JumpGame {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            int cases = Integer.parseInt(reader.readLine());
            while (cases-- > 0) {
                int arraySize = Integer.parseInt(reader.readLine());
                int[][] grid = new int[arraySize][arraySize];

                // grid 만들기
                for (int row = 0; row < arraySize; row++) {
                    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                    for (int col = 0; col < arraySize; col++) {
                        grid[row][col] = Integer.parseInt(tokenizer.nextToken());
                    }
                }
                if (jump(0, 0, grid[0][0], grid)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }


            }
            writer.flush();
            writer.close();
            reader.close();
        } catch (NumberFormatException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param row   밑으로 몇칸
     * @param col   오른쪽으로 몇칸
     * @param value 점프할 값
     * @param grid  위치 정보
     * @return
     */
    private static boolean jump(int row, int col, int value, int[][] grid) {
        if (row == grid.length - 1 && col == grid.length - 1 && grid[row][col] == 0) return true;

        if (!(col + value > grid.length - 1)) {
            if (jump(row, col + value, grid[row][col + value], grid)) {
                return true;
            }
        }
        if (!(row + value > grid.length - 1)) {
            if (jump(row + value, col, grid[row + value][col], grid)) {
                return true;
            }
        }
        return false;
    }
}
