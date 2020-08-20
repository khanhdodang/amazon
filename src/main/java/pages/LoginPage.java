package pages;

import com.BasePage;
import objects.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import profiles.DefaultProfile;

public class LoginPage extends BasePage{
    /**
     * All WebElements are identified by @FindBy annotation
     */

    @FindBy(xpath = "//span[text()='Account & Lists']")
    WebElement txt_account_list;

    @FindBy(xpath = "//div[@id='nav-al-signin']//span[@class='nav-action-inner']")
    WebElement btn_SignIn;

    @FindBy(id = "continue")
    WebElement btn_Continue;

    @FindBy(id = "ap_email")
    WebElement tb_email;

    @FindBy(id = "ap_password")
    WebElement tb_password;

    @FindBy(name = "rememberMe")
    WebElement chkbx_keepMeSignIn;

    @FindBy(id = "signInSubmit")
    WebElement btn_Login;

    WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    /**
     * Set Email
     *
     * @param email the email value
     */
    private void setEmail(String email) {
        Reporter.log("Set Email with value: " + email);
        this.setText(tb_email, email);
    }

    /**
     * Set Password
     *
     * @param password the password value
     */
    private void setPassword(String password) {
        Reporter.log("Set Password with value: " + password);
        this.setText(tb_password, password);
    }

    /**
     * Check on Keep Me Sign In checkbox
     *
     * @param flag if the flag is true, check on the checkbox
     */
    private void checkKeepMeSignIn(boolean flag) {
        Reporter.log("Check Keep Me Sign In with the value: " + flag);
        if (flag) {
            if (!this.isElementSelected(chkbx_keepMeSignIn)) {
                this.click(chkbx_keepMeSignIn);
            }
        }
    }

    /**
     * Click Account Lists text
     */
    public void clickAccountLists() {
        Reporter.log("Click Account Lists text");
        this.waitForElementClickable(txt_account_list, DefaultProfile.WAIT_PRESENT_TIMEOUT);
        this.click(txt_account_list);
    }

    /**
     * Click Login button
     */
    public void clickLogin() {
        Reporter.log("Click Login button");
        this.waitForElementClickable(btn_Login, DefaultProfile.WAIT_PRESENT_TIMEOUT);
        this.click(btn_Login);
    }

    /**
     * Click Continue button
     */
    public void clickContinue() {
        Reporter.log("Click Continue button");
        this.waitForElementClickable(btn_Continue, DefaultProfile.WAIT_PRESENT_TIMEOUT);
        this.click(btn_Continue);
    }

    /**
     * Click SignIn button
     */
    public void clickSignIn() {
        Reporter.log("Click SignIn button");
        this.waitForElementClickable(btn_SignIn, DefaultProfile.WAIT_PRESENT_TIMEOUT);
        this.click(btn_SignIn);
    }

    /**
     * Get the current title
     */
    public String validateLoginPageTitle(){
        return this.getTitle();
    }

    public void loginToAmazon(Account account) {
        this.clickAccountLists();
        this.setEmail(account.getEmail());
        this.clickContinue();
        this.setPassword(account.getPassword());
        this.checkKeepMeSignIn(account.isKeepMeSignIn());
        this.clickLogin();
        sleep(10);
    }
}
