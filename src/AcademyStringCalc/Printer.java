package AcademyStringCalc;

public class Printer {
    public void printQuotationMarks(String output) {
        if (output.length() > 40) {
            System.out.println("\"" + output.substring(0,40) + "...\"");
        } else {
            System.out.println("\"" + output + "\"");
        }
    }
}