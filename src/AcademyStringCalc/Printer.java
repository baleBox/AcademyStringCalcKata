package AcademyStringCalc;

public class Printer {
    public void printQuotationMarks(String output) {
        if (output.length() > 40) {
            System.out.println("\"" + output + "...\"");
        } else {
            System.out.println("\"" + output + "\"");
        }
    }
}