package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_10828 {

    public static ArrayList<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String text = br.readLine();
            switch (text) {
                case "top" : top();
                    break;
                case "size" : size();
                    break;
                case "empty" : empty();
                    break;
                case "pop" : pop();
                    break;
                default:
                    String[] splitText = text.split(" ");
                    push(Integer.parseInt(splitText[1]));
            }


        }


    }

    public static void push(int num) {
        stack.add(num);
    }


    public static void pop() {
        if(stack.size() == 0) {
            System.out.println(-1);
        }else{
            System.out.println(stack.get(stack.size()-1));
            stack.remove(stack.size()-1);
        }
    }

    public static void size() {
        System.out.println(stack.size());
    }

    public static void empty() {
        System.out.println(stack.isEmpty() ? 1 : 0);
    }

    public static void top() {
        if(stack.size() == 0) {
            System.out.println(-1);
        }else{
            System.out.println(stack.get(stack.size()-1));
        }
    }
}
