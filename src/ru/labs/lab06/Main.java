package ru.labs.lab06;

public class Main {
    public static void main(String[] args) {
        Object[] vals = FormattedInput.scanf("%d %s %c");
        int i = (int) vals[0];
        String s = (String) vals[1];
        char c = (char) vals[2];
        System.out.println("i = " + i + ", s = " + s + ", c = " + c);

        // test from String
        String str = "123 456 789";
        Object[]  valsStr = FormattedInput.sscanf("%d %d %d", str);
        int x = (int) valsStr[0];
        int y = (int) valsStr[1];
        int z = (int) valsStr[2];
        System.out.println("x = " + x + ", y = " + y + ", z = " + z);
    }
}
