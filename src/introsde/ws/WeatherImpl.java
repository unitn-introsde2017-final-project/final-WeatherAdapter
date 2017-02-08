package introsde.ws;

import java.net.URI;

import javax.jws.WebService;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import org.json.JSONObject;


//Service Implementation
@WebService(endpointInterface = "introsde.ws.Weather")
public class WeatherImpl implements Weather {
	/**
	 * getWeatherInformationByCity(String city)
	 */
    @Override
    public String getWeatherInformationByCity(String city) {
        
    	System.out.println("getWeatherInformationByCity called with argument: " + city);
        // Fetch the weather information for the Adapter to return
        String result = "Init";
        
        try {
	        String mediaType = MediaType.APPLICATION_JSON;
	        // http://api.openweathermap.org/data/2.5/weather?q=Budapest,hu&appid=7c73b4b9e7e29e9c0335c81ccdd8352d&units=Metric
	        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=7c73b4b9e7e29e9c0335c81ccdd8352d&units=Metric";
	        System.out.println("Request url: " + url);
			ClientConfig clientConfig = new ClientConfig();
			Client client = ClientBuilder.newClient(clientConfig);
			WebTarget service = client.target(getBaseURI(url));
	        //WebTarget resourceWebTarget = service.path("data/2.5/weather?q=" + city + "&appid=7c73b4b9e7e29e9c0335c81ccdd8352d&units=Metric");
			Response r = service.request().accept(mediaType).get(Response.class);
			
			if(r.getStatus() == 200) {
				String output = r.readEntity(String.class);
				JSONObject json_data = new JSONObject();
				json_data = new JSONObject(output);
				Integer temp = -100, wind = -100, rain = -100;
				try {
					temp = json_data.getJSONObject("main").getInt("temp");
				} catch (Exception e) {
					System.out.println("Exception: " + e.toString());
				}
				try {
					wind = json_data.getJSONObject("wind").getInt("speed");
				} catch (Exception e) {
					System.out.println("Exception: " + e.toString());
				}
				try {
					rain = json_data.getJSONObject("rain").getInt("3h");
				} catch (Exception e) {
					System.out.println("Exception: " + e.toString());
				}
				result = temp + "|" + wind + "|" + rain;
				System.out.println(result);
				System.out.println(output);
				System.out.println("--> Request done OK");
			} else {
				System.out.println(r.getStatus());
				System.out.println(r.getLocation());
				System.out.println(r.readEntity(String.class));
			}
        } catch (Exception e) {
        	result = "Exception: " + e.toString();
		}
		
		return result;
    }
    
    private static URI getBaseURI(String uriServer) {
		return UriBuilder.fromUri(uriServer).build();
	}
}