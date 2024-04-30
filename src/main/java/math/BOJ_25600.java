package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_25600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> scoreList = new ArrayList<>();

        for (int i=0; i<n; i++) {
            String[] arr = br.readLine().split(" ");

            int a = Integer.parseInt(arr[0]);
            int d = Integer.parseInt(arr[1]);
            int g = Integer.parseInt(arr[2]);

            int score = a * (d+g);

            if(a == (d+g)){
                score *= 2;
            }

            scoreList.add(score);
        }

        System.out.println(scoreList.stream().mapToInt(x -> x).max().getAsInt());
    }
}
