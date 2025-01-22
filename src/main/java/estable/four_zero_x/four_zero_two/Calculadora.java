package estable.four_zero_x.four_zero_two;

import java.util.Scanner;

public class Calculadora {

    public static double[] sumar(double realPart1, double realPart2,
                                 double imaginaryPart1, double imaginaryPart2) {
        double totalReal = realPart1 + realPart2;
        double totalImaginary = imaginaryPart1 + imaginaryPart2;

        return new double[]{totalReal, totalImaginary};
    }

    public static double[] restar(double realPart1, double realPart2,
                                 double imaginaryPart1, double imaginaryPart2) {
        double totalReal = realPart1 - realPart2;
        double totalImaginary = imaginaryPart1 - imaginaryPart2;

        return new double[]{totalReal, totalImaginary};
    }

    public static double multiplicar(double a, double b, int precision) {
        return Math.round(a * b * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    public static double dividir(double a, double b, int precision) {
        b = Math.round(b * 1000000.0) / 1000000.0;
        if (b == 0) {
            throw new ArithmeticException();
        }
        return Math.round(a / b * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    public static double exponentiation(double a, double b, int precision) {
        if (a < 0 && b % 1 != 0) {
            throw new ArithmeticException();
        }
        return Math.round(Math.pow(a, b) * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    public static double sine(double a, int precision) {
        double radians = Math.toRadians(a);
        return Math.round(Math.sin(radians) * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    public static double cosine(double a, int precision) {
        double radians = Math.toRadians(a);
        return Math.round(Math.cos(radians) * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    public static double tangent(double a, int precision) {
        double radians = Math.toRadians(a);
        if (a % 90 == 0 && a % 180 != 0) {
            throw new ArithmeticException();
        }

        return Math.round(Math.tan(radians) * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    public static double decimalLog(double a, int precision) {
        if (a <= 0) {
            throw new ArithmeticException();
        }
        return Math.round(Math.log10(a) * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    // Modified method to accept a Scanner as a parameter
    public static void calculateWithScanner(Scanner scanner) {
        while (true) {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Suma (números complejos)");
            System.out.println("2. Resta (números complejos)");
            System.out.println("3. Multiplicación (números reales)");
            System.out.println("4. División (números reales)");
            System.out.println("5. Exponienciación (números reales)");
            System.out.println("6. Seno (En grados)");
            System.out.println("7. Coseno (En grados)");
            System.out.println("8. Tangente (En grados)");
            System.out.println("9. Logaritmo decimal (número real)");
            System.out.println("10. Salir");
            int option = scanner.nextInt();
            int precision = 0;
            double num1 = 0;
            double num2 = 0;
            double resultDouble = 0;
            double realPart1 = 0;
            double realPart2 = 0;
            double imaginaryPart1 = 0;
            double imaginaryPart2 = 0;
            double realComplexResult = 0;
            double imaginaryComplexResult = 0;

            if (option == 10) {
                System.out.println("Saliendo...");
                break;
            }

            switch (option) {
                case 1:
                    System.out.println("Escribe la parte real del primer número:");
                    realPart1 = scanner.nextDouble();
                    System.out.println("Escribe la parte real del segundo número:");
                    realPart2 = scanner.nextDouble();
                    System.out.println("Escribe la parte imaginaria del primer número:");
                    imaginaryPart1 = scanner.nextDouble();
                    System.out.println("Escribe la parte imaginaria del segundo número:");
                    imaginaryPart2 = scanner.nextDouble();
                    realComplexResult = sumar(realPart1, realPart2, imaginaryPart1, imaginaryPart2)[0];
                    imaginaryComplexResult = sumar(realPart1, realPart2, imaginaryPart1, imaginaryPart2)[1];
                    System.out.println("El número complejo resultante es: " + realComplexResult + " + " + imaginaryComplexResult + "i");
                    continue;
                case 2:
                    System.out.println("Escribe la parte real del primer número:");
                    realPart1 = scanner.nextDouble();
                    System.out.println("Escribe la parte real del segundo número:");
                    realPart2 = scanner.nextDouble();
                    System.out.println("Escribe la parte imaginaria del primer número:");
                    imaginaryPart1 = scanner.nextDouble();
                    System.out.println("Escribe la parte imaginaria del segundo número:");
                    imaginaryPart2 = scanner.nextDouble();
                    realComplexResult = restar(realPart1, realPart2, imaginaryPart1, imaginaryPart2)[0];
                    imaginaryComplexResult = restar(realPart1, realPart2, imaginaryPart1, imaginaryPart2)[1];
                    System.out.println("El número complejo resultante es: " + realComplexResult + " + " + imaginaryComplexResult + "i");
                    continue;
                case 3:
                    System.out.println("Escribe el primer número:");
                    num1 = scanner.nextDouble();
                    System.out.println("Escribe el segundo número:");
                    num2 = scanner.nextDouble();
                    System.out.println("Establece la precisión decimal con la que quieres ver el resultado:");
                    precision = scanner.nextInt();
                    resultDouble = multiplicar(num1, num2, precision);
                    break;
                case 4:
                    try {
                        System.out.println("Escribe el primer número:");
                        num1 = scanner.nextDouble();
                        System.out.println("Escribe el segundo número:");
                        num2 = scanner.nextDouble();
                        resultDouble = dividir(num1, num2, 2);
                        System.out.println("Establece la precisión decimal con la que quieres ver el resultado:");
                        precision = scanner.nextInt();
                        resultDouble = dividir(num1, num2, precision);
                    } catch (ArithmeticException e) {
                        System.out.println("No se puede dividir entre cero. Inténtelo de nuevo.");
                        continue;
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Escribe el primer número:");
                        num1 = scanner.nextDouble();
                        System.out.println("Escribe el segundo número:");
                        num2 = scanner.nextDouble();
                        resultDouble = exponentiation(num1, num2, 1);
                        System.out.println("Establece la precisión decimal con la que quieres ver el resultado:");
                        precision = scanner.nextInt();
                        resultDouble = exponentiation(num1, num2, precision);
                    }
                    catch (ArithmeticException e) {
                        System.out.println("No se puede realizar la exponenciación con números negativos y exponentes decimales. Inténtelo de nuevo.");
                        continue;
                    }
                    break;

                case 6:
                    System.out.println("Escribe el número (en grados) que quieras para calcular su seno:");
                    num1 = scanner.nextDouble();
                    System.out.println("Establece la precisión decimal con la que quieres ver el resultado:");
                    precision = scanner.nextInt();
                    resultDouble = sine(num1, precision);
                    break;

                case 7:
                    System.out.println("Escribe el número (en grados) que quieras para calcular su coseno:");
                    num1 = scanner.nextDouble();
                    System.out.println("Establece la precisión decimal con la que quieres ver el resultado:");
                    precision = scanner.nextInt();
                    resultDouble = cosine(num1, precision);
                    break;

                case 8:
                    try {
                        System.out.println("Escribe el número (en grados) que quieras para calcular su tangente:");
                        num1 = scanner.nextDouble();
                        resultDouble = tangent(num1, 1);
                        System.out.println("Establece la precisión decimal con la que quieres ver el resultado:");
                        precision = scanner.nextInt();
                        resultDouble = tangent(num1, precision);
                    }
                    catch (ArithmeticException e) {
                        System.out.println("No se puede calcular la tangente de un " +
                                "ángulo múltiplo de 90 y no múltiplo de 180. " +
                                "Inténtelo de nuevo.");
                        continue;
                    }

                    break;

                case 9:
                    try {
                        System.out.println("Escribe el número que quieras calcular su logaritmo:");
                        num1 = scanner.nextDouble();
                        resultDouble = decimalLog(num1, 1);
                        System.out.println("Establece la precisión decimal con la que quieres ver el resultado:");
                        precision = scanner.nextInt();
                        resultDouble = decimalLog(num1, precision);
                    }
                    catch (ArithmeticException e) {
                        System.out.println("No se puede calcular el logaritmo de un número negativo o cero. Inténtelo de nuevo.");
                        continue;
                    }
                    break;

                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                    continue;
            }
            System.out.println("Resultado: " + resultDouble);
        }
    }

    public static void main(String[] args) {
        calculateWithScanner(new Scanner(System.in));
    }
}
