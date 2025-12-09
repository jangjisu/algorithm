package dynamic;

import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String inputNum = br.readLine();

        String[] inputNumArr = inputNum.split("");
        int baseNumber = Integer.parseInt(inputNumArr[0]);
        int sqrtCount = Integer.parseInt(inputNumArr[1]);
        int divide = Integer.parseInt(inputNumArr[2]);

        System.out.println(getSqrt(baseNumber, sqrtCount, divide));
    }

    private static long getSqrt(int baseNumber, int sqrtCount, int divide) {
        long result = 1;
        long base = baseNumber;

        while (sqrtCount > 0) {
            if ((sqrtCount & 1) == 1) {
                result = result * base % divide;
            }
            base = base * base % divide;
            sqrtCount >>= 1;
        }

        return result;
    }
}