package API_Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import model.Product;
import model.ProductCategories;
import model.ProductResp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class Test_Product {

    @Test(priority = 1)
    public void test_getAllProductCategories(){

        String SUPPLEMENTS_CATEGORY = "supplements";

        ProductCategories resp = given()
                .when()
                .get("https://mystoreapi.com/catalog/categories")
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract().body().as(ProductCategories.class);

        Boolean categoryCheck = resp.getCategories().isEmpty();

        Assert.assertTrue(!resp.getCategories().isEmpty());

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


    @Test(priority = 4)
    public void test_getAllProductCategoriesList(){
        ProductCategories resp =
                given()
                        .when()
                        .get("https://mystoreapi.com/catalog/categories")
                        .then()
                        .statusCode(200)
                        .log()
                        .body()
                        .extract().body().as(ProductCategories.class);

    }

    @Test(priority = 5)
    public void test_addProduct(){
        Product p1 = new Product(
                10000,
                "pramodaya",
                "sdsfd",
                "sdfdsf",
                "",
                10.09f,
                "",
                "",
                ""
        );
        ProductResp resp =
                given()
                        .contentType(ContentType.JSON)
                        .body(p1)
                        .when()
                        .post("https://mystoreapi.com/catalog/product")
                        .then()
                        .statusCode(201)
                        .log()
                        .body()
                        .extract().body().as(ProductResp.class);

        Assert.assertEquals("pramodaya", resp.getName());

    }

}
