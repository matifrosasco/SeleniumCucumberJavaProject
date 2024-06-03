package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    
    protected static WebDriver driver; //static para que haya un solo valor para todas las instancias del objeto de esta clase. Una sola instancia compartida p todas las clases
    private static WebDriverWait wait;
    private static Actions action;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);  
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //funciones staticas porque queremos que se comporten de la misma manera para todas las instancias que queresmo de de este obet
    public static void navigateTo(String url){
        driver.get(url);
    }

    public void goToLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click(); //funcion que hace click sobre un link
    }

    public static void closeBrowser(){
        driver.quit();
    }
    
    private WebElement Find(String locator){
            //espero hasta encontrar el elemento buscado
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));//usamos el wait aca para no tener que estar usandolo todo el tiempo
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(valueToSelect);
    }   

    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator)); //esta funcion permite hacer click con el boton derecho 
    }

    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend){

        String cellToFile = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        Find(cellToFile).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex); //esta funcion nos permite cambiar de frame
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame(); //no es necesario pasar ningun atributo
    }

    public void dismissAlert(){
       driver.switchTo().alert().dismiss(); //detecta la alerta y la cierra
    }

    public String textFromElement(String locator){ 
        return Find(locator).getText(); //esta funcion nos devuelve un texto
    }

    public boolean elementEnable(String locator){
        return Find(locator).isEnabled(); //esta funcion muestra si un elemento esta disponible (true o false)
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();//esta funcion muestra si un elemento no esta disponible (true o false)
    }

    public List<WebElement> bringMeAllElements(String locator){ 
        return driver.findElements(By.className(locator)); //esta funcion devuelve una lista de elementos
       }
}
