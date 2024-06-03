package pages;

public class TradeMePage extends BasePage {

    public TradeMePage(){
        super(driver);
    }

    public void navigateToTradeMePage(){
        navigateTo("https://www.trademe.co.nz/a/motors");
    }

    
    

}
