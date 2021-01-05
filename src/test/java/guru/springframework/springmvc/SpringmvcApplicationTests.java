package guru.springframework.springmvc;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;


@SpringBootTest
class SpringmvcApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void getProductList(){

        //specify baseURI
        RestAssured.baseURI="http://localhost:8082";

        //specify request object
        RequestSpecification httpRequest = RestAssured.given();

        //specify response object
        Response response = httpRequest.request(Method.GET, "/products");

        // print in console
        String responseBody = response.getBody().toString();
        System.out.println("responseBody = " + responseBody);

        //status code validation
        int statuscode = response.getStatusCode();
        System.out.println("Status code = " + statuscode);

        Assert.assertEquals(statuscode,"200");

        //status line verification
        String statusline = response.getStatusLine();
        System.out.println("status line = " +statusline);

        Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
    }

}
