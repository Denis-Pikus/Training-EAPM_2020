package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*
Создаем класс мультикарта
 */

public class MultiCard implements ICard{
    private Owner owner;
    private String id;
    private final int maxDocumentNumber = 2;     //максимальный номер мультикарты
    private static int countId;  //поле для формирования номера карты по мере создания новых мультикарт
    private static char prefix = 'A'; //поле для формирования серии номера карты по мере создания новых мультикарт
    private static List<MultiCard> allMulticard;    //контейнер для хранения всех выданных мультикартах
    private final int validCardPeriod = 10;     //срок действия документа в годах
    private LocalDate validPeriod;

    public MultiCard(Owner owner) {
        if (allMulticard == null){
            allMulticard = new ArrayList<>();
        }
        if (owner != null) {
            this.owner = owner;
            countId++;
            prefix();
            this.id = prefix + iCreateDocumentNumber(countId);
            this.validPeriod = date.plusYears(validCardPeriod);
            allMulticard.add(this);
        }
        else {
            System.out.println("Wrong input information about owner.");
            throw  new IllegalArgumentException();}
    }

    public String getId() {
        return id;
    }

    public static List<MultiCard> getAllMulticard() {
        return allMulticard;
    }

    //метод, который выводит информацию о том, какими функциями обладает мультикарта
    @Override
    public String iCardInfo() {
        return "Multicard:\n" +
                this.toString();
    }

    //метод, который формирует номер документа
    public String iCreateDocumentNumber(int countId) {
        int lenghtCurrentId = Integer.toString(countId).length();
        int lenghtMaxDocumentNumber = Integer.toString(maxDocumentNumber).length();
        if (lenghtCurrentId > lenghtMaxDocumentNumber){
            return Integer.toString(countId);
        }
        //добавляем "0" в номере до фортмирования числа заданной длинны
        return  String.format("%1$" + lenghtMaxDocumentNumber + "s",
                Integer.toString(countId)).replace(' ', '0');
    }

    //метод формирующий серию документа
    private void  prefix(){
        if (countId > maxDocumentNumber){
            prefix++;
            countId = 1;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultiCard)) return false;
        MultiCard card = (MultiCard) o;
        return maxDocumentNumber == card.maxDocumentNumber &&
                owner.equals(card.owner) &&
                Objects.equals(getId(), card.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, getId(), maxDocumentNumber);
    }

    @Override
    public String toString() {
        return owner +
                "\nmulticard number: " + id +
                ", valid to: " + validPeriod;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    LocalDate date = LocalDate.now();
}
