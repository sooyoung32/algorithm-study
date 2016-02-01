package algorithm.study.ep02;

import java.util.Scanner;

/**
 * Created by sooyoung on 16. 1. 25.
 */
public class BoardCover {
    public static int height;
    public static int width;
    public static int count;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        for (int test = 0; test < testCase; test++) {
            count = 0;
            height = scan.nextInt();
            width = scan.nextInt();
            String[][] array = new String[height][width];
            // 배열을 그린다.
            for (int i = 0; i < height; i++) {
                String dd = scan.next();
                for (int j = 0; j < width; j++) {
                    array[i][j] = String.valueOf(dd.charAt(j));
                    System.out.print(array[i][j]);
                }
                System.out.println("");
            }
            Point point = new Point(0, 0);
            callRecursive(array, point);
            System.out.print(count);
        }
    }

    private static boolean callRecursive(String[][] array, Point point) {
        if (isCaseA(array, point)) {
            callRecursive(fill(array, "A", point), getNextPoint(array, point));
        }
        if (isCaseB(array, point)) {
            callRecursive(fill(array, "B", point), getNextPoint(array, point));
        }
        if (isCaseC(array, point)) {
            callRecursive(fill(array, "C", point), getNextPoint(array, point));
        }
        if (isCaseD(array, point)) {
            callRecursive(fill(array, "D", point), getNextPoint(array, point));
        }
        //한포인트 옆으로 간다.
        //만약 마지막 포인트면 카운트 하고 끝낸다.
        if (point.getX() == width - 1 && point.getY() == height - 1) {
            if (isFilled(array)) {
                count++;
            }
        } else {
            callRecursive(array, getNextPoint(array, point));
        }

        return false;

    }

    private static String[][] fill(String[][] array, String _case, Point point) {
        if (!"C".equals(_case)) array[point.getX()][point.getY()] = "#";
        if (!"A".equals(_case)) array[point.getX() + 1][point.getY()] = "#";
        if (!"B".equals(_case)) array[point.getX()][point.getY() + 1] = "#";
        if (!"D".equals(_case)) array[point.getX() + 1][point.getY() + 1] = "#";

        return array;
    }

    private static Point getNextPoint(String[][] array, Point point) {
        if (point.getX() == width - 2) {
            point.setY(point.getY() + 1);
        } else {
            point.setX(point.getX() + 1);
        }
        return point;
    }

    private static boolean isCaseD(String[][] array, Point point) {
        if ("#".equals(array[point.getX()][point.getY()])) return false;
        if ("#".equals(array[point.getX() + 1][point.getY()])) return false;
        if ("#".equals(array[point.getX()][point.getY() + 1])) return false;
        return true;
    }

    private static boolean isCaseC(String[][] array, Point point) {
        if ("#".equals(array[point.getX() + 1][point.getY()])) return false;
        if ("#".equals(array[point.getX() + 1][point.getY() + 1])) return false;
        if ("#".equals(array[point.getX()][point.getY() + 1])) return false;
        return true;
    }

    private static boolean isCaseB(String[][] array, Point point) {
        if ("#".equals(array[point.getX()][point.getY()])) return false;
        if ("#".equals(array[point.getX() + 1][point.getY() + 1])) return false;
        if ("#".equals(array[point.getX() + 1][point.getY()])) return false;
        return true;
    }

    private static boolean isCaseA(String[][] array, Point point) {
        if ("#".equals(array[point.getX()][point.getY()])) return false;
        if ("#".equals(array[point.getX() + 1][point.getY() + 1])) return false;
        if ("#".equals(array[point.getX()][point.getY() + 1])) return false;
        return true;
    }


    public static boolean isFilled(String[][] array) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!"#".equals(array[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }


    public static String[][] typeA(int i) {
        String[][] typeA = new String[2][2];
        typeA[i][i] = ".";
        typeA[i][i + 1] = typeA[i][i + 1];
        typeA[i + 1][i] = ".";
        typeA[i + 1][i + 1] = ".";
        return typeA;
    }

    public static String[][] typeB(int i) {
        String[][] typeB = new String[2][2];
        typeB[i][i] = ".";
        typeB[i][i + 1] = ".";
        typeB[i + 1][i] = typeB[i + 1][i];
        typeB[i + 1][i + 1] = ".";
        return typeB;
    }

    public static String[][] typeC(int i) {
        String[][] typeC = new String[2][2];
        typeC[i][i] = ".";
        typeC[i][i + 1] = ".";
        typeC[i + 1][i] = ".";
        typeC[i + 1][i + 1] = typeC[i + 1][i + 1];
        return typeC;
    }

    public static String[][] typeD(int i) {
        String[][] typeD = new String[2][2];
        typeD[i][i] = typeD[i][i];
        typeD[i][i + 1] = ".";
        typeD[i + 1][i] = ".";
        typeD[i + 1][i + 1] = ".";
        return typeD;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
