public class CalculatorApp {

  // Базовые функции
  public double add(double a, double b) {
    return a + b;
  }

  public double subtract(double a, double b) {
    return a - b;
  }

  public double multiply(double a, double b) {
    return a * b;
  }

  public double divide(double a, double b) {
    if (b == 0) throw new ArithmeticException("Division by zero");
    return a / b;
  }

  // Расчет процента от числа
  public double percentage(double base, double percentage) {
    return (base * percentage) / 100;
  }

  // Возведение числа в степень
  public double power(double base, double exponent) {
    return Math.pow(base, exponent);
  }

  // Логарифм числа
  public double logarithm(double value) {
    if (value <= 0) throw new IllegalArgumentException("Logarithm only defined for positive numbers");
    return Math.log(value);
  }

  // Факториал числа
  public int factorial(int n) {
    if (n < 0) throw new IllegalArgumentException("Factorial only defined for non-negative integers");
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }

  public static void main(String[] args) {
    CalculatorApp calculator = new CalculatorApp();

    System.out.println("2 + 3 = " + calculator.add(2, 3));
    System.out.println("5 - 3 = " + calculator.subtract(5, 3));
    System.out.println("2 * 3 = " + calculator.multiply(2, 3));
    System.out.println("6 / 3 = " + calculator.divide(6, 3));
    System.out.println("10% от 100 = " + calculator.percentage(100, 10));
    System.out.println("2 в степени 3 = " + calculator.power(2, 3));
    System.out.println("Логарифм 1 = " + calculator.logarithm(1));
    System.out.println("Факториал 5 = " + calculator.factorial(5));
  }
}

