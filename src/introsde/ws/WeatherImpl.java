package introsde.ws;
import java.net.URI;

import javax.jws.WebService;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.glassfish.jersey.client.ClientConfig;


//Service Implementation
@WebService(endpointInterface = "introsde.ws.Weather")
public class WeatherImpl implements Weather {
    @Override
    public String getWeatherInformationByCity(String name) {
        
        // Fetch the weather information for the Adapter to return
        /*Integer temperature = -100;
        
        String mediaType = MediaType.APPLICATION_JSON;
        // http://api.openweathermap.org/data/2.5/weather?q=Budapest,hu&appid=7c73b4b9e7e29e9c0335c81ccdd8352d&units=Metric
        String url = "http://localhost:5900/sdelab";
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget service = client.target(getBaseURI(url));
        WebTarget resourceWebTarget = service.path("person/1");
		Response r = resourceWebTarget.request().accept(mediaType).get(Response.class);
		
		if(r.getStatus() == 200) {
			String output = r.readEntity(String.class);
			System.out.println(output);
			System.out.println("-- OK -- User fetched successfully.");
		} else {
			System.out.println(r.getStatus());
		}*/
		
		return "Temperature: " + name;
    }
    
    private static URI getBaseURI(String uriServer) {
		return UriBuilder.fromUri(uriServer).build();
	}
}