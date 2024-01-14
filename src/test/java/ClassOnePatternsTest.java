import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ClassOnePatternsTest {


    @BeforeEach
    void setUpAll() {
        open("http://localhost:9999/");
    }
    GeneratorTestsDate geTeDa = new GeneratorTestsDate();

    @Test
    void deliveryCardTest() {
        String meetingDate = geTeDa.GeherateTestsDate(7);
        String newMeetingData = geTeDa.GeherateTestsDate(10);

        $("[data-test-id=city] input").setValue(geTeDa.GeherateTestsCity("ru"));
//        String date = dateGenerate(5, "dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME),
                Keys.DELETE);
        $("[data-test-id='date'] input").setValue(meetingDate);
        $("[data-test-id='name'] input").setValue(geTeDa.GenerateTestsName());
        $("[data-test-id='phone'] input").setValue(geTeDa.GenerateTestsPhone());
        $("[data-test-id='agreement']").click();
        $(".button").click();
        $(".notification__title")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(text("Успешно!"));
        $(".notification__content")
                .shouldHave(text("Встреча успешно запланирована на " + meetingDate));
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(newMeetingData);
        $(".button").click();
        $("[data-test-id='replan-notification'] span.button__text").click();
        $(".button").click();
        $("[data-test-id='replan-notification']")
                .shouldHave(text("У вас уже запланирована встреча на другую дату." + " Перепланировать?"));
        $(byText("Перепланировать")).click();
        $("[data-test-id='success-notification']")
                .shouldHave(text("Встреча успешно запланирована на " + newMeetingData));
    }
}

