package math;

import java.util.Scanner;

public class BOJ_25375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        for(int i=0; i<count; i++){
            long a = sc.nextLong();
            long b = sc.nextLong();

            System.out.println(check(a,b));
        }
    }

    public static long check(long a, long b){
        int answer = 0;
        if(b % a == 0){
            if(b > a){
                answer = 1;
            }
        }
        return answer;
    }
}
