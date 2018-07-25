package com.ml.weather.forecast.entity;

public class Planet {
	
	private String name;
	
	private double angularVelocity;
	
	private double angularVelocityRad;
	
	private double distance;

	public Planet() {}
	
	public Planet(String name, double angularVelocity, double distance) {
		super();
		this.name = name;
		this.angularVelocity = angularVelocity;
		this.angularVelocityRad = Math.toRadians(angularVelocity);
		this.distance = distance;
	}

	public Position calculatePosition(int day) {
		double omega = this.angularVelocityRad * day;
		return new Position(this.distance * Math.cos(omega), this.distance * Math.sin(omega));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAngularVelocity() {
		return angularVelocity;
	}

	public void setAngularVelocity(double angularVelocity) {
		this.angularVelocity = angularVelocity;
	}

	public double getAngularVelocityRad() {
		return angularVelocityRad;
	}

	public void setAngularVelocityRad(double angularVelocityRad) {
		this.angularVelocityRad = angularVelocityRad;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}