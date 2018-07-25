package com.ml.weather.forecast.controller;

public class Condition {
	
	public int day;
	
	public String condition;

	public Condition(int day, String condition) {
		super();
		this.day = day;
		this.condition = condition;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
