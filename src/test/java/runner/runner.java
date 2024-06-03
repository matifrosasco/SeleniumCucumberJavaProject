package runner;
 
import org.junit.AfterClass;
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

//Archivo de configuracion de Cucumber para "unir" todo. 

@RunWith(Cucumber.class) 
@CucumberOptions(
    features = "src/test/resources/features", //donde estan los features en nuestro proyecto
    glue = "steps", //donde estan las definiciones de los stpes
    plugin = { "pretty", "html:target/cucumber-reports" }, 
    tags = "@Test"
    )



public class runner{
    @AfterClass
    public static void clearBrowser(){
        BasePage.closeBrowser();
    }
      
}
