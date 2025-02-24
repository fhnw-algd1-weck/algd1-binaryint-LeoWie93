package ch.fhnw.algd1.converters.binary;

public class BinConverter {
    public static String toString(int x) {
        if (x == 0) {
            return "00000000";
        }

        if (x < 0) {
            x = (1 << 8) - (~x + 1);
        }

        StringBuilder builder = new StringBuilder();

        while (x > 0) {
            if ((x & 1) == 0) {
                builder.append(0);
            } else {
                builder.append(1);
            }

            x = x / 2;
        }

        //in this solution, positive numbers need to be appended with zeroes to reach a 8bit representation
        if (builder.length() < 8) {
            char append = '0';

            int counter = 8 - builder.length();
            for (int i = 0; i < counter; i++) {
                builder.append(append);
            }
        }

        return builder.reverse().toString();
    }

    public static int fromString(String text) {
        int res = 0;
        StringBuilder builder = new StringBuilder(text);

        if ('1' == builder.charAt(0)) {
            res = ~(1 << 7) + 1;
        }

        builder.reverse();

        for (int i = 0; i < 7; i++) {
            char ch = builder.charAt(i);
            if (ch == '1') {
                res = res + (1 << i);
            }
        }

        return res;
    }
}