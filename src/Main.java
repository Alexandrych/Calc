import java.util.Scanner;

public class Main {

    static char operation;

    public static void main(String[] args) {
        System.out.println(" алькул€тор выполн€ет операции сложени€, вычитани€, умножени€ и делени€ с двум€ целыми числами от 1 до 10");
        System.out.println("¬ведите выражение арабскими или римскими числами");
        Scanner abc = new Scanner(System.in);
        String userInput = abc.nextLine();
        try {
            System.out.println(calc(userInput));
        }
        catch (NumberFormatException e){
            System.err.println(e+" Ќеверный формат чисел");
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    public static String calc (String input) throws Exception{
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+')
                operation = '+';
            if (input.charAt(i) == '-')
                operation = '-';
            if (input.charAt(i) == '*')
                operation = '*';
            if (input.charAt(i) == '/')
                operation = '/';
        }
        String[] blacks = input.split("[-+/*]");
        if (blacks.length < 2){
            throw new Exception("¬ы ввели не математическую операцию");
        }
        if (blacks.length > 2){
            throw new Exception("¬ыражение не удовлетвор€ет заданию - два целочисленных операнда и один оператор (+, -, /, *)");
        }
        String part1 = blacks[0].toUpperCase().trim();
        String part2 = blacks[1].toUpperCase().trim();
        int number1 = romanToArabic(part1);
        int number2 = romanToArabic(part2);

        //арабские
        if (number1 < 1 && number2 < 1){
            number1 = Integer.parseInt(part1, 10);
            number2 = Integer.parseInt(part2, 10);
            if (number1 > 0 && number1 <= 10 && number2 > 0 && number2 <= 10) {
                return "" + calculate(number1, number2, operation);
            }
            else{
                throw new Exception(" алькул€тор работает с числами только от 1 до 10");
            }
        }

        //римские
        else if (number1 > 0 && number2 > 0) {
            int result = calculate(number1, number2, operation);
            if (result > 0 ) {
                return arabicToRoman(result);
            }
            else {
                throw new Exception("–езультатом счета римских чисел не могут быть 0 и отрицательные числа");
            }
        }

        //римские + арабские
        else  {
            throw new Exception("Ќельз€ проводить операции с арабскими и римскими цифрами одновременно");
        }
    }

    static int romanToArabic (String roman) {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }

    static String arabicToRoman (int arabian){
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[arabian];
    }

    static int calculate(int num1, int num2, char op) {
        return switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> -1;
        };
    }
}