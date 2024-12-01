package model;


public final class Funcionario extends Pessoa {
    //ATRIBUTOS
    private int matricula;
    private String email;
    private String cpf;



    //CONSTRUTOR
    public Funcionario(String nome, String  email, String cpf, int matricula) {
        super(nome);
        this.email = email;
        this.cpf = cpf;
        this.matricula = matricula;
    }

    public Funcionario() {

    }

    //GETTERS AND SETTERS
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
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


    //TOSTRING
    @Override
    public String toString() {
        return "Nome: " + nome +
                ", E-mail: " + email +
                ", Matrícula: " + matricula;
    }



    //MÉTODOS


    @Override
    public void avaliarFeedback(String feedback) {
        System.out.println("\n#### O funcionário responsável analisará o feedback fornecido ####");
    }
}







