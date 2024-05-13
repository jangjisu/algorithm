package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int last = n % 5;

        int num = n/5;

        boolean isAvilable = false;

        for(int i = last; i<=n; i+=5) {
            if(i % 3 == 0){
                System.out.println(num + i/3);
                isAvilable = !isAvilable;
                break;
            }else{
                num --;
            }
        }

        if(!isAvilable){
            System.out.println(-1);
        }
    }
}
