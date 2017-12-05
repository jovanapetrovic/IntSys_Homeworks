package com.jovana.homework1.tsp_hill_climbing;

/**
 * Created by Jovana on Dec 03, 2017
 */
public class City {
    private static final double EARTH_EQUATOR_RADIUS = 6378.1370d;
    private static final double CONVERT_DEGREES_TO_RADIANS = Math.PI/180d;

    /**
     * Each city is identified by its' name, longitude and latitude coordinates.
     */
    private double longitude;
    private double latitude;
    private String name;

    public City() {
    }

    public City(double longitude, double latitude, String name) {
        this.longitude = longitude * CONVERT_DEGREES_TO_RADIANS;
        this.latitude = latitude * CONVERT_DEGREES_TO_RADIANS;
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * This method uses "Haversine" formula to calculate the distance between two cities. Haversine formula determines the
     * distance between two points on a sphere (Earth in this case) given their longitudes and latitudes.
     * @param city to compare
     * @return double distance between two cities
     */
    public double measureDistance(City city) {
        double deltaLongitude = city.getLongitude() - this.longitude;
        double deltaLatitude = city.getLatitude() - this.latitude;
        double a = Math.pow(Math.sin(deltaLatitude / 2d), 2d) + Math.cos(this.getLatitude())
                * Math.cos(city.getLatitude()) * Math.pow(Math.sin(deltaLongitude / 2d), 2d);
        return EARTH_EQUATOR_RADIUS * 2d * Math.atan2(Math.sqrt(a), Math.sqrt(1d - a));
    }
}

