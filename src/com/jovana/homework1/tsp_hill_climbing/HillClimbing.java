package com.jovana.homework1.tsp_hill_climbing;

/**
 * Created by Jovana on Dec 03, 2017
 */
public class HillClimbing {
    /**
     * Set up local maxima, meaning the maximum number of iterations allowed until a solution is found by the algorithm.
     */
    public static final int ITERATIONS_BEFORE_MAXIMA = 100;

    /**
     * This method represents the Hill climbing algorithm logic and it will try to find the shortest route until it
     * reaches the local maxima. It will first obtain the adjacent route to the current route. If the total distance
     * of the adjacent route is shorter than the current route's, the adjacent route will become the current route.
     * Else, the current route won't change, but the iteration to maxima will increase.
     * When the maxima iteration reaches its' limit, the algorithm will stop, and the last output will represent the
     * solution: the shortest route found by Hill climbing algorithm.
     * @param currentRoute
     * @return Route which is the shortest
     */
    public Route findShortestRoute(Route currentRoute) {
        Route adjacentRoute;
        int iterationsToMaxima = 0;
        String compareRoutes = null;
        while (iterationsToMaxima < ITERATIONS_BEFORE_MAXIMA) {
            adjacentRoute = obtainAdjacentRoute(new Route(currentRoute));
            if (adjacentRoute.getTotalDistance() <= currentRoute.getTotalDistance()) {
                compareRoutes = "=> (PROCEED)";
                iterationsToMaxima = 0;
                currentRoute = new Route(adjacentRoute);
            } else {
                compareRoutes = "=> (STAY) - iteration #" + iterationsToMaxima++;
            }
            System.out.println("       | " + compareRoutes);
            System.out.println(currentRoute +  "       | " + currentRoute.getTotalStringDistance());
        }
        if (iterationsToMaxima == 100) {
            System.out.println("       | => (STOP) - MAXIMA REACHED");
        } else {
            System.out.println("       | " + compareRoutes);
        }
        return currentRoute;
    }

    /**
     * Obtain adjacent route to the current route. Get two random cities from the cities list and swap their places.
     * Then, return the new adjacent route.
     * @param route current route
     * @return Route which is adjacent
     */
    private Route obtainAdjacentRoute(Route route) {
        int x1 = 0;
        int x2 = 0;
        while (x1 == x2) {
            x1 = (int) (route.getCities().size() * Math.random());
            x2 = (int) (route.getCities().size() * Math.random());
        }
        City city1 = route.getCities().get(x1);
        City city2 = route.getCities().get(x2);
        route.getCities().set(x2, city1);
        route.getCities().set(x1, city2);

        return route;
    }
}
