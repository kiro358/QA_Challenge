import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.net.URL
import java.time.Duration
import java.util.*
import java.util.stream.Stream

class SampleTest {
    private lateinit var driver: AndroidDriver
    private lateinit var wait: WebDriverWait

    // Sets up the Appium driver before each test
    @BeforeEach
    fun setUp() {
        configureDriver()
    }

    // Configures the Appium driver with options for the Android device and app
    private fun configureDriver() {
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
        wait = WebDriverWait(driver, Duration.ofSeconds(30)) /* 30 seconds wait */
    }

    // Provides data for the parameterized tests
    companion object {
        @JvmStatic
        fun inputData(): Stream<Arguments> = Stream.of(
            Arguments.of("Kirolos", "Youssef", "kirolos358@gmail.com", "1", "Raptors", "Toronto Raptors"),
            Arguments.of("Another", "User", generateRandomEmail(), "anotherPassword", "Mavericks", "Dallas Mavericks")
        )

        // Generates a random email for testing purposes
        private fun generateRandomEmail(): String {
            val uuidString = UUID.randomUUID().toString()
            return "test_$uuidString@gmail.com"
        }
    }

    // Navigates to the sign-up page of the app
    private fun navigateToSignUp() {
        val continueBtn =
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.fivemobile.thescore:id/action_button_text")))
        continueBtn.click()
        val nba =
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(3)")))
        nba.click()
        val nfl =
            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(1)"))
        nfl.click()
        val mlb =
            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(2)"))
        mlb.click()
        val nhl =
            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(0)"))
        nhl.click()
        val continueBtn2 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"))
        continueBtn2.click()
        // Permissions handling
        handlePermissions()
        val mlbSub =
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"MLB\").instance(1)")))
        mlbSub.click()
        val yankees =
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(2)")))
        yankees.click()
        val nbaSub = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"NBA\").instance(1)"))
        nbaSub.click()
        val raptors =
            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(4)"))
        raptors.click()
        val celtics =
            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/follow_icon\").instance(0)"))
        celtics.click()
        celtics.click()
        celtics.click()
        val continueBtn3 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"))
        continueBtn3.click()
        val scoringUpdates =
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/selectedSwitch\").instance(3)")))
        scoringUpdates.click()
        val continueBtn4 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"))
        continueBtn4.click()
        val emailSignUp = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"))
        emailSignUp.click()
    }

    // Handles location permissions
    private fun handlePermissions() {
        val allowLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.fivemobile.thescore:id/btn_allow")))
        allowLocation.click()
        val whileUsing = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")))
        whileUsing.click()
    }

    // Fills and submits the sign-up form
    private fun fillAndSubmitSignUpForm(firstName: String, lastName: String, email: String, password: String) {
        val fnameField = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/first_name_input_edittext"))
        fnameField.sendKeys(firstName)
        val lnameField = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/last_name_input_edittext"))
        lnameField.sendKeys(lastName)
        val emailField = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/email_input_edittext"))
        emailField.sendKeys(email)
        val pwField = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/password_input_edittext"))
        pwField.sendKeys(password)
        if (password == "1") {
            pwField.sendKeys("password123")
        }
        val submit = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text"))
        submit.click()
        if (email == "kirolos358@gmail.com") {
            val randomEmail = generateRandomEmail()
            val ok = driver.findElement(AppiumBy.id("android:id/button1"))
            ok.click()
            emailField.sendKeys(randomEmail)
            submit.click()
        }
    }

    // Clicks on visible elements if they are present, used for optional interactions
    private fun clickIfVisible(by: By) {
        try {
            val element = wait.until(ExpectedConditions.visibilityOfElementLocated(by))
            element.click()
        } catch (e: Exception) {
            println("Element not visible or not present; skipping interaction: ${e.message}")
        }
    }

    // Searches for a team and navigates to its page
    private fun searchTeam(team: String, teamName: String) {
        val allow =
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")))
        allow.click()
        clickIfVisible(AppiumBy.androidUIAutomator("new UiSelector().text(\"Ok, Got It\")") as AppiumBy)

        val searchBar =
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.fivemobile.thescore:id/search_bar_text_view")))
        searchBar.click()

        clickIfVisible(AppiumBy.id("com.fivemobile.thescore:id/dismiss_modal") as AppiumBy)
        val searchField =
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.fivemobile.thescore:id/search_src_text")))
        searchField.sendKeys(team)
        val searchText =
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"$teamName\")")))
        searchText.click()
    }

    // Verifies the presence of player stats and navigates back
    private fun verifyAndGoBack(teamName: String) {
        val stats =
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"PLAYER STATS\")")))
        stats.click()
        val back = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up")))
        back.click()
        assert(wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"$teamName\")"))).isDisplayed)
    }

    // Executes the test flow with given parameters
    @ParameterizedTest
    @MethodSource("inputData")
    fun demoFlow(firstName: String, lastName: String, email: String, password: String, team: String, teamName: String) {
            navigateToSignUp()
            fillAndSubmitSignUpForm(firstName, lastName, email, password)
            searchTeam(team, teamName)
            verifyAndGoBack(teamName)
    }

    // Cleans up after each test by closing the driver
    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}
