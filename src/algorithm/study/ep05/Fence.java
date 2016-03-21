package algorithm.study.ep05;

import java.util.Scanner;

/**
 * Created by sooyoung on 16. 3. 21.
 */
public class Fence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        for (int i = 0; i < testCase; i++) {
            int maxWidth = scan.nextInt();
            int[] array = new int[maxWidth];
            int maxHeight = 0;
            for (int j = 0; j < maxWidth; j++) {
                int height = scan.nextInt();
                if (height >= maxHeight) maxHeight = height;
                array[j] = height;
            }
            int maxArea = 1 * maxHeight;
            int area = 1;
            for (int checkHeight = 1; checkHeight <= maxHeight; checkHeight++) {
                int width = 0;
                for (int index = 0; index < array.length; index++) {
                    if (array[index] >= checkHeight) {
                        width++;
                    } else {
                        area = width * checkHeight;
                        if (area >= maxArea) maxArea = area;
                        width = 0;
                    }
                }
                area = width * checkHeight;
                if (area >= maxArea) maxArea = area;
            }
            System.out.println(maxArea);
        }
    }

}
