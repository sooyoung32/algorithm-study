package algorithm.study.ep05;

import java.io.*;

/**
 * Created by sooyoung on 16. 4. 11.
 */
public class Fence {
    private static int numOfBoard;
    private static int[] boardHeight;

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            int cases = Integer.parseInt(reader.readLine());

            while (cases-- > 0) {
                numOfBoard = Integer.parseInt(reader.readLine());
                boardHeight = new int[numOfBoard];
                String[] input = reader.readLine().split(" ");
                for (int i = 0; i < numOfBoard; i++) boardHeight[i] = Integer.parseInt(input[i]);
                writer.append(String.valueOf(cropFence(0, numOfBoard - 1)));
                writer.newLine();
            }
            writer.flush();
            writer.close(); reader.close();
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static int cropFence(int left, int right) {
        int ret = 0;
        // 판자가 하나밖에 없는 경우
        if (left == right) {
            return boardHeight[left];
        }
        // [left, mid] [mid+1, right] 의 두 구간으로 문제를 분할한다.
        int middle = (left + right) / 2;

        //분할한 문제 격파
        int leftCropFence = cropFence(left, middle);
        int rightCropFence = cropFence(middle + 1, right);
        ret = Math.max(leftCropFence, rightCropFence);

        // 부분문제 : 두 부분에 모두 걸치는 사각형 중 가장 큰 것을 찾는다.
        int leftCursor = middle;
        int rightCursor = middle + 1;
        int height = Math.min(boardHeight[leftCursor], boardHeight[rightCursor]);

        // [mid, mid+1] 만 포함하는 너비 2인 사각형을 고려한다.
        ret = Math.max(2 * height, ret);

        //사각형 입력 전체를 덮을때까지 확장해나간다.
        while (leftCursor > left || rightCursor < right) {
            // 항상 높이가 더 높은쪽으로 확장한다.
            if (rightCursor < right && (leftCursor == left || boardHeight[leftCursor-1] < boardHeight[rightCursor + 1])) {
                rightCursor++;
                height = Math.min(height, boardHeight[rightCursor]);
            }
            else {
                leftCursor--;
                height = Math.min(height, boardHeight[leftCursor]);
            }
            // 확장한 후 사각형의 넓이
            ret = Math.max(ret, (rightCursor - leftCursor + 1) * height);
        }

        return ret;
    }

}
