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
        System.out.println("����������� ����� ��������� �������� � �������: \"a\" + \"b\", \"a\" - \"b\", \"a\" * b, \"a\" / b.");
        System.out.println("������ ���������� � ���� ������.");
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
            input = expression.split("-");
            operation = '-';
        } else if (expression.contains("*")) {
            input = expression.split("\\*");
            operation = '*';
        } else if (expression.contains("/")) {
            input = expression.split("/");
            operation = '/';
        } else throw new IOException("�� ������ ��������.");

        //  �������� ����� �� �����
        if (input[0].matches("[0-9]")) {
            throw new NumberFormatException("������ ���������� ���������, ����������� �� ����, ������ ���� ������ � \" \" ��������.");
        }

        //  ��������� �� ��������� �� ����� � ��������..
        if (operation == '*' || operation == '/') {
            if (input[1].contains("\"")) throw new IOException("������ ����� �������� ��� ������ ������ �� �����.");
        }
        // ������� �������
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].replace("\"", "");
        }

        if ((input[0].length() > 10) || (input[1].length() > 10)) {
            throw new IOException("������ ������ ������� �� ����� 10 ��������.");
        }
        //��������
        if (operation == '+') {
            printer.printQuotationMarks(input[0] + input[1]);
            //���������
        } else if (operation == '*') {
            int num1 = parseInt(input[1]);
            if (num1 < 1 || num1 > 10) {
                throw new IOException("����������� ��������� �� ���� ����� �� 1 �� 10 ������������.");
            }
            int multiplication = parseInt(input[1]);
            String multresult = "";
            for (int i = 0; i < multiplication; i++) {
                multresult = multresult + input[0];
            }
            printer.printQuotationMarks(multresult);
            //���������
        } else if (operation == '-') {
            int index = input[0].indexOf(input[1]);
            if (index == -1) {
                printer.printQuotationMarks(input[0] + "-" + input[1]);
            } else {
                String minus = input[0].substring(0, index);
                minus = minus + input[0].substring(index + input[1].length());
                printer.printQuotationMarks(minus);
            }
        } else {
            // �������
            int num1 = parseInt(input[1]);
            if (num1 < 1 || num1 > 10) {
                throw new IOException("����������� ��������� �� ���� ����� �� 1 �� 10 ������������.");
            }
            int divide = input[0].length() / parseInt(input[1]);
            String minusdivide = input[0].substring(0, divide);
            printer.printQuotationMarks(minusdivide);
        }
    }
}
