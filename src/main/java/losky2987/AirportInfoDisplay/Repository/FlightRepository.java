package losky2987.AirportInfoDisplay.Repository;

import losky2987.AirportInfoDisplay.Database.FlightDB;
import losky2987.AirportInfoDisplay.Domain.Flight;
import losky2987.AirportInfoDisplay.Domain.FlightType;
import losky2987.AirportInfoDisplay.Domain.GateStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Repository
public class FlightRepository implements FlightRepo {
    private final FlightDB flightDB;
    public FlightRepository(FlightDB flightDB) {
        this.flightDB = flightDB;
    }


    @Override
    public List<Flight> findAll() {
        return flightDB.findAll();
    }

    @Override
    public Flight save(Flight flight) {
        return flightDB.save(flight);
    }

    @Override
    public void delete(Flight flight) {
        flightDB.delete(flight);
    }

    @Override
    public Flight findFlightByNumber(String flightNumber) {
        return flightDB.findFlightByNumber(flightNumber);
    }

    @Override
    public List<Flight> findFlightByFlightType(FlightType flightType) {
        return flightDB.findFlightByFlightType(flightType);
    }

    @Override
    public Map<FlightType, String> getAllCityNode() {
        return flightDB.getAllCityNode();
    }

    @Override
    public Map<GateStatus, LocalTime> getAllGateStatus() {
        return flightDB.getAllGateStatus();
    }
}
