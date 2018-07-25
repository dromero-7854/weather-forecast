package com.ml.weather.forecast.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.weather.forecast.entity.WeatherCondition;
import com.ml.weather.forecast.repository.WeatherConditionRepository;

@Controller
public class WeatherForecastController {
	
	@Autowired
	private WeatherConditionRepository weatherConditionRep;
	
	@GetMapping("/weather")
    @ResponseBody
    public Condition welcomeUser(@RequestParam(name="day", required=true, defaultValue="0") int day) {
		Optional<WeatherCondition> weatherCondition = this.weatherConditionRep.findById(day);
		String condition = "none";
		if (weatherCondition.isPresent()) {
			condition = weatherCondition.get().getCondition();
		} else {
			condition = "unpredicted day";
		}
		return new Condition(day, condition);
    }
	
	@GetMapping("/periods-drought")
    @ResponseBody
    public String periodsOfDrought() {
		return "{ \"value\": " + weatherConditionRep.periodsOfDrought() + " }";
    }
	
	@GetMapping("/periods-rain")
    @ResponseBody
    public String periodsOfRain() {
		return "{ \"value\": " + weatherConditionRep.periodsOfRain() + " }";
    }
	
	@GetMapping("/periods-max-rain-intensity")
    @ResponseBody
    public String periodsOfMaximumRainIntensity() {
		return "{ \"value\": " + weatherConditionRep.periodsOfMaximumRainIntensity() + " }";
    }
	
	@GetMapping("/periods-optimal-condition")
    @ResponseBody
    public String periodsOfOptimalCondition() {
		return "{ \"value\": " + weatherConditionRep.periodsOfOptimalCondition() + " }";
    }

}