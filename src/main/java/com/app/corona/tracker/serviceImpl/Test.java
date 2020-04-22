package com.app.corona.tracker.serviceImpl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        /*String date = "Tue March 21 22:39:04 IST 2020";*/
        String date4 =  "31 January ";
        //SimpleDateFormat formats = new SimpleDateFormat("dd MMMM");
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
                .parseCaseInsensitive().parseLenient()
                .parseDefaulting(ChronoField.YEAR_OF_ERA, 2016L)
                .appendPattern("dd MMM");
        DateTimeFormatter formatter2 = builder.toFormatter(Locale.ENGLISH);
        //LocalDateTime.parse(date4, formatter);
        System.out.println(LocalDate.parse(date4, formatter2));
        SimpleDateFormat format = new SimpleDateFormat("d");
        String date = format.format(new Date());
        format = new SimpleDateFormat(" d MMMMM");
        /*if(date.endsWith("1") && !date.endsWith("11"))
            format = new SimpleDateFormat(" MMM d'st'");
        else if(date.endsWith("2") && !date.endsWith("12"))
            format = new SimpleDateFormat(" MMM d'nd'");
        else if(date.endsWith("3") && !date.endsWith("13"))
            format = new SimpleDateFormat(" MMM d'rd'");
        else
            format = new SimpleDateFormat(" MMM d'th'");*/

        String yourDate = format.format(new Date());
        System.out.println(new Date());
        System.out.println(yourDate);
    }
}
