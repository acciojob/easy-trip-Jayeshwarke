package com.driver.repository;

import com.driver.model.City;
import com.driver.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public class FlightRepo {
    //flight id
    private HashMap<Integer, Flight> flightDB = new HashMap<>();

    //flight id - list of ids
    //flight id - count

    private HashMap<Integer, List<Integer>> booking = new HashMap<Integer, List<Integer>>();
    private HashMap<Integer, Integer> countOFbookingsinFlight = new HashMap<Integer, Integer>();


   public int getMaxCap(int flightId){
       return flightDB.get(flightId).getMaxCapacity();
   }

   public int getCurrBookinginFlight(int flightId){
       return countOFbookingsinFlight.get(flightId);
   }
   public List<Integer> getPassengerIdifBookedTicket(int flightId){
       return booking.get(flightId);
   }
   public void bookTicketUpadtepassidandcountinflight(int flightId, int passengerId){
       booking.get(flightId).add(passengerId);
       countOFbookingsinFlight.put(flightId,countOFbookingsinFlight.getOrDefault(flightId,0)+1);

   }

   public boolean cheakIfticketBooked(int flightId, int passengerId){
       if(booking.get(flightId).contains(passengerId)){
           return true;
       }
       return false;
   }

   public void cancelTicket(int flightId, int passengerId){
       countOFbookingsinFlight.put(flightId,countOFbookingsinFlight.getOrDefault(flightId,0)-1);
       booking.get(flightId).remove(passengerId);
   }

    public void addFlight(int fliightId, Flight flight){
        flightDB.put(fliightId,flight);
    }

    public double getShortDuration(City fromCity, City toCity){
        double shortestDuration = Integer.MAX_VALUE;
        for(Flight fli:flightDB.values()){
            if(fli.getFromCity().equals(fromCity) && fli.getToCity().equals(toCity)){
                if(fli.getDuration()<shortestDuration){
                    shortestDuration = fli.getDuration();
                }
            }
        }

        if(shortestDuration==Integer.MAX_VALUE){
            return -1.0;
        }
        return shortestDuration;
    }

    public int countPassgenONDate(Date date, City airportcity){
        int countP = 0;
        for(Flight fli:flightDB.values()){
            if((date==fli.getFlightDate()) && airportcity==fli.getFromCity() || airportcity== fli.getToCity()){
                countP=countP+fli.getMaxCapacity();
            }
        }
        return countP;
    }

    public City getCity(int flightId){
       return flightDB.get(flightId).getFromCity();
    }

}
