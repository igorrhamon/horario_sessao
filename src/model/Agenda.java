package model;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import enums.TimeZonesAgenda;

public class Agenda {

    
    private List<Sessao> sessoes = new ArrayList<>();
    private List<Local> locais = new ArrayList<>();
    
    public List<Local> getLocais() {
        // List of locales
        return locais;
    }

    private final Local sao_Paulo = new Local("São Paulo", ZoneId.of("America/Sao_Paulo"));
    final LocalDateTime inicio = ZonedDateTime.of(
        LocalDateTime.of( 2022, 7, 20,22, 0 ), 
        sao_Paulo.getZoneId()
        ).toLocalDateTime();
        
        
        final LocalDateTime fim = ZonedDateTime.of(
            LocalDateTime.of( 2022, 10, 29,23, 59 ),
            sao_Paulo.getZoneId()
            ).toLocalDateTime();
    
    
    public Agenda(List<Local> locais) {
        this.locais = locais;
        LocalDateTime horarioProximaSessao = inicio;
        int numSessao = 1;
        
        do {
            
            for (Local timeZones : locais) {
                Instant instant = horarioProximaSessao.atZone(timeZones.getZoneId()).toInstant();
                Local local = new Local(timeZones.getName(), timeZones.getZoneId());
                Sessao sessaoZoned = new Sessao(
                    LocalDateTime.ofInstant(instant, sao_Paulo.getZoneId()),
                    local,
                    numSessao
                    );
                    
                    sessoes.add(sessaoZoned);
                }
                horarioProximaSessao = horarioProximaSessao.plusDays(10).plusHours(2);
                numSessao++;
        } while (horarioProximaSessao.isBefore(fim));
            
        
        
    }
    
    public List<Sessao> getSessoes() {
        return sessoes;
    }
        



    
}
