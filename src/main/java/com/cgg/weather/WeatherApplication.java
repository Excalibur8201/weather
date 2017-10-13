package com.cgg.weather;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

	private void run() {
		int alpha1, alpha2, alpha3;
		double x1, y1, x2, y2, x3, y3, alpha1Radians, alpha2Radians, alpha3Radians, m, b, maxPerimeter = 0;
		boolean sunAligned = false, pointsAligned = false, triangled = false, sunTriangled = false;

		LocalDate today = LocalDate.now();
		LocalDate tenYearsLater = today.plusYears(10);
		long daysBetween = DAYS.between(today, tenYearsLater);

		for (int i = 0; i < daysBetween; i++) {

			// The angular positions of planets
			alpha1 = normalizeAngle(-1 * i + 90);
			alpha2 = normalizeAngle(5 * i + 90);
			alpha3 = normalizeAngle(-3 * i + 90);

			// Angles, degrees to radians
			alpha1Radians = Math.toRadians(alpha1);
			alpha2Radians = Math.toRadians(alpha2);
			alpha3Radians = Math.toRadians(alpha3);

			// Coordinates of each angular position
			x1 = 500 * Math.cos(alpha1Radians);
			y1 = 500 * Math.sin(alpha1Radians);
			x2 = 1000 * Math.cos(alpha2Radians);
			y2 = 1000 * Math.sin(alpha2Radians);
			x3 = 2000 * Math.cos(alpha3Radians);
			y3 = 2000 * Math.sin(alpha3Radians);

			m = (y1 - y2) / (x1 - x2) * x3;
			b = y1 - ((y1 - y2) / (x1 - x2) * x1);

			if (b == 0) {
				sunAligned = true;
				pointsAligned = true;
			} else if ((m + b) == y3) {
				pointsAligned = true;
			}
			// Non-aligned, triangle
			else {

				Quadrant quadrant1 = getQuadrant(alpha1);
				Quadrant quadrant2 = getQuadrant(alpha2);
				Quadrant quadrant3 = getQuadrant(alpha3);

				// Sun-aligned Triangle
				if (!quadrant1.equals(quadrant2) && !quadrant2.equals(quadrant3) && !quadrant1.equals(quadrant2)
						&& !quadrant1.equals(quadrant3)) {

					double perimeter = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))
							+ Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2))
							+ Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

					if (perimeter > maxPerimeter) {
						maxPerimeter = perimeter;
					}

					triangled = true;
					sunTriangled = true;
				}
				// Triangle with no Sun
				else {
					triangled = true;
				}

			}

			sunAligned = false;
			pointsAligned = false;
			triangled = false;
			sunTriangled = false;
		}
	}

	public enum Quadrant {

		FIRST,

		SECOND,

		THIRD,

		FOURTH
	}

	private int normalizeAngle(int angle) {
		if (angle <= -360) {
			while (angle <= -360) {
				angle += 360;
			}
		}
		if (angle >= 360) {
			while (angle >= 360) {
				angle -= 360;
			}
		}
		return angle;
	}

	private Quadrant getQuadrant(int angle) {
		Quadrant quadrant = null;
		if (angle < 0) {
			if (angle <= 0 && angle >= -90) {
				quadrant = Quadrant.FOURTH;
			} else if (angle < -90 && angle >= -180) {
				quadrant = Quadrant.THIRD;
			} else if (angle < -180 && angle >= -270) {
				quadrant = Quadrant.SECOND;
			} else if (angle < 270 && angle >= -359) {
				quadrant = Quadrant.FIRST;
			}
		} else {
			if (angle >= 0 && angle <= 90) {
				quadrant = Quadrant.FIRST;
			} else if (angle > 90 && angle <= 180) {
				quadrant = Quadrant.SECOND;
			} else if (angle > 180 && angle <= 270) {
				quadrant = Quadrant.THIRD;
			} else if (angle > 270 && angle <= 359) {
				quadrant = Quadrant.FOURTH;
			}
		}
		return quadrant;
	}
}
