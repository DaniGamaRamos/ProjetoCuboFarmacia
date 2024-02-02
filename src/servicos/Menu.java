package servicos;

import java.util.Scanner;

public class Menu {
    
    GerenciadorDeVendas gerenciadorDeVendas;
    Scanner scanner;
    GerenciadorDeFornecedores gerenciadorDeFornecedores;

   
    GerenciadorDeProdutos gerenciadorDeProdutos;

    public Menu(GerenciadorDeVendas gerenciadorDeVendas, Scanner scanner, GerenciadorDeFornecedores gerenciadorDeFornecedores, GerenciadorDeProdutos gerenciadorDeProdutos) {
        //O this associa o parametro de entrada a classe menu. o this referencia a classe
    	this.gerenciadorDeVendas = gerenciadorDeVendas;
        this.scanner = scanner;
        this.gerenciadorDeFornecedores = gerenciadorDeFornecedores;
        this.gerenciadorDeProdutos = gerenciadorDeProdutos;
    }
    public void mostrarMenu() {
        int opcao = 0;
        // estrutura de repeticao do-while executa sempre a primeira vez e
        // enquanto a condicao for true
        do {
            System.out.println("\n========== Menu Principal ==========");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Fornecedores");
            System.out.println("3. Registrar Venda");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            // estrutura de repeticao
            // ao inves de fazer (if (opcao == 1))
            switch (opcao) {
                case 1:
                    gerenciadorDeProdutos.gerenciar(scanner);
                    //O break faz com que encerre o switch case sem passar pelas outras opções.
                    break;
                case 2:
                    gerenciadorDeFornecedores.gerenciar(scanner);
                    break;
                case 3:
                    gerenciadorDeVendas.registrar(scanner);
                    break;
                case 4:
                    break;
                // se o usuario digitar qualquer coisa que nao seja o que foi predefinido
                // acima, o default é executado
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 4);
    }

}
