package com.write.timecalendar;

import java.io.IOException;
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
                    myCalendar.currentDateTimeDifferentTimezone();
                    break;
                }
                case "2": {
                    System.out.println("Input element that you want to add(One)");
                    int element = scanner.nextInt();
                    myCalendar.createEvent();
                    break;
                }
                case "3": {
                    System.out.println("Input index of element that you want to remove");
                    int index = scanner.nextInt();
                    myCalendar.determineTimezone();
                    break;
                }
                case "4": {
                    System.out.println("Input index of element that you want to change");
                    int index = scanner.nextInt();
                    int element = scanner.nextInt();
                    myCalendar.printDate();
                    break;
                }
                case "5": {
                    System.out.println("Input number that you want to increase array");
                    int number = scanner.nextInt();
                    myCalendar.printDateOrTime();
                    break;
                }
                case "6": {
                    System.out.println("Input number of element that you want to cut");
                    int number = scanner.nextInt();
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
