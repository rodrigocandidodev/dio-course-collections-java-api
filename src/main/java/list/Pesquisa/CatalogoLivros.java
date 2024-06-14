package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;

    public CatalogoLivros(List<Livro> LivroList) {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        Livro novoLivro = new Livro(titulo, autor, anoPublicacao);
        livroList.add(novoLivro);
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!livroList.isEmpty()) {
            for(Livro livro : livroList) {
                if(livro.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(livro);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosPorIntervalo = new ArrayList<>();
        if(!livroList.isEmpty()) {
            for(Livro livro : livroList) {
                if(livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
                    livrosPorIntervalo.add(livro);
                }
            }
        }
        return livrosPorIntervalo;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livroPorTLivro = null;
        if(!livroList.isEmpty()) {
            for(Livro livro : livroList) {
                if(livro.getTitulo().equalsIgnoreCase(titulo)) {
                    livroPorTLivro = livro;
                    break;
                }
            }
        }
        return livroPorTLivro;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogo = new CatalogoLivros(new ArrayList<>());
        catalogo.adicionarLivro("O Senhor dos Anéis", "J. R. R. Tolkien", 1954);
        catalogo.adicionarLivro("A Guerra dos Tronos", "George R. R. Martin", 1996);
        catalogo.adicionarLivro("O Retrato de Richard Diamond", "Daniel Suarez", 2015);

        System.out.println("Livros por autor: " + catalogo.pesquisarPorAutor("J. R. R. Tolkien"));
        System.out.println("Livros publicados entre 1950 e 1960: " + catalogo.pesquisarPorIntervaloAnos(1950, 1960));
        System.out.println("Livro por título: " + catalogo.pesquisarPorTitulo("O Retrato de Richard Diamond"));
    }
}
