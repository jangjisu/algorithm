package order;

import java.io.*;

public class BOJ_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        boolean[] ints = new boolean[2000001];

        for (int i = 0; i < num; i++) {
            int checkNum = Integer.parseInt(br.readLine()) + 1000000;
            ints[checkNum] = true;
        }

        for (int i = 0; i <ints.length; i++) {
            if (ints[i]) {
                bw.write((i - 1000000) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
