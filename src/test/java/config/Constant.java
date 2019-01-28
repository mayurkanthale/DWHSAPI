package config;

public class Constant {
	
	/*   				Environment Details 
	 * 
	 *  	Local - "http://192.168.5.148/tbdwhsapitest/api"
	 * 		UAT   - "https://tbdwhsapitest.azurewebsites.net/api"
	 * 		Live  -	"https://tbdwhsprodapi.azurewebsites.net/api"
	 */
	
	public static String environment = "http://192.168.5.148/tbdwhsapitest/api";  
	
	public static String getAppId = "F+D9OifgC41owLBQEa4rOg==";
	
	public static String getAppSecretKey = "UH4y4qPoEi0LxFwoW0m4QoezTdbtUCqT";
	
	/*   			 		Client Id Details 
	 * 
	 * 					Hannah						PCG		
	 *  	Local - 	  16						 18
	 * 		UAT   -		   4						  5
	 * 		Live  -	       4						  5
	 */
	
	public static int Hannahclientid = 16 ;
	
	public static int Pcgclientid = 18 ;

	
	public static String contentType = "application/json; charset=utf-8" ;
	
	/*   				Server Details 
	 * 
	 *  	Local - "Microsoft-IIS/8.0"
	 * 		UAT   - "Microsoft-IIS/10.0"
	 * 		Live  -	"Microsoft-IIS/10.0"
	 */
	
	public static String ServerName = "Microsoft-IIS/8.0";

	public static String LastSyncDate = "";//2019-1-10

}