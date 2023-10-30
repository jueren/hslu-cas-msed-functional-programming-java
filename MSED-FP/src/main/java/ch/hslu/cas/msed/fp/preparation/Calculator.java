package ch.hslu.cas.msed.fp.preparation;

public class Calculator
{
        private int number;

        public Calculator(int number)
        {
                this.number = number;
        }

        public int process (CalculatorInterface calc)
        {
                return calc.calculate(this.number);
        }

        // Used as Static Method-References
        public static int square(int x)
        {
                return x * x;
        }
}

