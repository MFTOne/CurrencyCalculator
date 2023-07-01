public class Functions {
    public static float func1(double n) {
        n = n * 100;
        int result = (int) Math.round(n);
        float result1 = (float) result / 100;
        return result1;
    }
    public static double func2(String str) {
        String a = "Error",curr="";
        String[] additionParts = str.split("\\+");
        double total = 0;
        for (String part : additionParts) {
            String[] subtractionParts = part.split("-");
            double partTotal = 0;
            boolean isFirstSubtractionPart = true;
            for (String subPart : subtractionParts) {
                String trimmedExpression = subPart.trim();
                if (trimmedExpression.startsWith("+") || trimmedExpression.startsWith("-")) {
                    System.out.print("Error");
                } else {
                    if (trimmedExpression.startsWith("toDollar(") && trimmedExpression.endsWith("p)") ||
                            trimmedExpression.startsWith("toDollar(") && trimmedExpression.endsWith("р)")) {
                        Exchange currencyUSD = new Exchange(Double.parseDouble(trimmedExpression.replaceAll("[^\\d.]", "")));
                        double value = currencyUSD.toDollar().get_value();
                        if (isFirstSubtractionPart) {
                            partTotal += value;
                        } else {
                            partTotal -= value;
                        }
                        a = "Conversion to usd: ";
                    } else if (trimmedExpression.startsWith("toRouble(") && trimmedExpression.endsWith("$)")) {
                        Exchange currencyRUB = new Exchange(Double.parseDouble(trimmedExpression.replaceAll("[^\\d.]", "")));
                        double value = currencyRUB.toRouble().get_value();
                        if (isFirstSubtractionPart) {
                            partTotal += value;
                        } else {
                            partTotal -= value;
                        }
                        a = "Conversion to rub: ";
                    } else if (trimmedExpression.contains("p")||trimmedExpression.contains("р")){
                        Exchange currencyRUB = new Exchange(Double.parseDouble(trimmedExpression.replaceAll("[^\\d.]", "")));
                        double value = currencyRUB.get_value();
                        if (isFirstSubtractionPart) {
                            partTotal += value;
                        } else {
                            partTotal -= value;
                        }
                        a = "Sum:";
                        curr=" rub";

                    }else if (trimmedExpression.contains("$")){
                        Exchange currencyUSD = new Exchange(Double.parseDouble(trimmedExpression.replaceAll("[^\\d.]", "")));
                        double value = currencyUSD.get_value();
                        if (isFirstSubtractionPart) {
                            partTotal += value;
                        } else {
                            partTotal -= value;
                        }
                        a = "Sum:";
                        curr=" usd";

                    }
                }
                isFirstSubtractionPart = false;
            }
            total += partTotal;
        }
        if(a.equals("Error")){
            System.out.print(a);
        }
        else if(curr.equals(" rub")){
        System.out.print(a+Functions.func1(total)+curr);}
        else if(curr.equals(" usd")){
            System.out.print(a+Functions.func1(total)+curr);}
        else System.out.print(a+Functions.func1(total));
        return Functions.func1(total);
    }
}