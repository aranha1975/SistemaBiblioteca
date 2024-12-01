package model;

public abstract class Pessoa {

    // ATRIBUTOS
    protected String nome;


    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    // CONSTRUTOR
    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa() {
    }


    //MÉTODOS (abstrato)

    public abstract void avaliarFeedback(String feedback);

}
