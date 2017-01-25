package introsde.endpoint;
import javax.xml.ws.Endpoint;
import introsde.ws.WeatherImpl;

import java.net.InetAddress;
import java.net.URISyntaxException;
import java.io.IOException;

//Endpoint publisher
public class WeatherPublisher{
    /*public static void main(String[] args) {
       Endpoint.publish("http://localhost:9003/ws/weather", new WeatherImpl());
    }*/
    
    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException{
        String PROTOCOL = "http://";
        String HOSTNAME = InetAddress.getLocalHost().getHostAddress();
        if (HOSTNAME.equals("127.0.0.1"))
        {
            HOSTNAME = "localhost";
        }
        String PORT = "9003";
        String BASE_URL = "/ws/weather";

        if (String.valueOf(System.getenv("PORT")) != "null"){
            PORT=String.valueOf(System.getenv("PORT"));
        }

        String endpointUrl = PROTOCOL+HOSTNAME+":"+PORT+BASE_URL;
        System.out.println("Starting People Service...");
        System.out.println("--> Published at = "+endpointUrl);
        Endpoint.publish(endpointUrl, new WeatherImpl());
        }
}