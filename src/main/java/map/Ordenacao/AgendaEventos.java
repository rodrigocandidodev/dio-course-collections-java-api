package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos(){
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        Evento evento = new Evento(nome, atracao);
        eventosMap.put(data, evento);
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
        //o LocalDate já organiza a agenda em ordem cronológica
    }

    public void obterProximoEvento() {
        /*Set<LocalDate> dataSet = eventosMap.keySet();
        Collection<Evento> values = eventosMap.values();
        Não podemos usar essas duas variáveis para obter o próximo evento, pois não podemos ter acesso a um Set ou Collection sem um Map.
        Não consigo pegar uma data no dataSet e vincular a uma Collection
        eventosMap.get() -> não tenho a chave
        */
        
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;

        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);

        for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("Próximo evento: " + proximoEvento + " acontecerá na data " + proximaData);
                break;
            }
            else System.out.println("Não há eventos agendados");
        }
    }
    
    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JULY, 15), "Festa do João", "Casa do João");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.APRIL, 1), "Festa da Maria", "Casa da Maria");

        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();
    }
}
