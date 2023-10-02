package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = "src/test/Feature",
                glue = {"stepDefinition"},
                plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
                tags= "@login"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void beforeClass()
    {

    }
    @AfterClass
    public static void afterClass()
    {


    }

}
