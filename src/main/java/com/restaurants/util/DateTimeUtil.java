package com.restaurants.util;

import org.springframework.cglib.core.Local;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeUtil {

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


}
