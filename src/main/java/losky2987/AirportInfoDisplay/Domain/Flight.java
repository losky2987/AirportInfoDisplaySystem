package losky2987.AirportInfoDisplay.Domain;

import java.time.LocalTime;

public class Flight {
    private final String flightNumber;
    private final String airlinesCode;
    private final String destination;
    private final LocalTime boardingTime;
    private final LocalTime departureTime;

    public Flight(String flightNumber, String airlinesCode, String destination, LocalTime boardingTime, LocalTime departureTime) {
        this.flightNumber = flightNumber;
        this.airlinesCode = airlinesCode;
        this.destination = destination;
        this.boardingTime = boardingTime;
        this.departureTime = departureTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirlinesCode() {
        return airlinesCode;
    }

    public String getDestination() {
        return destination;
    }

    public LocalTime getBoardingTime() {
        return boardingTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }
}
