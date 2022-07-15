package service;

import java.time.ZoneId;

import model.Agenda;
import model.Local;
import service.agenda_observer.EventManager;

public class InsereLocal {
    private Agenda agenda;
    public EventManager eventManager;

    public InsereLocal(Agenda agenda) {
        this.agenda = agenda;
        eventManager = new EventManager(agenda, "insereLocal");
    }

    public void insereLocal(String name, ZoneId zoneId) {
        agenda.getLocais().add(new Local(name, zoneId));
        eventManager.trigger("insereLocal");
    }

}
