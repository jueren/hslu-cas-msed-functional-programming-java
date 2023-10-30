package ch.hslu.cas.msed.fp.preparation;

import java.util.function.Function;
import java.util.List;

public class CalculatorMain
{
    public static void main(String[] args)
    {
        // 0) Use of most basic Functional Interface: https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
        // import java.util.function.Function;
        Function<Integer, Integer> squareFn = x -> x * x;
        System.out.println(squareFn.apply(2)); // .andThen(), .compose()
        // Can be used as function argument -> SomeFunction(a, b, squareFn);

        // 1) Custom Functional Interfaces
        // Abstract-Inner Classes
        CalculatorInterface i = new CalculatorInterface() {
            @Override
            public int calculate(int x) {
                return x * x;
            }
        };
        System.out.println(i.calculate(5)); // 25

        // Lambda Definition
        CalculatorInterface i_lambda = (x) -> x * x;
        System.out.println(i_lambda.calculate(5)); // 25

        CalculatorInterface i_lambda2 = (x) -> x + x; // 10
        System.out.println(i_lambda2.calculate(5));

        // Passing Functional Interface as Method Argument
        Calculator c = new Calculator(5);
        // Does work, because only one function can be overwritten
        System.out.println(c.process(x -> x / x)); // 1

        // Using Method References
        List<String> list = List.of("Dev1", "Dev2", "Dev3");
        list.forEach(x -> System.out.println(x));
        list.forEach(System.out::println);

        // Using Method References on Custom Classes
        Calculator c2 = new Calculator(10);
        System.out.println(c2.process(Calculator::square)); // 100
    }
}
