import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        System.out.print("Currency Calculator:\n");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("\nExpression: ");
            String expression = scanner.nextLine();
            if(expression.equals("end")) break;
            if (expression.startsWith("+")||expression.startsWith("-")) {
                System.out.print("Error");
            }
            else{
                if(expression.contains("p")&&expression.contains("$")){
                    System.out.print("Error");
                }
                else{
                    System.out.print(Exchange.conversion(expression));
                    if(Exchange.conversion(expression)==values.usd){
                        if(expression.contains("+")){
                            Functions.func2(expression);
                            Exchange currencyUSD = new Exchange(Functions.func2(expression));
                            System.out.print(Functions.func1(currencyUSD.toRouble().get_value()));
                        }
                        else if(expression.contains("-")){
                            Functions.func3(expression);
                            Exchange currencyUSD = new Exchange(Functions.func3(expression));
                            System.out.print(Functions.func1(currencyUSD.toRouble().get_value()));
                        }
                        else {
                            Exchange currencyUSD = new Exchange(Double.parseDouble(expression.replaceAll("[^\\d.]","")));
                            System.out.print(Functions.func1(currencyUSD.toRouble().get_value()));
                        }
                    }
                    else if (Exchange.conversion(expression)==values.rub) {
                        if(expression.contains("+")){
                            Functions.func2(expression);
                            Exchange currencyRUB = new Exchange(Functions.func2(expression));
                            System.out.print(Functions.func1(currencyRUB.toDollar().get_value()));
                        }
                        else if(expression.contains("-")){
                            Functions.func3(expression);
                            Exchange currencyRUB = new Exchange(Functions.func3(expression));
                            System.out.print(Functions.func1(currencyRUB.toDollar().get_value()));
                        }
                        else {
                            Exchange currencyRUB = new Exchange(Double.parseDouble(expression.replaceAll("[^\\d.]","")));
                            System.out.print(Functions.func1(currencyRUB.toDollar().get_value()));
                        }
                    }
                    else System.out.print(" currency is not supported.");
                }
            }
        }
    }
}
