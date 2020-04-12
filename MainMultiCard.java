package com.company;
/*
Для решения этой задачи применяю паттерн Декоратор, так как по условию задачи нам необходимо
добавлять новую функциональность базовому классу
 */

public class MainMultiCard {
    public static void main(String[] args) {
    MultiCardCreator multiCard = new MultiCardCreator();
    multiCard.multiCardCreateByKeyboard();
   }
}