package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        String start = String.valueOf(S.charAt(0));

        String check = start;

        int count = 0;

        for(String mon : S.split("")) {
            if(mon.equals(check)){
                continue;
            }else{
                check = mon;
               if(start.equals(check)){
                   count++;
               }
            }
        }

        if(!start.equals(String.valueOf(S.charAt(S.length()-1)))){
            count ++;
        }

        System.out.println(count);
    }
}
