package com.write.timecalendar;

import java.io.IOException;
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
    private static String key;

    public static String getKey() {
        return key;
    }

    public static void main(String[] args) throws IOException {
        //   MyList myList = new MyList();

        while (true) {
            //        myList.menu();
            key = scanner.next();
            switch (key) {
                case "1": {
                    System.out.println("Input element that you want to add(Capacity)");
                    int element = scanner.nextInt();
                    //            myList.addIncreaseCapacityDouble(element);
                    break;
                }
                case "2": {
                    System.out.println("Input element that you want to add(One)");
                    int element = scanner.nextInt();
                    //             myList.addIncreaseCapacityForOne(element);
                    break;
                }
                case "3": {
                    System.out.println("Input index of element that you want to remove");
                    int index = scanner.nextInt();
                    //                myList.remove(index);
                    break;
                }
                case "4": {
                    System.out.println("Input index of element that you want to change");
                    int index = scanner.nextInt();
                    int element = scanner.nextInt();
                    //              myList.changeElementOfArray(index, element);
                    break;
                }
                case "5": {
                    System.out.println("Input number that you want to increase array");
                    int number = scanner.nextInt();
                    //                myList.increaseList(number);
                    break;
                }
                case "6": {
                    System.out.println("Input number of element that you want to cut");
                    int number = scanner.nextInt();
                    //               myList.cutList(number);
                    break;
                }
                case "7": {
                    //                  myList.printList();
                    break;
                }
                case "8": {
                    //                 myList.sortList();
                    break;
                }
                case "9": {
                    System.out.println("Input index of element that you want to see");
                    int index = scanner.nextInt();
//                    System.out.println(myList.getElement(index));
                    break;
                }
                case "10": {
                    //                 myList.showLogList();
                    break;
                }
                case "11":
                    return;
                default:
                    return;
            }
        }
    }
}
