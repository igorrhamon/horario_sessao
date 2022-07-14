import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<TimeZones> locais = new ArrayList<>();
        locais.add(TimeZones.SAO_PAULO);
        locais.add(TimeZones.PARIS);
        locais.add(TimeZones.LONDON);
        locais.add(TimeZones.NEW_YORK);
        locais.add(TimeZones.TOKYO);
        locais.add(TimeZones.SYDNEY);
        Agenda agenda = new Agenda(locais);
        agenda.exibeSessoes();
        // agenda.exibeSessoesPorLocal(TimeZones.SAO_PAULO);
        // agenda.exibeSessoesPorLocal(TimeZones.PARIS);
        // agenda.exibeSessoesPorLocal(TimeZones.LONDON);
        

    }
}
