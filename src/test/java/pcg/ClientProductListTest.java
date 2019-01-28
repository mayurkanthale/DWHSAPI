package pcg;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import config.Constant;
import config.EndPoint;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ClientProductListTest {
	
	private static Logger log = LogManager.getLogger(ClientProductListTest.class.getName());

	@Test
	public static void getClientProductList () {
		
		RestAssured.baseURI = Constant.environment;

		Response response = given().
				
		header("AppId",Constant.getAppId).
		header("AppSecretKey",Constant.getAppSecretKey).
		param("LastSyncDate",Constant.LastSyncDate).
		when().get(EndPoint.ClientProductList()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		body("[0].ClientId",equalTo(Constant.Pcgclientid)).and().
		header("Content-Type",Constant.contentType).and().
		header("Server", Constant.ServerName).and().
		extract().response();
	
		//String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + response.asString());
		
//		log.debug("I am Debuging");

		log.info("Object is present");
		log.error("Object is Not present");

		log.fatal("I am Fatal");
	
	
	}

}
