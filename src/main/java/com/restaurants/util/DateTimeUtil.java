package com.restaurants.util;

import org.springframework.util.StringUtils;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static boolean isTillExpiredTime(LocalTime expiredTime){
        return LocalTime.now().isBefore(expiredTime);
    }

    public static boolean isSameDay(LocalDate lastVote, LocalDate currentVote){
        if(lastVote == null) return true;
        else return lastVote.isEqual(currentVote);
    }

    public static  boolean isBetweenDate(LocalDate ld, LocalDate startDate, LocalDate endDate){
        return  ld.compareTo(startDate) >= 0 && ld.compareTo(endDate) <=0;
    }


    public static LocalDate parseLocalDate(String date){
        return StringUtils.isEmpty(date) ?  null : LocalDate.parse(date);
    }

    public static String toString(LocalDate localDate) {
        return localDate == null ? "" : localDate.format(DATE_FORMATTER);
    }


}
