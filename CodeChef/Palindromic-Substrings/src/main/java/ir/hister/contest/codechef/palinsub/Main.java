package ir.hister.contest.codechef.palinsub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by <a href="http://about.me/kh.bakhtiari">Khaled Bakhtiari</a> on 3/15/2016.
 *
 * @author Khaled Bakhtiari
 */
public class Main {
    private char[] a;
    private char[] b;

    public Main(String a, String b) {
        this.a = a.toCharArray();
        this.b = b.toCharArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lineCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lineCount; i++) {
            String a = reader.readLine();
            String b = reader.readLine();
            Main palindromic = new Main(a, b);
            if (palindromic.isPalindromic()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public boolean isPalindromic() {
        return haveCommonChars();
    }

    public boolean haveCommonChars() {
        return getFirstCommonChar() != null;
    }

    public Character getFirstCommonChar() {
        for (char c1 : a) {
            for (char c2 : b) {
                if (c1 == c2)
                    return c1;
            }
        }
        return null;
    }
}