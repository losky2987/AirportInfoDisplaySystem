package losky2987.AirportInfoDisplay.Repository;

import losky2987.AirportInfoDisplay.Domain.Flight;
import losky2987.AirportInfoDisplay.Domain.FlightType;
import losky2987.AirportInfoDisplay.Domain.GateStatus;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface FlightRepo {
    List<Flight> findAll();
    Flight save(Flight flight);
    void delete(Flight flight);
    Flight findFlightByNumber(String flightNumber);
    List<Flight> findFlightByFlightType(FlightType flightType);
    Map<FlightType, String> getAllCityNode();
    Map<GateStatus, LocalTime> getAllGateStatus();
}
