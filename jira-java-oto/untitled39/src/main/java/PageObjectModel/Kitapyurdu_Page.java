package PageObjectModel;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kitapyurdu_Page extends AbstractClass {
    WebDriver driver;
    By sayfakitapfiyat = new By.ByXPath("//div[@class='price__item']");

    public Kitapyurdu_Page() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

public void cerezkabul(){
    WebElement cerez = driver.findElement(By.xpath("/html/body/div[7]/button[1]"));
    clickFunction(cerez);
}
    public void cokSatanKitaplarTikla() {
        WebElement cokSatanKitaplar = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/ul/li[1]/div[2]/ul/li[1]/span"));
        clickFunction(cokSatanKitaplar);
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/ul[1]/li[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/strong[1]")
    private WebElement cokSatanEdebiyat;

    public void cokSatanEdebiyatTikla() {
        clickFunction(cokSatanEdebiyat);
    }

    @FindBy(className = "product-cr")
    private List<WebElement> tumkitaplar;

    public void kitabatikla() {
        Random rand = new Random();
        int randomBook = rand.nextInt(tumkitaplar.size());
        tumkitaplar.get(randomBook).click();
    }

    @FindBy(xpath = "/html/body/div[5]/div/div/div[8]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div[4]/a/span")
    private WebElement sepeteekle;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[8]/div/div[2]/div[1]/h1")
    private WebElement kitapadi;

    public void clicksepeteekle() {
        String KitapAdi = kitapadi.getText();
        clickFunction(sepeteekle);
    }

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[4]/div[1]/div[1]/span")
    private WebElement sepetetikla;

    public void clicksepetetikla() {
        clickFunction(sepetetikla);
    }

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[4]/div[2]/div[2]/div[2]/div/a")
    private WebElement sepetegit;

    public void clicksepetegit() {
        clickFunction(sepetegit);
    }




    public void isimyaz(){
            WebElement bookNameElement1 = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[8]/div/div[2]/div[1]/h1"));
            String bookName1 = bookNameElement1.getText();

            WebElement bookNameElement2 = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div[1]/table/tbody"));
            String bookName2 = bookNameElement2.getText();

            if (bookName1.equalsIgnoreCase(bookName2)) {
                System.out.println("İki kitap adı birbirine eşittir.");
            } else {
                System.out.println("İki kitap adı birbirine eşit değildir.");
            }

        }






   /* By kitapismi = new By.ByXPath("/html/body/div[5]/div/div/div[2]/div/div[1]/table/tbody/tr[2]/td[3]/div/div/a");
    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/div[1]/table/tbody/tr[2]/td[3]/div/div/a")
    private WebElement eklendipopup;
    public void assertMassage(){
        Assertion(eklendipopup, find(kitapismi).getText());
    }*/

  /*  @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/div[1]/table/tbody/tr/td[3]/div/div/a")
    private List<WebElement>sepettekiKitapAdi;

    public static boolean sepetkontrol(String[] args) {
           List<String> getSepettekiKitapAdlari() {
            List<String> kitapAdlari = new ArrayList<>();
            for (WebElement element : sepettekiKitapAdi) {
                kitapAdlari.add(element.getText());
            }
            return kitapAdlari;
        }

           Kitapyurdu_Page deneme = new Kitapyurdu_Page();
           deneme.clicksepeteekle();
           if(getSepettekiKitapAdlari().contains())
       }*/

}










