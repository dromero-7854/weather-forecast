# weather-forecast v1.0.0
### Start server
```sh
$ java -jar weather-forecast-1.0.0.jar
```
### Rest Services
	
- GET http://weather-forecast-ml-cloud-app.cfapps.io/weather?day=1

- GET http://weather-forecast-ml-cloud-app.cfapps.io/periods-drought

- GET http://weather-forecast-ml-cloud-app.cfapps.io/periods-rain

- GET http://weather-forecast-ml-cloud-app.cfapps.io/periods-max-rain-intensity

- GET http://weather-forecast-ml-cloud-app.cfapps.io/periods-optimal-condition

### H2 Console - Access data (only localhost)
URL: http://localhost:8083/h2-console

Driver class: org.h2.Driver

JDBC URL: jdbc:h2:mem:testdb

User Name: sa

Password:

### Useful scripts
```
select * from weather_condition where day = ?;
select * from weather_condition where drought='Y';
select * from weather_condition where rain='Y';
select * from weather_condition where max_rain='Y';
select * from weather_condition where optimal_cond='Y';
select count(*) from weather_condition where drought='Y';
select count(*) from weather_condition where rain='Y';
select count(*) from weather_condition where max_rain='Y';
select count(*) from weather_condition where optimal_cond='Y';
```
