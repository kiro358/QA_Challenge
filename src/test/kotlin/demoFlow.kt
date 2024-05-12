import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import java.net.URL
import java.time.Duration

public class SampleTest {

    private lateinit var driver: AndroidDriver

    @BeforeEach
    fun setUp() {
        val options = UiAutomator2Options()
            .setDeviceName("emulator-5554")
            .setPlatformName("Android")
            .setAutomationName("UiAutomator2")
            .setAppPackage("com.fivemobile.thescore")
            .setAppActivity(".ui.MainActivity")
            .setNewCommandTimeout(Duration.ofSeconds(120))
            .setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(120000))
            .setNoReset(true)

        driver = AndroidDriver(URL("http://127.0.0.1:4723/"), options)
    }

    @Test
    fun demoFlow() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(30)) // 30 seconds wait
//        val element = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.fivemobile.thescore:id/action_button_text")))
//        element.click()
        var el4 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"));
        el4.click();
        var el5 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(3)"));
        el5.click();
        var el6 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(1)"));
        el6.click();
        var el7 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(2)"));
        el7.click();
        var el8 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(0)"));
        el8.click();
        var el9 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"));
        el9.click();
        var el10 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/btn_allow"));
        el10.click();
        var el11 = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
        el11.click();
        var el12 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"MLB\").instance(1)"));
        el12.click();
        var el13 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(2)"));
        el13.click();
        var el14 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"NBA\").instance(1)"));
        el14.click();
        var el15 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(4)"));
        el15.click();
        var el16 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(0)"));
        el16.click();
        el16.click();
        var el17 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(0)"));
        el17.click();
        var el18 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"));
        el18.click();
        var el19 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/selectedSwitch\").instance(3)"));
        el19.click();
        var el20 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"));
        el20.click();
        var el21 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"));
        el21.click();
        var el22 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/first_name_input_edittext"));
        el22.sendKeys("Kirolos");
        var el23 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/last_name_input_edittext"));
        el23.sendKeys("Youssef");
        var el24 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/email_input_edittext"));
        el24.sendKeys("kkikjv9@gmail.com");
        var el25 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/password_input_edittext"));
        el25.sendKeys("kiro1234");
        var el26 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"));
        el26.click();
        var el27 = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
        el27.click();
        var el28 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Ok, Got It\")"));
        el28.click();
        var el31 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/search_bar_text_view"));
        el31.click();
        var el32 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/dismiss_modal"));
        el32.click();
        var el33 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/search_src_text"));
        el33.sendKeys("mavericks");
        var el34 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Dallas Mavericks\")"));
        el34.click();
        var el35 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"PLAYER STATS\")"));
        el35.click();
        var el36 = driver.findElement(AppiumBy.accessibilityId("Navigate up"));
        el36.click();

    }

    @AfterEach
    fun tearDown() {
        driver.quit();
    }
}
