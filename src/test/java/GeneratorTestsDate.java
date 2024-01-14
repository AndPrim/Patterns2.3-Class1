import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.s;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class GeneratorTestsDate {
    GeneratorTestsDate() {
    }
    private static Faker faker = new Faker(new Locale("ru"));

    public static String GeherateTestsDate(int day){
        return LocalDate.now().plusDays(day).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    public static String GeherateTestsCity(String locale) {
//        Stream<String> citys = Stream.of("Челябинск","Москва","Казань","Курган","Уфа","Рязань");
//        Optional<R> any = citys.map(s::toString).findAny();
//        return any;
        String[] str = new String[]{"Челябинск","Москва","Казань","Курган","Уфа","Рязань"};
        return str[new Random().nextInt(str.length)];
    }

    public static String GenerateTestsName(){
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String GenerateTestsPhone() {
        return faker.phoneNumber().phoneNumber();
    }

}
