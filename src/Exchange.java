import java.io.*;
import java.util.Properties;

public class Exchange {
    protected double value;
    protected double exchange_rate;
    public Exchange(double value) {
        this.value = value;
        try{
            FileInputStream path;
            Properties property = new Properties();
            path =new FileInputStream ("C:\\Users\\akitaru\\IdeaProjects\\CurrencyCalculator\\src\\CFG.properties");
            property.load(path);
            exchange_rate=Double.parseDouble(property.getProperty("db.exrate"));
        } catch (IOException e) {
            System.err.println("Ошибка: файла не существует");
        }
    }
    public double get_value(){
        return value;
    }
    public static values conversion(String tmp) {
        if (tmp.indexOf('$') != -1) return values.usd;
        else if (tmp.indexOf('p')!=-1) return values.rub;
        else return values.other;
    }

    public Exchange toDollar(){
        System.out.print(" to usd = ");
        return new Exchange(this.value / this.exchange_rate);
    }
    public Exchange toRouble(){
        System.out.print(" to rub = ");
        return new Exchange(this.value * this.exchange_rate);
    }
}
