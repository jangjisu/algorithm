package programmers;

import java.util.PriorityQueue;

public class DefenseGame {
    public static void main(String[] args) {
        int[] enemy = {1,1,1,1,1,1,1};

        System.out.println(solution(7, 3, enemy));
    }

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;

        if(enemy.length <= k) {
            return enemy.length;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<enemy.length; i++) {

            pq.add(enemy[i]);

            if(i >= k) {
                int poll = pq.poll();

                if(n - poll < 0){
                    return i;
                }else{
                    n -= poll;
                }
            }
        }


        return enemy.length;
    }
}
