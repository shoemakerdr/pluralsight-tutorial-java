package main.java.typeconversion;

public class Main {

    public static void main(String[] args) {
        float floatVal = 1.0f;
        double doubleVal = 4.0d;
        byte byteVal = 7;
        short shortVal = 7;
        long longVal = 5;

        short result1 = byteVal; // works implicit type conversion
        short result2 = longVal; // will not work
        short result3 = (short) longVal; // explicit type conversion

        short result4 = byteVal - longVal; // will not work
        short result5 = (short) (byteVal - longVal); // works parens value is all cast to short explicitly

        long result6 = longVal - floatVal; // will not work-- incompatible types
        float result7 = longVal - floatVal; // works
        float result8 = longVal - doubleVal; // will not work-- incompatible types
        double result9 = longVal - doubleVal; // works

        long result10 = shortVal - longVal; // works
        long result11 = shortVal - longVal + floatVal; // will not work
        long result12 = shortVal - longVal + floatVal + doubleVal; // will not work
        long result13 = (long) (shortVal - longVal + floatVal + doubleVal); // works

        System.out.println("Success");
    }
}
