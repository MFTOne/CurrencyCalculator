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
               System.out.print(currencyUSD.toRouble().get_value());}

           else if (Exchange.conversion(expression)==values.usd) {
               Exchange currencyRUB = new Exchange(Double.parseDouble(expression.replaceAll("[^\\d\\. ]","")));
               System.out.print(currencyRUB.toDollar().get_value());
           }
           else System.out.print(" currency is not supported.");
        }
    }
}