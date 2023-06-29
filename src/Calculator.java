import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.print("Currency Calculator:\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nExpression: ");
            String expression = scanner.nextLine();
            if (expression.equals("end")) break;
            if (expression.startsWith("+") || expression.startsWith("-")) {
                System.out.print("Error");
            } else {
                System.out.print(Exchange.conversion(expression));
                if (Exchange.conversion(expression) == values.rub) {
                    if (expression.contains("+")) {
                        System.out.print(Functions.func2(expression));
                    } else if (expression.contains("-")) {
                        System.out.print(Functions.func3(expression));
                    } else if(expression.startsWith("toDollar(")&&expression.endsWith("p)")) {
                        Exchange currencyUSD = new Exchange(Double.parseDouble(expression.replaceAll("[^\\d.]","")));
                        System.out.print(Functions.func1(currencyUSD.toDollar().get_value()));
                        System.out.print("\nExchangeRate = 60");
                    }
                    else {
                        Exchange currencyRUB = new Exchange(Double.parseDouble(expression.replaceAll("[^\\d.]","")));
                        System.out.print("=");
                        System.out.print(Functions.func1(currencyRUB.get_value()));
                    }
                } else if (Exchange.conversion(expression) == values.usd) {
                    if (expression.contains("+")) {
                        System.out.print(Functions.func2(expression));
                    } else if (expression.contains("-")) {
                        System.out.print(Functions.func3(expression));
                    } else if(expression.startsWith("toRouble(")&&expression.endsWith(")")||expression.endsWith("$)")) {
                        Exchange currencyRUB = new Exchange(Double.parseDouble(expression.replaceAll("[^\\d.]","")));
                        System.out.print(Functions.func1(currencyRUB.toRouble().get_value()));
                        System.out.print("\nExchangeRate = 60");
                    }
                    else {
                        Exchange currencyUSD = new Exchange(Double.parseDouble(expression.replaceAll("[^\\d.]","")));
                        System.out.print("=");
                        System.out.print(Functions.func1(currencyUSD.get_value()));
                    }
                } else {
                    System.out.print(" currency is not supported.");
                }
            }
        }
    }
}