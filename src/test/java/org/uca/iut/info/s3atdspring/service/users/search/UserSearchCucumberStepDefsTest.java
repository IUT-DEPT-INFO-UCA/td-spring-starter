package org.uca.iut.info.s3atdspring.service.users.search;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.uca.iut.info.s3atdspring.model.entity.UserEntity;
import org.uca.iut.info.s3atdspring.model.repository.UserRepository;
import org.uca.iut.info.s3atdspring.service.UserService;
import org.uca.iut.info.s3atdspring.service.users.data.UserData;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest
public class UserSearchCucumberStepDefsTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    List<UserEntity> result;


    @Before
    public void setUp() {

        result = new ArrayList<UserEntity>();
    }

    @Given("these existing users")
    public void these_existing_users(DataTable table) {

        final List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        final List<UserData> users = new ArrayList<UserData>();
        for (final Map<String, String> columns : rows) {
            users.add(
                    new UserData(Long.parseLong(columns.get("id")), columns.get("firstname"), columns.get("lastname")));
        }

        final List<UserEntity> entitiesToSave = new ArrayList<UserEntity>();
        for (final UserData user : users) {

            final UserEntity userEntity = new UserEntity();

            userEntity.setId(user.getId());
            userEntity.setFirstname(user.getFirstname());
            userEntity.setLastname(user.getLastname());

            entitiesToSave.add(userEntity);
        }

        try {
            userRepository.saveAll(entitiesToSave);
        } catch (final DataAccessException ex) {
            throw new IllegalArgumentException("error while saving the users", ex);
        }

    }

    @When("we try to retrieve all users")
    public void we_try_to_retrieve_all_users() {

        result = userService.getUsers();
    }

    @Then("we have this response")
    public void a_have_this_response(DataTable table) {

        final List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        final List<UserData> expectedUsers = new ArrayList<UserData>();
        for (final Map<String, String> columns : rows) {
            expectedUsers.add(
                    new UserData(Long.parseLong(columns.get("id")), columns.get("firstname"), columns.get("lastname")));
        }

        assertThat(expectedUsers.size()).isEqualTo(result.size());

        for (int i = 0; i < expectedUsers.size(); i++) {

            final UserData userExpected = expectedUsers.get(i);

            assertThat(userExpected.getFirstname()).isEqualTo(result.get(i).getFirstname());
            assertThat(userExpected.getLastname()).isEqualTo(result.get(i).getLastname());
        }

    }

    @When("we search users with firstname {string} and lastname {string}")
    public void we_search_users_with_firstname_and_lastname(String firstName, String lastName) {

        result = userService.getUsersByLastNameAndFirstName(lastName, firstName);
    }

}
