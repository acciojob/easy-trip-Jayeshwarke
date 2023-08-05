package com.driver.repository;

import com.driver.model.Airport;
import com.driver.model.City;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AirportRepo {
    private HashMap<String, Airport> aiP = new HashMap<String, Airport>();

    public void addAirPort(Airport airport){
        String aipName = airport.getAirportName();
        aiP.put(aipName,airport);

    }

    public String getLargestAirport(){
//        Airport largestAip = null;
//
//        for(Airport aip: aiP.values()){
//            if (largestAip == null || aip.getNoOfTerminals() > largestAip.getNoOfTerminals()) {
//                largestAip = aip;
//            } else if (aip.getNoOfTerminals() == largestAip.getNoOfTerminals()) {
//                if (aip.getAirportName().compareTo(largestAip.getAirportName()) < 0) {
//                    largestAip = aip;
//                }
//            }
//        }
//
//        if (largestAip == null) {
//            return null;
//        }
//        return largestAip.getAirportName();
//    }


        // Add airport details to the HashMap (Assuming you have a HashMap of airports)
        // airportMap.put("AirportName1", new Airport("AirportName1", numberOfTerminals1));
        // airportMap.put("AirportName2", new Airport("AirportName2", numberOfTerminals2));
        // airportMap.put("AirportName3", new Airport("AirportName3", numberOfTerminals3));
        // ...

        // Find the airport with the maximum number of terminals
        Airport largestAirport = null;
        for (Airport airport : aiP.values()) {
            if (largestAirport == null || airport.getNoOfTerminals() > largestAirport.getNoOfTerminals()) {
                largestAirport = airport;
            }
        }

        // If the HashMap is empty, return an appropriate message
        if (largestAirport == null) {
            return "No airports found.";
        }

        // Find all airports with the maximum number of terminals
        HashMap<String, Airport> airportsWithMaxTerminals = new HashMap<>();
        for (Airport airport : aiP.values()) {
            if (airport.getNoOfTerminals() == largestAirport.getNoOfTerminals()) {
                airportsWithMaxTerminals.put(airport.getAirportName(), airport);
            }
        }

        // If there is only one airport with the maximum terminals, return its name
        if (airportsWithMaxTerminals.size() == 1) {
            return largestAirport.getAirportName();
        }

        // If there are multiple airports with the same maximum terminals, find the lexicographically smallest name
        String smallestAirportName = airportsWithMaxTerminals.keySet().stream()
                .sorted()
                .findFirst()
                .orElse(null);

        return smallestAirportName;
    }

    public City getAirportByName(String airPname){
        return aiP.get(airPname).getCity();
    }

    public City getAirportnamefromStartingCity(City city){
        for(Airport aip: aiP.values()){
            if(aip.getCity()==city){
                return aip.getCity();
            }
        }
        return null;
    }

}







