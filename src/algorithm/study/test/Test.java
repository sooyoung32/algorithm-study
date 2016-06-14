package algorithm.study.test;

/**
 * Created by sooyoung on 16. 2. 15.
 */
public class Test {
    public static void main(String[] args) {
        int result = fastSum(8);
        System.out.println(result);
    }

    private static int fastSum(int number) {
        if (number == 1)
            return 1;
        if (number % 2 == 1)
            return fastSum(number-1) + number;
        return 2 * fastSum(number/2) + (number/2)*(number/2);

    }


}
