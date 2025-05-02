package losky2987.AirportInfoDisplay.Service;

import jakarta.annotation.Nullable;
import losky2987.AirportInfoDisplay.Domain.Flight;
import losky2987.AirportInfoDisplay.Domain.FlightType;
import losky2987.AirportInfoDisplay.Domain.GateStatus;
import losky2987.AirportInfoDisplay.Repository.FlightRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
public class FlightService {
    private final FlightRepo flightRepo;
    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    public Flight save(Flight flight) {
        return flightRepo.save(flight);
    }

    @Transactional
    public synchronized Flight addFlight(String flightNumber, List<String> shared, FlightType flightType, Map<FlightType, String> cityNode, Map<GateStatus, LocalTime> timePoint) {
        Flight flight = new Flight(flightNumber, shared, flightType, cityNode, timePoint);
        return save(flight);
    }
}
