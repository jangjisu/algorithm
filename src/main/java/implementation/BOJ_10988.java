package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988 {
    //https://www.acmicpc.net/problem/10988
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputText = br.readLine();

        System.out.println(checkPalindrome(inputText));
    }

    public static int checkPalindrome(String text) {
        int textLength = text.length();

        if (textLength > 100) {
            return 0;
        }

        for (int i = 0; i < textLength / 2; i++) {
            char character = text.charAt(i);

            if (isNotLowerCaseEnglishAlphabet(character)) {
                return 0;
            }

            if (character != text.charAt(textLength - i - 1)) {
                return 0;
            }
        }

        return 1;
    }

    public static boolean isLowerCaseEnglishAlphabet(char c) {
        return (c >= 'a' && c <= 'z');
    }

    public static boolean isNotLowerCaseEnglishAlphabet(char c) {
        return !isLowerCaseEnglishAlphabet(c);
    }
}