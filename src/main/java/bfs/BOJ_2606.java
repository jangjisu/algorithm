package bfs;

import java.io.*;
import java.util.*;


public class BOJ_2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        int point_num = Integer.parseInt(a);
        //int point_num = 6;

        String b = br.readLine();
        int node_num = Integer.parseInt(b);
        //int node_num = graph.length;

        ArrayList<int[]> node = new ArrayList<>();

        for (int i=0; i<node_num; i++){
            String st = br.readLine();
            //String st = graph[i];
            int[] arr = new int[2];
            String[] str = st.split(" ");
            arr[0] = Integer.parseInt(str[0]);
            arr[1] = Integer.parseInt(str[1]);
            //System.out.println(arr[0] + " " + arr[1]);
            node.add(arr);
        }

        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[point_num+1];

        bfs(1, node, visited, result);

        //System.out.println("result = " + result);

        System.out.println(result.size()-1);


    }

    public static void bfs(int start, ArrayList<int[]> node, boolean[] visited, ArrayList<Integer> result){
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(start);

        visited[start] = true;

        while(!q.isEmpty()) {
            int nodeIndex = q.poll();

            result.add(nodeIndex);
            //System.out.println("add : " + nodeIndex);

            for(int[] arr : node){
                if(arr[0] == nodeIndex && !visited[arr[1]]) {
                    q.offer(arr[1]);
                    visited[arr[1]] = true;
                }else if(arr[1] == nodeIndex && !visited[arr[0]]){
                    q.offer(arr[0]);
                    visited[arr[0]] = true;
                }
            }
        }
    }
}
