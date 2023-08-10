package stepDefination;

import PageObjectModel.Kitapyurdu_Page;
import driver.Driver;
//import io.cucumber.java.After;
import io.cucumber.java.After;
import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriverException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import token.BearerToken;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.Constants.RESET;
import static java.awt.Color.GREEN;
import token.BearerTokenV2;





public class SepeteUrunEklemeTesti {
    private WebDriver driver ;
    Kitapyurdu_Page kitapyurdu_page=new Kitapyurdu_Page();
    BearerTokenV2 requestSender = new BearerTokenV2();

    public static String text1;
    public static final String GREEN = "\033[0;32m";
    public static final String RESET = "\033[0m";

    @Before
    public void open() throws MalformedURLException {
        //setUp();
        requestSender = new BearerTokenV2();
    }



    @Given("Kitapyurdu sitesine git")
    public void kitapyurdu_sitesine_git() throws IOException, InterruptedException {
        try {
            driver = Driver.getDriver();
            //System.setProperty("web-driver.chrome.driver","/Users/caglacesme/Downloads/chromedriver_mac64_2/chromedriver");
            driver.manage().window().maximize();
            driver.get("https://www.kitapyurdu.com/");
            Thread.sleep(3000);

            //PageFactory.initElements(driver, this);

            //System.out.println("kitapyurdu sitesine gidildi");
            requestSender.changeResultt("CAG-7", true);
        } catch (Exception e) {
            requestSender.changeResultt("CAG-7", false);
            tearDown();
            System.exit(0);
        }
    }


        @Given("cerezleri kabul et")
        public void cerezkabul () throws InterruptedException {
        try{
            kitapyurdu_page.cerezkabul();
            Thread.sleep(2000);
            System.out.println("cerezler kabul edildi");
            requestSender.changeResultt("CAG-24", true);
        }catch (Exception e) {
            requestSender.changeResultt("CAG-24", false);
            tearDown();
            System.exit(0);
        }}

        @Given("cok satan kitaplar sekmesinin uzerine gel")
        public void cok_satan_kitaplar_sekmesinin_uzerine_gel () throws InterruptedException {
        try{
            kitapyurdu_page.cokSatanKitaplarTikla();
            Thread.sleep(2000);
            System.out.println("cok satan kitaplar sekmesinin üzerine gelindi");
            requestSender.changeResultt("CAG-8", true);
        }catch (Exception e) {
            requestSender.changeResultt("CAG-8", false);
            tearDown();
            System.exit(0);}}
        @Given("cok satan edebiyat kitaplari uzerine tikla")
        public void cok_satan_edebiyat_kitaplari_uzerine_tikla () throws InterruptedException {
        try {
            kitapyurdu_page.cokSatanEdebiyatTikla();
            Thread.sleep(2000);
            System.out.println("çok satan edebiyat kitapları üzerine tıklandı");
            requestSender.changeResultt("CAG-9", true);
        }catch (Exception e) {
            requestSender.changeResultt("CAG-9", false);
            tearDown();
            System.exit(0);}}

        @Given("bir ve yirmi arasi random bir kitaba tikla")
        public void bir_ve_yirmi_arasi_random_bir_kitaba_tikla () throws InterruptedException {
        try{
            kitapyurdu_page.kitabatikla();
            Thread.sleep(2000);
            System.out.println("random kitap seçildi");
            requestSender.changeResultt("CAG-10", true);
        }catch (Exception e) {
            requestSender.changeResultt("CAG-10", false);
            tearDown();
            System.exit(0);}}

        @Given("secilen kitabi sepete ekle")
        public void secilen_kitabi_sepete_ekle () throws InterruptedException {
        try {
            kitapyurdu_page.clicksepeteekle();
            Thread.sleep(2000);
            System.out.println("seçilen kitap sepete eklendi");
            requestSender.changeResultt("CAG-11", true);
        }catch (Exception e) {
            requestSender.changeResultt("CAG-11", false);
            tearDown();
            System.exit(0);}}
        @When("sepete tikla")
        public void sepetetikla () throws InterruptedException {
        try {
            kitapyurdu_page.clicksepetetikla();
            Thread.sleep(2000);
            System.out.println("sepete tıklandı");
            requestSender.changeResultt("CAG-25", true);
        }catch (Exception e) {
            requestSender.changeResultt("CAG-25", false);
            tearDown();
            System.exit(0);}}

        @Then("sepete git butonuna tikla")
        public void sepete_git_butonuna_tikla () throws InterruptedException {
        try {
            WebElement kitap1Element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[2]/div/a"));
            String ilkkitap = kitap1Element.getText();
            System.out.println("Alınan kitap adı: " + ilkkitap);
            kitapyurdu_page.clicksepetegit();
            Thread.sleep(2000);
            System.out.println("sepete git butonuna tıklandı");
            WebElement kitap2Element = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div[1]/table/tbody/tr[1]/td[3]/div/div/a"));
            String ikincikitap = kitap2Element.getText();
            System.out.println("Alınan kitap adı: " + ikincikitap);
            Assertions.assertEquals(ilkkitap, ikincikitap);

            requestSender.changeResultt("CAG-18", true);
        }catch(Exception e) {
            requestSender.changeResultt("CAG-18", false);
            tearDown();
            System.exit(0);}}
        @After
        public void tearDown () {
            // Close the driver and send test results
            if (driver != null) {
                driver.quit();
            }
            try {
                requestSender.sendTestResults();
            } catch (IOException e) {
                System.out.println("Error sending test results: " + e.getMessage());
            }

        }
    }