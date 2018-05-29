package com.faranegar.utils;


public class DateConverter {
    static int[] ShamsiMonth = {31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29};
    static int[] miladiMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int differenceDays = 226899;
    static int differenceKabisehDays = 155;

    public int KabisehChecker(int year) {
        if ((year % 4) == 0)
            return 1;
        else
            return 0;
    }

    public String GetDateShamsiText(String date) {
        int out[];
        String d[] = date.split("/");
        if (d.length < 3)
            return date + "pure";
        out = Miladi2shamsi(d[0], d[1], d[2]);
        return out[0] + "/" + out[1] + "/" + out[2];
    }

    public String NextDayMiladi(String today) {
        String s[] = today.split("/");

        int yy = Integer.parseInt(s[0]);
        int mm = Integer.parseInt(s[1]);
        int dd = Integer.parseInt(s[2]);

        if (KabisehChecker(yy) == 1) {
            ShamsiMonth[11] = 30;
        } else {
            ShamsiMonth[11] = 29;
        }

        dd++;

        if (dd > miladiMonth[mm - 1]) {
            dd = 1;
            mm++;
        }
        if (mm > 12) {
            mm = 1;
            yy++;
        }

        String y = yy + "";
        String m = mm > 9 ? "" + mm : "0" + mm;
        String d = dd > 9 ? "" + dd : "0" + dd;

        return y + "/" + m + "/" + d;
    }

    public String PrevDayMiladi(String today) {

        String s[] = today.split("/");

        int yy = Integer.parseInt(s[0]);
        int mm = Integer.parseInt(s[1]);
        int dd = Integer.parseInt(s[2]);

        if (KabisehChecker(yy) == 1) {
            ShamsiMonth[11] = 30;
        } else {
            ShamsiMonth[11] = 29;
        }

        dd--;

        if (dd <= 0) {
            mm--;
            dd = miladiMonth[mm - 1];
        }
        if (mm <= 0) {
            mm = 12;
            yy--;
        }

        String y = yy + "";
        String m = mm > 9 ? "" + mm : "0" + mm;
        String d = dd > 9 ? "" + dd : "0" + dd;

        return y + "/" + m + "/" + d;
    }

    public int[] shamsi2Miladi(String y, String m, String d) {
        int[] result = new int[3];
        long sum = 0;
        int year = Integer.parseInt(y);
        int month = Integer.parseInt(m);
        int day = Integer.parseInt(d);

        Roozh jCal = new Roozh(); // Make an instance
        jCal.PersianToGregorian(year, month, day); // Convert the date
        result[0] = jCal.getYear();
        result[1]=jCal.getMonth();
        result[2]=jCal.getDay();

        return result;
    }

    public int[] Miladi2shamsi(String y, String m, String d) {

        int[] result = new int[3];
        long sum = 0;
        int year = Integer.parseInt(y);
        int month = Integer.parseInt(m);
        int day = Integer.parseInt(d);

        Roozh jCal = new Roozh(); // Make an instance
        jCal.GregorianToPersian(year, month, day); // Convert the date
        result[0] = jCal.getYear();
        result[1]=jCal.getMonth();
        result[2]=jCal.getDay();

        return result;

    }
}