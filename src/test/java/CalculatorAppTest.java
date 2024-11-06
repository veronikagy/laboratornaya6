import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorAppTest {

  private final CalculatorApp calculator = new CalculatorApp();

  // Тесты для сложения
  @Test
  public void testAdditionPositive() {
    assertEquals(5, calculator.add(2, 3), "2 + 3 должно быть 5");
  }

  @Test
  public void testAdditionWithPositiveAndNegative() {
    assertEquals(2, calculator.add(5, -3), "Сложение 5 и -3 должно быть 2");
  }

  @Test
  public void testAdditionWithTwoNegativeNumbers() {
    assertEquals(-5, calculator.add(-2, -3), "Сложение -2 и -3 должно быть -5");
  }

  @Test
  public void testAdditionWithOverflow() {
    assertTrue(Double.isInfinite(calculator.add(Double.MAX_VALUE, Double.MAX_VALUE)), "Результат должен быть бесконечным при переполнении");
  }

  // Тесты для вычитания
  @Test
  public void testSubtractionPositive() {
    assertEquals(1, calculator.subtract(3, 2), "3 - 2 должно быть 1");
  }
  @Test
  public void testSubtractionWithPositiveAndNegative() {
    assertEquals(5, calculator.subtract(3, -2), "3 - (-2) должно быть 5");
  }

  @Test
  public void testSubtractionWithOverflow() {
    System.out.println(calculator.subtract(Double.MAX_VALUE, Double.MAX_VALUE));
    assertEquals(0, calculator.subtract(Double.MAX_VALUE, Double.MAX_VALUE), "Результат должен быть бесконечным при переполнении");
  }


  // Тесты для умножения
  @Test
  public void testMultiplicationPositive() {
    assertEquals(6, calculator.multiply(2, 3), "2 * 3 должно быть 6");
  }

  @Test
  public void testMultiplicationWithPositiveAndNegative() {
    assertEquals(-6, calculator.multiply(2, -3), "Умножение 2 и -3 должно быть -6");
  }

  @Test
  public void testMultiplicationWithTwoNegativeNumbers() {
    assertEquals(0, calculator.multiply(2, 0), "Умножение 2 и 0 должно быть 0");
  }

  @Test
  public void testMultiplicationWithOverflow() {
    assertTrue(Double.isInfinite(calculator.multiply(Double.MAX_VALUE, 2)), "Результат должен быть бесконечным при переполнении");
  }

  // Тесты для деления
  @Test
  public void testDivisionPositive() {
    assertEquals(2, calculator.divide(6, 3), "6 / 3 должно быть 2");
  }

  @Test
  public void testDivisionByZero() {
    assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0), "Деление на ноль должно вызвать ArithmeticException");
  }

  @Test
  public void testDivisionNearZero() {
    assertEquals(Double.POSITIVE_INFINITY, calculator.divide(1, Double.MIN_VALUE), "1 / очень малое число должно быть очень большим значением");
  }

  // Тесты для процента от числа
  @Test
  public void testPercentagePositive() {
    assertEquals(10, calculator.percentage(100, 10), "10% от 100 должно быть 10");
  }

  @Test
  public void testNegativePercentage() {
    assertEquals(-10, calculator.percentage(100, -10), "Отрицательный процент должен быть корректно рассчитан");
  }

  @Test
  public void testPercentageWithZeroBase() {
    assertEquals(0, calculator.percentage(0, 10), "Процент от нуля должен быть равен нулю");
  }

  // Тесты для возведения в степень
  @Test
  public void testPowerPositive() {
    assertEquals(8, calculator.power(2, 3), "2 в степени 3 должно быть 8");
  }

  @Test
  public void testPowerWithNegativeExponent() {
    assertEquals(0.5, calculator.power(2, -1), "2 в степени -1 должно быть 0.5");
  }

  @Test
  public void testPowerWithInfinityExponent() {
    assertEquals(Double.POSITIVE_INFINITY, calculator.power(2, Double.POSITIVE_INFINITY), "2 в степени бесконечность должно быть бесконечностью");
  }


  // Тесты для логарифма
  @Test
  public void testLogarithmPositive() {
    assertEquals(0, calculator.logarithm(1), 0.0001, "log(1) должно быть 0");
  }

  @Test
  public void testLogarithmOfZero() {
    assertThrows(IllegalArgumentException.class, () -> calculator.logarithm(0), "log(0) должно вызвать IllegalArgumentException");
  }

  @Test
  public void testLogarithmOfNegative() {
    assertThrows(IllegalArgumentException.class, () -> calculator.logarithm(-1), "log(-1) должно вызвать IllegalArgumentException");
  }

  @Test
  public void testLogarithmOfInfinity() {
    assertEquals(Double.POSITIVE_INFINITY, calculator.logarithm(Double.POSITIVE_INFINITY), "log(бесконечность) должно быть бесконечностью");
  }

  @Test
  public void testLogarithmOfSmallPositiveNumber() {
    assertEquals(-230.2585, calculator.logarithm(1e-100), 0.0001, "log(1e-100) должно быть примерно -230.2585");
  }

  // Тесты для факториала
  @Test
  public void testFactorialPositive() {
    assertEquals(120, calculator.factorial(5), "5! должно быть 120");
  }

  @Test
  public void testFactorialOfZero() {
    assertEquals(1, calculator.factorial(0), "0! должно быть 1");
  }

  @Test
  public void testFactorialNegative() {
    assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-5), "Факториал отрицательного числа должен вызвать IllegalArgumentException");
  }

}
