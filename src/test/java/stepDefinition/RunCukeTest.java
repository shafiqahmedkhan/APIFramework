package stepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/placeValidations.feature", glue = {"src/test/java/stepDefinition"})
public class RunCukeTest {
}
