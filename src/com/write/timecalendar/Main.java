package com.write.timecalendar;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Scanner;


/**
 * The class creates a menu for handling information about date and different events.
 *
 * @author Vitalii Prykhid
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        CalendarMethods myCalendar = new CalendarMethods();
        while (true) {
            myCalendar.menu();
            String key = scanner.next();
            try {
                switch (key) {
                    case "1": {
                        System.out.println("-> Input timezone/city like (Europe/Madrid) to know current time and date.\n-> Input country.");
                        String timezone = scanner.next();
                        System.out.println("-> Input city");
                        String city = scanner.next();
                        System.out.println("Time UTC: " + ZonedDateTime.now(ZoneOffset.UTC) + "\n Converted time: "
                                + myCalendar.currentDateTimeDifferentTimezone(timezone, city));
                        break;
                    }
                    case "2": {

                        myCalendar.combineFunction();
                        break;
                    }
                    case "3": {
                        System.out.println("Input part of world(like Europe, America or Africa)");
                        String partOfWorld = scanner.next();
                        System.out.println("Input city");
                        String city = scanner.next();
                        System.out.println(myCalendar.determineTimezone(partOfWorld, city));
                        break;
                    }
                    case "4": {
                        System.out.println("Input 1 for choose day,2 for choose week,3 for choose month,4 for choose " +
                                "year and count of it");
                        int number = scanner.nextInt();
                        System.out.println("Input count of data");
                        int count = scanner.nextInt();
                        myCalendar.printDate(number, count);
                        break;
                    }
                    case "5": {
                        System.out.println("Input 1 for choose Time,2 for choose Date ,3 for choose Date and Time,4 for" +
                                " choose Day of week,5 for choose Number of day in year,6 for choose count days to New Year");
                        myCalendar.printDateOrTime();
                        break;
                    }
                    case "6": {
                        System.out.println("Input your format of date");
                        System.out.println("You can choose 1 of this formats\n\"dd MMMM yy hh:mm:ss\"\n\"dd/MM/yy\"\n" +
                                "\"HH:mm\"\nor dd/MM/yyyy, dd-MM-yyyy, MM/dd/yyyy, yyyy-MM-dd.\n\"yyyy.MM.dd G 'at' " +
                                "hh:mm:ss z\"\n\"EEE, MMM d, ''yy\"\n\"h:mm a\"\n\"hh 'o''''clock' a, zzzz\"\n\"K:mm " +
                                "a, z\"\n\"yyyyy.MMMMM.dd GGG hh:mm aaa\"\n");
                        String dateFormat = scanner.next();
                        System.out.println(myCalendar.formatDate(dateFormat));
                        break;
                    }
                    case "7": {
                        myCalendar.deleteEvent();
                        break;
                    }
                    case "8": {
                        System.out.println(myCalendar.getList());
                        break;
                    }
                    case "9":
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }
    }
}
