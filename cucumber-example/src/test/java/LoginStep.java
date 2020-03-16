import cl.globallogic.User;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LoginStep {
    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        System.out.println("Step 1");
    }

    @And("I enter the username as admin and password as admin")
    public void iEnterTheUsernameAsAdminAndPasswordAsAdmin() {
        System.out.println("Step 2");

    }

    @And("I click login button")
    public void iClickLoginButton() {
        System.out.println("Step 3");

    }

    @Then("I should see the userform page")
    public void iShouldSeeTheUserformPage() {
        System.out.println("Step 4");

    }

    @And("I enter the username as {string} and password as {string}")
    public void iEnterTheUsernameAsAndPasswordAs(String userName, String password) {
        System.out.println("User: " + userName);
        System.out.println("Password: " + password);

    }

    @And("I enter the following login")
    public void iEnterTheFollowingLogin(DataTable table) {

/*
        List<User> users = table.asList(User.class);

        users.stream().forEach((x) -> {
                    System.out.println("X" + x.getPassword());
                    System.out.println("X" + x.getUserName());
                });
        //row1.stream().forEach(x-> System.out.println("X" + x));
*/
    }


    public class TypeRegistryConfiguration implements TypeRegistryConfigurer {



        @Override
        public void configureTypeRegistry(TypeRegistry typeRegistry) {
            typeRegistry.defineDataTableType(new DataTableType(
                    User.class,
                    (Map<String, String> row) -> new User(
                            row.get("username"),
                            row.get("password"))
                    )
            );
        }
    }
}
