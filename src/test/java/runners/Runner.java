package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target\\cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},
        features = "src/test/resources/features",
        glue="stepdefinitions",  //java kodlarımız "stepDefinitions" alır
        tags="@CH1",

        dryRun=false

        //dryRun=true dediğimizde testi çalıştırmadan bize eksik adımı verir
        //dryRun=false yaparsak testi çalıştırır eksik bir adımla karşılaşırsa
        //test failed olur ve bize eksik adımı raporlar

)
public class Runner {


}
