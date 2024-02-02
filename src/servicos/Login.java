package servicos;

public class Login {
    private String nomeDeUsuario;
    private String senha;

    // Constructor
    public Login(String username, String senha) {
        this.nomeDeUsuario = username;
        this.senha = senha;
    }

    // Metodo para validar credenciais
    public boolean validarLogin(String usernameDigitado, String senhaDigitada) {
        return nomeDeUsuario.equals(usernameDigitado) && senha.equals(senhaDigitada);
    }
}
