
public class Functions {
    public static float func1(double n) {
        n = n * 100;
        int result = (int) Math.round(n);
        float result1 = (float) result / 100;
        return result1;
    }
}
