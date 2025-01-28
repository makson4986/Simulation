package org.makson.simulation;

import org.makson.Validator;

import java.util.Scanner;

public class InputData {
    public static   int inputSettingsSimulation(String outputText) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(outputText);
            String line = scanner.nextLine();

            int intLine = Validator.tryParseToInteger(line);
            if (intLine != -1) {
                return intLine;
            }

            System.out.println("Неверное значение!\n");
        }
    }

    public static int inputDefaultOrCustomSimulation() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Хотите настроить параметры игры?
                    1. Оставить по умолчанию
                    2. Настроить""");

            String line = scanner.nextLine();

            if (Validator.isCorrectChosenAnswer(line, 2)) {
                return Integer.parseInt(line);
            }

            System.out.println("Неверный вариант ответа!\n");
        }
    }
}
