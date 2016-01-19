package algorithm.study.ep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sooyoung on 16. 1. 18.
 */
public class Picnic {
    static boolean isFriend[][];
    static int totalNum;

    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            totalNum = Integer.parseInt(st.nextToken());   // 총 인원수
            int pairNum = Integer.parseInt(st.nextToken());   // 쌍 개수

            isFriend = new boolean[totalNum][totalNum];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < pairNum; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                isFriend[a][b] = true;
                isFriend[b][a] = true;
            }

            System.out.println(countParings(new boolean[totalNum]));
        }
    }

    static int countParings(boolean taken[]) {
        // 비어있는 사람 찾기
        int firstFree = -1;
        for (int i = 0; i < totalNum; i++) {
            if (!taken[i]) {
                firstFree = i;
                break;
            }
        }

        // 기저사례 : 모두 짝지었다면 끝
        if (firstFree == -1)
            return 1;

        int ret = 0;
        for (int pair = firstFree + 1; pair < totalNum; pair++) {
            if (!taken[pair] && isFriend[firstFree][pair]) {
                taken[firstFree] = true;
                taken[pair] = true;

                ret += countParings(taken);

                taken[firstFree] = false;
                taken[pair] = false;
            }
        }

        return ret;
    }

}
