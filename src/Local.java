import java.time.ZoneId;

public class Local {
    private String name;
    private ZoneId zoneId ;

    public Local(String name, ZoneId zoneId) {
        this.name = name;
        this.zoneId = zoneId;
    }

    public String getName() {
        return name;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

}
