import java.io.*;
import java.util.Properties;

public class Exchange {
    protected double exchange_rate;
    protected double value;

    public Exchange(double value) {
        this.value = value;
        FileInputStream path;
        Properties properties = new Properties();
        try{
            path= new FileInputStream("C:\\Users\\akitaru\\IdeaProjects\\CurrencyCalculator\\src\\Configuration.properties\"");
            properties.load(path);
            exchange_rate=Double.parseDouble(properties.getProperty("db.exrate"));
        } catch (IOException e) {
            System.err.println("Ошибка: файла не существует");
        }
    }

    public double get_value(){
        return value;
    }
    public static values conversion(String tmp) {
        if (tmp.indexOf('$') != -1)
            return values.usd;
        else return values.rub;


    }
    public Exchange toDollar(){
        return new Exchange(this.value/this.exchange_rate);
    }

    public Exchange toRouble(){
        return new Exchange(this.value * this.exchange_rate);
    }

}
