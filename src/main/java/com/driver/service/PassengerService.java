package com.driver.service;

import com.driver.model.Passenger;
import com.driver.repository.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    @Autowired
    PassengerRepo passengerRepo;
    public void addPassGen(Passenger passenger){
        passengerRepo.addPassGen(passenger.getPassengerId(),passenger);
    }
}

