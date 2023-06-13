
public class Functions {

    public static float func1(double n) {
        n = n * 100;
        int result = (int) Math.round(n);
        float result1 = (float) result / 100;
        return result1;
    }

    public static double func2(String str) {
        double sum=0;
        String[]numbers=str.split("\\+");
        for(String number : numbers){
          sum=sum+(Double.parseDouble(number.replaceAll("[^\\d.]","")));
        }
        return sum;
    }

    public static double func3(double value1, double value2) {
        double sub = 0;
        sub = value1 - value2;
        return sub;
    }

}
