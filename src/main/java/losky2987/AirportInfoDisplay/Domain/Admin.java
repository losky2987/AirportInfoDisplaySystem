package losky2987.AirportInfoDisplay.Domain;

public class Admin {
    private final long id;
    private final AdminIdent ident;

    public Admin(long id, AdminIdent ident) {
        this.id = id;
        this.ident = ident;
    }

    public long getId() {
        return id;
    }

    public AdminIdent getIdent() {
        return ident;
    }
}
