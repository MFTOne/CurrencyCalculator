import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        System.out.print("Currency Calculator:\n");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("\nExpression: ");
            String expression = scanner.nextLine();
            if(expression.equals("end")) break;
            System.out.print(Exchange.conversion(expression));
            if(Exchange.conversion(expression)==values.rub){
                Exchange currencyUSD = new Exchange(Double.parseDouble(expression.replaceAll("[^\\d\\. ]","")));
                double n=(currencyUSD.toRouble().get_value());
                n=n*100;
                int result = (int)Math.round(n);
                float result1 = (float) result / 100;
                System.out.print(result1);
            }
            else if (Exchange.conversion(expression)==values.usd) {
                Exchange currencyRUB = new Exchange(Double.parseDouble(expression.replaceAll("[^\\d\\. ]","")));
                double n=(currencyRUB.toDollar().get_value());
                n=n*100;
                int result = (int)Math.round(n);
                float result1 = (float) result / 100;
                System.out.print(result1);
            }
            else System.out.print(" currency is not supported.");
        }
    }
}