import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Agenda {

    
    final Local sao_Paulo = new Local("São Paulo", ZoneId.of("America/Sao_Paulo"));
    final Local paris = new Local("Paris", ZoneId.of("Europe/Paris"));
    
    final LocalDateTime inicio = ZonedDateTime.of(
        LocalDateTime.of( 2022, 7, 20,22, 0 ), 
        sao_Paulo.getZoneId()
        ).toLocalDateTime();
    
    
    final LocalDateTime fim = ZonedDateTime.of(
        LocalDateTime.of( 2022, 10, 29,23, 59 ),
        sao_Paulo.getZoneId()
        ).toLocalDateTime();
    
    private List<Sessao> sessoes = new ArrayList<>();
    
    public Agenda(List<TimeZones> locais) {
        LocalDateTime controle = inicio;
        int numSessao = 1;
        // do {
            
            
            
        //     Instant instantParis = controle.atZone(paris.getZoneId()).toInstant();
            
            
        
        //     sessoes.add(sessaoSaoPaulo);
        //     sessoes.add(sessaoParis);
        //     controle = controle.plusDays(10).plusHours(2);
        //     numSessao++;
        // } while (controle.isBefore(fim));
        do {
            
            for (TimeZones timeZones : locais) {
                Instant instant = controle.atZone(timeZones.getZoneId()).toInstant();
                Local local = new Local(timeZones.getName(), timeZones.getZoneId());
                Sessao sessaoZoned = new Sessao(
                    LocalDateTime.ofInstant(instant, sao_Paulo.getZoneId()),
                    local,
                    numSessao
                );
                
                sessoes.add(sessaoZoned);
            }
            controle = controle.plusDays(10).plusHours(2);
            numSessao++;
        } while (controle.isBefore(fim));

        
    }

    public void exibeSessoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sessões: \n");
        for (Sessao sessao : sessoes) {
            sb.append(sessao.getNumSessao())
            .append(" - ")
            .append(sessao.getInicio())
            .append(" - ")
            .append(sessao.getLocal().getName())
            .append("\n")
            .append("\n");
            
        }
        
        System.out.println(sb.toString());
    }

    public void exibeSessoesPorLocal(TimeZones local) {
        // for (Sessao sessao : sessoes) {
        //     if (sessao.getLocal().getName().equals(string)) {
        //         System.out.println("N°: "+ sessao.getNumSessao() + " " +
        //         sessao.getInicio().atZone(sessao.getLocal().getZoneId()).toLocalDateTime().format(
        //             java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
        //         ) 
        //         + " - " + sessao.getLocal().getName());
        //         System.out.println("");
        //     }
        // }

        StringBuilder sb = new StringBuilder();
        for (Sessao sessao : sessoes) {
            // java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"
            if (sessao.getLocal().getName().equals(local.getName())) {
                
                sb.append("N°: "+ sessao.getNumSessao());
                sb.append(" ");
                sb.append(
                    sessao.getInicio().atZone(sessao.getLocal().getZoneId()).toLocalDateTime().format(
                        java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
                    )    
                    
                    
                    
                );
                sb.append(" - ");
                
                sb.append(
                    sessao.getInicio()
                    .atZone(sao_Paulo.getZoneId())
                    .toLocalDateTime()
                    .getDayOfWeek()
                    .getDisplayName(
                        TextStyle.FULL_STANDALONE, 
                        new Locale("pt","BR")
                    )
                );
                sb.append(" - ");
                sb.append(sessao.getLocal().getName());
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());


    }



    
}
