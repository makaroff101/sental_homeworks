package org.example;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int number = 100 + random.nextInt(900);

        System.out.println("Сгенерированное число: " + number);

        int digit1 = number / 100;
        int digit2 = (number / 10) % 10;
        int digit3 = number % 10;

        int maxDigit = Math.max(Math.max(digit1, digit2), digit3);

        System.out.println("Наибольшая цифра: " + maxDigit);
    }
}