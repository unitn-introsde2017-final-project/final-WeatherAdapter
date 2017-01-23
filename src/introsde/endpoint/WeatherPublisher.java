package introsde.endpoint;
import javax.xml.ws.Endpoint;
import introsde.ws.WeatherImpl;

//Endpoint publisher
public class WeatherPublisher{
    public static void main(String[] args) {
       Endpoint.publish("http://localhost:9003/ws/weather", new WeatherImpl());
    }
}