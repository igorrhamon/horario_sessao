import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Agenda {

    
    final Local sao_Paulo = new Local("São Paulo", ZoneId.of("America/Sao_Paulo"));
    final Local paris = new Local("Paris", ZoneId.of("Europe/Paris"));
    
    final LocalDateTime inicio = LocalDateTime.of( 2022, 7, 20,22, 0 );
    
    final LocalDateTime fim = LocalDateTime.of( 2022, 10, 29,23, 59 );
    private List<Sessao> sessoes = new ArrayList<>();
    
    public Agenda() {
        LocalDateTime controle = inicio;
        int numSessao = 1;
        do {
            
            Sessao sessao = new Sessao(controle, sao_Paulo, numSessao);
            
            Sessao sessao2 = new Sessao(controle, paris, numSessao);
            
            sessoes.add(sessao);
            sessoes.add(sessao2);
            controle = controle.plusDays(10).plusHours(2);
            numSessao++;
        } while (controle.isBefore(fim));

        
    }

    public void exibeSessoes() {
        for (Sessao sessao : sessoes) {
            System.out.println("N°: "+ sessao.getNumSessao() + " " +
            sessao.getInicio() 
            + " - " + sessao.getLocal().getName());
        }
    }



    
}
