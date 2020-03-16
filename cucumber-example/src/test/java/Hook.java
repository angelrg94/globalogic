import io.cucumber.java.After;
import io.cucumber.java.Before;


/**
 * Utilizado para agregar funcionalidades Antes y despues de los Scenarios
 * **/
public class Hook {

    @Before
    public void initializeTest(){

        System.out.println("Opening the Browser...");
    }

    @After
    public void tearDownTest(){
        System.out.println("Closing the Browser...");

    }
    
}
