package service.agenda_observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Agenda;

public class EventManager {
    Map<String, List<Agendador_Listener>> events = new HashMap<>();
    private Agenda agenda;

    public EventManager(Agenda agenda, String... operations) {
        for (String operation : operations) {
            this.events.put(operation, new ArrayList<>());
        }
        this.agenda = agenda;
    }
    


    public void addListener(String event, Agendador_Listener listener) {
        if (!events.containsKey(event)) {
            events.put(event, new ArrayList<>());
        }
        events.get(event).add(listener);
    }

    public void removeListener(String event, Agendador_Listener listener) {
        if (events.containsKey(event)) {
            events.get(event).remove(listener);
        }
    }

    public void trigger(String event) {
        List<Agendador_Listener> novos_Locais = events.get(event);
        for (Agendador_Listener listener : novos_Locais) {
            listener.update(agenda);
        }
    }
}
