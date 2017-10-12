package com.cgg.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

	private void run() {
		int alpha1, alpha2, alpha3;
		double x1, y1, x2, y2, x3, y3, alpha1Radians, alpha2Radians, alpha3Radians, m, b, maxPerimeter;
		boolean sunAligned, pointsAligned;
		for (int i = 0; i < 3650; i++) {
			alpha1 = -1 * i + 90;
			alpha2 = 5 * i + 90;
			alpha3 = -3 * i + 90;
			alpha1Radians = Math.toRadians(alpha1);
			alpha2Radians = Math.toRadians(alpha2);
			alpha3Radians = Math.toRadians(alpha3);
			
			x1 = 500 * Math.cos(alpha1Radians);
			y1 = 500 * Math.sin(alpha1Radians);
			x2 = 1000 * Math.cos(alpha2Radians);
			y2 = 1000 * Math.sin(alpha2Radians);
			x3 = 2000 * Math.cos(alpha3Radians);
			y3 = 2000 * Math.sin(alpha3Radians);
			
			m = (y1-y2)/(x1-x2)*x3; 
			b = y1-((y1-y2)/(x1-x2)*x1);
			
			if (b == 0) {
				sunAligned = true;
				pointsAligned = true;
			}
			else if ((m+b) == y3) {
				pointsAligned = true;
			}
			// Non-aligned
			else {
				
				if
				
			}
			
			
			
			sunAligned = false;
			pointsAligned = false;
		}
	}

	public enum Quadrant {

		FIRST,

		SECOND,

		THIRD,

		FOURTH
	}

	private Quadrant getQuadrant(int angle) {
		Quadrant quadrant;
		if (angle < 0) {
			if (angle >= 0 && angle <= -90) {
				quadrant = Quadrant.FOURTH;
			} else if (angle < -90 && angle >= -180) {
				quadrant = Quadrant.THIRD;
			} else if (angle < -180 && angle >= -270) {
				quadrant = Quadrant.SECOND;
			} else if (angle >= 0 && angle <= -90) {
				quadrant = Quadrant.FIRST;
			}
		} else {

		}

	}
}
