package model;

import enums.GeneroLiterario;

public class Livro {

    //ATRIBUTOS
    private String titulo;
    private String autor;
    private GeneroLiterario generoLiterario;
    private boolean disponivel;


    //GETTERS E SETTERS
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public GeneroLiterario getGeneroLiterario() {
        return generoLiterario;
    }
    public void setGeneroLiterario(GeneroLiterario generoLiterario) {
        this.generoLiterario = generoLiterario;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    //CONSTRUTOR
    public Livro(String titulo, String autor, GeneroLiterario generoLiterario) {
        this.titulo = titulo;
        this.autor = autor;
        this.generoLiterario = generoLiterario;
        this.disponivel = true;
    }

    public Livro() {
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nAutor:  " + autor +
                "\nGenero:  " + generoLiterario;
    }





}
