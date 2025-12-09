package dynamic;

import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_11401 {
    private static final long PRIME = 1_000_000_007;

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String inputNum = br.readLine();

        String[] inputNumArr = inputNum.split("");
        long n = Long.parseLong(inputNumArr[0]);
        long k = Long.parseLong(inputNumArr[1]);

        System.out.println(solution(n, k));

    }

    public static long solution(long n, long k) {
        long nFactorialMod = 1;
        long kFactorialMod = 1;
        long nMinusKFactorialMod = 1;

        long nMinusK = n - k;

        for (long i = 1; i <= n; i++) {
            nFactorialMod *= i;

            nFactorialMod = nFactorialMod % PRIME;

            if (i == k) {
                kFactorialMod = nFactorialMod;
            }

            if (i == nMinusK) {
                nMinusKFactorialMod = nFactorialMod;
            }
        }

        long inverseNum1 = getInverse(kFactorialMod);
        long inverseNum2 = getInverse(nMinusKFactorialMod);

        return nFactorialMod * inverseNum1 * inverseNum2 % PRIME;
    }

    private static long getInverse(long num) {
        long result = 1;
        long base = num;
        long exp = PRIME - 2;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % PRIME;
            }
            base = (base * base) % PRIME;
            exp >>= 1;
        }
        return result;
    }

}