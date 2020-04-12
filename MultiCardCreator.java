package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
  Класс, который формируетобъект мультикарта
 */

public class MultiCardCreator {
    private MultiCard multiCard;
    private Owner owner;
    private ICard card;

// Метод, который формирует объект мультикарты вводом данных из клавиатуры
    public ICard multiCardCreateByKeyboard() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter owners first name");
            String ownerFirstName = sc.nextLine();
            System.out.println("Enter owners last name");
            String ownerLastName = sc.nextLine();
            System.out.println("Enter owners birthday in format: day/month/year");
            String ownerDateOfBirthday = sc.nextLine();
            this.owner = new Owner(ownerFirstName, ownerLastName, ownerDateOfBirthday);
            this.multiCard = new MultiCard(owner);
            System.out.println(multiCard.iCardInfo());
            System.out.println("Do you want to get an electronic passport? y/n");
            if(sc.nextLine().equals("y")) {
                passportCreate();
            }
            System.out.println("Do you want to get an electronic driver license? y/n");
            switch (sc.nextLine()) {
                case "y":
                    driverLicenseCreate();
                    break;
                case "n":
                    System.out.println("Good by!");
                    break;
            }
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
            return multiCard;
    }

    //Метод добавляет функцию паспорта
    private ICard passportCreate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your passport number.");
        card = new Passport(this.multiCard, sc.nextLine());
        System.out.println(card.iCardInfo());
        return card;
    }

    //Метод добавляет функция водительскогоудостоверения
    private ICard driverLicenseCreate() {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>(4);
        String tmp = "";
        System.out.println("Enter your driver categories (A, B, C, D).");
        while (!(tmp = sc.nextLine().toUpperCase()).isEmpty()){
            if (tmp.equals("A") || tmp.equals("B") ||
                    tmp.equals("C") || tmp.equals("D")){
                list.add(tmp);
            }
        }
        String[] arrayCategories = new String[list.size()];
        card = new DriverLicense(this.multiCard, list.toArray(arrayCategories));
        System.out.println(card.iCardInfo());
        return card;
    }
}

