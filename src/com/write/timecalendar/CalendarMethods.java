package com.write.timecalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * Created by Vitalik on 05.09.2016.
 */
public class CalendarMethods {
    public String createEvent(String date, String event) {
        String s = "2012-12-12";
        Date data = null;
        SimpleDateFormat formate = new SimpleDateFormat("YYYY-MM-DD");
        try {
            data = formate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data + "" + event;
    }

    public List<Event> showListOfEvents(){
        List<Event> list = new ArrayList<>();
        list.add(new Event(new Date("2016-09-01"), "Holliday First September"));
        list.add(new Event(new Date("2016 - 01 - 01"), "Holliday New Year"));
        list.add(new Event(new Date("2016 - 08 - 03"), "Holliday 8 of March"));
        list.add(new Event(new Date("2016 - 24 - 08"), "Holliday Independence Day"));
        list.add(new Event(new Date("2016 - 28 - 06"), "Holliday Day of Constitution"));
        list.add(new Event(new Date("2016 - 26 - 06"), "Holliday Young Day"));
        list.add(new Event(new Date("2016 - 15 - 07"), "Holliday Best Day"));
        return list;
    }

    //Выводить текущее время и дату в нескольких тайм-зонах(на выбор). При выводе даты и времени выводить также события на данный день.
    public String currentDateTimeDifferentTimezone(String inputTimezone) {


        return null;
    }

    //Создавать событие на конкретную дату и по требованию пользователя выводить список событий. Добавить возможность удалять события.
    public String createEvent(){
        List<Event> list = showListOfEvents();
        //    list.add(Event e);
        return null;
    }

    //Позволять пользователю вводить свой город(страну), определить его тайм-зону(проверить такую возможность в Java) и выводить текущее время,
    // день недели в этой тайм-зоне.
    public String determineTimezone(String partOfWorld, String city) {
        TimeZone timeZone = TimeZone.getTimeZone(partOfWorld + "/" + city);
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(timeZone);
        return "" + "-> Time : " + "hour = " + calendar.get(Calendar.HOUR_OF_DAY) + " minutes = " + calendar.get(Calendar.MINUTE) + " seconds = " + calendar.get(Calendar.SECOND) + " day of week = " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
    }

    //По требованию пользователя выводить в консоль дату через неделю, месяц, год.
    public void printDate(int number, int count) {

        LocalDate today = LocalDate.now();
        if (number == 1) {
            System.out.println(count + " days after today : " + today.plusDays(count));
        } else if (number == 2) {
            System.out.println(count + " weeks after today :" + today.plusWeeks(count));
        } else if (number == 3) {
            System.out.println(count + " month after today :" + today.plusMonths(count));
        } else if (number == 4) {
            System.out.println(count + " years after today :" + today.plusYears(count));
        }
    }

    //По требованию пользователя выводить в консоль только время и/или дату, день недели, номер дня в году, количество дней оставшеееся до Нового Года.
    public void printDateOrTime(int number) {
        Date date = new Date();
        LocalDate today = LocalDate.now();
        LocalDateTime todayDT = LocalDateTime.now();
        LocalTime time = LocalTime.now();
        if (number == 1) {
            System.out.println(" Time : " + time);
        } else if (number == 2) {
            System.out.println(" Date : " + todayDT.toLocalDate());
        } else if (number == 3) {
            System.out.println(" Date and Time: " + today.atTime(LocalTime.now()));
        } else if (number == 4) {
            System.out.println(" Day of week : " + today.getDayOfWeek());
        } else if (number == 5) {
            System.out.println(today.getDayOfYear() + " day " + today.getYear() + " year.");
        } else if (number == 6) {
            LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
//            Period period = today.until(lastDayOfYear);
            //   int days = daysBetween();
            //  System.out.println(" Count of days for New Year : " + period.getDays() + " days ");
            //       System.out.println(" Count of days for New Year : " + days + " days ");
        }
    }

    public int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    //Позволить пользователю вводить формат даты и выводить дату в этом формате.
    public String formatDate() {

        return null;
    }

    void menu() {
        System.out.println("\n ”`”*°•. `”*°••°*”` .•°*”`”*°•. ");
        System.out.println("•°*”`.•°*”`*MENU*`”*°•.`”*°•.");
        System.out.println(".•°*”` .•°*”` .•°*”` `”*°•. `”*°•. `”*°");
        System.out.println("1) Выводить текущее время и дату в нескольких тайм-зонах(на выбор). При выводе даты и времени выводить также события на данный день.");
        System.out.println("2) Создавать событие на конкретную дату и по требованию пользователя выводить список событий. Добавить возможность удалять события.");
        System.out.println("3) Позволять пользователю вводить свой город(страну), определить его тайм-зону(проверить такую возможность в Java) и выводить текущее время, день недели в этой тайм-зоне.");
        System.out.println("4) По требованию пользователя выводить в консоль дату через неделю, месяц, год.");
        System.out.println("5) По требованию пользователя выводить в консоль только время и/или дату, день недели, номер дня в году, количество дней оставшеееся до Нового Года.");
        System.out.println("6) Позволить пользователю вводить формат даты и выводить дату в этом формате.");
        System.out.println("7) Exit.");
    }
}
