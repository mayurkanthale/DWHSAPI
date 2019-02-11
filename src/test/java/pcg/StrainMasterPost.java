package pcg;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import config.Constant;
import config.EndPoint;
import dataDriven.DBConnect;
import dataDriven.DataProviders;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StrainMasterPost {

//	@Test(dataProvider = "StrainPostData", dataProviderClass = DataProviders.class)
	public static void PostStrainMaster (String clientid,String strainName) 
	{
		RestAssured.baseURI = Constant.environment;

		Response response = given().
		
		header("AppId",Constant.getAppId).
		header("AppSecretKey",Constant.getAppSecretKey).
		header("Content-Type","application/json").
//		queryParam("LastSyncDate",Constant.LastSyncDate).
		
		body("{\r\n" + 
				"  \"StrainMasterList\": [\r\n" + 
				"    {\r\n" + 
				"      \"ClientId\": "+clientid+",\r\n" + 
				"      \"StrainName\": \""+strainName+"\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}").
		
		when().post(EndPoint.StrainPost()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		header("Content-Type",Constant.contentType).and().
		header("Server", Constant.ServerName).and().
		extract().response();
		
		
		//String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + response.asString());
	}
	
	@Test(dataProvider = "StrainPostData", dataProviderClass = DataProviders.class)
	public static void ListStrainMaster (String clientid,String strainName) 
	{
		RestAssured.baseURI = Constant.environment;

		Response response = given().
				
		header("AppId",Constant.getAppId).
		header("AppSecretKey",Constant.getAppSecretKey).
		param("LastSyncDate",Constant.LastSyncDate).
		when().get(EndPoint.StrainList()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		header("Content-Type",Constant.contentType).and().
		header("Server", Constant.ServerName).and().
		extract().response();
		
		
		//String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + response.asString());
		
		String Qry="select StrainName from TBG_StrainMasterList where StrainName ='"+strainName+"'";
		Assert.assertEquals(DBConnect.getDataFromDataBase(Qry),strainName);
		System.out.println("data is matched with database  "+DBConnect.getDataFromDataBase(Qry));
		
	}


}
