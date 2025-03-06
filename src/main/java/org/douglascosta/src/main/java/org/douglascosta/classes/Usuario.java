package org.douglascosta.classes;

public class Usuario {
    private final int id;
    private final String nome_completo;
    private final String cpf_cnpj;
    private String email;
    private String senha;
    private String endereco;

    public Usuario(int id, String nome_completo, String cpf_cnpj, String email, String senha, String endereco) {
        this.id = id;
        this.nome_completo = nome_completo;
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getCpfCnpj() {
        return cpf_cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void exibirInformacao() {
        System.out.println("ID: " + getId() +
                " Nome: " + getNome_completo() +
                " CPF/CNPJ: " + getCpfCnpj() +
                " Endereço: " + getEndereco() +
                " Email: " + getEmail() +
                " Password: " + getSenha());
    }
}