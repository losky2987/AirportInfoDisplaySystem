package losky2987.AirportInfoDisplay.Domain;

public class Gate {
    private final String number;
    private final Flight flight;
    private Flight changedInfo;
    private GateStatus status;

    public Gate(String number, Flight flight, GateStatus status) {
        this.number = number;
        this.flight = flight;
    }
    public String getNumber() {
        return number;
    }
    public Flight getFlightInfo() {
        return flight;
    }
    public Flight getChangedInfo() {
        return changedInfo;
    }
    public void setChangedInfo(Flight changedInfo) {
        this.changedInfo = changedInfo;
    }
    public GateStatus getStatus() {
        return status;
    }
    public void setStatus(GateStatus status) {
        this.status = status;
    }
}
