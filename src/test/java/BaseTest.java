import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "file://" + System.getProperty("user.dir");
    }

    @AfterEach
    void teardown() {
        closeWebDriver();
    }
} 