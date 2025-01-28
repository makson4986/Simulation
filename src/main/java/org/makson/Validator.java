package org.makson;

import java.util.Arrays;

public class Validator {
    public static boolean isCorrectTotalPercentage(int... percents) {
        return Arrays.stream(percents).sum() <= 100;
    }

    public static boolean isCorrectChosenAnswer(String answer, int maxAnswer) {
        if (answer.length() == 1) {
            return Character.isDigit(answer.charAt(0)) && Integer.parseInt(answer) <= maxAnswer && Integer.parseInt(answer) > 0;
        }

        return false;
    }

    public static int tryParseToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            return -1;
        }
    }

    public static boolean isCorrectCoordinates(Coordinates coordinates, int maxSizeField) {
        return (coordinates.x() < maxSizeField) && (coordinates.x() >= 0) && (coordinates.y() < maxSizeField) && (coordinates.y() >= 0);
    }
}
