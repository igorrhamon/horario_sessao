import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TimeZone;

public class Sessao {
    private LocalDateTime inicio;
    LocalDateTime fim;
    private Local local;
    private int numSessao;

    public Local getLocal() {
        return local;
    }


    public Sessao(LocalDateTime inicio, Local local, int    numSessao) {
        System.out.println(ZonedDateTime.of(inicio, local.getZoneId()).toLocalDateTime());
        this.inicio = ZonedDateTime.of(inicio, local.getZoneId()).toLocalDateTime();
        this.fim = inicio.plusHours(6);
        this.local = local;
        this.numSessao = numSessao;
    }


    public LocalDateTime getInicio() {
        return inicio;
    }


    public String getNumSessao() {
        return Integer.toString(numSessao);
    }
}