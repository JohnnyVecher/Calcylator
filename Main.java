import java.util.Scanner;

public class Main {

    static Scanner s = new Scanner(System.in);

    public static void calc(String input) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение:");
        input = scanner.nextLine();

        String[] tokens = input.split(" ");

        if (tokens.length != 3) {
            System.out.println("Неверное выражение.");
            return;
        }

        String operand1 = tokens[0];
        String operator = tokens[1];
        String operand2 = tokens[2];

        int num1, num2;

        try {
            num1 = convertToNumber(operand1);
            num2 = convertToNumber(operand2);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат чисел.");
            return;
        }

        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("Неверный оператор.");
                return;
        }

        System.out.println("Ответ: " + result);
    }

    public static int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return RomanConverter.romanToArabic(input);
        }
    }
}

class RomanConverter {

    public static int romanToArabic(String romanNumber) {
        int arabicNumber = 0;
        int previousValue = 0;

        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            char romanChar = romanNumber.charAt(i);
            int value = romanCharToValue(romanChar);

            if (value < previousValue) {
                arabicNumber -= value;
            } else {
                arabicNumber += value;
            }

            previousValue = value;
        }

        return arabicNumber;
    }

    public static int romanCharToValue(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            default:
                return 0;
        }
    }
}