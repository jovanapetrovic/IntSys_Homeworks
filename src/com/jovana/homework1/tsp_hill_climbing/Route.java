package com.jovana.homework1.tsp_hill_climbing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Jovana on Dec 03, 2017
 */
public class Route {
    private ArrayList<City> cities = new ArrayList<>();

    public Route() {
    }

    /**
     * Initialize a route. Add all cities and shuffle the list.
     * @param cities list
     */
    public Route(ArrayList<City> cities) {
        this.cities.addAll(cities);
        Collections.shuffle(this.cities);
    }

    public Route(Route route) {
        route.cities.stream().forEach(c -> cities.add(c));
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return Arrays.toString(cities.toArray());
    }

    /**
     * Calculate the total distance between the cities that travelling salesman visits.
     * @return double totalDistance
     */
    public double getTotalDistance() {
        int citiesSize = this.cities.size();
        return this.cities.stream().mapToDouble(c -> {
            int cityIndex = this.cities.indexOf(c);
            double totalDistance = 0;
            if (cityIndex < citiesSize - 1) {
                totalDistance = c.measureDistance(this.cities.get(cityIndex + 1));
            }
            return totalDistance;
        }).sum() + this.cities.get(citiesSize - 1).measureDistance(this.cities.get(0));
    }

    /**
     * Format distance km value. Fix to 2 decimals.
     * @return String formattedDistance
     */
    public String getTotalStringDistance() {
        String formattedDistance = String.format("%.2f", this.getTotalDistance());
        if (formattedDistance.length() == 7) {
            formattedDistance = " " + formattedDistance;
        }
        return formattedDistance;
    }

}
