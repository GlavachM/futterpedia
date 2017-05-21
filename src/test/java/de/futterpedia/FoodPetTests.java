package de.futterpedia;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FoodPetPage;


public class FoodPetTests extends FunctionalTest{

    @Test(priority = 1)
    public void checkFoodPet(){
        FoodPetPage page = new FoodPetPage(driver);
        String catName = "Max";
        page.getFoodPage(catName,"Devon Rex");
        Assert.assertEquals(page.petName.getText(),catName);
        Assert.assertEquals(page.elementListProgressBar.get(0).getAttribute("class"),"completed");
        Assert.assertEquals(page.elementListProgressBar.get(1).getAttribute("class"),"current");
        Assert.assertEquals(page.elementListProgressBar.get(2).isDisplayed(),true);
    }

    @Test(priority = 2)
    public void checkFoodBrand(){
        FoodPetPage page = new FoodPetPage(driver);
        page.getNameFood("Elmo","Burmese");
        Assert.assertFalse(page.foodBrand.getAttribute("value").isEmpty());
        Assert.assertTrue(page.varietyOfFood.isDisplayed());
    }

    @Test(priority = 3)
    public void checkVarietyOfFood(){
        FoodPetPage page = new FoodPetPage(driver);
        page.getVarietyOfFood("Hooke","Munchkin");
        Assert.assertFalse(page.varietyOfFood.getAttribute("value").isEmpty());
        Assert.assertTrue(page.foodUseNavigationBar.isDisplayed());
        Assert.assertTrue(page.foodUseNavigationBar.isEnabled());
    }

    @Test(priority = 4)
    public void checkNavigationBarForHowLongYouUseThisFood(){
        FoodPetPage page = new FoodPetPage(driver);
        page.navigationBarForHowLongYouUseThisFood("Valley","Asher");
        page.howLongYouUseThisFood.get(0).click();
        Assert.assertTrue(page.howLongYouUseThisFood.get(0).getAttribute("class").contains("_item--active"));
        Assert.assertTrue(page.howOftenYouBuyThisFoofNavBar.isDisplayed());
        page.howLongYouUseThisFood.get(1).click();
        Assert.assertTrue(page.howLongYouUseThisFood.get(1).getAttribute("class").contains("_item--active"));
        Assert.assertTrue(page.howOftenYouBuyThisFoofNavBar.isDisplayed());
        page.howLongYouUseThisFood.get(2).click();
        Assert.assertTrue(page.howLongYouUseThisFood.get(2).getAttribute("class").contains("_item--active"));
        Assert.assertTrue(page.howOftenYouBuyThisFoofNavBar.isDisplayed());
        page.howLongYouUseThisFood.get(3).click();
        Assert.assertTrue(page.howLongYouUseThisFood.get(3).getAttribute("class").contains("_item--active"));
        Assert.assertTrue(page.howOftenYouBuyThisFoofNavBar.isDisplayed());
        page.howLongYouUseThisFood.get(4).click();
        Assert.assertTrue(page.howLongYouUseThisFood.get(4).getAttribute("class").contains("_item--active"));
        Assert.assertTrue(page.howOftenYouBuyThisFoofNavBar.isDisplayed());
    }

    @Test(priority = 5)
     public void checkNavigationBarForHowOftenYouUseThisFood (){
        FoodPetPage page = new FoodPetPage(driver);
        page.navigateToHowOftenYouUseThisFoodNavBar("Zembi","Mexikanische Nacktkatze");
        page.howOftenYouBuyThisFood.get(0).click();
        Assert.assertTrue(page.howOftenYouBuyThisFood.get(0).getAttribute("class").contains("item--active"));
        page.howOftenYouBuyThisFood.get(1).click();
        Assert.assertTrue(page.howOftenYouBuyThisFood.get(1).getAttribute("class").contains("item--active"));
        page.howOftenYouBuyThisFood.get(2).click();
        Assert.assertTrue(page.howOftenYouBuyThisFood.get(2).getAttribute("class").contains("item--active"));
        page.howOftenYouBuyThisFood.get(3).click();
        Assert.assertTrue(page.howOftenYouBuyThisFood.get(3).getAttribute("class").contains("item--active"));
    }

    @Test(priority = 6)
    public void checkDropDown (){
        FoodPetPage page = new FoodPetPage(driver);
        String petName = "Mery";
        page.navigateToDropDown(petName,"American Curl");
        Assert.assertTrue(page.messageAboveDropDown.getText().contains(petName));
        page.selectFirstValueFromDropDown();
        Assert.assertEquals("Familie / Freunde",page.howDidYouKnowAboutThisDropDown.getText());
        page.selectSecondValueFromDropDown();
        Assert.assertEquals("TV / Radio / Zeitschrift",page.howDidYouKnowAboutThisDropDown.getText());
        page.selectThirdValueFromDropDown();
        Assert.assertEquals("Gekauft und getestet",page.howDidYouKnowAboutThisDropDown.getText());
        page.selectFourthValueFromDropDown();
        Assert.assertEquals("Züchter", page.howDidYouKnowAboutThisDropDown.getText());
        page.selectFifthValueFromDropDown();
        Assert.assertFalse(page.otherInputField.getAttribute("value").isEmpty());
    }

    @Test(priority = 7)
    public void checkSatisfyedOfFeedstuffSection (){
        FoodPetPage page = new FoodPetPage(driver);
        page.navigateToOverallSatisfactionStars("Garfild","Bengalkatze");
        page.selectFirstStarOfOverallSatisfaction();
        Assert.assertTrue(page.valuationOfOverallSatisfaction.getText().contains("mangelhaft"));
        page.selectSecondStarOfOverallSatisfaction();
        Assert.assertTrue(page.valuationOfOverallSatisfaction.getText().contains("ausreichend"));
        page.selectThirdStarOfOverallSatisfaction();
        Assert.assertTrue(page.valuationOfOverallSatisfaction.getText().contains("befriedigend"));
        page.selectFourthStarOfOverallSatisfaction();
        Assert.assertTrue(page.valuationOfOverallSatisfaction.getText().contains("gut"));
        page.selectFifthStarOfOverallSatisfaction();
        Assert.assertTrue(page.valuationOfOverallSatisfaction.getText().contains("sehr gut"));
        // Second section of stars
        page.selectFirstStarOfPricePerformanceRatio();
        Assert.assertTrue(page.valuationOfPricePerformanceRatio.getText().contains("mangelhaft"));
        page.selectSecondStarOfPricePerformanceRatio();
        Assert.assertTrue(page.valuationOfPricePerformanceRatio.getText().contains("ausreichend"));
        page.selectThirdStarOfPricePerformanceRatio();
        Assert.assertTrue(page.valuationOfPricePerformanceRatio.getText().contains("befriedigend"));
        page.selectFourthStarOfPricePerformanceRatio();
        Assert.assertTrue(page.valuationOfPricePerformanceRatio.getText().contains("gut"));
        page.selectFifthStarOfPricePerformanceRatio();
        Assert.assertTrue(page.valuationOfPricePerformanceRatio.getText().contains("sehr gut"));
        //Third section of star
        page.selectFirstStarOfcompositionOfTheFeed();
        Assert.assertTrue(page.valuationCompositionOfTheFeed.getText().contains("mangelhaft"));
        page.selectSecondStarOfcompositionOfTheFeed();
        Assert.assertTrue(page.valuationCompositionOfTheFeed.getText().contains("ausreichend"));
        page.selectThirdStarOfcompositionOfTheFeed();
        Assert.assertTrue(page.valuationCompositionOfTheFeed.getText().contains("befriedigend"));
        page.selectFourtStarOfcompositionOfTheFeed();
        Assert.assertTrue(page.valuationCompositionOfTheFeed.getText().contains("gut"));
        page.selectFifthStarOfcompositionOfTheFeed();
        Assert.assertTrue(page.valuationCompositionOfTheFeed.getText().contains("sehr gut"));
    }

    @Test(priority = 8)
    public void checkWouldYouRecommendThisFoodNavBar () throws InterruptedException{
        FoodPetPage page = new FoodPetPage(driver);
        page.navigateToWouldYouRecommendThisFoodNavBar("Afira","Kashmir");
        page.wouldYouRecommendThisFoodNavBar.get(0).click();
        Assert.assertTrue(page.wouldYouRecommendThisFoodNavBar.get(0).getAttribute("class").contains("item--active"));
        page.wouldYouRecommendThisFoodNavBar.get(1).click();
        Assert.assertTrue(page.wouldYouRecommendThisFoodNavBar.get(1).getAttribute("class").contains("item--active"));
        page.wouldYouRecommendThisFoodNavBar.get(2).click();
        Assert.assertTrue(page.wouldYouRecommendThisFoodNavBar.get(2).getAttribute("class").contains("item--active"));
        page.wouldYouRecommendThisFoodNavBar.get(3).click();
        Assert.assertTrue(page.wouldYouRecommendThisFoodNavBar.get(3).getAttribute("class").contains("item--active"));
        page.wouldYouRecommendThisFoodNavBar.get(4).click();
        Assert.assertTrue(page.wouldYouRecommendThisFoodNavBar.get(4).getAttribute("class").contains("item--active"));
        page.wouldYouRecommendThisFoodNavBar.get(5).click();
        Assert.assertTrue(page.wouldYouRecommendThisFoodNavBar.get(5).getAttribute("class").contains("item--active"));
        page.wouldYouRecommendThisFoodNavBar.get(6).click();
        Assert.assertTrue(page.wouldYouRecommendThisFoodNavBar.get(6).getAttribute("class").contains("item--active"));
        page.wouldYouRecommendThisFoodNavBar.get(7).click();
        Assert.assertTrue(page.wouldYouRecommendThisFoodNavBar.get(7).getAttribute("class").contains("item--active"));
        page.wouldYouRecommendThisFoodNavBar.get(8).click();
        Assert.assertTrue(page.wouldYouRecommendThisFoodNavBar.get(8).getAttribute("class").contains("item--active"));
        page.wouldYouRecommendThisFoodNavBar.get(9).click();
        Assert.assertTrue(page.wouldYouRecommendThisFoodNavBar.get(9).getAttribute("class").contains("item--active"));
    }

    @Test(priority = 9)
    public void checkCommentField(){
        FoodPetPage page = new FoodPetPage(driver);
        String comment = "Best food for my cat.";
        page.navirateToCommentField("Bimka","Ragdoll");
        page.writeComment(comment);
        Assert.assertTrue(page.addBtn.isEnabled());
    }

    @Test(priority = 10)
    public void checkOwnData(){
        FoodPetPage page = new FoodPetPage(driver);
        page.navigateToOwnAddressData("Brig","Perser");
        page.fillInAllTheFields();
        Assert.assertTrue(page.fergitBtn.isEnabled());

    }
    @Test(priority = 11)
    public void checkNotValidOwnData(){
        FoodPetPage page = new FoodPetPage(driver);
        page.navigateToOwnAddressData("Kuna","Einfache Hauskatze");
        page.clearName();
        Assert.assertTrue(page.requiredFirstName.isDisplayed());
        page.addShortName();
        Assert.assertTrue(page.shortNameMessage.isDisplayed());
        page.clearLastName();
        Assert.assertTrue(page.requiredLastName.isDisplayed());
        page.addShortLastName();
        Assert.assertTrue(page.shortLastNameMessage.isDisplayed());
        page.clearAddress();
        Assert.assertTrue(page.requiredAddress.isDisplayed());
        page.addShortAddress();
        Assert.assertTrue(page.shortAddressMessage.isDisplayed());
        page.clearPostCode();
        Assert.assertTrue(page.requiredPostCode.isDisplayed());
        page.addShortPostCode();
        Assert.assertTrue(page.shortPostCodeMessage.isDisplayed());
        page.clearCity();
        Assert.assertTrue(page.requiredCity.isDisplayed());
        page.addShortCityName();
        Assert.assertTrue(page.shortCityMessage.isDisplayed());
        page.clearPhone();
        Assert.assertTrue(page.requiredPhone.isDisplayed());
        page.addShortPhone();
        Assert.assertTrue(page.shortPhoneNumberMessage.isDisplayed());
        page.clearEmail();
        Assert.assertTrue(page.requiredEmail.isDisplayed());
    }

    @Test(priority = 12)
    public void checkCompleteFoodCheckWithFillOutSamples() throws InterruptedException{
        FoodPetPage page = new FoodPetPage(driver);
        page.completeFoodCheckWuthOutSamples("Merly","Europäisch Kurzhaar Kartäuser");
        Assert.assertTrue(page.elementListProgressBar.get(2).getAttribute("class").contains("completed"));
        Assert.assertTrue(page.foodList.isDisplayed());
    }

    @Test(priority = 13)
    public void checkCompleteFoodCheck()throws InterruptedException{
        FoodPetPage page = new FoodPetPage(driver);
        page.completeFoodCheck("Nana","Devon Rex");
        Assert.assertTrue(page.elementListProgressBar.get(2).getAttribute("class").contains("completed"));
        Assert.assertTrue(page.foodList.isDisplayed());
    }

}
