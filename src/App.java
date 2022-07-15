import java.util.ArrayList;
import java.util.List;

import enums.TimeZonesAgenda;
import model.Agenda;
import model.Local;
import service.ExibeAgenda;
import service.InsereLocal;
import service.agenda_observer.ImprimeListener;

public class App {
    public static void main(String[] args) throws Exception {
        List<Local> locais = new ArrayList<>();
        locais.add(new Local("São Paulo", TimeZonesAgenda.SAO_PAULO.getZoneId()));
        locais.add(new Local("Lisboa", TimeZonesAgenda.LISBON.getZoneId()));
        locais.add(new Local("Paris", TimeZonesAgenda.PARIS.getZoneId()));
        
        Agenda agenda = new Agenda(locais);
        
        // ExibeAgenda exibeAgenda = new ExibeAgenda(agenda);
        // exibeAgenda.exibeSessoesPorLocal(TimeZonesAgenda.SAO_PAULO);
        
        InsereLocal insereLocal = new InsereLocal(agenda);
        insereLocal.eventManager.addListener("insereLocal", new ImprimeListener());
        insereLocal.insereLocal("New York", TimeZonesAgenda.NEW_YORK.getZoneId());
        

    }
}
