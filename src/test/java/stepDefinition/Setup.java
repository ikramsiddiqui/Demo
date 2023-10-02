package stepDefinition;

import Variables.configProperties;
import common.WebHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Setup {

      WebHelper webHelper = new WebHelper();

    @Before
    public void PrintScenarioInfo(Scenario scenario) {


        System.out.println("/******************************************************************************************************/");
        System.out.println("/******************************************************************************************************/");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("/******************************************************************************************************/");
        System.out.println("Scenario Id :  - " + scenario.getId());
        System.out.println("/******************************************************************************************************/");
        System.out.println("Scenario Tags :  - " + scenario.getSourceTagNames());
        System.out.println("/******************************************************************************************************/");
        configProperties.initializePropertyFile();

    }



    @After
    public void TakeScreenshot(Scenario scenario) throws IOException, InterruptedException {
        System.out.println("/------------------------------------------------------------------------------------------------------/");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        if (scenario.isFailed()) {
            String rootDirectoryPath = System.getProperty("user.dir");
            String directoryName = rootDirectoryPath+"/Images/"+ LocalDate.now()+"/";
            File directory = new File(directoryName);
            if(!directory.exists())
            {
                directory.mkdir();
            }

                File screenshot = ((TakesScreenshot) webHelper.driver).getScreenshotAs(OutputType.FILE);
                File targetFile=new File(directory+ "/" + webHelper.getCurrentTimeStamp() +" - " +scenario.getName()+".jpg");
                FileUtils.copyFile(screenshot,targetFile);

                Allure.addAttachment("Failure",new ByteArrayInputStream(((TakesScreenshot) webHelper.driver).getScreenshotAs(OutputType.BYTES)));



        }
        System.out.println("/------------------------------------------------------------------------------------------------------/");
    }




}