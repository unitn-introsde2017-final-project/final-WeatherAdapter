# final-WeatherAdapter service

This is service that provides weather information to my application using openweathermap.org service.

## Using the service API

This service uses the openweathermap.org service with JSON, but the information is provided using SOAP.

You can find the wsdl definition of the service on this url:
[https://final-weather-adapter.herokuapp.com/ws/weather?wsdl](https://final-weather-adapter.herokuapp.com/ws/weather?wsdl)

The only operation that you will find is: *getWeatherInformationByCity* accepting a city name.

For the demonstration I'm using the city name: "Budapest,hu"

## Copyright

This service was made by Sándor Tibor Nagy as part of the final project for Introduction to Service Design and Engineering class at UNITN. 2017