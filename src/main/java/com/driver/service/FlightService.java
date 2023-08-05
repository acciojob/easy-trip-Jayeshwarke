package com.driver.service;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.repository.AirportRepo;
import com.driver.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FlightService {
    @Autowired
    FlightRepo flightRepo;
    @Autowired
    AirportRepo airportRepo;
    public void addFlight(Flight flight){
    int flightID = flight.getFlightId();
    flightRepo.addFlight(flightID,flight);
    }

    public double getShortestDuration(City fromCity, City toCity){
       return flightRepo.getShortDuration(fromCity, toCity);
    }
    public int getCountOfPassOnAiponDate(Date date, String airportName){
       City airCity =  airportRepo.getAirportByName(airportName);
       return getCountOfPassOnAiponDate(date, String.valueOf(airCity));
    }

    public String bookTicket(int flightId, int passengerId){
        int maxCapacity = flightRepo.getMaxCap(flightId);
        int currBookingsInFlight =flightRepo.getCurrBookinginFlight(flightId);


        if(currBookingsInFlight>=maxCapacity){
           return  "FAILURE";
        }else if(flightRepo.getPassengerIdifBookedTicket(flightId).contains(passengerId)){
            return  "FAILURE";
        }
        flightRepo.bookTicketUpadtepassidandcountinflight(flightId,passengerId);
        return "SUCCESS";
    }

    public String cancelticket(int flightId, int passengerId){
        if(flightRepo.cheakIfticketBooked(flightId,passengerId)){
            return"FAILURE";
        }

        flightRepo.cancelTicket(flightId,passengerId);
        return "SUCCESS";

    }

    public String AirportnameFromFlightid(int flightID){
        City city = flightRepo.getCity(flightID);
        return String.valueOf(airportRepo.getAirportnamefromStartingCity(city));
    }

    public int calculateFare(int flightID){
        return 300+flightRepo.getCurrBookinginFlight(flightID)*50;
    }
}
