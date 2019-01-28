package hannah;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import config.Constant;
import config.EndPoint;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetTrimmingTaskListTest {
	@Test
	public static void GetTrimmingtaskList () {
		RestAssured.baseURI = Constant.environment;

		Response response = given().
				
		header("AppId",Constant.getAppId).
		header("AppSecretKey",Constant.getAppSecretKey).
		param("LastSyncDate",Constant.LastSyncDate).
		when().get(EndPoint.TrimmingTask()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		
		//String responseBody = response.getBody().asString();
		System.out.println("Response Body of Trimming Task is =>  " + response.asString());
	}

}
