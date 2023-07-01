import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.print("Currency Calculator:\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nExpression: ");
            String expression = scanner.nextLine();
            if (expression.equals("end")) break;
            Functions.func2(expression);
        }
    }
}
