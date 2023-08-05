package com.driver.service;

import com.driver.model.Airport;
import com.driver.repository.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    @Autowired
    AirportRepo airportRepo;

    public void addairPort(Airport airport){
        airportRepo.addAirPort(airport);
    }
    public String getlargestAipname(){
        System.out.println( airportRepo.getLargestAirport()+"#");
       return  airportRepo.getLargestAirport();

    }


}
