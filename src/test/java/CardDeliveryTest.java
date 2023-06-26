import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {


    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
        open("http://localhost:9999/");

    }

    @Test
    void shouldSomethingTest(){
        DataGenerator dataGenerator = new DataGenerator();
        $("[data-test-id=city] input").setValue(dataGenerator.generateCityName());
        $("[data-test-id=date] input").doubleClick().sendKeys(dataGenerator.planningDate);
        $("[data-test-id=name] input").setValue(dataGenerator.generateFullName());
        $("[data-test-id=phone] input").setValue(dataGenerator.generatePhoneNumber());
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();
        $(new ByText("Успешно!")).shouldBe(visible);
        $(".notification__content").shouldHave(exactText("Встреча успешно запланирована на " + dataGenerator.planningDate));
        $(By.className("button")).click();
        $("[data-test-id=date] input").doubleClick().sendKeys(dataGenerator.futureDate);
        $(By.className("button")).click();
        $(new ByText("Перепланировать")).click();
        $(".notification__content").shouldHave(exactText("Встреча успешно запланирована на " + dataGenerator.futureDate));

    }
}