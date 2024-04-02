package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        //수 찾기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //HashMap<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        String[] n_arr = br.readLine().split(" ");

        for(String nstr : n_arr) {
            //map.put(nstr, 1);
            arr.add(Integer.parseInt(nstr));
        }

        Collections.sort(arr);

        int m = Integer.parseInt(br.readLine());

        String[] m_arr = br.readLine().split(" ");

        for(String mstr : m_arr) {
            //if(map.getOrDefault(mstr, 0) == 1){
            //    System.out.println(1);
            //}else{
            //    System.out.println(0);
            //}
            if(binarySearch(arr, Integer.parseInt(mstr))) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

    }

    public static boolean binarySearch(ArrayList<Integer> arr, int target){
        int start = 0;
        int end = arr.size()-1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr.get(mid) == target){
                return true;
            }else if(arr.get(mid) < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return false;
    }
}
