import servicos.*;

import java.util.Scanner;

public class Main {
    // Metodo de entrada do programa
    public static void main(String[] args) {
        // Instanciando dependencias para uso ,ou seja aqui está gerenciando minha classes:
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeProdutos gereniadorDeProdutos = new GerenciadorDeProdutos();
        GerenciadorDeVendas gerenciadorDeVendas = new GerenciadorDeVendas(gereniadorDeProdutos);
        GerenciadorDeFornecedores gerenciadorDeFornecedores = new GerenciadorDeFornecedores();
        Menu menu = new Menu(gerenciadorDeVendas, scanner, gerenciadorDeFornecedores, gereniadorDeProdutos);

        // Cria uma instancia de login com nome de usuario e senha pre definido (mock)
        Login login = new Login("dani", "123");
        System.out.println("========== Farmácia Cubo - Login ==========");
        System.out.print("Nome de Usuario: ");
        String nomeDeUsuario = scanner.nextLine();

        System.out.print("senha: ");
        String senha = scanner.nextLine();

        // Checar se as credenciais sao validas
        if (login.validarLogin(nomeDeUsuario, senha)) {
            System.out.println("Login bem sucedido. Bem vindo," + nomeDeUsuario + "!");
          //se o login estiver ok aparece o MENU
            menu.mostrarMenu();
        } else {
            System.out.println("Login Inválido. Por favor, tente novamente.");
        }
        
    }
}