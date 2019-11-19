package com.yly.databinding;

import android.widget.RatingBar;

import androidx.databinding.InverseMethod;

public class InverseMethodDemo {

    @InverseMethod("convertIntToString")
    public static int convertStringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static String convertIntToString(int value) {
        return String.valueOf(value);
    }


    public static void onRatingChange(RatingBar ratingBar, float rating, boolean fromUser) {
        System.out.println("onRatingChange");
    }
}