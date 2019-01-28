package pcg;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import config.Constant;
import config.EndPoint;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ClientStrainListTest {
	
	@Test
	public static void getClientStrainList () {
		RestAssured.baseURI = Constant.environment;

		Response response = given().
				
		header("AppId",Constant.getAppId).
		header("AppSecretKey",Constant.getAppSecretKey).
		param("LastSyncDate",Constant.LastSyncDate).
		when().get(EndPoint.ClientStrainList()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		body("[0].ClientId",equalTo(Constant.Pcgclientid)).and().
		header("Content-Type",Constant.contentType).and().
		header("Server", Constant.ServerName).and().
		extract().response();
		
		
		//String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + response.asString());
}

}
