package losky2987.AirportInfoDisplay.Database;

import losky2987.AirportInfoDisplay.Domain.Flight;
import losky2987.AirportInfoDisplay.Domain.FlightType;
import losky2987.AirportInfoDisplay.Domain.GateStatus;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface FlightDB extends CrudRepository<Flight, Integer> {
    List<Flight> findAll();
//    Flight save(Flight flight);
//    void delete(Flight flight);
    Flight findFlightByNumber(String flightNumber);
    List<Flight> findFlightByFlightType(FlightType flightType);
    Map<FlightType, String> getAllCityNode();
    Map<GateStatus, LocalTime> getAllGateStatus();
}
