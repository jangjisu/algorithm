package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_10616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int card_count = Integer.parseInt(br.readLine());

        String card_arr_str = br.readLine();

        int card_kind_count = Integer.parseInt(br.readLine());

        String card_kind_arr_str = br.readLine();

        HashMap<String, Integer> card_map = new HashMap<>();

        String[] card_arr = card_arr_str.split(" ");

        for (String kind : card_arr) {
            card_map.put(kind, card_map.getOrDefault(kind, 0) +1 );
        }

        String[] card_kind_arr = card_kind_arr_str.split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<card_kind_arr.length; i++){
            if(i==card_kind_arr.length-1){
                sb.append(card_map.getOrDefault(card_kind_arr[i], 0));
            }else{
                sb.append(card_map.getOrDefault(card_kind_arr[i], 0)).append(" ");
            }
        }

        System.out.println(sb);
    }
}
