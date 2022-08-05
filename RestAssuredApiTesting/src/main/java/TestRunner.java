import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Feature"
        ,glue={"steps"},
        plugin = {"pretty","html:target/cucumber.html"}
)
public class TestRunner {

}