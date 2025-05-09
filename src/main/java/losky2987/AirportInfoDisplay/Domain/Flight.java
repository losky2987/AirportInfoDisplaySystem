package losky2987.AirportInfoDisplay.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Flight {
    @Id
    private final String number; // flight number, like CA936
    private final List<String> shared; // shared number, if it needs
    private final String airlinesCode; // to parse for Airlines logo and airlines union
    private final FlightType flightType; // to parse for gate information
    @Transient
    private final Map<FlightType, String> cityNode = new HashMap<>(); // this map to storage the cities for departure, destination or transfer, depends on flight type
    @Transient
    private final Map<GateStatus, LocalTime> timePoint = new HashMap<>(); // this map to storage every time points, like boarding, departure, arrival etc.

    public Flight(String number, List<String> shared, FlightType flightType) {
        this.number = number;
        this.shared = shared;
        this.airlinesCode = number.substring(0, 2);
        this.flightType = flightType;
    }

    public Flight(String number, List<String> shared, FlightType flightType, Map<FlightType, String> cityNode) {
        this.number = number;
        this.shared = shared;
        this.airlinesCode = number.substring(0, 2);
        this.flightType = flightType;
        this.cityNode.putAll(cityNode);
    }

    @PersistenceCreator
    public Flight(String number, List<String> shared, FlightType flightType, Map<FlightType, String> cityNode, Map<GateStatus, LocalTime> timePoint) {
        this.number = number;
        this.shared = shared;
        this.airlinesCode = number.substring(0, 2);
        this.flightType = flightType;
        this.cityNode.putAll(cityNode);
        this.timePoint.putAll(timePoint);
    }

    public void addCityNode(FlightType flightType, String cityNode) {
        this.cityNode.put(flightType, cityNode);
    }

    public void addTimePoint(GateStatus gateStatus, LocalTime timePoint) {
        this.timePoint.put(gateStatus, timePoint);
    }

    public void removeCityNode(FlightType flightType, String cityNode) {
        this.cityNode.remove(flightType, cityNode);
    }

    public void removeTimePoint(GateStatus gateStatus, LocalTime timePoint) {
        this.timePoint.remove(gateStatus, timePoint);
    }

    public Map<FlightType, String> getCityNode() {
        return cityNode;
    }

    public Map<GateStatus, LocalTime> getTimePoint() {
        return timePoint;
    }

    public List<String> getCityNode(FlightType flightType) {
        return cityNode.entrySet().stream().filter(e -> e.getKey() == flightType).map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public List<LocalTime> getTimePoint(GateStatus gateStatus) {
        return timePoint.entrySet().stream().filter(e -> e.getKey() == gateStatus).map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public String getNumber() {
        return number;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public String getAirlinesCode() {
        return airlinesCode;
    }

    public List<String> getShared() {
        return shared;
    }
}
