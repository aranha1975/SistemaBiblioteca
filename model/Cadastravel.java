package model;

public interface Cadastravel {

    void cadastrar ();

    void listar();

    void atualizar(String nome, String novoNome);

    void remover(String nome);

}