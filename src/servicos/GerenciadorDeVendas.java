package servicos;

import modelo.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeVendas {

    //sera um mock da base de dados, onde todos os itens vendidos sao registrados
    private GerenciadorDeProdutos gereniadorDeProdutos;
    public GerenciadorDeVendas(GerenciadorDeProdutos gerenciadorDeProdutos) {
        // recebe o gerenciador de produtos e aloca-o na variavel gerenciador de produtos
        // deste classe. Por isto o uso do 'this'
        this.gereniadorDeProdutos = gerenciadorDeProdutos;
    }

    public void registrar(Scanner scanner) {
        List<ItemVenda> itensVendidos = new ArrayList<>();
        boolean adicionandoProdutos = true;
        System.out.println("Iniciando registro de venda...");

        // enquanto adicionando produtos for true
        while (adicionandoProdutos) {
            System.out.println("Produtos disponíveis:");
            for (Produto produto : gereniadorDeProdutos.produtosList) {
                System.out.println(produto.getNome() + " - R$ " + produto.getPreco());
            }

            System.out.print("Digite o (Nome do Produto) para adicionar à venda ou ( 0 )para finalizar : ");
            String nome = scanner.next();

            if (nome.equals("0")) {
                adicionandoProdutos = false;
            } else {
                Produto produtoSelecionado = null;
                for (Produto produto : gereniadorDeProdutos.produtosList) {
                    if (produto.getNome().equals(nome)) {
                        produtoSelecionado = produto;
                        break;
                    }
                }

                if (produtoSelecionado != null) {
                    System.out.print("Digite a quantidade do produto: ");
                    int quantidade = scanner.nextInt();
                    ItemVenda itemVenda = new ItemVenda(produtoSelecionado, quantidade, produtoSelecionado.getPreco());
                    itensVendidos.add(itemVenda);
                    System.out.println("Produto adicionado à venda.");
                } else {
                    System.out.println("Produto não encontrado.");
                }
            }

            // Calcula o total da venda
            double totalVenda = 0;
            for (ItemVenda item : itensVendidos) {
                totalVenda = totalVenda + item.getPreco() * item.getQuantidade();
            }

            System.out.println("\n======Total Da Venda=======: R$ " + totalVenda);
        }

    }

    // Classe interna para representar um item vendido
    public static class ItemVenda {
        private Produto produto;
        private int quantidade;
        private double preco;

        // Construtor
        public ItemVenda(Produto produto, int quantidade, double preco) {
            this.produto = produto;
            this.quantidade = quantidade;
            this.preco = preco;
        }

        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }
    }
}

