package AcademyStringCalc;


import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.*;

public class StringCalc {
    static String expression;
    static char operation;
    static String[] input;

    public static void main(String[] args) throws IOException, NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        expression = scanner.nextLine();
        expression = expression.replace(" ", "");
        System.out.println("Input: ");
        System.out.println(expression);
        System.out.println("\n");
        System.out.println("Output: ");

        if (expression.contains("+")) {
            input = expression.split("\\+");
            operation = '+';
        } else if (expression.contains("-")) {
            input = expression.split("\\-");
            operation = '-';
        } else if (expression.contains("*")) {
            input = expression.split("\\*");
            operation = '*';
        } else if (expression.contains("/")) {
            input = expression.split("/");
            operation = '/';
        } else throw new IOException("Ќе верна€ операци€.");

        //  проверки строк на вводе
        if (!input[0].contains("\"")) {
            throw new NumberFormatException("ѕервым аргументом выражени€, подаваемого на вход, должна быть строка в \" \" кавычках.");
        }

        //  провер€ем на умножение на число в кавычках..
        if (operation == '*' || operation == '/') {
            if (input[1].contains("\"")) throw new IOException("—троку можно умножать или делить только на число.");
        }
        // убираем кавычки
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].replace("\"", "");
        }

        if ((input[0].length() > 10) || (input[1].length() > 10)) {
            throw new IOException("—троки должны длинной не более 10 символов.");
        }

        //сложение
        if (operation == '+') {
            printer.printQuotationMarks(input[0] + input[1]);
            //умножение
        } else if (operation == '*') {
            int num1 = parseInt(input[1]);
            if (num1 < 1 || num1 > 10) {
                throw new IOException(" алькул€тор принимает на вход числа от 1 до 10 включительно.");
            }
            int multiplication = parseInt(input[1]);
            String multresult = "";
            for (int i = 0; i < multiplication; i++) {
                multresult = multresult + input[0];
            }
            printer.printQuotationMarks(multresult);
            //вычитание
        } else if (operation == '-') {
            int index = input[0].indexOf(input[1]);
            if (index == -1) {
                printer.printQuotationMarks(input[0]);
            } else {
                String minus = input[0].substring(0, index);
                minus = minus + input[0].substring(index + input[1].length());
                printer.printQuotationMarks(minus);
            }
        } else {                         // деление
            int divide = input[0].length() / parseInt(input[1]);
            String minusdivide = input[0].substring(0, divide);
            printer.printQuotationMarks(minusdivide);
        }
    }
}
