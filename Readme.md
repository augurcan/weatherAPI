# Weather-API

This project creates a simple district-based weather API using Spring Boot and MySQL, enabling CRUD operations. The API can be used to manage weather information for different districts.

## Installation and Run

The project is ready to run on Docker. Follow the steps below to get the project up and running.
1. Clone the repository:
```bash
git clone https://github.com/augurcan/weatherAPI.git
```
2. Ensure Docker is installed.
3. Open the terminal in the project root directory and run the following command:

```bash
docker-compose up -d
```

## To stop the services
Open the terminal in the project root directory and run the following command:
```bash
docker-compose down
```

## Technologies and Tools

- Spring Boot
- MySQL
- Docker

## Project Structure

![structure](images/weather.png)

## Endpoints
- GET
	* 'localhost:8080/api/v1/weather'
	* 'localhost:8080/api/v1/weather/weatherId'
	* 'localhost:8080/api/v1/weather/cities/cityId'
	* 'localhost:8080/api/v1/weather/district/districtId'
	* 'localhost:8080/api/v1/weather/cities/cityId/date'
	* 'localhost:8080/api/v1/weather/district/districtId/date'
- POST
	* 'localhost:8080/api/v1/weather'
			
- PUT
	* 'localhost:8080/api/v1/weather/weatherId'
- DELETE
	* 'localhost:8080/api/v1/weather/weatherId'
- WeatherDto:
```json

		{
			"id":,
			"districtId":"",
			"cityId":"",
			"date":"",
			"hour":,
			"name":"",
			"temperature":,
			"feltTemperature":,
			"humidity":,
			"windDirection":"",
			"maxWind":,
			"averageWind":
		}
```
