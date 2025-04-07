package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PackageExtraction {
    public static void main(String[] args) {
        int solution = solution(22, 6, 8);
        int solution2 = solution(13, 3, 6);
        System.out.println(solution);
        System.out.println(solution2);
    }

    public static int solution(int n, int w, int num) {
        List<Stack<Integer>> stacks = new ArrayList<>();

        for (int i = 0; i < w; i++) {
            stacks.add(new Stack());
        }

        int check = 0;
        int includedStackNum = 0;

        for (int i = 1; i <= n; i++) {
            stacks.get(check).push(i);
            if (i == num) {
                includedStackNum = check;
            }

            if (i / w % 2 == 0 && i % w != 0) {
                check += 1;
            }

            if (i / w % 2 == 1 && i % w != 0) {
                check -= 1;
            }
        }

        Stack<Integer> stack = stacks.get(includedStackNum);

        int stackSize = stack.size();
        for (int i = 0; i <= stackSize; i++) {
            Integer pop = stack.pop();
            if (pop == num) {
                return i+1;
            }
        }

        return 0;
    }
}
