package com.ml.weather.forecast.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ml.weather.forecast.entity.WeatherCondition;

@Repository
public interface WeatherConditionRepository extends JpaRepository<WeatherCondition, Integer> {

	@Query("select coalesce(max(wc.perimeter), 0) from WeatherCondition wc where wc.rain=true")
	public long getMaxPerimeter();
	
	@Modifying
	@Transactional
	@Query("update WeatherCondition wc set wc.maxRain=true where wc.rain = true and wc.perimeter = :maxPerimeter")
	public void updateMaxRain(@Param("maxPerimeter") long maxPerimeter);
	
	@Query("select count(*) from WeatherCondition wc where wc.drought=true")
	public long periodsOfDrought();
	
	@Query("select count(*) from WeatherCondition wc where wc.rain=true")
	public long periodsOfRain();
	
	@Query("select count(*) from WeatherCondition wc where wc.maxRain=true")
	public long periodsOfMaximumRainIntensity();
	
	@Query("select count(*) from WeatherCondition wc where wc.optimalCond=true")
	public long periodsOfOptimalCondition();
	
}
