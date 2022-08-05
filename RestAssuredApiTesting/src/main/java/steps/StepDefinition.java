package steps;

import Actions.StateList;
import Actions.States;
import Refactoring.RefactoringMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
public class StepDefinition {
    States stateName;
    static int id;
    Response response;

    RefactoringMethod result=new RefactoringMethod();
    @Given("User has to get The state details {string}")
    public void stateDetails(String basePath) throws JsonProcessingException {
    String res=result.traditionalMethod(basePath);


        System.out.println(res);

        ObjectMapper objectMapper=new ObjectMapper();
        StateList stateList=objectMapper.readValue(res,StateList.class);
        for(int i=0;i<stateList.getStates().size()-1;i++)
        {
            stateName=stateList.getStates().get(i);
            if(stateName.getState_name().equals("Tamil Nadu"))
            {
                 id= stateName.getState_id();
                System.out.println("id is "+id);
                break;
            }
        }
        }

    @When("User has to get districts using state id {string}")
    public void userHasToGetDistrictsUsingStateId(String basePath) throws JsonProcessingException {
        String totalPath=basePath+String.valueOf(id);
       String res=result.traditionalMethod(totalPath);
        System.out.println(res);

    }

    @Then("User has to find districts using pin {string} and {string} and {string}")
    public void userHasToFindDistrictsUsingPin(String basePath,String param1,String param2) {
    String res=result.parameterMethod(basePath,param1,param2);
        System.out.println(res);
    }


    @And("Verify Schema of response {string} and {string} and {string}")
    public void verifySchemaOfResponse(String basePath,String param1,String param2) {
        result.schemaValidate(basePath,param1,param2);
    }

}
