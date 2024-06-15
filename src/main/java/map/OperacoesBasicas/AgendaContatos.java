package main.java.map.OperacoesBasicas;

import java.util.Map;
import java.util.HashMap;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if(!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(agendaContatoMap);
    }

    public Integer pesqusarPorNome(String nome) {
        Integer numeroPorNome = null;
        if(!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main (String[] args) {
        AgendaContatos agenda = new AgendaContatos();
        agenda.adicionarContato("João", 123456);
        agenda.adicionarContato("Maria", 789012);
        agenda.exibirContatos();
        agenda.removerContato("João");
        agenda.exibirContatos();
        System.out.println(agenda.pesqusarPorNome("Maria"));
    }
}
