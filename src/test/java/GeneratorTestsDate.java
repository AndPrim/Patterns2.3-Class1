import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class GeneratorTestsDate {
    private GeneratorTestsDate() {
    }
    private static Faker faker = new Faker(new Locale("ru"));

    public static String geherateTestsDate(int day){
        return LocalDate.now().plusDays(day).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    public static String geherateTestsCity(String locale) {
        String[] str = new String[]{"Челябинск","Москва","Казань","Курган","Уфа","Рязань"};
        return str[new Random().nextInt(str.length)];
    }

    public static String generateTestsName(){
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generateTestsPhone() {
        return faker.phoneNumber().phoneNumber();
    }

}
