package algorithm.study.ep06;


import java.util.Arrays;

public class Karatsuba {

    public static void main(String[] args) {

    }


    private static int hugs(String[] members, String[] fans) {
        int N = members.length;
        int M = fans.length;

        int[] memberArray = new int[N];
        int[] fanArray = new int[M];
        for (int i = 0; i < N; i++) {
            if (members[i] == "M") {
                memberArray[i] = 1;
            } else {
                memberArray[i] = 0;
            }
        }
        for (int i = 0; i < M; i++) {
            if (fans[i] == "M") {
                fanArray[i] = 1;
            } else {
                fanArray[i] = 0;
            }
        }

//        int[] C = karatsuba(N)
        return 0;
    }


    private static int karatsuba(int i, int j) {
        if (i<10 || j<10){
            return i*j;
        }

        double n=Math.round(getCount(i));

        int a=(int) (i/Math.pow(10, Math.round(n/2)));
        int b=(int) (i%Math.pow(10, Math.round(n/2)));
        int c=(int) (j/Math.pow(10, Math.round(n/2)));
        int d=(int) (j%Math.pow(10, Math.round(n/2)));

        int first=karatsuba(a,c);
        int second=karatsuba(b,d);

        int third=karatsuba(a+b,c+d);

        return ((int) ((first*Math.pow(10, Math.round(n)))+((third-second-first)*Math.pow(10, Math.round(n/2)))+second));

    }

    private static double getCount(int i) {
        String totalN=Long.toString(i);

        return totalN.length();
    }

}



