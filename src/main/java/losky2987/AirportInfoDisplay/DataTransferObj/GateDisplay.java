package losky2987.AirportInfoDisplay.DataTransferObj;

import losky2987.AirportInfoDisplay.Domain.Flight;
import losky2987.AirportInfoDisplay.Domain.Gate;

public record GateDisplay(
        Gate gate,
        Flight flight
) {
}
