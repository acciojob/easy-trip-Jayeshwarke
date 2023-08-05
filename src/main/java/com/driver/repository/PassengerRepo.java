package com.driver.repository;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Passenger;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PassengerRepo {
    private HashMap<Integer, Passenger> passGen= new HashMap<Integer, Passenger>();

    public void addPassGen(int PassId ,Passenger passenger){

        passGen.put(PassId,passenger);
    }


}
