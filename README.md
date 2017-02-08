# Weather Adapter service

This service provides weather information to my application using openweathermap.org.

## API Endpoints

The WSDL for this service can be found here: 
[https://final-weather-adapter.herokuapp.com/ws/weather?wsdl](https://final-weather-adapter.herokuapp.com/ws/weather?wsdl)

#### ws/weather - getWeatherInformationByCity

In the request we can ask weather information to a location which is given by a City and Country code.  
The only available function is getWeatherInformationByCity used like this:

An example request:

```xml
<soap:Envelope
xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
  <soap:Body xmlns:m="http://ws.introsde/">
  <m:getWeatherInformationByCity>
    <arg0>Budapest,hu</arg0>
  </m:getWeatherInformationByCity>
</soap:Body>
</soap:Envelope>
```

For this we get a response that contains the *Temperature*, *Wind strength* and *Rain possibility* to the give city:

```xml
<?xml version='1.0' encoding='UTF-8'?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getWeatherInformationByCityResponse xmlns:ns2="http://ws.introsde/">
            <return>1|3|-100</return>
        </ns2:getWeatherInformationByCityResponse>
    </S:Body>
</S:Envelope>
```

The response means that the:
* Temperature is 1 Celsius at the city.
* The Wind strength is 3 m/s
* There was no rain in the last 3 hours and no rain expected.

The value `-100` is the default and represents that no data was available for the given metric.


## OpenWeatherMap

This service uses the [openweathermap.org](http://openweathermap.org) service with the JSON API, but the information is provided for the health application using SOAP.

The documentation for the current weather information can be found [here](http://openweathermap.org/current).

**My API token**: *7c73b4b9e7e29e9c0335c81ccdd8352d*

An example request with my token:

```
GET http://api.openweathermap.org/data/2.5/weather?q=Budapest,hu&appid=7c73b4b9e7e29e9c0335c81ccdd8352d&units=Metric
```

The API endpoint here is `api.openweathermap.org` and we request `weather` information.
We specify the city, my token for authorization and also the units that is Metric so we get the response in Celsius and km rather than Fahrenheit and miles.

## Copyright

&copy; Made by Sándor Tibor Nagy as the final project for Introduction to Service Design and Engineering course 2016/2017 at [UNITN](http://www.unitn.it/)