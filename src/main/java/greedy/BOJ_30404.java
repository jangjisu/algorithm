package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_30404 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, K, i, x, last = 0, cnt = 0;

        String kn = br.readLine();
        N = Integer.parseInt(kn.split(" ")[0]);
        K = Integer.parseInt(kn.split(" ")[1]);

        String duckRing = br.readLine();
        String[] ringArrStr = duckRing.split(" ");

        for (i = 0; i < ringArrStr.length; i++) {
            x = Integer.parseInt(ringArrStr[i]);
            if (i == 0) last = x;

            if (last + K < x) {
                cnt++;
                last = x;
            }
        }

        System.out.println(cnt + 1);
    }
}
