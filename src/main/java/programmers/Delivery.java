package programmers;

import java.util.Stack;

public class Delivery {
    static Stack<Integer> delivery = new Stack<>();
    static Stack<Integer> pickup = new Stack<>();
    static long answer = 0;

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {

        for (int i=0; i<n; i++) {
            delivery.push(deliveries[i]);
            pickup.push(pickups[i]);
        }

        while(!delivery.empty() || !pickup.empty()) {
            move(cap);
        }

        return answer;
    }

    private static void move(int cap) {
        while(!delivery.isEmpty() && delivery.peek() == 0) {
            delivery.pop();
        }

        while(!pickup.isEmpty() && pickup.peek() == 0) {
            pickup.pop();
        }

        answer += (long) 2 * Math.max(delivery.size(), pickup.size());

        //delivery
        int remain_delivery = cap;
        while(!delivery.isEmpty()) {
            int delivery_pop = delivery.pop();
            if(remain_delivery >= delivery_pop) {
                remain_delivery -= delivery_pop;
            }
            else {
                delivery.push(delivery_pop - remain_delivery);
                break;
            }
        }

        //pickup
        int remain_pickup = cap;
        while(!pickup.isEmpty()) {
            int pickup_pop = pickup.pop();
            if(remain_pickup >= pickup_pop) {
                remain_pickup -= pickup_pop;
            }
            else {
                pickup.push(pickup_pop - remain_pickup);
                break;
            }
        }

    }


    public static void main(String[] args) {
        //long solution = solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        //System.out.println(solution);
//
        long solution2 = solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0});
        System.out.println(solution2);


    }

    //4	5	[1, 0, 3, 1, 2]	[0, 3, 0, 4, 0]	16
    //2	7	[1, 0, 2, 0, 1, 0, 2]	[0, 2, 0, 1, 0, 2, 0]	30
}
