package adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReqresBaseAdapter {
    private static final String URL = "https://reqres.in/api/";

    Gson converter = new Gson();

    public String get(String url){
        return
                given()
                        .header("Content-Type", "application/json")
                .when()
                        .get(URL + url)
                .then()
                        .log().all()
                        .extract().body().asString();
    }

    public int getStatusCode(String url){
        return
                given()
                        .header("Content-Type", "application/json")
                .when()
                        .get(URL + url)
                .then()
                        .log().all()
                        .extract().statusCode();
    }

    public Response put(String url, String body){
        return
                given()
                        .header("Content-Type", "application/json")
                        .body(body)
                .when()
                        .put(URL + url)
                .then()
                        .log().all()
                        .extract().response();
    }

    public Response patch(String url, String body){
        return
                given()
                        .header("Content-Type", "application/json")
                        .body(body)
                .when()
                        .put(URL + url)
                .then()
                        .log().all()
                        .extract().response();
    }

    public Response post(String url, String body){
        return
                given()
                        .header("Content-Type", "application/json")
                        .body(body)
                .when()
                        .post(URL + url)
                .then()
                        .log().all()
                        .extract().response();
    }

    public int delete(String url){
        return given()
                .header("Content-Type", "application/json")
        .when()
                .delete(URL + url)
        .then()
                .log().all()
                .extract().statusCode();
    }
}
