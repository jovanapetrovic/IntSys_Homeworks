package com.jovana.homework1.tsp_hill_climbing;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jovana on Dec 03, 2017
 */
public class TravellingSalesman {

    private ArrayList<City> citiesToVisit;

    public TravellingSalesman() {
        this.citiesToVisit = createCitiesList();
    }

    public ArrayList<City> getCitiesToVisit() {
        return citiesToVisit;
    }

    /**
     * Create initial cities list that travelling salesman must visit.
     */
    private ArrayList<City> createCitiesList() {
        return new ArrayList<>(Arrays.asList(
                new City(-20.448922, 44.786568, "Beograd"),
                new City(-21.895759, 43.320902, "Nis"),
                new City(-19.83355, 45.267135, "Novi Sad"),
                new City(-22.273801, 43.901505, "Zajecar"),
                new City(-20.911423, 44.012793, "Kragujevac"),
                new City(-20.521362, 43.140698, "Novi Pazar"),
                new City(-21.900271, 42.545034, "Vranje"),
                new City(-19.665059, 46.100547, "Subotica"),
                new City(-19.890655, 44.268273, "Valjevo"),
                new City(-22.585681, 43.155701, "Pirot")
        ));
    }

}
