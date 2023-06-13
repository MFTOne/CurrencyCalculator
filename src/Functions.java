
public class Functions {

    public static float func1(double n) {
        n = n * 100;
        int result = (int) Math.round(n);
        float result1 = (float) result / 100;
        return result1;
    }

    public static double func2(String str) {
        double sum = 0;
        String[] numbers = str.split("\\+");
            for (String number : numbers) {
                sum = sum + (Double.parseDouble(number.replaceAll("[^\\d.]", "")));
            }
        return sum;
    }

    public static double func3(String str) {
        String[] numbers = str.split("\\-");
        double[] Numbers = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            Numbers[i] = Double.parseDouble(numbers[i].replaceAll("[^\\d.]", ""));
        }
        double diff = Numbers[0];
        for (int i = 1; i <Numbers.length; i++) {
            diff -= Numbers[i];
        }
        return diff;
    }

}
