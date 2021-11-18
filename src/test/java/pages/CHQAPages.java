package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.security.cert.X509Certificate;

public class CHQAPages {
    public CHQAPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginLinki;

    @FindBy(xpath="//input[@name='UserName']")
    public WebElement usernameKutusu;

    @FindBy(xpath="//input[@name='Password']")
    public WebElement passwordKutusu;

    @FindBy (xpath = "//input[@id='btnSubmit']")
    public WebElement loginButonu;

    @FindBy(xpath="//span[text()='Try again please']")
    public WebElement girisYapilamadiYazisiElementi;

    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement girisYapildiKontrolYazi;

}