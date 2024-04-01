package datastructure;

import java.io.*;
import java.util.Stack;

public class BOJ_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String a = br.readLine();
        int n = Integer.parseInt(a);


        for (int i=0; i<n; i++){
            String st = br.readLine();
            bw.write(check(st));
        }

        bw.flush();
        bw.close();
    }

    public static String check(String message) {
        String[] arr = message.split("");

        Stack<String> stack = new Stack<>();

        for (String letter : arr) {
            if(letter.equals("(")){
                stack.push(letter);
            }else if(letter.equals(")")){
                if(stack.isEmpty()){
                    return "NO\n";
                }else{
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()){
            return "YES\n";
        }else {
            return "NO\n";
        }
    }
}
