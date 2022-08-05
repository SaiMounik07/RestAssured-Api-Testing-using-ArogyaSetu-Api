package Refactoring;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class RefactoringMethod {
    Response response;
    public String traditionalMethod(String basePath) {
        String type="content-type";
        String header="application/json; charset=utf-8";
        response = RestAssured
                .given()
                .baseUri("https://cdn-api.co-vin.in/")
                .basePath(basePath)
                .headers(type,header)
                .when()
                .get()
                .then()
                .extract()
                .response();
        assertThat("Response is 200",response.getStatusCode(),equalTo(200));
        return response.asPrettyString();
    }
    public String parameterMethod(String basePath,String param1,String param2) {
        Response response = RestAssured
                .given()
                .baseUri("https://cdn-api.co-vin.in/")
                .basePath(basePath)
                .param("pincode", param1)
                .param("date", param2)
                .header("content-type", "application/json; charset=utf-8")
                .when()
                .get()
                .then()
                .extract().response();
        assertThat("Response is not 200 ok",response.getStatusCode(),equalTo(200));
        return response.asPrettyString();
    }
    public void schemaValidate(String basePath,String param1,String param2){
        RestAssured
                .given()
                .baseUri("https://cdn-api.co-vin.in/")
                .basePath(basePath)
                .param("pincode", param1)
                .param("date", param2)
                .headers("content-type", "application/json; charset=utf-8")//responsetype
                .when()
                .get()
                .then()
                .assertThat()
               .body(matchesJsonSchemaInClasspath("expected.json"));
        System.out.println("Successfully validated");

    }
}
