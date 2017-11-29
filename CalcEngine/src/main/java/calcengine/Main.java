package main.java.calcengine;

public class Main {

    public static void main(String[] args) {
//        useMathEquation();
//        useCalculateBase();

        String[] statements = {
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0",
        };

        CalculateHelper helper = new CalculateHelper();
        for (String statement : statements) {
            helper.process(statement);
            System.out.println(helper);
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
