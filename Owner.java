package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Owner {
    private String firstName;
    private String secondName;
    private String dateOfBirthday;

    public Owner(String firstName, String secondName, String dateOfBirthday) {
        if (firstName != null && !firstName.isEmpty() &&
                secondName != null && !secondName.isEmpty() &&
                dateOfBirthday != null &&
                LocalDate.parse(dateOfBirthday, formatter).isBefore(date))
        {
            this.firstName = firstName;
            this.secondName = secondName;
            this.dateOfBirthday = dateOfBirthday;
        }
        else {
            System.out.println("Wrong input information about owner.");
            throw new IllegalArgumentException();
        }
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate date = LocalDate.now();

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        Owner owner = (Owner) o;
        return getFirstName().equals(owner.getFirstName()) &&
                getSecondName().equals(owner.getSecondName()) &&
                getDateOfBirthday().equals(owner.getDateOfBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getSecondName(), getDateOfBirthday());
    }

    @Override
    public String toString() {
        return "Owner: first name: " +
                firstName + ", secondName: " + secondName +
                ", date of birthday: " + dateOfBirthday;
    }
}