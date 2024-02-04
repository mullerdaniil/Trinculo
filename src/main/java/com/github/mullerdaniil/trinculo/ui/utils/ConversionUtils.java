package com.github.mullerdaniil.trinculo.ui.utils;

import java.time.LocalDateTime;

public class ConversionUtils {
    public static String convertTimestampToDateString(LocalDateTime timestamp) {
        var dayOfMonth = fillLeadingZeroes(String.valueOf(timestamp.getDayOfMonth()), 2);
        var month = fillLeadingZeroes(String.valueOf(timestamp.getMonthValue()), 2);
        var year = fillLeadingZeroes(String.valueOf(timestamp.getYear() % 100), 2);

        return dayOfMonth + "." + month + "." + year;
    }

    public static String convertTimestampToDayOfWeekTwoLettersCodeString(LocalDateTime timestamp) {
        var dayOfWeek = timestamp.getDayOfWeek();
        return switch (dayOfWeek) {
            case MONDAY -> "MO";
            case TUESDAY -> "TU";
            case WEDNESDAY -> "WE";
            case THURSDAY -> "TH";
            case FRIDAY -> "FR";
            case SATURDAY -> "SA";
            case SUNDAY -> "SU";
        };
    }

    public static String convertTimestampToTimeString(LocalDateTime timestamp) {
        var hour = fillLeadingZeroes(String.valueOf(timestamp.getHour()), 2);
        var minute = fillLeadingZeroes(String.valueOf(timestamp.getMinute()), 2);
        var second = fillLeadingZeroes(String.valueOf(timestamp.getSecond()), 2);

        return hour + ":" + minute + ":" + second;
    }

    private static String fillLeadingZeroes(String string, int length) {
        if (string.length() >= length) {
            return string;
        }

        int zeroesLength = length - string.length();
        return "0".repeat(zeroesLength) + string;
    }
}
