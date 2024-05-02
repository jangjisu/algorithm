package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12865 {
    //https://www.acmicpc.net/workbook/view/4349
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");

        int n = Integer.parseInt(nk[0]); //bag number
        int k = Integer.parseInt(nk[1]); //can weight

        int[] W = new int[n+1];
        int[] V = new int[k+1];

        int[][] dp = new int[n+1][k+1];

        for (int i = 1; i <= n; i++) {
            String[] WV = br.readLine().split(" ");
            W[i] = Integer.parseInt(WV[0]);
            V[i] = Integer.parseInt(WV[1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(W[i] > j) {
                    dp[i][j] = dp[i -1][j];
                    //System.out.println("if dp" + i + j + " = " + dp[i][j]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                    //System.out.println("else dp" + i + j + " = " + dp[i][j]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
