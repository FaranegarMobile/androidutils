package com.mohamadamin.persianmaterialdatetimepicker;

import android.graphics.Color;

/**
 * Created by fps on 2/14/2017.
 */

public class ColorModel {

    private int headerBackground;
    private int monthName;
    private int dayOfWeekName;
    private int pastDayColor;
    private int todayColor;
    private int todayBackColor;
    private int cancelButton;
    private int dateBackground;
    private int selectedDay;
    private boolean isDark;

    public ColorModel() {
        headerBackground = android.R.color.holo_purple;
        monthName = android.R.color.holo_green_light;
        dayOfWeekName = android.R.color.holo_red_dark;
        pastDayColor = android.R.color.holo_orange_dark;
        todayBackColor = android.R.color.white;
        todayColor = android.R.color.holo_red_light;
        cancelButton = android.R.color.black;
        dateBackground = android.R.color.holo_blue_dark;
        selectedDay = android.R.color.black;
        isDark = false;
    }

    public ColorModel(int headerBackground, int monthName, int dayOfWeekName, int pastDayColor
            , int todayColor, int todayBackColor, int cancelButton, int dateBackground
            , int selectedDay, boolean isDark) {
        this.headerBackground = headerBackground;
        this.monthName = monthName;
        this.dayOfWeekName = dayOfWeekName;
        this.pastDayColor = pastDayColor;
        this.todayColor = todayColor;
        this.todayBackColor = todayBackColor;
        this.cancelButton = cancelButton;
        this.dateBackground = dateBackground;
        this.selectedDay = selectedDay;
        this.isDark = isDark;
    }

    public int getHeaderBackground() {
        return headerBackground;
    }

    public void setHeaderBackground(int headerBackground) {
        this.headerBackground = headerBackground;
    }

    public int getMonthName() {
        return monthName;
    }

    public void setMonthName(int monthName) {
        this.monthName = monthName;
    }

    public int getDayOfWeekName() {
        return dayOfWeekName;
    }

    public void setDayOfWeekName(int dayOfWeekName) {
        this.dayOfWeekName = dayOfWeekName;
    }

    public int getPastDayColor() {
        return pastDayColor;
    }

    public void setPastDayColor(int pastDayColor) {
        this.pastDayColor = pastDayColor;
    }

    public int getTodayColor() {
        return todayColor;
    }

    public void setTodayColor(int todayColor) {
        this.todayColor = todayColor;
    }

    public int getTodayBackColor() {
        return todayBackColor;
    }

    public void setTodayBackColor(int todayBackColor) {
        this.todayBackColor = todayBackColor;
    }

    public int getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(int cancelButton) {
        this.cancelButton = cancelButton;
    }

    public int getDateBackground() {
        return dateBackground;
    }

    public void setDateBackground(int dateBackground) {
        this.dateBackground = dateBackground;
    }

    public boolean isDark() {
        return isDark;
    }

    public void setDark(boolean dark) {
        isDark = dark;
    }

    public int getSelectedDay() {
        return selectedDay;
    }

    public void setSelectedDay(int selectedDay) {
        this.selectedDay = selectedDay;
    }
}
