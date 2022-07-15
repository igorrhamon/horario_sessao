package service.agenda_observer;

import model.Agenda;
import service.ExibeAgenda;

public class ImprimeListener implements Agendador_Listener {
    @Override
    public void update(Agenda agenda) {
        ExibeAgenda exibeAgenda = new ExibeAgenda(agenda);
        exibeAgenda.exibeSessoes();
    }
    
}
