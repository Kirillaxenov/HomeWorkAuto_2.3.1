import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    Faker faker = new Faker(new Locale("ru"));


    private Random random = new Random();
    private String[] cities = {"Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань", "Белгород", "Курск", "Барнаул", "Нарьян-Мар"};

    public String generateCityName() {
        int index = random.nextInt(cities.length);
        return cities[index];
    }

    public String generateFullName() {
        return faker.name().fullName();
    }

    public String generatePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public String generateDate(long addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    String planningDate = generateDate(4, "dd.MM.yyyy");
    String futureDate = generateDate(5, "dd.MM.yyyy");
}
