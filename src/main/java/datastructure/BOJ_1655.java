package datastructure;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Long> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Long> minQueue = new PriorityQueue<>();

        for(int i=0; i<count; i++) {
            long newNum = Long.parseLong(br.readLine());

            if(maxQueue.size() == minQueue.size()){
                maxQueue.offer(newNum);
            }else{
                minQueue.offer(newNum);
            }

            long maxQueuePeek = maxQueue.isEmpty() ? 0L : maxQueue.peek();
            long minQueuePeek = minQueue.isEmpty() ? 0L : minQueue.peek();

            if(maxQueuePeek > minQueuePeek){
                minQueue.offer(maxQueue.poll());
                maxQueue.offer(minQueue.poll());
            }
            bw.write(maxQueue.peek() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
