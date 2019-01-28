package hannah;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import config.Constant;
import config.EndPoint;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetClientTest {
	
	@Test
	public static void GetClientList () {
		RestAssured.baseURI = Constant.environment;

		Response response = given().
				
		header("AppId",Constant.getAppId).
		header("AppSecretKey",Constant.getAppSecretKey).
		param("LastSyncDate",Constant.LastSyncDate).
		when().get(EndPoint.Client()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		body("[0].ClientId",equalTo(Constant.Hannahclientid)).and().
		body("[0].ClientName",equalTo("Hannah Industries")).and().
//		body("[2].ClientId",equalTo(Constant.Pcgclientid)).and(). /* for UAT PCG Index no is 1 */
//		body("[2].ClientName",equalTo("PCG Industries")).and().
		header("Content-Type",Constant.contentType).and().
		header("Server", Constant.ServerName).and().

		extract().response();
		
		//String responseBody = response.getBody().asString();
		
		System.out.println("Response Body of Bud Packaging Task is =>  " + response.asString());
		
//		ResponseBody x = response.getBody().prettyPeek(); print response in raw format
		

	}

}
