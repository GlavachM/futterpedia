package de.futterpedia;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PetPage;

public class PetPageTests extends FunctionalTest{

    @Test(priority=1)
    public void CheckNotValidPetNameField(){
        PetPage page = new PetPage(driver);
        page.addNotValidPetName("123456");
        Assert.assertTrue(page.errorMessagePetName.isDisplayed());
    }

    @Test(priority=2)
    public void CheckValidPetName(){
        PetPage page = new PetPage(driver);
        page.addValidPetName("Lucky");
        Assert.assertTrue(page.radioButtonDog.isDisplayed());
        Assert.assertTrue(page.radioButtonCat.isDisplayed());
    }

    @Test(priority=3)
    public void CheckRadioButtonDog(){
        PetPage page = new PetPage(driver);
        page.checkRadioButtonsForDog("Rex");
        Assert.assertTrue(page.radioButtonMaleDog.isDisplayed());
        Assert.assertTrue(page.radioButtonBitchDog.isDisplayed());
    }

    @Test(priority=4)
    public void CheckRadioButtonCat(){
        PetPage page = new PetPage(driver);
        page.checkRadioButtonForCat("Anatole");
        Assert.assertTrue(page.radioButtonMaleCat.isDisplayed());
        Assert.assertTrue(page.radioButtonBitchCat.isDisplayed());
    }

    @Test(priority =5)
    public void CheckRadioButtonMaleDog(){
        PetPage page = new PetPage(driver);
        page.checkRadioButtonForMaleDog("Rocky");
        Assert.assertTrue(page.breedOfDog.isDisplayed());
    }

    @Test(priority = 6)
    public void CheckRadioButtonMaleCat(){
       PetPage page = new PetPage(driver);
       page.checkRadioButtonForMaleCat("Aston");
       Assert.assertTrue(page.breedOfDog.isDisplayed());
    }

    @Test(priority = 7)
    public void CheckRadioButtonGirlDog(){
        PetPage page = new PetPage(driver);
        page.checkRadioButtonForGirlDog("Buddy");
        Assert.assertTrue(page.breedOfDog.isDisplayed());
    }

    @Test(priority = 8)
    public void CheckRadioButtonGirlCat(){
        PetPage page = new PetPage(driver);
        page.checkRadioButtonForGirlCat("Lola");
        Assert.assertTrue(page.breedOfDog.isDisplayed());
    }

    @Test(priority = 9)
    public void CheckNotValidBreedOfDog(){
        PetPage page = new PetPage(driver);
        page.checkNotValidNameBreedDog("Booster", "L");
        Assert.assertTrue(page.errorMessaageBreed.isDisplayed());

    }

    @Test(priority = 10)
    public void CheckNotValidBreedOfCat(){
        PetPage page = new PetPage(driver);
        page.checkNotValidNameBreedCat("Oliver","Q");
        Assert.assertTrue(page.errorMessaageBreed.isDisplayed());

    }

    @Test(priority = 11)
    public void CheckValidBreedOfDog(){
       PetPage page = new PetPage(driver);
       page.checkValidNameBreedDog("Harley", "Chihahua Mops Mix");
       Assert.assertEquals("Chihahua Mops Mix",page.breedOfDog.getAttribute("value"));
       Assert.assertTrue(page.calendarButton.isDisplayed());
       Assert.assertTrue(page.notCastratedButton.isDisplayed());
       Assert.assertTrue(page.castratedButton.isDisplayed());
    }

    @Test(priority =12)
    public void CheckValidBreedOfCat(){
        PetPage page = new PetPage(driver);
        page.checkValidNameBreedCat("Sam", "Einfache Hauskatze");
        Assert.assertEquals("Einfache Hauskatze",page.breedOfDog.getAttribute("value"));
        Assert.assertTrue(page.calendarButton.isDisplayed());
        Assert.assertTrue(page.notCastratedButton.isDisplayed());
        Assert.assertTrue(page.castratedButton.isDisplayed());
    }

    @Test(priority = 13)
    public void checkCalendarFunctionality(){
        PetPage page = new PetPage(driver);
        page.selectFutureDateInCalendar("Casey","Basset Hound");
        Assert.assertTrue(page.calendarErrorMessage.isDisplayed());
    }

    @Test(priority = 14)
    public void CheckValidDateInCalendar() {
        PetPage page = new PetPage(driver);
        page.selectValidDateInCalendar("Amadeus","Rhodesian Ridgeback");
        Assert.assertFalse(page.currentDate.getAttribute("value").isEmpty());
        Assert.assertTrue(page.pleaseAnswerTheQuestionFirstMessage.isDisplayed());
    }

    @Test(priority =15)
    public void CheckNoButton(){
        PetPage page = new PetPage(driver);
        page.selectNoButton("Albuquerque","Deutscher Schäferhund");
        Assert.assertTrue(page.dogsWeight.isDisplayed());
    }

    @Test(priority = 16)
    public void CheckYesButton(){
        PetPage page = new PetPage(driver);
        page.selectYesButton("Largo","Havaneser");
        Assert.assertTrue(page.dogsWeight.isDisplayed());
    }

    @Test(priority = 17)
    public void CheckSlider(){
        PetPage page = new PetPage(driver);
        page.navigateToWeightSlideBar("Saly","Basset Hound");
        String widthPetBeforeMove = page.slideBar.getAttribute("style");
        page.moveSlideBar();
        Assert.assertNotEquals(widthPetBeforeMove, page.slideBar.getAttribute("style"));
    }

    @Test(priority=18)
    public void checkActivityDogNavBar(){
        PetPage page = new PetPage(driver);
        page.navigateToActivityNavBar("Ivory","Corset");
        Assert.assertEquals(3, page.activityOfYourPetNavBar.size());
        page.activityOfYourPetNavBar.get(0).click();
        Assert.assertTrue(page.activityOfYourPetNavBar.get(0).getAttribute("class").contains("ft__scale-select__item--active"));
        page.activityOfYourPetNavBar.get(1).click();
        Assert.assertTrue(page.activityOfYourPetNavBar.get(1).getAttribute("class").contains("ft__scale-select__item--active"));
        page.activityOfYourPetNavBar.get(2).click();
        Assert.assertTrue(page.activityOfYourPetNavBar.get(2).getAttribute("class").contains("ft__scale-select__item--active"));
    }

    @Test(priority = 19)
    public void checkFieldOfDiseases(){
        PetPage page = new PetPage(driver);
        page.navigateToDiseasesField("Alli","Munchkin");
        page.addDisease("Diabetes mellitus");
        Assert.assertTrue(page.diseaseName.getText().equals("Diabetes mellitus"));
        page.deleteDisease();
        Assert.assertEquals(0,page.listDisease.size());
    }

//    @Test(priority = 20)
//    public void checkNavBarTypeOfFoods() throws InterruptedException{
//        PetPage page = new PetPage(driver);
//        page.navigateToTypesOfFood("Zephyr","Bengalkatze");
////        page.driedAnimalFood.get(1).click();
////        page.WetFood.click();
//        page.moveToFirsItem();
//        Thread.sleep(5000);
//    }


    @Test(enabled = false)
    public void DogsTest() throws InterruptedException{
        PetPage page = new PetPage(driver);
        page.enterDogName("Lucky","Bolonka");
        Assert.assertEquals("http://192.241.147.61/demo.html", driver.getCurrentUrl());
        Assert.assertTrue(page.nextButton.isDisplayed());
    }
}