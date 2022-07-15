package enums;

import java.time.ZoneId;

public enum TimeZonesAgenda {
    
    SAO_PAULO("São Paulo", ZoneId.of("America/Sao_Paulo")),
    PARIS("Paris", ZoneId.of("Europe/Paris")),
    LONDON("London", ZoneId.of("Europe/London")),
    NEW_YORK("New York", ZoneId.of("America/New_York")),
    TOKYO("Tokyo", ZoneId.of("Asia/Tokyo")),
    SYDNEY("Sydney", ZoneId.of("Australia/Sydney")),
    MELBOURNE("Melbourne", ZoneId.of("Australia/Melbourne")),
    BERLIN("Berlin", ZoneId.of("Europe/Berlin")),
    LISBON("Lisbon", ZoneId.of("Europe/Lisbon")),
    
    ROME("Rome", ZoneId.of("Europe/Rome")),

    ;

    private String name;
    private ZoneId zoneId;

    TimeZonesAgenda(String name, ZoneId zoneId) {
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
