package org.uca.iut.info.s3atdspring.service.users.creation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.uca.iut.info.s3atdspring.model.entity.UserEntity;
import org.uca.iut.info.s3atdspring.model.repository.UserRepository;
import org.uca.iut.info.s3atdspring.service.UserService;
import org.uca.iut.info.s3atdspring.service.data.UserDto;
import org.uca.iut.info.s3atdspring.service.users.data.UserData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest
public class UserCreationCucumberStepDefsTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    UserEntity result;

    @Given("there is no user created")
    public void there_is_no_user_created() {

        userRepository.deleteAll();
    }


    @When("we try to create a user with firstname {string} and lastname {string}")
    public void we_try_to_create_a_user_with_firstname_and_lastname(String firstName, String lastName) {

        final UserDto userDto = new UserDto();
        userDto.setLastname(lastName);
        userDto.setFirstname(firstName);

        result = userService.createUser(userDto);
    }

    @Then("we have this response")
    public void we_have_this_response(io.cucumber.datatable.DataTable dataTable) {
        final List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        final List<UserData> expectedUsers = new ArrayList<UserData>();
        for (final Map<String, String> columns : rows) {
            expectedUsers.add(
                    new UserData(Long.parseLong(columns.get("id")), columns.get("firstname"), columns.get("lastname")));
        }

        assertThat(result).isNotNull();
        assertThat(1).isEqualTo(expectedUsers.size());

        final List<UserEntity> dbContent = userRepository.findAll();
        assertThat(1).isEqualTo(dbContent.size());

        assertThat(expectedUsers.get(0).getFirstname()).isEqualTo(result.getFirstname());
        assertThat(expectedUsers.get(0).getLastname()).isEqualTo(result.getLastname());
    }

}
