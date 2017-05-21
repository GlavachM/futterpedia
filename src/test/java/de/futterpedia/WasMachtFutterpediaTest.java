package de.futterpedia;

import org.testng.annotations.Test;
import org.testng.Assert;
import pages.WasMachtFutterpediaPage;

public class WasMachtFutterpediaTest extends FunctionalTest {

    @Test
    public void RedirectToAboutFutterpedia() {

        WasMachtFutterpediaPage wasMachtFutterpediaPage = new WasMachtFutterpediaPage(driver);
        wasMachtFutterpediaPage.moveToFutterpediaTutorial();
        Assert.assertEquals("https://www.futterpedia.de/was-macht-futterpedia/", driver.getCurrentUrl());
        Assert.assertTrue(wasMachtFutterpediaPage.contentAboutFutterpedia.isDisplayed());
        Assert.assertEquals("Was macht futterpedia?", wasMachtFutterpediaPage.headerText.getText());
    }


    @Test
    public void RedirectToImprint(){
        WasMachtFutterpediaPage wasMachtFutterpediaPage = new WasMachtFutterpediaPage(driver);
        wasMachtFutterpediaPage.moveToImprint();
        Assert.assertEquals("https://www.futterpedia.de/impressum/",driver.getCurrentUrl());
        Assert.assertTrue(wasMachtFutterpediaPage.contentAboutFutterpedia.isDisplayed());
        Assert.assertTrue(wasMachtFutterpediaPage.facebookPluginsLink.isDisplayed());
        Assert.assertTrue(wasMachtFutterpediaPage.privacyLink.isDisplayed());
        Assert.assertTrue(wasMachtFutterpediaPage.twitterLink.isDisplayed());
        Assert.assertTrue(wasMachtFutterpediaPage.twitterAcountLink.isDisplayed());
    }
}