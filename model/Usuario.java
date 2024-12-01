package model;

import enums.TipoUsuario;

public final class Usuario extends Pessoa {


    //ATRIBUTOS
    private String email;
    private String cpf;
    private TipoUsuario tipoUsuario;


    //CONSTRUTOR
    public Usuario(String nome, String email, String cpf, TipoUsuario tipoUsuario) {
        super(nome);
        this.email = email;
        this.cpf = cpf;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario() {
    }

    //GETTERS E SETTERS
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


    //TOSTRING
    @Override
    public String toString() {
        return "Nome: " + nome +
                ", E-mail: " + email +
                ", Tipo: " + tipoUsuario;
    }



    //MÉTODOS


    @Override
    public void avaliarFeedback(String feedback) {
        System.out.println("\n#### O usuário forneceu o seguinte feedback ####\n    -> -> " + feedback + " <- <- ");
    }
}
