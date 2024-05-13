import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.net.URL
import java.time.Duration
import java.util.UUID

class SampleTest {

    private lateinit var driver: AndroidDriver

    private fun generateRandomEmail(): String {
        val uuidString = UUID.randomUUID().toString()
        return "test_$uuidString@gmail.com"
    }

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
//            .setNoReset(true)

        driver = AndroidDriver(URL("http://127.0.0.1:4723/"), options)
    }

    @Test
    fun demoFlow() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(30)) // 30 seconds wait
        val email = generateRandomEmail()
        val el4 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.fivemobile.thescore:id/action_button_text")))
//        var el4 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"));
        el4.click()
        val el5 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(3)")))
        el5.click()
        val el6 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(1)"))
        el6.click()
        val el7 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(2)"))
        el7.click()
        val el8 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(0)"))
        el8.click()
        val el9 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"))
        el9.click()
        val el10 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.fivemobile.thescore:id/btn_allow")))
        el10.click()
        val el11 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")))
        el11.click()
        val el12 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"MLB\").instance(1)")))
        el12.click()
        val el13 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(2)")))
        el13.click()
        val el14 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"NBA\").instance(1)"))
        el14.click()
        val el15 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(4)"))
        el15.click()
        val el16 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(0)"))
        el16.click()
        el16.click()
        val el17 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(0)"))
        el17.click()
        val el18 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"))
        el18.click()
        val el19 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/selectedSwitch\").instance(3)")))
        el19.click()
        val el20 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"))
        el20.click()
        val el21 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"))
        el21.click()
        val el22 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/first_name_input_edittext"))
        el22.sendKeys("Kirolos")
        val el23 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/last_name_input_edittext"))
        el23.sendKeys("Youssef")
        val el24 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/email_input_edittext"))
        el24.sendKeys(email)
        val el25 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/password_input_edittext"))
        el25.sendKeys("password123")
        val el26 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"))
        el26.click()
        val el27 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")))
        el27.click()
//        var el28 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Ok, Got It\")")));
//        el28.click();
        val el31 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.fivemobile.thescore:id/search_bar_text_view")))
        el31.click()
//        var el32 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.fivemobile.thescore:id/dismiss_modal")));
//        el32.click();
        val el33 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/search_src_text"))
        el33.sendKeys("mavericks")
        val el34 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Dallas Mavericks\")"))
        el34.click()
        val el35 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"PLAYER STATS\")"))
        el35.click()
        val el36 = driver.findElement(AppiumBy.accessibilityId("Navigate up"))
        el36.click()

    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}
