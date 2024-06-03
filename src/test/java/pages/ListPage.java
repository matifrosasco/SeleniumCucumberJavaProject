package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

public class ListPage extends BasePage {

    private String searchField = "//body/form[1]/input[1]";
    private String searchResults = "name";

    public ListPage(){
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }

    public void enterSearchCriteria(String state) throws InterruptedException {
        
        try{ //dentro del Try va la accion que vamos hacer
            Thread.sleep(600); //el sistema se frene por 600 milisegundos
     write(searchField, state); 
    }catch(NoSuchElementException e ){ //dentro del catch el error que queremos mostrar
        System.out.println("The WebElemen Search Field couldn´t be found");
        e.printStackTrace();
    }


    }

    public List<String> getAllSearchResults(){
        List <WebElement> list = bringMeAllElements (searchResults);  //creamos una lista llamada list formada por todos los string que tiene dicha lista
        List<String> stringsFromList = new ArrayList<String>(); //lista de tipo string porque nos permite hacer otras funciones como validar texto, en cambio WebElement tiene funciones como hacer click, enviar texto etc.
        for(WebElement e : list){
        stringsFromList.add(e.getText());
    }
        return stringsFromList;
    }

}
