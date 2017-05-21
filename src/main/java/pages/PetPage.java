package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import common.Helper;

import java.util.List;
import  java.util.Random;


public class PetPage extends PageObject {

    private final Helper helper;
    // Fields and elements
    @FindBy(xpath="//input[@name='petname']")
    private WebElement fieldForDogName;

    @FindBy(css ="[name='futterpedia-iframe']")
    private WebElement iframe;

    @FindBy(xpath="//*[text()='Hund']")
    public WebElement radioButtonDog;

    @FindBy(xpath = "//*[text()='Katze']")
    public  WebElement radioButtonCat;

    @FindBy(xpath = "//*[text()='Rüde']")
    public  WebElement radioButtonMaleDog;

    @FindBy(xpath = "//*[text()='Hündin']")
    public WebElement radioButtonBitchDog;

    @FindBy(xpath = "//*[text()='Kater']")
    public WebElement radioButtonMaleCat;

    @FindBy(xpath = "//*[text()='Kätzchen']")
    public WebElement radioButtonBitchCat;

    @FindBy(css = "[name='animal_breed']")
    public WebElement breedOfDog;

    @FindBy(css = "[class='fpw-text-input__datepicker']")
    public WebElement calendarButton;

    @FindBy(css = "body")
    private WebElement spake;

    @FindBy(css = "[class='ui-datepicker-year']")
    private  WebElement year;

    @FindBy(xpath = "(//a[@class='ui-state-default'])[1]")
    private  WebElement theThirdDay;

    @FindBy(xpath = "(//*[text()='Nein'])[1]")
    public WebElement notCastratedButton;

    @FindBy(xpath = "(//*[text()='Ja'])[1]")
    public WebElement castratedButton;

    @FindBy(xpath = "(//*[text()='3'])[1]")
    public  WebElement dogsWeight;

    @FindBy(css="[name='weight']")
    public WebElement hiddenWeight;

    @FindBy(xpath = "(//ul[@class='ft__scale-select']/li)[1]")
    private WebElement LowButton;

    @FindBy(xpath = "(//*[@class='ft__scale-select'])[1]/li")
    public   List <WebElement> activityOfYourPetNavBar;

    @FindBy(xpath = "(//*[@class='fpw-widget__range-select'])[1]")
    private WebElement driedAnimalFood;

    @FindBy(xpath = "(//*[@class='fpw-widget__range-select'])[2]")
    public WebElement WetFood;

    @FindBy(xpath = "(//*[@class='fpw-widget__range-select'])[3]")
    private WebElement BARF;

    @FindBy(xpath = "(//*[@class='fpw-widget__range-select'])[4]")
    private WebElement Snacks;

    @FindBy(xpath = "//*[text()='Weiter']")
    public  WebElement nextButton;

    @FindBy(css = "[class='fpw-error']")
    public  WebElement errorMessagePetName;

    @FindBy(xpath = "(//li[@class='fpw-error'])[4]")
    public WebElement errorMessaageBreed;

    @FindBy(css = "[data-handler='selectDay']")
    private List<WebElement> listOfDays;

    @FindBy(xpath = "(//*[@class='fpw-error'])[5]")
    public WebElement calendarErrorMessage;

    @FindBy(css="[name='date_birth']")
    public WebElement currentDate;

    @FindBy(xpath = "(//li[@class='fpw-error'])[5]")
    public WebElement pleaseAnswerTheQuestionFirstMessage;

    @FindBy(css ="[class='ui-slider-range ui-widget-header ui-corner-all ui-slider-range-min']")
    public WebElement slideBar;

    @FindBy(css ="[id='s2id_autogen2']")
    private WebElement diseaseField;

    @FindBy(xpath ="//*[@class='select2-container select2-container-multi fpw-select-multiple']//li")
    public List <WebElement> listDisease;

    @FindBy(css="[title='Diabetes mellitus']")
    public WebElement diseaseName;

    @FindBy(css ="[onclick='return false;']")
    private WebElement deliteDiseaseBtn;

    //Methods
    public void enterDogName(String dogName, String breedOfDog ) throws InterruptedException {
//        Thread.sleep(5000);
//    	driver.switchTo().frame(this.iframe);
        this.addPetName( dogName);
        this.selectRadioButtonDog();
        this.selectMaleDog();
        this.setBreedOfDog(breedOfDog);
        this.setDateOfBirthday();
        this.setSterilization();
        this.setWeight();
        this.specifyDogActivityRandomly();
//        this.specifyValuesForDifferentTypesOfFood();
    }

    /////
    public void addNotValidPetName(String dogName){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
    }

    private void addPetName(String dogName){
        helper.waitForElement(this.fieldForDogName,5000);
        this.fieldForDogName.click();
        this.fieldForDogName.sendKeys(dogName);
        helper.sleep(1000);
    }

    public void addValidPetName(String dogName){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
    }

    public void checkRadioButtonsForDog(String dogName){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonDog();
    }

    public void checkRadioButtonForCat(String dogName){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonCat();
    }

    private void selectRadioButtonCat(){
        helper.waitForElement(this.radioButtonCat,5000);
        this.radioButtonCat.click();
        helper.sleep(1000);
    }

    public void checkRadioButtonForMaleDog(String dogName){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonDog();
        this.selectMaleDog();
    }

    public void checkRadioButtonForMaleCat(String dogName){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonCat();
        this.selectMaleCat();
    }

    public void selectMaleCat(){
        helper.waitForElement(this.radioButtonMaleCat,5000);
        this.radioButtonMaleCat.click();
        helper.sleep(1000);

    }

    public void checkRadioButtonForGirlDog(String dogName){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonDog();
        this.selectBitchDog();
    }

    private void selectBitchDog(){
        helper.waitForElement(this.radioButtonBitchDog,5000);
        this.radioButtonBitchDog.click();
        helper.sleep(1000);
    }

    public void checkRadioButtonForGirlCat(String dogName){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonCat();
        this.selectBitchCat();
    }

    private void selectBitchCat(){
        helper.waitForElement(this.radioButtonBitchCat,5000);
        this.radioButtonBitchCat.click();
        helper.sleep(1000);
    }


    public void checkNotValidNameBreedDog(String dogName, String breedOfDog){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonDog();
        this.selectMaleDog();
        this.setBreedOfDog(breedOfDog);
    }

    public void checkNotValidNameBreedCat(String dogName, String bredOfDog){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonCat();
        this.selectMaleCat();
        this.setBreedOfDog(bredOfDog);

    }

    public void checkValidNameBreedDog(String dogName, String breedOfDog){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonDog();
        this.selectMaleDog();
        this.setBreedOfDog(breedOfDog);
    }

    public void checkValidNameBreedCat(String dogName, String breedOfDog){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonCat();
        this.selectMaleCat();
        this.setBreedOfDog(breedOfDog);
    }


    private  void setBreedOfDog(String breedOfDog){
        helper.waitForElement(this.breedOfDog,5000);
        this.breedOfDog.sendKeys(breedOfDog);
        this.spake.click();
        helper.sleep(1000);
    }

    private void selectRadioButtonDog(){
        helper.waitForElement(this.radioButtonDog,5000);
        this.radioButtonDog.click();
        helper.sleep(1000);
    }

    private void selectMaleDog (){
        helper.waitForElement(this.radioButtonMaleDog,5000);
        this.radioButtonMaleDog.click();
        helper.sleep(1000);
    }

    private void setSterilization()throws InterruptedException{
        this.notCastratedButton.click();
        Thread.sleep(1000);
    }

    private  void setWeight() throws InterruptedException{
        this.dogsWeight.click();
        Thread.sleep(1000);
    }

    private void specifyDogActivityRandomly ()/* throws  InterruptedException*/{
        Random randomActivity = new Random();
        WebElement getActivity = activityOfYourPetNavBar.get(randomActivity.nextInt(activityOfYourPetNavBar.size()));
        getActivity.click();
        /*Thread.sleep(1000);*/
        helper.sleep(1000);
    }

    private void specifyValuesForDifferentTypesOfFood ()/*throws  InterruptedException*/{
        this.driedAnimalFood.click();
        /*Thread.sleep(1000);*/
        helper.waitForElement(this.WetFood,5000);
        this.WetFood.click();
        /*Thread.sleep(1000);*/
        helper.waitForElement(this.BARF,5000);
        this.BARF.click();
        /*Thread.sleep(1000);*/
        helper.waitForElement(this.Snacks,5000);
        this.Snacks.click();
        /*Thread.sleep(1000);*/
    }


    private void setDateOfBirthday () throws  InterruptedException{
        this.calendarButton.click();
        Thread.sleep(1000);
        this.selectRandomlyYear();
        Thread.sleep(1000);
        this.selectRandomlyDayInCalendar();
        Thread.sleep(1000);
    }

    private void selectRandomlyYear(){
        Select years = new Select(this.year);
        Random random = new Random();
        List <WebElement> yearsList = years.getOptions();
        int countOfYears = yearsList.size();
        int OptionByYearsRandomly = random.nextInt(countOfYears);
        if (OptionByYearsRandomly == yearsList.size()-1){
            years.selectByIndex(OptionByYearsRandomly-2);
        }
        else if (OptionByYearsRandomly < yearsList.size()-1){
            years.selectByIndex(OptionByYearsRandomly);
        }
    }

    private void selectRandomlyDayInCalendar(){
        Random randomDay = new Random();
        WebElement getDay = listOfDays.get(randomDay.nextInt(listOfDays.size()));
        getDay.click();
    }

    private void addDateInCalendar(){
        this.selectRandomlyYear();
        this.selectRandomlyDayInCalendar();
    }

    public void selectFutureDateInCalendar(String dogName, String breedOfDog){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonDog();
        this.selectBitchDog();
        this.setBreedOfDog(breedOfDog);
        this.calendarButton.click();
        helper.sleep(1000);
        this.addCurrentYear();
        helper.sleep(1000);
        this.addFutureDateInCalendar();
        helper.sleep(1000);
    }

    public void selectValidDateInCalendar(String dogName,String breedOfDog){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonDog();
        this.selectBitchDog();
        this.setBreedOfDog(breedOfDog);
        this.calendarButton.click();
        this.addDateInCalendar();
        helper.sleep(1000);
    }

    private void addFutureDateInCalendar(){
        WebElement lastDay = listOfDays.get(listOfDays.size()-1);
        lastDay.click();
    }

    private void addCurrentYear(){
        Select years = new Select(this.year);
        List <WebElement> yearsList = years.getOptions();
        WebElement currentYear = yearsList.get(yearsList.size()-1);
        currentYear.click();
    }

    public void moveSlideBar (){
        Dimension sliderSize = slideBar.getSize();
        int sliderWidth = sliderSize.getWidth();
        int xCoord = slideBar.getLocation().getX();
        Actions builder = new Actions(driver);
        builder.moveToElement(slideBar)
                .click()
                .dragAndDropBy(slideBar,xCoord+sliderWidth,0)
                .build()
                .perform();
        helper.sleep(1000);
    }

    public void navigateToWeightSlideBar(String dogName, String breedOfDog){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonDog();
        this.selectBitchDog();
        this.setBreedOfDog(breedOfDog);
        this.calendarButton.click();
        this.addDateInCalendar();
        this.notCastratedButton.click();
        helper.sleep(1000);
    }

    public void selectNoButton(String dogName, String breedOfDog){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonDog();
        this.selectBitchDog();
        this.setBreedOfDog(breedOfDog);
        this.calendarButton.click();
        this.addDateInCalendar();
        this.notCastratedButton.click();
        helper.sleep(1000);
    }

    public void selectYesButton(String dogName, String breedOfDog){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonDog();
        this.selectBitchDog();
        this.setBreedOfDog(breedOfDog);
        this.calendarButton.click();
        this.addDateInCalendar();
        this.castratedButton.click();
        helper.sleep(1000);

    }

    public void navigateToActivityNavBar(String dogName, String breedOfDog){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonCat();
        this.selectBitchCat();
        this.setBreedOfDog(breedOfDog);
        this.calendarButton.click();
        this.addDateInCalendar();
        this.castratedButton.click();
        this.moveSlideBar();
    }

    public void navigateToDiseasesField(String dogName, String breedOfDog){
        helper.waitForFrame(this.iframe,10000);
        this.addPetName(dogName);
        this.selectRadioButtonCat();
        this.selectMaleCat();
        this.setBreedOfDog(breedOfDog);
        this.calendarButton.click();
        this.addDateInCalendar();
        this.castratedButton.click();
        this.moveSlideBar();
        helper.sleep(1000);
        this.specifyDogActivityRandomly();
    }

     public void addDisease(String disease){
        helper.waitForElement(this.diseaseField,5000);
        this.diseaseField.click();
        this.diseaseField.sendKeys(disease);
        helper.sleep(1000);
        this.diseaseField.sendKeys(Keys.ENTER);
     }

     public void deleteDisease(){
         helper.waitForElement(this.deliteDiseaseBtn,5000);
        this.deliteDiseaseBtn.click();
     }

     public void navigateToTypesOfFood(String dogName, String breedOfDog) throws InterruptedException{
         Thread.sleep(5000);
         driver.switchTo().frame(this.iframe);
         this.addPetName(dogName);
         this.selectRadioButtonCat();
         this.selectBitchCat();
         this.setBreedOfDog(breedOfDog);
         this.calendarButton.click();
         this.addDateInCalendar();
         this.castratedButton.click();
         this.moveSlideBar();
         Thread.sleep(1000);
         this.specifyDogActivityRandomly();
         this.spake.click();
         Thread.sleep(5000);
     }

     public void goToFoodPage(String dogName, String breedOfDog){
         helper.waitForFrame(this.iframe,10000);
         this.addPetName(dogName);
         this.selectRadioButtonCat();
         this.selectBitchCat();
         this.setBreedOfDog(breedOfDog);
         this.calendarButton.click();
         this.addDateInCalendar();
         this.castratedButton.click();
         this.moveSlideBar();
         helper.sleep(1000);
         this.specifyDogActivityRandomly();
         this.spake.click();
         this.specifyValuesForDifferentTypesOfFood();
         helper.waitForElement(this.nextButton,5000);
         this.nextButton.click();
         helper.sleep(2000);
     }

    //Constructor
    public PetPage(WebDriver driver) {
        super(driver);
        this.helper = new Helper(driver);
        driver.get("http://192.241.147.61/demo.html");

    }

}