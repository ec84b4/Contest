package ir.hister.contest.quera.eydi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by khbak on 3/12/2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        int rowCount = Integer.parseInt(firstLine[0]);
        int columnCount = Integer.parseInt(firstLine[1]);

        char[][] table = new char[rowCount][columnCount];
        for (int row = 0; row < rowCount; row++) {
            String line = reader.readLine();
            char[] charArray = line.toCharArray();
            System.arraycopy(charArray, 0, table[row], 0, charArray.length);
        }

        EydiFinder finder = new EydiFinder(table);
        try {
            System.out.println(finder.countEydis());
        } catch (EydiException e) {
            System.out.println(e.getMessage());
        }
    }
}