package com.faranegar.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.faranegar.faranegarutils.BuildConfig;
import com.faranegar.faranegarutils.R;
import com.faranegar.utils.customviews.CustomTypefaceSpan;
import com.faranegar.utils.customviews.TypefaceSpan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 *
 * Created by shahab on 5/29/2018...
 *
 */

public class FaranegarUtils {

    private static FaranegarUtils ourInstance = null;
    private static Typeface iranSansFont = null;
    private static Typeface normalFont = null;
    private static Typeface boldFont = null;
    private static Typeface lightFont = null;
    private static Typeface awesomeFont = null;
    private static Typeface englishFont = null;

    private FaranegarUtils(){

    }

    public static FaranegarUtils getInstance() {
        if (ourInstance == null) {
            ourInstance = new FaranegarUtils();
        }
        return ourInstance;
    }

    private FaranegarUtils(){

    }


    public static SpannableString getSpannable(Context context,
                                               String mi,
                                               int size) {
        SpannableString mNewTitle = new SpannableString(mi);

        mNewTitle.setSpan(new TypefaceSpan (context, "fonts/font.ttf", size), 0,
                mNewTitle.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return mNewTitle;
    }

    public static CustomTypefaceSpan getEnglishTypefaceSpan(Context context) {
        return new CustomTypefaceSpan
                ("", Typeface.createFromAsset(context.getAssets(),
                        "fonts/english.ttf"));
    }


    public static SpannableString getSpannableBold(Context context, String mi, int size) {
        SpannableString mNewTitle = new SpannableString(mi);
        mNewTitle.setSpan(new TypefaceSpan(context, "font_bold.ttf", size), 0,
                mNewTitle.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return mNewTitle;
    }

    public static Typeface getBoldFont(Context context) {
        if (boldFont == null)
            boldFont = Typeface.createFromAsset(context.getAssets(),
                    "fonts/font_bold.ttf");
        return boldFont;
    }

    public static Typeface getFontAwesome(Context context) {
        if (awesomeFont == null)
            awesomeFont = Typeface.createFromAsset(context.getAssets(), "fonts/font_awesome.ttf");
        return awesomeFont;
    }

    public static Typeface getFontIranSans(Context context) {
        if (iranSansFont == null)
            iranSansFont = Typeface.createFromAsset(context.getAssets(), "fonts/IRANSans(FaNum)_Medium.ttf");
        return iranSansFont;
    }

    public static boolean checkEmailValidation(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static Typeface getFontLight(Context context) {
        if (lightFont == null)
            lightFont = Typeface.createFromAsset(context.getAssets(), "fonts/font_light.ttf");
        return lightFont;
    }

    public static Typeface getFont(Context context) {
        if (normalFont == null)
            normalFont = Typeface.createFromAsset(context.getAssets(), "fonts/font.ttf");
        return normalFont;
    }

    private static Typeface typeLightFont = null;

    public static Typeface getLightFont(Context context) {
        if (typeLightFont == null)
            typeLightFont = Typeface.createFromAsset(context.getAssets(), "fonts/font_light.ttf");
        return typeLightFont;
    }

    public static Typeface getFontEnglish(Context context) {
        if (englishFont == null)
            englishFont = Typeface.createFromAsset(context.getAssets(), "fonts/font_en.ttf");
        return englishFont;
    }

    public static Date convertShamsiDateTimeToMildaiDateTime(String shamsiDate) {
        String s[] = shamsiDate.split("/");
        DateConverter dateConverter = new DateConverter();
        int m[] = dateConverter.shamsi2Miladi(s[0], s[1], s[2]);
        String yy = m[0] + "";
        String mm = m[1] > 9 ? "" + m[1] : "0" + m[1];
        String dd = m[2] > 9 ? "" + m[2] : "0" + m[2];
        String date;

        date = yy + "/" + mm + "/" + dd;
        DateFormat df = new SimpleDateFormat("yy/MM/dd");
        Date startDate = null;
        try {
            startDate = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startDate;
    }

    public static boolean checkNationalCodeValidation(String code) {
        try {
            if (code.length() == 10) {

                int sum = 0;
                int j = 10;
                for (int i = 0; i < 9; i++) {
                    sum += Integer.parseInt(code.substring(i, i + 1)) * j;//0-10/1-9/2-8/3-7/4-6/5-5/6-4/7-3/8-2
                    j--;
                }
                int r = sum % 11;
                if (r < 2)
                    return Integer.parseInt(code.substring(9)) == r;
                else
                    return Integer.parseInt(code.substring(9)) == (11 - r);
            }

            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getPersianNameOfNumber(int number) {
        switch (number) {
            case 1:
                return "یک";
            case 2:
                return "دو";
            case 3:
                return "سه";
            case 4:
                return "چهار";
            case 5:
                return "پنج";
            case 6:
                return "شش";
            case 7:
                return "هفت";
            case 8:
                return "هشت";
            case 9:
                return "نه";
            case 10:
                return "ده";
        }
        return null;
    }

    public static String setShortTimeFromShamsi(String shamsiDate) {
        String s[] = shamsiDate.split("/");
        DateConverter dateConverter = new DateConverter();
        int m[] = null;
        m = dateConverter.shamsi2Miladi(s[0], s[1], s[2]);
        String yy = m[0] + "";
        String mm = "";
        String dd = m[2] > 9 ? "" + m[2] : "0" + m[2];

        switch (m[1]) {
            case 1:
                mm = "JAN";
                break;
            case 2:
                mm = "FEB";
                break;
            case 3:
                mm = "MAR";
                break;
            case 4:
                mm = "APR";
                break;
            case 5:
                mm = "MAY";
                break;
            case 6:
                mm = "JUN";
                break;
            case 7:
                mm = "JUL";
                break;
            case 8:
                mm = "AUG";
                break;
            case 9:
                mm = "SEP";
                break;
            case 10:
                mm = "OCT";
                break;
            case 11:
                mm = "NOV";
                break;
            case 12:
                mm = "DEC";
                break;
        }
        return dd + mm + yy.substring(2);
    }

    public static String getGregurianMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1: {
                monthName = "JAN";

                break;
            }
            case 2: {
                monthName = "FEB";

                break;
            }
            case 3: {
                monthName = "MAR";

                break;
            }
            case 4: {
                monthName = "APR";

                break;
            }
            case 5: {
                monthName = "MAY";

                break;
            }
            case 6: {
                monthName = "JUN";

                break;
            }
            case 7: {
                monthName = "JUL";

                break;
            }
            case 8: {
                monthName = "AUG";

                break;
            }
            case 9: {
                monthName = "SEP";

                break;
            }
            case 10: {
                monthName = "OCT";

                break;
            }
            case 11: {
                monthName = "NOV";

                break;
            }
            case 12: {
                monthName = "DEC";

                break;
            }
        }
        return monthName;
    }

    public static String setTimeFromMiladi(String miladiDate) {
        String s[] = miladiDate.split("/");
        DateConverter dateConverter = new DateConverter();
        int m[] = dateConverter.Miladi2shamsi(s[2], s[1], s[0]);
        String yy = m[0] + "";
        String mm = m[1] > 9 ? "" + m[1] : "0" + m[1];
        String dd = m[2] > 9 ? "" + m[2] : "0" + m[2];
        String date;
        date = yy + mm + dd;

        return date;
    }

    public String setTimeFromMiladi2(String miladiDate) {
        String s[] = miladiDate.split("-");
        DateConverter dateConverter = new DateConverter();
        int m[] = dateConverter.Miladi2shamsi(s[0], s[1], s[2]);
        String yy = m[0] + "";
        String mm = m[1] > 9 ? "" + m[1] : "0" + m[1];
        String dd = m[2] > 9 ? "" + m[2] : "0" + m[2];
        String date;

        date = yy + "/" + mm + "/" + dd;

        return date;
    }

    public static boolean checkPhoneValidation(String phone) {
        return (phone.startsWith("09") && phone.length() == 11);
    }

    public static int getMiladiMonthInt(String month) {
        int mm = 0;
        switch (month) {
            case "JAN":
                mm = 1;
                break;
            case "FEB":
                mm = 2;
                break;
            case "MAR":
                mm = 3;
                break;
            case "APR":
                mm = 4;
                break;
            case "MAY":
                mm = 5;
                break;
            case "JUN":
                mm = 6;
                break;
            case "JUL":
                mm = 7;
                break;
            case "AUG":
                mm = 8;
                break;
            case "SEP":
                mm = 9;
                break;
            case "OCT":
                mm = 10;
                break;
            case "NOV":
                mm = 11;
                break;
            case "DEC":
                mm = 12;
                break;
        }
        return mm;
    }

    public static void hideSoftKeyBoard(View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean isDeviceConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting() ? true : false;
    }

    public static String getDayOFWeekFarsi(int day) {
        String dayOfweek = "";
        switch (day) {
            case 1:
                dayOfweek = "یکشنبه";
                break;
            case 2:
                dayOfweek = "دوشنبه";
                break;
            case 3:
                dayOfweek = "سه شنبه";
                break;
            case 4:
                dayOfweek = "چهارشنبه";
                break;
            case 5:
                dayOfweek = "پنجشنبه";
                break;
            case 6:
                dayOfweek = "جمعه";
                break;
            case 7:
                dayOfweek = "شنبه";
                break;
        }
        return dayOfweek;
    }

    public static void openBazaar(Context context, String share) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "http://cafebazaar.ir/app/?id=" +
                BuildConfig.APPLICATION_ID + "&ref=share");
        context.startActivity(Intent.createChooser(intent, context.getResources().getString( R.string.share)));
    }

}
