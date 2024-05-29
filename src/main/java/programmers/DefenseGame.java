package programmers;

import java.util.PriorityQueue;

public class DefenseGame {
    public static void main(String[] args) {
        int[] enemy = {3,3,3,3};

        System.out.println(solution(2, 4, enemy));
    }

    public static int solution(int n, int k, int[] enemy) {
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
