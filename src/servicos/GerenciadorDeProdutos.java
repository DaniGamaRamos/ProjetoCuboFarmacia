package servicos;

import modelo.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeProdutos {

    List<Produto> produtosList = new ArrayList<>();

    public GerenciadorDeProdutos() {
        produtosList.add(new Produto( "aspirina", 5.00));
        produtosList.add(new Produto("paracetamol", 8.50));
        produtosList.add(new Produto("ibuprofeno", 7.30));
    }

    Scanner scanner;
    public void gerenciar(Scanner scanner) {
        this.scanner = scanner;
        int opcao = 0;
        do {
            System.out.println("\n========== Gerenciamento de Produtos ==========");
            System.out.println("1. Listar produtos");
            System.out.println("2. Adicionar produto");
            System.out.println("3. Editar produto");
            System.out.println("4. Remover produto");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    adicionarProduto();
                    break;
                case 3:
                    editarProduto();
                    break;
                case 4:
                    removerProduto();
                    break;
                case 5:
                    // Volta ao menu principal
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 5);
    }

    public void listarProdutos() {
        if (produtosList.isEmpty())//vazia 
        	{
            System.out.println("Não há produtos cadastrados.");
            return;
        }

        // loop para percorrer a lista de produtos listando-os
        for (Produto produto : produtosList) {
            System.out.println("Nome: " + produto.getNome() +
                    ", Preço: R$ " + produto.getPreco());            
        }
    }

    public void adicionarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
    
        scanner.nextLine();

        Produto novoProduto = new Produto(nome, preco);
        produtosList.add(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }

    public void editarProduto() {
        System.out.print("Digite o nome do produto que deseja editar: ");
        String nome = scanner.next();
        scanner.nextLine();
        // para cada produto da produtosList
        for (Produto produto : produtosList) {
            if (produto.getNome().equals(nome)) {
                System.out.print("Digite o novo nome do produto: ");
                produto.setNome(scanner.nextLine());
                System.out.print("Digite o novo preço do produto: ");
                produto.setPreco(scanner.nextDouble());
                scanner.nextLine(); // Consume newline left-over
                System.out.println("Produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void removerProduto() {
        System.out.print("Digite o Nome do produto que deseja remover: ");
        String nome = scanner.next();
        scanner.nextLine();
        Produto produtoARemover = null;
        for (Produto produto : produtosList) {
            if (produto.getNome().equals(nome)) {
                produtoARemover = produto;
                break;
            }
        }
        if (produtoARemover != null) {
            produtosList.remove(produtoARemover);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

}
