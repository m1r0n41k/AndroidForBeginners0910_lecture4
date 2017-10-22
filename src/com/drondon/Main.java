package com.drondon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*;
    * Хранилище контактов
    * */
    private static List<Contact> contacts = new ArrayList<>();


    /*;
    * Стандартное меню приложения
    * */
    private final static String MENU = "1 - Добавить контакт\n" +
            "2 - Просмотреть все контакты\n" +
            "3 - Редактировать контакт\n" +
            "4 - Удалить контакт\n" +
            "0 - Выйти из приложения\n" +
            "\n" +
            "Введите пункт меню: ";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*Для специального сообщения при первом входе в приложение*/
        boolean isFirst = true;
        while (true) {
            printAppSeparator();
            if (isFirst) {
                //Только первый раз
                isFirst = false;
                System.out.println("Для работы с приложение выберите один из пунктов меню:\n");
            } else {
                //Все последующие
                System.out.println("\nДля продолжения работы с приложение выберите один из пунктов меню:\n");
            }

            System.out.print(MENU);

            String data = scanner.nextLine();

            int input = Integer.valueOf(data);

            System.out.println();

            switch (input) {
                case 0:
                    System.out.println("Спасибо что воспользовались нашим сервисом! До скорой встречи!");
                    return;
                case 1:
                    printMenuHeader("Добавить контакт:");
                    addNewContact(scanner);
                    break;
                case 2:
                    printMenuHeader("Просмотреть все контакты:");
                    printAllContacts();
                    break;
                case 3:
                    printMenuHeader("Редактировать контакт:");
                    System.out.println("ОШИБКА! Не поодерживаеться в данной версии!");
                    break;
                case 4:
                    printMenuHeader("Удалить контакт:");
                    System.out.println("ОШИБКА! Не поодерживаеться в данной версии!");
                    break;

            }

            printAppSeparator();
            System.out.print("Введите ENTER, чтобы продолжить: ");
            scanner.nextLine();
        }
    }

    /**
     * В данном методе реализован код для считывания данных контакта из консоли и сохранения нового контакта в список
     */
    private static void addNewContact(Scanner scanner) {

        String name; //Поле для хранения имени
        while (true) {
            System.out.print("Введите имя контакта: ");
            name = scanner.nextLine();
            if (isValidName(name)) {
                break;
            } else {
                System.out.println("ОШИБКА! Имя введено неправильно");
            }
        }

        String email; //Поле для хранения почты
        while (true) {
            System.out.print("Введите почту: ");
            email = scanner.nextLine();
            if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("ОШИБКА! Почта введена неправильно");
            }
        }


        Contact contact = new EmailContact(name, email); // Создаем новый контакт

        contacts.add(contact); //Добавляем контак в список

    }

    /**
     * Данный метод не реализован
     * Его необходимо реализваит в качестве ДЗ
     */
    private static boolean isValidName(String name) {
        return name.length() > 6;
    }

    /**
     * Данный метод не реализован
     * Его необходимо реализваит в качестве ДЗ
     */
    private static boolean isValidEmail(String email) {
        return email.length() > 6;
    }


    /**
     * Выводит пронумерованный список контактов
     */
    private static void printAllContacts() {
        System.out.println("Список контактов: ");

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println("|-----|----------------------------------------------------|");
            System.out.println("|  " + i + "  |  Имя: " + contact.getName() + ", Почта: " + contact.getData());
        }
        System.out.println("|-----|----------------------------------------------------|");
    }

    /**
     * Выводи красивую шапку для пунктов меню
     */
    private static void printMenuHeader(String menuName) {
        System.out.println("----------------------------------------");
        System.out.println(menuName);
        System.out.println("----------------------------------------");
        System.out.println();
    }

    /*
    * Для разделения циклов
    * */
    private static void printAppSeparator() {
        System.out.println();
        System.out.println("> ***************************************** <");
        System.out.println();
    }

}
