package programmers;

public class BilliardPractice {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {

        int[] ans = new int[balls.length];

        for (int i=0; i< balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int an1 = 99999999;
            int an2 = 99999999;
            int an3 = 99999999;
            int an4 = 99999999;

            if (!(startY == targetY && startX >= targetX)) {
                an1 = (int) (Math.pow(startX + targetX, 2) + Math.pow(startY - targetY, 2));
            }

            if (!(startY == targetY && startX <= targetX)) {
                an2 = (int) (Math.pow(startX + targetX - 2 * m, 2) + Math.pow(startY - targetY, 2));
            }

            if (!(startX == targetX && startY <= targetY)) {
                an3 = (int) (Math.pow((startX - targetX), 2) + Math.pow(startY + targetY - 2 * n,2));
            }

            if (!(startX == targetX && startY >= targetY)) {
                an4 = (int) (Math.pow(startX - targetX, 2) + Math.pow(startY + targetY,2));
            }

            ans[i] = Math.min(Math.min(an1, an2), Math.min(an3, an4));
        }

        return ans;
    }
}
