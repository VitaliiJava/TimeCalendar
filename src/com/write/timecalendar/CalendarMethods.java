package com.write.timecalendar;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/*
 * The class is created for storing and handle of information about date and different events.
 */
public class CalendarMethods {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Event> list;

    public CalendarMethods() {
        list = new ArrayList<>();
        list.add(new Event(LocalDate.of(2016, 9, 1), "Holliday First September"));
        list.add(new Event(LocalDate.of(2016, 1, 1), "Holliday New Year"));
        list.add(new Event(LocalDate.of(2016, 8, 3), "Holliday 8 of March"));
        list.add(new Event(LocalDate.of(2016, 8, 24), "Holliday Independence Day"));
        list.add(new Event(LocalDate.of(2016, 6, 28), "Holliday Day of Constitution"));
        list.add(new Event(LocalDate.of(2016, 6, 26), "Holliday Young Day"));
        list.add(new Event(LocalDate.of(2016, 9, 21), "Holliday Best Day"));
    }

    /**
     * The method allows getting information about List of events.
     *
     * @return list of events.
     */
    public List<Event> getList() {
        return list;
    }

    /**
     * The method allows to show the current time and date in multiple time zones.
     *
     * @param inputTimezone the string that will contain the name of the country.
     * @param city          the string that will contain the name of the city.
     * @return the object of ZonedDateTime
     */
    public ZonedDateTime currentDateTimeDifferentTimezone(String inputTimezone, String city) {
        ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now(ZoneId.of(inputTimezone + "/" + city));
        LocalDate date = LocalDate.now(ZoneId.from(zonedDatetimeFromZone));
        date.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        List<Event> list = getList();
        Iterator<Event> iter = list.iterator();
        while (iter.hasNext()) {
            Event event = iter.next();
            if (date.equals(event.getDate())) {
                System.out.println(event);
            }
        }
        return zonedDatetimeFromZone;
    }

    /**
     * The method allows to create event and to see the list of events.
     */
    public void combineFunction() {
        createEvent();
        System.out.println("If you want to see a list of events input 1 ,if not input 2");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println(getList());
        } else {
            System.out.println("OK!");
        }
    }

    /**
     * The method allows to create an event on a specific date.
     */
    public void createEvent() {
        System.out.println("Input date format YYYY-MM-DD that you want to create ");
        String date = scanner.nextLine();
        System.out.println("Input name Of Event that you want to create ");
        String event = scanner.nextLine();
        String[] str = date.split("-");
        LocalDate today = LocalDate.of(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
        list.add(new Event(today, event));
    }

    /**
     * The method allows to delete the event to see a list of events.
     */
    public void deleteEvent() {
        System.out.println("Input date format YYYY-MM-DD that you want to delete ");
        Iterator<Event> iter = list.iterator();
        String dateOfEvent = scanner.next();
        String[] str = dateOfEvent.split("-");
        LocalDate today = LocalDate.of(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
        while (iter.hasNext()) {
            Event event = iter.next();
            if (event.getDate().equals(today)) {
                iter.remove();
            }
        }
        showList();
    }

    public void showList() {
        System.out.println("If you want to see a list of events input 1 ,if not input 2");
        int choice = Integer.parseInt(scanner.next());
        if (choice == 1) {
            System.out.println(getList());
        } else {
            System.out.println("OK!");
        }
    }

    /**
     * The method allows for user to enter their country(city), to determine its time zone and display the current time , day of the week in this time zone.
     *
     * @param partOfWorld the string that will contain the name of the country.
     * @param city        the string that will contain the name of the city.
     * @return the string with information about hours,minutes,seconds,day of week.
     */

    public String determineTimezone(String partOfWorld, String city) {
        TimeZone timeZone = TimeZone.getTimeZone(partOfWorld + "/" + city);
        ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now(ZoneId.of(partOfWorld + "/" + city));
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(timeZone);
        return "" + "-> Time : " + "hours = " + calendar.get(Calendar.HOUR_OF_DAY) + "; minutes = " + calendar.get(Calendar.MINUTE) + "; seconds = " + calendar.get(Calendar.SECOND) + "; day of week = " + zonedDatetimeFromZone.getDayOfWeek() + ".";
    }

    /**
     * The method allows output to the console date in a week, month, year,day.
     *
     * @param number the number for choice what you want to see.
     * @param count  the number that will contain the quantity of days,weeks,month,years.
     */

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

    /**
     * The method allows to output to the console only current time and/or date, day of week, day of the year, the quantity of days until the New Year.
     */
    public void printDateOrTime() {
        LocalDate today = LocalDate.now();
        LocalDateTime todayDT = LocalDateTime.now();
        LocalTime time = LocalTime.now();
        String key = scanner.next();
        switch (key) {
            case "1": {
                System.out.println(" Time : " + time);
                break;
            }
            case "2": {
                System.out.println(" Date : " + todayDT.toLocalDate());
                break;
            }
            case "3": {
                System.out.println(" Date and Time: " + today.atTime(LocalTime.now()));
                break;
            }
            case "4": {
                System.out.println(" Day of week : " + today.getDayOfWeek());
                break;
            }
            case "5": {
                System.out.println(today.getDayOfYear() + " day " + today.getYear() + " year.");
                break;
            }
            case "6": {
                LocalDateTime lastDayOfYear = todayDT.with(TemporalAdjusters.lastDayOfYear());
                final Duration duration = Duration.between(todayDT, lastDayOfYear);
                System.out.println("Duration in days: " + duration.toDays());
                break;
            }
        }
    }

    /**
     * The method allows for the user to enter the date format and get the date in this format.
     *
     * @param format the string that will contain the format of date.
     * @return the string with date in choose format.
     */
    public String formatDate(String format) {
        LocalDateTime dateTime = LocalDateTime.now();
        return "format: " + dateTime.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * The method allows to see the menu of application.
     */
    void menu() {
        System.out.println("\n ”`”*°•. `”*°••°*”` .•°*”`”*°•. ");
        System.out.println("•°*”`.•°*”`*MENU*`”*°•.`”*°•.");
        System.out.println(".•°*”` .•°*”` .•°*”` `”*°•. `”*°•. `”*°");
        System.out.println("1) Show the current time and date in different time zones.");
        System.out.println("2) Create an event on a specific date and on the user's request to show a list of events.");
        System.out.println("3) Allow for the user to enter their country(city), to determine it's time zone and display the current time , day of the week in this time zone .");
        System.out.println("4) Output to the console date in a week, month, year .");
        System.out.println("5) Output to the console only time and / or date , day of week , day of the year , the quantity of days until the New Year ");
        System.out.println("6) Allow for the user to enter the date format and get the date in this format.");
        System.out.println("7) Delete event.");
        System.out.println("8) Show list of Events.");
        System.out.println("9) Exit.");
    }
}
