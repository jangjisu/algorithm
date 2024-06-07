package programmers;

public class MagicElevator {

    public static void main(String[] args) {
        System.out.println("dap = " + solution(485));
    }

    public static int answer = 0;
    public static int solution(int storey) {
        while(storey != 0) {
            int check = storey%10;

            if(check == 5) {
                if(storey% 100 /10 >= 5) {
                    storey = goUp(check, storey);
                }else {
                    goDown(check, storey);
                }
            }

            if (check > 5) {
                storey = goUp(check, storey);
            }
            if (check < 5) {
                goDown(check, storey);
            }

            storey /= 10;
        }

        return answer;
    }

    public static int goUp(int check, int storey) {
        answer += 10 - check;

        return storey + 10;
    }

    public static void goDown(int check, int storey) {
        answer += check;
    }
}
