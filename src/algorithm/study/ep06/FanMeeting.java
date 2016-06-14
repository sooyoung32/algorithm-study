package algorithm.study.ep06;

import java.io.*;

/**
 * Created by sooyoung on 16. 4. 25.
 */
public class FanMeeting {

    private static String[] stars;
    private static String[] fans;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(reader.readLine());

        while (cases-- > 0) {
            String star = reader.readLine();
            stars = star.split("");
            String fan = reader.readLine();
            fans = fan.split("");
            result = compare(0);
            System.out.println(result);
            result=0;
         }

        writer.flush();
        writer.close();
        reader.close();
    }

    private static int compare(int start) {

        if (check(start)) {
            result++;
        }
        if (start == fans.length-stars.length) {
            return result;
        } else {
            start++;
            compare(start);
        }
        return result;
    }

    private static boolean check(int start) {
        for (int i = 0; i < stars.length; i++) {
            if ("M".equals(fans[start]) && "M".equals(stars[i])) {
                return false;
            }
            start++;
        }
        return true;
    }
}
