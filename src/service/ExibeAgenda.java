package service;

import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import enums.TimeZonesAgenda;
import model.Agenda;
import model.Sessao;

public class ExibeAgenda {

    private Agenda agenda;
    private final Locale locale = new Locale("pt", "BR");
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", locale);

    public ExibeAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public void exibeSessoes(){
        int contador=0;
        for (Sessao sessao : agenda.getSessoes()) {
                
            if(contador==agenda.getLocais().size()){
                System.out.println("Numero da sessao: " + sessao.getNumSessao() +" -----------------");
                contador=0;
            }
            System.out.println("Local: " + sessao.getLocal().getName());
            System.out.println("Horário: " + sessao.getInicio().format(
                formatter));
            
            System.out.println("Dia da semana: " + sessao.getInicio().getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, locale));

                    
            System.out.println("Time Zone: " + sessao.getLocal().getZoneId().getDisplayName(TextStyle.FULL, new Locale("pt", "BR")));
            System.out.println("-----------------------------------------------------");
            contador++;
        }
    }
    
    public void exibeSessoesPorLocal(TimeZonesAgenda local) {
        
        StringBuilder sb = new StringBuilder();
        for (Sessao sessao : agenda.getSessoes()) {
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
                    // .atZone(sao_Paulo.getZoneId())
                    // .toLocalDateTime()
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
