package API_Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import model.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test_Product {

    @Test(priority = 1)
    public void test_getAllProductCategories(){
        given()
                .when()
                .get("https://mystoreapi.com/catalog/categories")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test(priority = 2)
    public void test_getAllDataInProductCategory(){
        given()
                .when()
                .get("https://mystoreapi.com/catalog/products")
                .then()
                .statusCode(200)
                .log()
                .body();
    }
    @Test(priority = 3)
    public void test_getProductById(){


        Product resp =
        given()
                .when()
                .get("https://mystoreapi.com/catalog/product/20774")
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract().body().as(Product.class);
        Assert.assertEquals(resp.getName(), "tree");
    }
}
