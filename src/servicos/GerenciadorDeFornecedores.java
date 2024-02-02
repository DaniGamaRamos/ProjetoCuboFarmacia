package servicos;

import modelo.Fornecedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeFornecedores {

    Scanner scanner;

    public GerenciadorDeFornecedores() {
        scanner = new Scanner(System.in);
    }
    List<Fornecedor> fornecedoresList = new ArrayList<>();

    public void gerenciar(Scanner scanner) {
        int opcao = 0;
        do {
            System.out.println("\n========== Gerenciamento de Fornecedores ==========");
            System.out.println("1. Listar fornecedores");
            System.out.println("2. Adicionar fornecedor");
            System.out.println("3. Editar fornecedor");
            System.out.println("4. Remover fornecedor");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (opcao) {
                case 1:
                    listarFornecedores();
                    break;
                case 2:
                    adicionarFornecedor();
                    break;
                case 3:
                    editarFornecedor();
                    break;
                case 4:
                    removerFornecedor();
                    break;
                case 5:
                    // Volta ao menu principal
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 5);
    }

    public void listarFornecedores() {
        // verifica se a lista de fornecedores esta vazia
        if (fornecedoresList.isEmpty()) {
            System.out.println("Não há fornecedores cadastrados.");
            return;
        }
        for (Fornecedor fornecedor : fornecedoresList) { //loop for each
            System.out.println("ID: " + fornecedor.getId() + ", Nome: " + fornecedor.getNome() +
                    ", Endereço: " + fornecedor.getEndereco() + ", Telefone: " + fornecedor.getTelefone());
        }
    }

    public void adicionarFornecedor() {
        System.out.print("Digite o nome do fornecedor: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o endereço do fornecedor: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o telefone do fornecedor: ");
        String telefone = scanner.nextLine();

        // O ID é gerado automaticamente com base no tamanho da lista
        int id = fornecedoresList.size() + 1;
        Fornecedor novoFornecedor = new Fornecedor(id, nome, endereco, telefone);
        fornecedoresList.add(novoFornecedor);
        System.out.println("Fornecedor adicionado com sucesso!");
    }

    public void editarFornecedor() {
        System.out.print("Digite o ID do fornecedor que deseja editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Fornecedor fornecedor : fornecedoresList) {
            if (fornecedor.getId() == id) {
                System.out.print("Digite o novo nome do fornecedor: ");
                fornecedor.setNome(scanner.nextLine());
                System.out.print("Digite o novo endereço do fornecedor: ");
                fornecedor.setEndereco(scanner.nextLine());
                System.out.print("Digite o novo telefone do fornecedor: ");
                fornecedor.setTelefone(scanner.nextLine());
                System.out.println("Fornecedor atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Fornecedor não encontrado.");
    }

    public void removerFornecedor() {
        System.out.print("Digite o ID do fornecedor que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Fornecedor fornecedorARemover = null;
        for (Fornecedor fornecedor : fornecedoresList) {
            if (fornecedor.getId() == id) {
                fornecedorARemover = fornecedor;
                break;
            }
        }
        if (fornecedorARemover != null) {
            fornecedoresList.remove(fornecedorARemover);
            System.out.println("Fornecedor removido com sucesso!");
        } else {
            System.out.println("Fornecedor não encontrado.");
        }
    }

}
