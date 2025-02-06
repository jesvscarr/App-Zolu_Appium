
package com.cmac.appzolux.runners;

import com.igs.managers.AppiumServerManager;
import com.igs.managers.MobileDriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:reportes/html/index.html",
                "json:reportes/json/cucumber.json",
                "junit:reportes/junit/cucumber.xml",
                "de.monochromata.cucumber.report.PrettyReports:reportes/"
        },
        features = {"src/test/java/com/cmac/appzolux/features"},
        glue = {"com/cmac/appzolux/stepdef"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        tags = "@login"

)

public class RunnerLogin {
    
    @AfterClass
    public static void quit() {
        MobileDriverManager mobileDriverManager = new MobileDriverManager();
        if (mobileDriverManager.getDriver() != null) {
            mobileDriverManager.getDriver().quit();
            mobileDriverManager.setDriver(null);
        }

      AppiumServerManager serverManager = new AppiumServerManager();
        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();
        }

    }
}