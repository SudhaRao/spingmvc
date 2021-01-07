package guru.springframework.springmvc;

import guru.springframework.springmvc.controllers.IndexController;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.Assert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
class SpringmvcApplicationTests {

    private MockMvc mockMvc;

    @InjectMocks
    private IndexController indexController;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/")).
                andExpect(status().isOk()).
                andExpect(view().name("index"));
    }

//    @Test
//    void contextLoads() {
//    }

//    @Test
//    void getProductList(){
//
//        //specify baseURI
//        RestAssured.baseURI="http://localhost:8082";
//
//        //specify request object
//        RequestSpecification httpRequest = RestAssured.given();
//
//        //specify response object
//        Response response = httpRequest.request(Method.GET, "/customer/list");
//
//        // print in console
//        String responseBody = response.getBody().toString();
//        System.out.println("responseBody = " + responseBody);
//
//        //status code validation
//        int statuscode = response.getStatusCode();
//        System.out.println("Status code = " + statuscode);
//
//        Assert.assertEquals(statuscode,"200");
//
//        //status line verification
//        String statusline = response.getStatusLine();
//        System.out.println("status line = " +statusline);
//
//        Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
//    }

}
