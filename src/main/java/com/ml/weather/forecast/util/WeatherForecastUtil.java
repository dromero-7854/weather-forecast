package com.ml.weather.forecast.util;

import com.ml.weather.forecast.entity.Position;

public final class WeatherForecastUtil {
	
	public static final Position SUN_POSITION = new Position(0, 0); 
		
	public static boolean aligned(Position posA, Position posB, Position posC) {
		if ((posA.getX() + posB.getX()+ posC.getX()) == 0)
			return true;
		if ((posA.getY() + posB.getY()+ posC.getY()) == 0)
			return true;
		return Math.round((posB.getX() - posA.getX()) * (posC.getY() - posB.getY())) == Math.round((posC.getX() - posB.getX()) * (posB.getY() - posA.getY()));
	}
	
	public static boolean isRainySeason(Position planetAPos, Position planetBPos, Position planetCPos) {
		double abc = WeatherForecastUtil.getOrientation(planetAPos, planetBPos, planetCPos);
		double abp = WeatherForecastUtil.getOrientation(planetAPos, planetBPos, SUN_POSITION);
		double bcp = WeatherForecastUtil.getOrientation(planetBPos, planetCPos, SUN_POSITION);
		double cap = WeatherForecastUtil.getOrientation(planetCPos, planetAPos, SUN_POSITION);
		if (abc > 0 && abp > 0 && bcp > 0 && cap > 0) {
			return true;
		} else if (abc < 0 && abp < 0 && bcp < 0 && cap < 0) {
			return false;    
		} 
		return false;
	}

	public static double getOrientation(Position planetAPos, Position planetBPos, Position planetCPos) {
		return ((planetAPos.getX() - planetCPos.getX())*(planetBPos.getY() - planetCPos.getY())) - ((planetAPos.getY() - planetCPos.getY())*(planetBPos.getX() - planetCPos.getX())); 
	}
		
	public static long calculatePerimeter(Position planetAPos, Position planetBPos, Position planetCPos) {
		double distAB = WeatherForecastUtil.distance(planetAPos, planetBPos);
		double distBC = WeatherForecastUtil.distance(planetBPos, planetCPos);
		double distCA = WeatherForecastUtil.distance(planetCPos, planetAPos);
		return Math.round(distAB + distBC + distCA);
	}
	
	public static double distance(Position posA, Position posB) {
		return Math.sqrt(Math.pow(posB.getX() - posA.getX(), 2) + Math.pow(posB.getY() - posA.getY(), 2));
	}
	
}
