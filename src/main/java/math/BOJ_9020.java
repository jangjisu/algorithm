package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num_str = br.readLine();

        int num = Integer.parseInt(num_str);

        for (int i=0; i<num; i++){
            String n = br.readLine();
            int number = Integer.parseInt(n);

            int a = number/2;
            int b = number/2;

            while(true){
                if(isPrime(a) && isPrime(b)){
                    System.out.println(a + " " + b);
                    break;
                }else{
                    a--;
                    b++;
                }
            }
        }
    }

    private static boolean isPrime(int a) {
        if(a == 1){
            return false;
        }else{
            for (int i=2; i<=Math.sqrt(a); i++){
                if(a%i == 0){
                    return false;
                }
            }
        }

        return true;
    }
}
