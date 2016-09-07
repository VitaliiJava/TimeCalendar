package com.write.timecalendar;

import java.io.IOException;
import java.time.LocalTime;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Организовать приложение календарь.
 * Приложение должно позволять:
 * 1) Выводить текущее время и дату в нескольких тайм-зонах(на выбор). При выводе даты и времени выводить также события на данный день.
 * 2) Создавать событие на конкретную дату и по требованию пользователя выводить список событий. Добавить возможность удалять события.
 * 3) Позволять пользователю вводить свой город(страну), определить его тайм-зону(проверить такую возможность в Java) и выводить текущее
 * время, день недели в этой тайм-зоне.
 * 4) По требованию пользователя выводить в консоль дату через неделю, месяц, год.
 * 5) По требованию пользователя выводить в консоль только время и/или дату, день недели, номер дня в году, количество дней оставшеееся
 * до Нового Года.
 * 6) Позволить пользователю вводить формат даты и выводить дату в этом формате.
 */

public class Main {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        CalendarMethods myCalendar = new CalendarMethods();
        while (true) {
            myCalendar.menu();
            String key = scanner.next();
            switch (key) {
                case "1": {
                    System.out.println("-> Input timezone to know current time and date.");
                    int element = scanner.nextInt();
                    // myCalendar.currentDateTimeDifferentTimezone();
                    break;
                }
                case "2": {
                    System.out.println("Input element that you want to add(One)");
                    int element = scanner.nextInt();
                    myCalendar.createEvent();
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
                    System.out.println("Input 1 for choose day,2 for choose week,3 for choose month,4 for choose year and count of it");
                    int number = scanner.nextInt();
                    int count = scanner.nextInt();
                    myCalendar.printDate(number, count);
                    break;
                }
                case "5": {
                    System.out.println("Input 1 for choose Time,2 for choose Date ,3 for choose Date and Time,4 for choose Day of week,5 for choose Number of day in year,6 for choose count days to New Year");
                    int number = scanner.nextInt();
                    myCalendar.printDateOrTime(number);
                    break;
                }
                case "6": {
                    myCalendar.formatDate();
                    break;
                }
                case "7":
                    return;
                default:
                    return;
            }
        }
    }
}
