package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProduto {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProduto() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long code, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(code, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos() {
        System.out.println("Estoque de Produtos: " + estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0;

        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
    }
    
    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                if(p.getPreco() > maiorPreco) {
                    maiorPreco = p.getPreco();
                    produtoMaisCaro = p;
                }
            }
        }
        return produtoMaisCaro;
    }

    public static void main(String[] args) {
        EstoqueProduto estoque = new EstoqueProduto();

        estoque.adicionarProduto(1, "Produto 1", 10, 9.99);
        estoque.adicionarProduto(2, "Produto 2", 5, 14.99);
        estoque.adicionarProduto(3, "Produto 3", 15, 19.99);

        estoque.exibirProdutos();

        double valorTotalEstoque = estoque.calcularValorTotalEstoque();
        System.out.println("Valor total do estoque: R$ " + valorTotalEstoque);

        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("Produto mais caro: " + produtoMaisCaro.getNome() + " (R$ " + produtoMaisCaro.getPreco() + ")");
    }
}
