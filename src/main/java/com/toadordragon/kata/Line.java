package com.toadordragon.kata;

public class Line {
    public static final String CHANGE_YES = "YES";
    public static final String CHANGE_NO = "NO";

    public static String Tickets(int[] peopleInLine) {
        int[] bills = new int[101];
        boolean changeAvailable = true;

        for (int i = 0; i < peopleInLine.length; i++) {
            bills[peopleInLine[i]]++;
            changeAvailable = changeAvailable && IsChangeAvailable(bills, peopleInLine[i] - 25);
        }

        if (changeAvailable) {
            return CHANGE_YES;
        } else {
            return CHANGE_NO;
        }
    }

    private static boolean IsChangeAvailable(int[] bills, int changeRequired) {
        if (changeRequired == 0) {
            return true;
        }

        if (bills[changeRequired] > 0) {
            bills[changeRequired]--;
            return true;
        }

        if (changeRequired == 75) {
            if ((bills[25] >= 1) && (bills[50] >= 1)) {
                bills[25] = bills[25] - 1;
                bills[50] = bills[50] - 1;
                return true;
            }

            if (bills[25] >= 3) {
                bills[25] = bills[25] - 3;
                return true;
            }
        }

        return false;
    }
}
