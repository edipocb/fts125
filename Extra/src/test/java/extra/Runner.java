package extra;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//Classe RUN  programado antes da classe principal


@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun = false, 
		monochrome = true, 
		features = {"src/test/resources/"},
        glue     = {"extra/"},
        plugin   = {"pretty",
        		    "html:target/relatoriosimples",
        		    "json:target/relatoriosimples.json",
        		    "com.cucumber.listener.ExtentCucumberFormatter:target/relatoriodetalhado/dashboard.html"
                    }
)
public class Runner {

}

