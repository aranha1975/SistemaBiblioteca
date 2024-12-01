package model;


public class Emprestimo {

    // ATRIBUTOS
    private Livro livro;
    private Pessoa usuario;
    private Pessoa funcionario;
    private int diasEmprestimo;



    // GETTERS E SETTERS
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Usuario getUsuario() {
        return (Usuario) usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Funcionario getFuncionario() {
        return (Funcionario) funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public int getDiasEmprestimo() {
        return diasEmprestimo;
    }
    public void setDiasEmprestimo(int diasEmprestimo) {
        this.diasEmprestimo = diasEmprestimo;
    }



    // CONSTRUTOR
    public Emprestimo(Livro livro, Usuario usuario, Funcionario funcionario, int diasEmprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.funcionario = funcionario;
        this.diasEmprestimo = diasEmprestimo;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Título: " + livro +
                "\nAUsuário:  " + usuario +
                "\nFuncionário:  " + funcionario +
                "\nDias Emprestado: " + diasEmprestimo;
    }



}
