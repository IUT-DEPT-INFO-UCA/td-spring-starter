package org.uca.iut.info.s3atdspring.service.users.search;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = "pretty",
        features = "classpath:features/users/users-retrieval.feature",
        glue = { "org.uca.iut.info.s3atdspring.service.users.search", "cucumber.api.spring" })
public class UserSearchCucumberRunnerTest {

}

