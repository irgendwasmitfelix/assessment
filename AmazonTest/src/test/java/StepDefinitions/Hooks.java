package StepDefinitions;

import Base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends TestBase {

    @Before
    public void setup(){
        initialization();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
