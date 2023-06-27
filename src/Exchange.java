import java.io.*;
import java.util.Properties;

class Exchange {
    private double value;
    private double exchangeRate;

    public Exchange(double value) {
        this.value = value;
        try {
            FileInputStream path;
            Properties property = new Properties();
            path = new FileInputStream("C:\\Users\\akitaru\\IdeaProjects\\CurrencyCalculator\\src\\CFG.properties");
            property.load(path);
            exchangeRate = Double.parseDouble(property.getProperty("db.exrate"));
        } catch (IOException e) {
            System.err.println("Ошибка: файла не существует");
        }
    }
    public double get_value() {
        return value;
    }
    public static values conversion(String tmp) {
        String[] prefixes = {"toDollars(", "toRoubles($"};
        String[] suffixes = {"p)", ")"};
        values[] currencies = {values.usd, values.rub};
        for (int i = 0; i < prefixes.length; i++) {
            if (tmp.startsWith(prefixes[i]) && tmp.endsWith(suffixes[i])) {
                return currencies[i];
            }
        }
        return values.other;
    }

    public Exchange toDollar() {
        System.out.print("=");
        return new Exchange(this.value * this.exchangeRate);
    }

    public Exchange toRouble() {
        System.out.print("=");
        return new Exchange(this.value / this.exchangeRate);
    }
}