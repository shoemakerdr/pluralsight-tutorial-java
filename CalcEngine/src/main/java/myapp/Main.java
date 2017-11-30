package main.java.myapp;

import main.java.calcengine.Adder;
import main.java.calcengine.CalculateBase;
import main.java.calcengine.CalculateHelper;
import main.java.calcengine.Divider;
import main.java.calcengine.DynamicHelper;
import main.java.calcengine.InvalidStatementException;
import main.java.calcengine.MathEquation;
import main.java.calcengine.MathProcessing;
import main.java.calcengine.Multiplier;
import main.java.calcengine.Subtracter;

public class Main {

    public static void main(String[] args) {
//        useMathEquation();
//        useCalculateBase();
//        useCalculateHelper();

        String[] statements = {
                "add 25.0 92.0",
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
        });
        for (String statement : statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }


    }
    static void useCalculateHelper () {
        String[] statements = {
                "add 1.0",                  // Error: incorrect number of values
                "add xx 25.0",              // Error: non-numeric data
                "addX 0.0 0.0",             // Error: invalid command
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0",
        };

        CalculateHelper helper = new CalculateHelper();
        for (String statement : statements) {
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out.println("-- Original exception: " + e.getCause().getMessage());
            }
        }

    }


    static void useMathEquation () {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(100.0d, 50.0d, 'd');
        equations[1] = new MathEquation(25.0d, 92.0d, 'a');
        equations[2] = new MathEquation(225.0d, 17.0d, 's');
        equations[3] = new MathEquation(11.0d, 3.0d, 'm');

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }

        System.out.println("\nUsing Overloads\n");

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("result = " + equationOverload.getResult());

        equationOverload.execute(leftInt, rightInt);
        System.out.println("result = " + equationOverload.getResult());

        equationOverload.execute((double) leftInt, rightInt);
        System.out.println("result = " + equationOverload.getResult());
    }

    private static void useCalculateBase() {
        System.out.println("\nUsing Inheritance\n");

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d),
        };

        for (CalculateBase calculator: calculators) {
            calculator.calculate();
            System.out.println("result = " + calculator.getResult());
        }

    }
}
