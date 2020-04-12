package com.company;

import java.util.ArrayList;
import java.util.List;

public class DriverLicense extends CardDecorator {
    private String[] categories;
    private static List<DriverLicense> allDriverLicenses;

    //Конструктор класса с переменным числом параметров для установления категорий управляемого транспорта
    public DriverLicense(MultiCard multiCard, String[] categories) {
        super(multiCard);
        if (allDriverLicenses == null)
            allDriverLicenses = new ArrayList<>();
            this.categories = categories;
            allDriverLicenses.add(this);
    }

    public String[] getCategories() {
        return categories;
    }

    public static List<DriverLicense> getAllDriverLicenses() {
        return allDriverLicenses;
    }

    @Override
    public String iCardInfo() {
        return multiCard.iCardInfo() + "\nPerforms the function: Driver license:\n" +
                driveTransportOfCategory(categories) + "\n";
    }

    //Метод, который выводит информацию, о том. каким видом транспорта может управлять владелец водительского
    //удостоверения
    private String driveTransportOfCategory(String[] categories){
        StringBuffer sb = new StringBuffer();
        for (String cat: categories) {
            switch (cat.toUpperCase()){
                case "A": sb.append("I drive bike.\n");
                break;
                case "B": sb.append("I drive car.\n");
                break;
                case "C": sb.append("I drive truck.\n");
                break;
                case "D": sb.append("I drive bus.\n");
                break;
            }
        }
        return sb.toString();
    }
}
