package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import common.Helper;

import java.util.List;
import java.util.Random;

public class FoodPetPage extends PageObject {

    private final Helper helper;
    private final PetPage petPage;
    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Fields
    @FindBy(xpath = "(//h2/span)[1]")
    public WebElement petName;

    @FindBy(css = "[class='fpw-widget__progressbar'] li")
    public List <WebElement> elementListProgressBar;

    @FindBy(css = "[name='brand']")
    public WebElement foodBrand;

    @FindBy(css = "[name='feed']")
    public WebElement varietyOfFood;

    @FindBy(xpath = "(//*[@class='ft__scale-select'])[2]")
    public WebElement  foodUseNavigationBar;

    @FindBy(xpath = "(//*[@class='ft__scale-select'])[2]/li")
    public List <WebElement> howLongYouUseThisFood;

    @FindBy(xpath =  "(//*[@class='ft__scale-select'])[3]")
    public WebElement howOftenYouBuyThisFoofNavBar;

    @FindBy(xpath = "(//*[@class='ft__scale-select'])[3]/li")
    public List <WebElement> howOftenYouBuyThisFood;

    @FindBy (css = "[id='s2id_autogen3']")
    public WebElement howDidYouKnowAboutThisDropDown;

    @FindBy(xpath = "(//*[@class='select2-results'])[2]")
    public List <WebElement> dropDownList;

    @FindBy(css = "[name='source_select']")
    public WebElement dropDownSelect;

    @FindBy(css = "[name='source']")
    public WebElement otherInputField;

    @FindBy(xpath = "(//*[@class='fpw-widget__subtitle'])[5]")
    public WebElement messageAboveDropDown;

    @FindBy(xpath = "(//*[@class='fpw-widget__star-list'])[1]/li")
    private List <WebElement> OverallSatisfactionStars;

    @FindBy(xpath = "(//*[@class='fpw-widget__table-list__column fpw-widget__table-list__column--3'])[5]")
    public WebElement valuationOfOverallSatisfaction;

    @FindBy(xpath = "(//*[@class='fpw-widget__star-list'])[2]/li")
    private List <WebElement> pricePerformanceRatio;

    @FindBy(xpath = "(//*[@class='fpw-widget__table-list__column fpw-widget__table-list__column--3'])[6]")
    public WebElement valuationOfPricePerformanceRatio;

    @FindBy(xpath = "(//*[@class='fpw-widget__star-list'])[3]/li")
    private List <WebElement> compositionOfTheFeedStars;

    @FindBy(xpath = "(//*[@class='fpw-widget__table-list__column fpw-widget__table-list__column--3'])[7]")
    public WebElement valuationCompositionOfTheFeed;

    @FindBy(xpath = "(//ul[@class='ft__scale-select'])[4]/li")
    public List <WebElement> wouldYouRecommendThisFoodNavBar;

    @FindBy(css = "[name='comment']")
    public WebElement commentField;

    @FindBy(css = "[class='ftreview-x-controls ftw-widget-controls fpw-button--no-arrow ftw-widget-controls--thin']")
    public WebElement addBtn;

    @FindBy(xpath = "(//label)[8]")
    private WebElement yesRadioBtn;

    @FindBy(xpath = "(//label)[10]")
    private WebElement sirRadioBtn;

    @FindBy(css ="[name='ts-firstname']")
    private WebElement firstName;

    @FindBy(css ="[name='ts-lastname']")
    private  WebElement lastName;

    @FindBy(css = "[name='ts-address']")
    private  WebElement address;

    @FindBy(css = "[name='ts-postcode']")
    private WebElement postCode;

    @FindBy(css ="[name='ts-city']")
    private WebElement city;

    @FindBy(css="[name='ts-phone']")
    private WebElement phoneNumber;

    @FindBy(css = "[name='ts-email']")
    private WebElement email;

    @FindBy(xpath = "(//*[@class='fpw-widget-controls-flow fpw-widget-controls-next'])[2]")
    public WebElement fergitBtn;

    @FindBy(xpath = "//*[text()='Pflichtfeld: Vorname']")
    public WebElement requiredFirstName;

    @FindBy(xpath = "//*[text()='Vorname sollte > 1 Zeichen lang sein']")
    public WebElement shortNameMessage;

    @FindBy(xpath = "//*[text()='Pflichtfeld: Nachname']")
    public WebElement requiredLastName;

    @FindBy(xpath = "//*[text()='Nachname sollte > 1 Zeichen lang sein']")
    public WebElement shortLastNameMessage;

    @FindBy(xpath = "//*[text()='Pflichtfeld: Straße + Nr.']")
    public WebElement requiredAddress;

    @FindBy(xpath = "//*[text()='Straße + Nr. sollte > 4 Zeichen lang sein']")
    public WebElement shortAddressMessage;

    @FindBy(xpath = "//*[text()='Pflichtfeld: Postleitzahl']")
    public WebElement requiredPostCode;

    @FindBy(xpath = "//*[text()='Postleitzahl sollte > 3 Zeichen lang sein']")
    public WebElement shortPostCodeMessage;

    @FindBy(xpath = "//*[text()='Pflichtfeld: Ort']")
    public WebElement requiredCity;

    @FindBy(xpath = "//*[text()='Ort sollte > 1 Zeichen lang sein']")
    public WebElement shortCityMessage;

    @FindBy(xpath = "//*[text()='Dieses Feld ist zwingend erforderlich.']")
    public WebElement requiredPhone;

    @FindBy(xpath = "//*[text()='Es sind nur Zahlen erlaubt. Die Telefonnummer ist zu kurz oder zu lang']")
    public WebElement shortPhoneNumberMessage;

    @FindBy(xpath = "//*[text()='Pflichtfeld: E-Mail-Adresse']")
    public WebElement requiredEmail;

    @FindBy(xpath = "(//label)[9]")
    private WebElement noRadioBtn;

    @FindBy(css ="[name='email']")
    private  WebElement emailField;

    @FindBy(xpath = "(//*[@class='fpw-widget__step__block'])[17]")
    public WebElement foodList;



    //Methods
    public void getFoodPage(String dogName, String breedOfDog){
       petPage.goToFoodPage(dogName, breedOfDog);
    }

    public void getNameFood (String dogName, String breedOfDog){
       String randomChar = randomAlphaNumeric(1);
        petPage.goToFoodPage(dogName, breedOfDog);
        this.foodBrand.sendKeys(randomChar);
        helper.sleep(1000);
        this.foodBrand.sendKeys(Keys.ARROW_DOWN);
        this.foodBrand.sendKeys(Keys.ENTER);
        helper.sleep(1000);
    }

    private static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*alphabet.length());
            builder.append(alphabet.charAt(character));
        }
        return builder.toString();
    }

    public void getVarietyOfFood (String dogName, String breedOfDog){
        this.getNameFood(dogName, breedOfDog);
        this.varietyOfFood.sendKeys("A");
        helper.sleep(1000);
        this.varietyOfFood.sendKeys(Keys.ARROW_DOWN);
        this.varietyOfFood.sendKeys(Keys.ENTER);
        helper.sleep(1000);
    }

    public void navigationBarForHowLongYouUseThisFood (String dogName, String breedOfDog){
        this.getVarietyOfFood(dogName, breedOfDog);
    }

    private void getRandomlyValueForNavBarHowLongYouUseThisFood() {
        Random randomDay = new Random();
        WebElement randomValue = howLongYouUseThisFood.get(randomDay.nextInt(howLongYouUseThisFood.size()));
        randomValue.click();
    }

    public void navigateToHowOftenYouUseThisFoodNavBar(String dogName, String breedOfDog){
        this.getVarietyOfFood(dogName, breedOfDog);
        this.getRandomlyValueForNavBarHowLongYouUseThisFood();
        helper.sleep(1000);
    }

    public void getRandomlyValueForHowOftenYouUseThisFoodNavBar(){
        Random randomDay = new Random();
        WebElement randomValue = howOftenYouBuyThisFood.get(randomDay.nextInt(howOftenYouBuyThisFood.size()));
        randomValue.click();
    }

    public void navigateToDropDown (String dogName, String breedOfDog){
        this.navigateToHowOftenYouUseThisFoodNavBar(dogName, breedOfDog);
        this.getRandomlyValueForHowOftenYouUseThisFoodNavBar();
    }

    public void selectFirstValueFromDropDown (){
        helper.waitForElement(this.howDidYouKnowAboutThisDropDown,5000);
        this.howDidYouKnowAboutThisDropDown.click();
        Select valueFromDropDown = new Select(this.dropDownSelect);
        valueFromDropDown.selectByVisibleText("Familie / Freunde");
    }

    public void selectSecondValueFromDropDown (){
        helper.waitForElement(this.howDidYouKnowAboutThisDropDown,5000);
        this.howDidYouKnowAboutThisDropDown.click();
        Select valueFromDropDown = new Select(this.dropDownSelect);
        valueFromDropDown.selectByVisibleText("TV / Radio / Zeitschrift");
    }

    public void selectThirdValueFromDropDown () /*throws InterruptedException*/{
        /*Thread.sleep(500);*/
        helper.waitForElement(this.howDidYouKnowAboutThisDropDown,5000);
        this.howDidYouKnowAboutThisDropDown.click();
        Select valueFromDropDown = new Select(this.dropDownSelect);
        valueFromDropDown.selectByVisibleText("Gekauft und getestet");
    }

    public void selectFourthValueFromDropDown (){
        helper.waitForElement(this.howDidYouKnowAboutThisDropDown,5000);
        this.howDidYouKnowAboutThisDropDown.click();
        Select valueFromDropDown = new Select(this.dropDownSelect);
        valueFromDropDown.selectByVisibleText("Züchter");
    }

    public void selectFifthValueFromDropDown (){
        helper.waitForElement(this.howDidYouKnowAboutThisDropDown,5000);
        this.howDidYouKnowAboutThisDropDown.click();
        helper.sleep(500);
        Select valueFromDropDown = new Select(this.dropDownSelect);
        valueFromDropDown.selectByVisibleText("Sonstiges");
        helper.sleep(1000);
        String value = randomAlphaNumeric(1);
        this.otherInputField.sendKeys(value);
        helper.sleep(1000);
        this.otherInputField.sendKeys(Keys.ARROW_DOWN);
        this.otherInputField.sendKeys(Keys.ENTER);
    }

    public void selectRandomlyValueFromDropDown ()/* throws InterruptedException*/{
        helper.waitForElement(this.howDidYouKnowAboutThisDropDown,5000);
        this.howDidYouKnowAboutThisDropDown.click();
        helper.sleep(500);
        Select valueFromDropDown = new Select(this.dropDownSelect);
        Random random = new Random();
        List <WebElement> dropDownList = valueFromDropDown.getOptions();
        int countOfValue = dropDownList.size();
        int OptionByValueRandomly = random.nextInt(countOfValue);
        System.out.println("OptionByValueRandomly: " +OptionByValueRandomly);
        if(OptionByValueRandomly == 0){
            valueFromDropDown.selectByIndex(1);
        }
        else if(OptionByValueRandomly == dropDownList.size()-1) {
            valueFromDropDown.selectByIndex(3);
        }
        else{
            valueFromDropDown.selectByIndex(OptionByValueRandomly);
        }
     }

     public void navigateToOverallSatisfactionStars (String dogName, String breedOfDog){
        this.navigateToDropDown(dogName, breedOfDog);
        this.selectRandomlyValueFromDropDown();
     }

     public void selectFirstStarOfOverallSatisfaction (){
        helper.waitForElement(this.OverallSatisfactionStars.get(0),5000);
        this.OverallSatisfactionStars.get(0).click();
     }

     public void selectSecondStarOfOverallSatisfaction (){
         helper.waitForElement(this.OverallSatisfactionStars.get(1),5000);
         this.OverallSatisfactionStars.get(1).click();
     }

     public void selectThirdStarOfOverallSatisfaction (){
         helper.waitForElement(this.OverallSatisfactionStars.get(2),5000);
         this.OverallSatisfactionStars.get(2).click();
     }

     public void selectFourthStarOfOverallSatisfaction (){
         helper.waitForElement(this.OverallSatisfactionStars.get(3),5000);
         this.OverallSatisfactionStars.get(3).click();
     }

     public void selectFifthStarOfOverallSatisfaction (){
         helper.waitForElement(this.OverallSatisfactionStars.get(4),5000);
         this.OverallSatisfactionStars.get(4).click();
     }

     public void selectFirstStarOfPricePerformanceRatio (){
         helper.waitForElement(this.pricePerformanceRatio.get(0),5000);
         this.pricePerformanceRatio.get(0).click();
     }

     public void selectSecondStarOfPricePerformanceRatio (){
         helper.waitForElement(this.pricePerformanceRatio.get(1),5000);
         this.pricePerformanceRatio.get(1).click();
     }

     public void selectThirdStarOfPricePerformanceRatio(){
         helper.waitForElement(this.pricePerformanceRatio.get(2),5000);
         this.pricePerformanceRatio.get(2).click();
     }

     public void selectFourthStarOfPricePerformanceRatio (){
         helper.waitForElement(this.pricePerformanceRatio.get(3),5000);
         this.pricePerformanceRatio.get(3).click();
     }

     public void selectFifthStarOfPricePerformanceRatio (){
         helper.waitForElement(this.pricePerformanceRatio.get(4),5000);
         this.pricePerformanceRatio.get(4).click();
     }

     public void selectFirstStarOfcompositionOfTheFeed (){
         helper.waitForElement(this.compositionOfTheFeedStars.get(0),5000);
        this.compositionOfTheFeedStars.get(0).click();
     }

     public void selectSecondStarOfcompositionOfTheFeed (){
         this.compositionOfTheFeedStars.get(1).click();
     }

     public void selectThirdStarOfcompositionOfTheFeed (){
         helper.waitForElement(this.compositionOfTheFeedStars.get(2),5000);
         this.compositionOfTheFeedStars.get(2).click();
     }

     public void selectFourtStarOfcompositionOfTheFeed (){
         helper.waitForElement(this.compositionOfTheFeedStars.get(3),5000);
         this.compositionOfTheFeedStars.get(3).click();
     }

     public void selectFifthStarOfcompositionOfTheFeed (){
         helper.waitForElement(this.compositionOfTheFeedStars.get(4),5000);
         this.compositionOfTheFeedStars.get(4).click();
     }

     private void selectRandomlyStarOfOverallSatisfaction(){
         Random randomDay = new Random();
         WebElement randomValue = OverallSatisfactionStars.get(randomDay.nextInt(OverallSatisfactionStars.size()));
         randomValue.click();
     }
     private void selectRandomlyStarOfPricePerformanceRatio (){
         Random randomDay = new Random();
         WebElement randomValue = pricePerformanceRatio.get(randomDay.nextInt(pricePerformanceRatio.size()));
         randomValue.click();
     }

     private void selectRandomlyStarOfcompositionOfTheFeed (){
         Random randomDay = new Random();
         WebElement randomValue = compositionOfTheFeedStars.get(randomDay.nextInt(compositionOfTheFeedStars.size()));
         randomValue.click();
     }

     public void navigateToWouldYouRecommendThisFoodNavBar(String dogName, String breedOfDog){
         this.navigateToDropDown(dogName, breedOfDog);
         this.selectRandomlyValueFromDropDown();
         this.selectRandomlyStarOfOverallSatisfaction();
         this.selectRandomlyStarOfPricePerformanceRatio();
         this.selectRandomlyStarOfcompositionOfTheFeed();
         helper.sleep(500);
     }

     private void selectRandomlyValueFromWouldYouRecommendThisFoodNavBar()/* throws InterruptedException*/{
         Random randomDay = new Random();
         WebElement randomValue = wouldYouRecommendThisFoodNavBar.get(randomDay.nextInt(wouldYouRecommendThisFoodNavBar.size()));
         helper.waitForElement(randomValue,5000);
         randomValue.click();
     }

    public void navirateToCommentField(String dogName, String breedOfDog){
        this.navigateToDropDown(dogName, breedOfDog);
        this.selectRandomlyValueFromDropDown();
        this.selectRandomlyStarOfOverallSatisfaction();
        this.selectRandomlyStarOfPricePerformanceRatio();
        this.selectRandomlyStarOfcompositionOfTheFeed();
        helper.sleep(500);
        this.selectRandomlyValueFromWouldYouRecommendThisFoodNavBar();
        helper.sleep(500);
    }

    public void writeComment(String comment){
        this.commentField.click();
        this.commentField.sendKeys(comment);
        helper.sleep(500);
    }

    public void navigateToOwnAddressData (String dogName, String breedOfDog){
        String comment = "Best food for my cat.";
        this.navigateToDropDown(dogName, breedOfDog);
        this.selectRandomlyValueFromDropDown();
        this.selectRandomlyStarOfOverallSatisfaction();
        this.selectRandomlyStarOfPricePerformanceRatio();
        this.selectRandomlyStarOfcompositionOfTheFeed();
        this.selectRandomlyValueFromWouldYouRecommendThisFoodNavBar();
        this.writeComment(comment);
        helper.waitForElement(this.yesRadioBtn,5000);
        this.yesRadioBtn.click();
    }

    public void fillInAllTheFields(){
        helper.waitForElement(this.sirRadioBtn,5000);
        this.sirRadioBtn.click();
        this.firstName.sendKeys("FirstName");
        this.lastName.sendKeys("LastName");
        this.address.sendKeys("Address");
        this.postCode.sendKeys("1234546");
        this.city.sendKeys("MyCity");
        this.phoneNumber.sendKeys("0500001111");
        this.email.sendKeys("123456@gmail.com");
    }

    public void clearName (){
        this.fillInAllTheFields();
        helper.waitForElement(this.firstName,5000);
        this.firstName.sendKeys(Keys.BACK_SPACE);
        this.firstName.sendKeys(Keys.BACK_SPACE);
        this.firstName.sendKeys(Keys.BACK_SPACE);
        this.firstName.sendKeys(Keys.BACK_SPACE);
        this.firstName.sendKeys(Keys.BACK_SPACE);
        this.firstName.sendKeys(Keys.BACK_SPACE);
//        this.firstName.sendKeys(new CharSequence[]{Keys.BACK_SPACE,
//                Keys.BACK_SPACE,
//                Keys.BACK_SPACE,
//                Keys.BACK_SPACE,
//                Keys.BACK_SPACE,
//                Keys.BACK_SPACE,
//                Keys.BACK_SPACE,
//                Keys.BACK_SPACE,
//                Keys.BACK_SPACE});
        this.firstName.sendKeys(Keys.BACK_SPACE);
        this.firstName.sendKeys(Keys.BACK_SPACE);
        this.firstName.sendKeys(Keys.BACK_SPACE);
        helper.sleep(500);
    }

    public void addShortName(){
        this.firstName.sendKeys("a");
        helper.sleep(500);
    }

    public void clearLastName(){
        this.firstName.clear();
        this.firstName.sendKeys("FirstName");
        this.lastName.sendKeys(Keys.BACK_SPACE);
        this.lastName.sendKeys(Keys.BACK_SPACE);
        this.lastName.sendKeys(Keys.BACK_SPACE);
        this.lastName.sendKeys(Keys.BACK_SPACE);
        this.lastName.sendKeys(Keys.BACK_SPACE);
        this.lastName.sendKeys(Keys.BACK_SPACE);
        this.lastName.sendKeys(Keys.BACK_SPACE);
        this.lastName.sendKeys(Keys.BACK_SPACE);
        helper.sleep(500);
    }

     public void addShortLastName(){
        this.lastName.sendKeys("a");
     }

     public void clearAddress(){
        this.lastName.clear();
        this.lastName.sendKeys("LastName");
        this.address.sendKeys(Keys.BACK_SPACE);
        this.address.sendKeys(Keys.BACK_SPACE);
        this.address.sendKeys(Keys.BACK_SPACE);
        this.address.sendKeys(Keys.BACK_SPACE);
        this.address.sendKeys(Keys.BACK_SPACE);
        this.address.sendKeys(Keys.BACK_SPACE);
        this.address.sendKeys(Keys.BACK_SPACE);
        helper.sleep(500);
     }

     public void addShortAddress(){
        this.address.sendKeys("a");
     }

     public void clearPostCode (){
        this.address.clear();
        this.address.sendKeys("Address");
        helper.sleep(500);
        this.postCode.click();
        this.postCode.sendKeys(Keys.BACK_SPACE);
        this.postCode.sendKeys(Keys.BACK_SPACE);
        this.postCode.sendKeys(Keys.BACK_SPACE);
        this.postCode.sendKeys(Keys.BACK_SPACE);
        this.postCode.sendKeys(Keys.BACK_SPACE);
        this.postCode.sendKeys(Keys.BACK_SPACE);
        this.postCode.sendKeys(Keys.BACK_SPACE);
        helper.sleep(500);
     }

     public void addShortPostCode(){
        this.postCode.sendKeys("1");
     }

     public void clearCity(){
        this.postCode.clear();
        this.postCode.sendKeys("1234546");
        this.city.sendKeys(Keys.BACK_SPACE);
        this.city.sendKeys(Keys.BACK_SPACE);
        this.city.sendKeys(Keys.BACK_SPACE);
        this.city.sendKeys(Keys.BACK_SPACE);
        this.city.sendKeys(Keys.BACK_SPACE);
        this.city.sendKeys(Keys.BACK_SPACE);
     }

     public void addShortCityName (){
        this.city.sendKeys("a");
     }

     public void clearPhone (){
        this.city.clear();
        this.city.sendKeys("MyCity");
        helper.sleep(500);
        this.phoneNumber.click();
        this.phoneNumber.sendKeys(Keys.BACK_SPACE);
        this.phoneNumber.sendKeys(Keys.BACK_SPACE);
        this.phoneNumber.sendKeys(Keys.BACK_SPACE);
        this.phoneNumber.sendKeys(Keys.BACK_SPACE);
        this.phoneNumber.sendKeys(Keys.BACK_SPACE);
        this.phoneNumber.sendKeys(Keys.BACK_SPACE);
        this.phoneNumber.sendKeys(Keys.BACK_SPACE);
        this.phoneNumber.sendKeys(Keys.BACK_SPACE);
        this.phoneNumber.sendKeys(Keys.BACK_SPACE);
        this.phoneNumber.sendKeys(Keys.BACK_SPACE);
        helper.sleep(500);
     }

     public void addShortPhone(){
        this.phoneNumber.sendKeys("9");
     }

     public void clearEmail(){
        this.phoneNumber.clear();
        this.phoneNumber.sendKeys("0500001111");
        helper.sleep(500);
        this.email.click();
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        this.email.sendKeys(Keys.BACK_SPACE);
        helper.sleep(500);
     }

     public void completeFoodCheck(String dogName, String breedOfDog)throws InterruptedException{
        this.navigateToOwnAddressData(dogName,breedOfDog);
        this.fillInAllTheFields();
        Thread.sleep(1000);
        this.fergitBtn.click();
        Thread.sleep(2000);
     }

    public void completeFoodCheckWuthOutSamples(String dogName, String breedOfDog)throws InterruptedException{
        String comment = "Best food for my cat.";
        this.navigateToDropDown(dogName, breedOfDog);
        this.selectRandomlyValueFromDropDown();
        this.selectRandomlyStarOfOverallSatisfaction();
        this.selectRandomlyStarOfPricePerformanceRatio();
        this.selectRandomlyStarOfcompositionOfTheFeed();
        Thread.sleep(500);
        this.selectRandomlyValueFromWouldYouRecommendThisFoodNavBar();
        Thread.sleep(500);
        this.writeComment(comment);
        Thread.sleep(500);
        this.noRadioBtn.click();
        Thread.sleep(1000);
        this.emailField.sendKeys("123456@gmail.com");
        Thread.sleep(1000);
        this.fergitBtn.click();
        Thread.sleep(2000);
    }
    // Constructor
    public FoodPetPage(WebDriver driver) {
        super(driver);
        this.petPage = new PetPage(driver);
        this.helper = new Helper(driver);
    }
}
