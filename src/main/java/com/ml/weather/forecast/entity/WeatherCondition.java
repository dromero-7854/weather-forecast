package com.ml.weather.forecast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "weather_condition")
public class WeatherCondition {

	@Id
	@Column(name = "day")
	private Integer day;

	@Type(type="yes_no")
	@Column(name = "drought", nullable=false)
	private Boolean drought;

	@Type(type="yes_no")
	@Column(name = "rain", nullable=false)
	private Boolean rain;

	@Type(type="yes_no")
	@Column(name = "max_rain", nullable=false)
	private Boolean maxRain;

	@Type(type="yes_no")
	@Column(name = "optimal_cond", nullable=false)
	private Boolean optimalCond;

	@Column(name = "perimeter", precision=10, scale=2, nullable=true)
	private Long perimeter;

	public WeatherCondition() {};

	public WeatherCondition(Integer day) {		
		this.day = day;
		this.drought = false;
		this.rain = false;
		this.maxRain = false;
		this.optimalCond = false;
	}

	public String getCondition() {
		if (this.drought)
			return "drought";
		if (this.optimalCond)
			return "optimal condition";
		if (this.maxRain) 
			return "maximum rain intensity";
		if (this.rain) 
			return "rain";
		return "normal";
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Boolean getDrought() {
		return drought;
	}

	public void setDrought(Boolean drought) {
		this.drought = drought;
	}

	public Boolean getRain() {
		return rain;
	}

	public void setRain(Boolean rain) {
		this.rain = rain;
	}

	public Boolean getMaxRain() {
		return maxRain;
	}

	public void setMaxRain(Boolean maxRain) {
		this.maxRain = maxRain;
	}

	public Boolean getOptimalCond() {
		return optimalCond;
	}

	public void setOptimalCond(Boolean optimalCond) {
		this.optimalCond = optimalCond;
	}

	public Long getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(Long perimeter) {
		this.perimeter = perimeter;
	}

}