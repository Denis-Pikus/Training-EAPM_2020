package com.company;

import java.util.ArrayList;
import java.util.List;

public class Passport extends CardDecorator {
    private static List<Passport> allPassport;
    private String passportNumber;

    public Passport(MultiCard multiCard, String passportNumber) {
        super(multiCard);
        if (passportNumber != null && !passportNumber.isEmpty())
        this.passportNumber = passportNumber;
        if (allPassport == null){
            allPassport = new ArrayList<>();
        }
            allPassport.add(this);
    }

    public List<Passport> getAllPassport() {
        return allPassport;
    }

    @Override
    public String iCardInfo() {
        return multiCard.iCardInfo() + "\nPerforms the function: Passport: " +
                "\npassport number: " + passportNumber;
    }
}
