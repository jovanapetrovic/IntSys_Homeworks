package com.jovana.homework1.tsp_hill_climbing;

/**
 * Created by Jovana on Dec 03, 2017
 */
public class Main {

    public static void main(String[] args) {
        TravellingSalesman travellingSalesman = new TravellingSalesman();
        Route route = new Route(travellingSalesman.getCitiesToVisit());
        System.out.println("==================================================================================================================\n" +
                            "Route (cities to visit)   |   Distance (in kilometers)   |   Compare adjacent to current route (proceed or stay)\n" +
                            "==================================================================================================================");
        System.out.println(route + "       | " + route.getTotalStringDistance());
        new HillClimbing().findShortestRoute(route);
        System.out.println("==================================================================================================================");
    }

}
