package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.GMIBankPage;
import pages.US3001_Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class GMIBankStepDefinitions {
    GMIBankPage gmiBankPage = new GMIBankPage();
    @When("kullanici gmibank sayfasina gider")
    public void kullanici_gmibank_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("GMIBankUrl"));
    }
    @Then("sayfaya giris yapar")
    public void sayfaya_giris_yapar() {
        gmiBankPage.GMIBankLogin();
    }
    @Then("sayfaya giris yaptigini dogrular")
    public void sayfaya_giris_yaptigini_dogrular() {
        gmiBankPage.girisOnayWebElementi.isDisplayed();
    }
    @When("gmibank signout butonuna tikalar")
    public void gmibank_signout_butonuna_tikalar() {
        gmiBankPage.girisOnayWebElementi.click();
        gmiBankPage.signOutWebElementi.click();
    }
    @When("gmibank sayfasindan cikis yaptigini dogrular")
    public void gmibank_sayfasindan_cikis_yaptigini_dogrular() {
        //h2[normalize-space()='THANK YOU FOR USING US...']
        //html//div[@id='app-view-container']/div[1]//h2[.='THANK YOU FOR USING US...']
        //*[@id="app-view-container"]/div[1]/div/div/div/h2
        gmiBankPage.signOutOnayWebElementi.isDisplayed();
    }

    @Then("gmibank signin butonuna tiklar")
    public void gmibankSigninButonunaTiklar() {
        gmiBankPage.ilkGirisButonu.click();
        gmiBankPage.signInButonu.click();
    }

    @And("gmibank username kutusuna {string} yazar")
    public void gmibankUsernameKutusunaYazar(String yanlisUserName) {
        gmiBankPage.gmibankUsernameKutusu.sendKeys(yanlisUserName);

    }

    @And("gmibank password kutusuna {string} yazar")
    public void gmibankPasswordKutusunaYazar(String yanlisPassword) {
        gmiBankPage.gmiBankPasswordKutusu.sendKeys(yanlisPassword);
        
    }

    @And("gmibank signin butonuna basar")
    public void gmibankSigninButonunaBasar() {
        gmiBankPage.gmiBankSigInOkButonu.click();
    }

    @Then("gmibank giris yapilamadigini test eder")
    public void gmibankGirisYapilamadiginiTestEder() {
        Assert.assertTrue(gmiBankPage.hataliGirisWebElementi.isDisplayed());
    }

    @Then("kullanici gecerli username ve password girer")
    public void kullaniciGecerliUsernameVePasswordGirer() {
        gmiBankPage.gmibankUsernameKutusu.sendKeys(ConfigReader.getProperty("gmibankUsernameValid"));
        gmiBankPage.gmiBankPasswordKutusu.sendKeys(ConfigReader.getProperty("gmibankUPasswordValid"));

    }

    @Then("kullanici userIcona tiklar")
    public void kullaniciUserIconaTiklar() {
        gmiBankPage.girisOnayWebElementi.click();

    }

    @Then("kullanici user settings sayfasinda olmalidir")
    public void kullaniciUserSettingsSayfasindaOlmalidir() {
        gmiBankPage.userInfoWebElementi.click();
        String expectedUrl = "https://www.gmibank.com/account/settings";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(expectedUrl.equals(actualUrl) ? "PASS" : "FAIL");
    }

    @And("kullanici language dropdown da secenekleri gorur")
    public void kullaniciLanguageDropdownDaSecenekleriGorur() {
        Select select=new Select(gmiBankPage.dilDropDown);
        gmiBankPage.dilDropDown.click();
        List<WebElement>languageOptions=select.getOptions();
        System.out.println("languageOptions1 =" +languageOptions.get(0).getText() );
        System.out.println("languageOptions2 =" +languageOptions.get(1).getText() );

    }

    @Then("kullanici English ve Turkish den basaka dil seceneginin olmadigini dogrular")
    public void kullaniciEnglishVeTurkishDenBasakaDilSecenegininOlmadiginiDogrular() {
        Select select=new Select(gmiBankPage.dilDropDown);
        gmiBankPage.dilDropDown.click();
        List<WebElement>languageOptions=select.getOptions();
        for (WebElement each:languageOptions) {
            boolean languages=each.getText().equals("Türkçe") || each.getText().equals("English");
            Assert.assertTrue("user can only select English or Turkish", languages);
        }
    }

    @Then("kullanici My Opertions a tiklar")
    public void kullaniciMyOpertionsATiklar() {
        gmiBankPage.myOperationWebElementi.click();
    }

    @Then("kullanici Manage Customers i secer")
    public void kullaniciManageCustomersISecer() {
        gmiBankPage.manageCustomersWebElementi.click();
    }

    @And("kullanici Create a New Customer a tiklar")
    public void kullaniciCreateANewCustomerATiklar() {
        gmiBankPage.createNewCustomer.click();
    }

    @And("kullanici  {string} girer")
    public void kullaniciGirer(String ssn) {
        gmiBankPage.searchSSN.sendKeys(ConfigReader.getProperty("ssn"));
    }

    @And("kullanici Search button a tiklar")
    public void kullaniciSearchButtonATiklar() {
        gmiBankPage.searchButton.click();
    }

    @Then("kullanici fail message i gorur")
    public void kullaniciFailMessageIGorur() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(gmiBankPage.failedMEssage.isDisplayed());



    }
    US3001_Page us3001_page=new US3001_Page();

    @Then("gmibank giris butonuna tiklar")
    public void gmibankGirisButonunaTiklar() {
       us3001_page.ilkGirisButonu.click();

    }


    @Then("gmibank register butonuna tiklar")
    public void gmibankRegisterButonunaTiklar() {
        us3001_page.registerButonu.click();
    }



    @And("gmibank password kutusuna tiklar")
    public void gmibankPasswordKutusunaTiklar() {
        us3001_page.passwordKutusu.click();
    }

    @Given("{string}girer")
    public void girer(String password) throws InterruptedException {
        us3001_page.passwordKutusu.sendKeys(password);
        Thread.sleep(2000);
    }


    @Then("gmibank Password strength red gorunur")
    public void gmibankPasswordStrengthRedGorunur() {
        Assert.assertTrue(us3001_page.red.isDisplayed());
    }

    @Then("gmibank Password strength orange gorunur")
    public void gmibankPasswordStrengthOrangeGorunur() {
        Assert.assertTrue(us3001_page.orange.isDisplayed());
    }

    @Then("gmibank Password strength yellow gorunur")
    public void gmibankPasswordStrengthYellowGorunur() {
        Assert.assertTrue(us3001_page.yellow.isDisplayed());
    }

    @Then("gmibank Password strength LightGreen gorunur")
    public void gmibankPasswordStrengthLightGreenGorunur() {
        Assert.assertTrue(us3001_page.lightGreen.isDisplayed());
    }

    @Then("gmibank Password strength Green gorunur")
    public void gmibankPasswordStrengthGreenGorunur() {
        Assert.assertTrue(us3001_page.green.isDisplayed());
    }
}
