package main.java.set.OperacoesBasicas;

import java.util.Set;
import java.util.HashSet;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadePorCodigoConvite(int condigoConvite) {
        Convidado convidadoParaRemover = null;
        for(Convidado convidado : convidadoSet) {
            if(convidado.getCodigoConvite() == condigoConvite) {
                convidadoParaRemover = convidado;
                break;
            }
        }
        convidadoSet.remove(convidadoParaRemover);
    }

    public void exibirConvidados() {
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjunto = new ConjuntoConvidados();

        conjunto.adicionarConvidado("Joao", 1);
        conjunto.adicionarConvidado("Maria", 2);
        conjunto.adicionarConvidado("Jose", 3);

        conjunto.exibirConvidados();

        conjunto.removerConvidadePorCodigoConvite(2);

        conjunto.exibirConvidados();
    }
}
