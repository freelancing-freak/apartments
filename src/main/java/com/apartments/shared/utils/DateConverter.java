package com.apartments.shared.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateConverter {

    public static String convert(ZonedDateTime zonedDateTime) {
        StringBuilder sb = new StringBuilder();
        LocalDate date = zonedDateTime.toLocalDate();
        sb.append(date.getDayOfMonth());
        sb.append(' ');
        sb.append(mapMonth(date.getMonthValue()));
        sb.append(' ');
        sb.append(date.getYear());
        return sb.toString();
    }

    private static String mapMonth(int month) {
        return switch (month) {
            case 1 -> "stycznia";
            case 2 -> "lutego";
            case 3 -> "marca";
            case 4 -> "kwietnia";
            case 5 -> "maja";
            case 6 -> "czerwca";
            case 7 -> "lipca";
            case 8 -> "sierpnia";
            case 9 -> "września";
            case 10 -> "października";
            case 11 -> "listopada";
            case 12 -> "grudnia";
            default -> "Unknown";
        };
    }
}
