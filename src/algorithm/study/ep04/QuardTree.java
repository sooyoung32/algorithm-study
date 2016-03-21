package algorithm.study.ep04;

import java.io.IOException;

/**
 * Created by sooyoung on 16. 2. 15.
 */
public class QuardTree {

    public static void main(String[] args) throws IOException {
        String _case = "xbwxwbbwb";

        String result = _case;
        for (; hasX(solve(result)); result = solve(result)) {

        }
        result = result.replaceAll("c", "x");

        System.out.println(result);
        System.out.println(result.equals("xxbwwbbbw"));
    }

    private static boolean hasX(String solved) {
        return solved.contains("x");
    }

    private static String solve(String aCase) {
        //aCase x를 먼저 찾는다.
        //그리고 그 다음 4개까지
        String value = aCase.substring(aCase.indexOf("x") + 1, aCase.indexOf("x") + 5);

        String xPrevious = aCase.substring(0, aCase.indexOf("x") + 1);
        String xNextNext = aCase.substring(aCase.indexOf("x") + 5, aCase.length());

//        if (value.contains("x")) {
        if (value.contains("x")) {
            String xNext = aCase.substring(aCase.indexOf("x") + 1, aCase.length());
            return aCase.substring(0, aCase.indexOf("x") + 1) + solve(xNext);
        }

        return xPrevious.replace('x', 'c') + swap(value) + xNextNext;
    }

    private static String swap(String someString) {
        String[] string = someString.split("");
        return string[2] + string[3] + string[0] + string[1];
    }

}
