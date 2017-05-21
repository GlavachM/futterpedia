package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WasMachtFutterpediaPage extends PageObject {

    // Fields and elements
    @FindBy(css="[class='fp__nav']")
    private WebElement aboutFutterpediaLink;

    @FindBy(css="[class='fp__content']")
    public WebElement contentAboutFutterpedia;

    @FindBy(css="h1")
    public WebElement headerText;

    @FindBy(css="[rel='nofollow']")
    private WebElement imprint;

    @FindBy(xpath="(//a[@rel='nofollow'])[1]")
    public WebElement facebookPluginsLink;

    @FindBy(xpath="(//a[@rel='nofollow'])[2]")
    public WebElement privacyLink;

    @FindBy(xpath="(//a[@rel='nofollow'])[3]")
    public WebElement twitterLink;

    @FindBy(xpath="(//a[@rel='nofollow'])[4]")
    public WebElement twitterAcountLink;

    //Methods
    public void moveToFutterpediaTutorial(){
        this.aboutFutterpediaLink.click();
    };

    public void moveToImprint(){
        this.moveToFutterpediaTutorial();
        this.imprint.click();
    }


    //Constructor
    public WasMachtFutterpediaPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.futterpedia.de/");
    };

}