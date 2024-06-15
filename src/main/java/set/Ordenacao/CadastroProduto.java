package main.java.set.Ordenacao;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class CadastroProduto {
    private Set<Produto> produtoSet;

    public CadastroProduto() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(nome, codigo, preco, quantidade));
    }
    
    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>();
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutoPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(produtoSet);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProduto cadastro = new CadastroProduto();
        cadastro.adicionarProduto(1, "TV", 1000.00, 10);
        cadastro.adicionarProduto(2, "Geladeira", 500.00, 20);
        cadastro.adicionarProduto(3, "Notebook", 2000.00, 15);

        System.out.println("Produtos ordenados por nome:");
        Set<Produto> produtosPorNome = cadastro.exibirProdutosPorNome();
        for (Produto produto : produtosPorNome) {
            System.out.println(produto);
        }

        System.out.println("\nProdutos ordenados por preço:");
        Set<Produto> produtosPorPreco = cadastro.exibirProdutoPorPreco();
        for (Produto produto : produtosPorPreco) {
            System.out.println(produto);
        }
    }
}