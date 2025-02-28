package classes;

public class Usuario {
    private final int id;
    private final String username;
    private final String cpfCnpj;
    private String endereco;
    private String email;
    private String password;

    public Usuario(int id, String username, String cpfCnpj, String endereco, String email, String password) {
        this.id = id;
        this.username = username;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void exibirInformacao() {
        System.out.println("ID: " + getId() +
                " Nome: " + getUsername() +
                " CPF/CNPJ: " + getCpfCnpj() +
                " Endereço: " + getEndereco() +
                " Email: " + getEmail() +
                " Password: " + getPassword());
    }
}

