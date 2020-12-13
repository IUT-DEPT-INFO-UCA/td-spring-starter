package org.uca.iut.info.s3atdspring.service.users.creation;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = "pretty",
        features = "classpath:features/users/users-creation.feature",
        glue = { "org.uca.iut.info.s3atdspring.service.users.creation", "cucumber.api.spring" })
public class UserCreationCucumberRunnerTest {

}
