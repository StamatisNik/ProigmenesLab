package gr.upatras.junit.first;

public class Subtraction {

    public String subtract(int a, int b) {
        int result = a - b;
        if (a > 999) {
        	 throw new IllegalArgumentException(" should be less than 1000");
        	 }

        if (result >= 0) {
            return "POSITIVE";
        } else {
            return "NEGATIVE";
        }
    }
}