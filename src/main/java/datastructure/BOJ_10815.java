package datastructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ_10815 {
    //https://www.acmicpc.net/problem/10815
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> havingCards = new HashMap<>();

        br.readLine();

        String[] havingCardsArr = br.readLine().split(" ");

        for (String card : havingCardsArr) {
            havingCards.put(Integer.parseInt(card), 1);
        }

        br.readLine();

        String[] checkCardsArr = br.readLine().split(" ");

        for (String checkStr : checkCardsArr) {
            int checkNum = Integer.parseInt(checkStr);

            sb.append(havingCards.getOrDefault(checkNum, 0)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}