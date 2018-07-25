package com.ml.weather.forecast.server.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ml.weather.forecast.entity.Planet;
import com.ml.weather.forecast.entity.Position;
import com.ml.weather.forecast.entity.WeatherCondition;
import com.ml.weather.forecast.repository.WeatherConditionRepository;
import com.ml.weather.forecast.util.WeatherForecastUtil;

@Component
public class PredictWeather implements ApplicationRunner {

	private WeatherConditionRepository weatherConditionRep;
	
	@Autowired
    public PredictWeather(WeatherConditionRepository weatherConditionRep) {
        this.weatherConditionRep = weatherConditionRep;
    }

    public void run(ApplicationArguments args) {
    	Planet ferengi = new Planet("ferengi", 1, 500);
    	Planet betasoide = new Planet("betasoide", 3, 2000);
    	Planet vulcano = new Planet("vulcano", 5, 1000);
    	
    	WeatherCondition weatherCondition;
    	Position ferengiPos;
    	Position betasoidePos;
    	Position vulcanoPos;
    	
    	for (int day = 1; day <= (10 * 365); day++) {
    		
    		ferengiPos = ferengi.calculatePosition(day);
    		betasoidePos = betasoide.calculatePosition(day);
    		vulcanoPos = vulcano.calculatePosition(day);

    		weatherCondition = new WeatherCondition(day);
    		if (WeatherForecastUtil.aligned(ferengiPos, betasoidePos, vulcanoPos)) {
    			if (WeatherForecastUtil.aligned(ferengiPos, betasoidePos, WeatherForecastUtil.SUN_POSITION)) {
        			weatherCondition.setDrought(true);
        		} else {
        			weatherCondition.setOptimalCond(true);
        		}
    		} else if (WeatherForecastUtil.isRainySeason(ferengiPos, betasoidePos, vulcanoPos)) {
    			weatherCondition.setRain(true);
    			weatherCondition.setPerimeter(WeatherForecastUtil.calculatePerimeter(ferengiPos, betasoidePos, vulcanoPos));
    		}
    		
    		weatherConditionRep.save(weatherCondition);
    	}
    	
    	long maxPerimeter = weatherConditionRep.getMaxPerimeter();
    	weatherConditionRep.updateMaxRain(maxPerimeter);
    }
}
