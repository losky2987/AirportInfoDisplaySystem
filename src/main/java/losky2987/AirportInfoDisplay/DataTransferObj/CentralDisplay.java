package losky2987.AirportInfoDisplay.DataTransferObj;

import losky2987.AirportInfoDisplay.Domain.Flight;
import losky2987.AirportInfoDisplay.Domain.Gate;

import java.util.List;
import java.util.Map;

public record CentralDisplay (
        List<Map<Gate, Flight>> takeoffFlights,
        List<Map<Gate, Flight>> landingFlights
) {
}
