package programmers;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Long> scovileQueue = new PriorityQueue<>();

        for (int i : scoville) {
            scovileQueue.offer((long) i);
        }

        while (scovileQueue.peek() < K) {
            if(scovileQueue.size() == 1) {
                return -1;
            }

            answer ++;
            long lowScovile = scovileQueue.poll();
            long low2Scovile = scovileQueue.poll();

            scovileQueue.offer(lowScovile + 2*low2Scovile);

        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{0, 1, 2}, 7);
    }
}
