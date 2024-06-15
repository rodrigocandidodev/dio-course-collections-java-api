package main.java.set.Pesquisa;

import java.util.Set;
import java.util.HashSet;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }
    
    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato contato : contatoSet) {
            if (contato.getNome().startsWith(nome)) {
                contatosPorNome.add(contato);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for(Contato contato : contatoSet) {
            if(contato.getNome().equalsIgnoreCase(nome)) {
                contato.setNumero(novoNumero);
                contatoAtualizado = contato;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();

        agenda.adicionarContato("João", 123456);
        agenda.adicionarContato("Maria", 789012);
        agenda.adicionarContato("Pedro", 345678);

        System.out.println("Contatos iniciais:");
        agenda.exibirContatos();

        Set<Contato> contatosPorNome = agenda.pesquisarPorNome("João");
        System.out.println("Contatos com nome 'João':");
        System.out.println(contatosPorNome);

        Contato contatoAtualizado = agenda.atualizarNumeroContato("Maria", 987654);
        System.out.println("Contato atualizado:");
        System.out.println(contatoAtualizado);

        System.out.println("Contatos após a atualização:");
        agenda.exibirContatos();
    
    }
}