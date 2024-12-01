package service;

import enums.GeneroLiterario;
import model.Cadastravel;
import model.Livro;
import java.util.ArrayList;
import java.util.Scanner;

public class LivroService implements Cadastravel {

    // CRIAÇÃO DE LISTA DE LIVROS
    public static ArrayList<Livro> livros = new ArrayList<>(); static {{
        livros.add(new Livro("Relato de um náufrago", "Gabriel García Marquez", GeneroLiterario.FICÇÃO));
        livros.add(new Livro("Capitães da Areia", "Jorge Amado", GeneroLiterario.FICÇÃO));
        livros.add(new Livro("Mar Morto", "Jorge Amado", GeneroLiterario.FICÇÃO));
        livros.add(new Livro("Introdução à programação com PYTHON", "Nilo Ney Coutinho Menezes", GeneroLiterario.INFORMATICA));
        livros.add(new Livro("Clara Nunes Guerreira da Utopia", "Vagner Fernandes", GeneroLiterario.BIOGRAFIAS));
        livros.add(new Livro("O egípcio", "Mika Waltari", GeneroLiterario.FICÇÃO));
        livros.add(new Livro("Um brasileiro em Berlim", "João Ubaldo Ribeiro", GeneroLiterario.FICÇÃO));
    }}


    // LISTAR TODOS OS LIVROS
    @Override
    public void listar() {
        if (livros.isEmpty()) {
            System.out.println("\nNenhum livro cadastrado.");
            return;
        }

        System.out.println("\nLivros cadastrados:");
        for (Livro funcionario : livros) {
            System.out.println(funcionario);
        }
    }


    // ATUALIZAR O TÍTULO DE UM LIVRO
    @Override
    public void atualizar(String titulo, String novoTitulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livro.setTitulo(novoTitulo);
                System.out.println("##### LIVRO ATUALIZADO COM SUCESSO #####");
                System.out.println(livro);
                return;
            }
        }
        System.out.println("\nFuncionário não encontrado!");
    }


    // REMOVER UM LIVRO PELO TÍTULO
    @Override
    public void remover(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(livro);
                System.out.println("###### LIVRO REMOVIDO COM SUCESSO ######");
                System.out.println(livro);
                return;
            }
        }
        System.out.println("\nFuncionário não encontrado!");
    }

    /// CADASTRAR LIVRO

    @Override
    public void cadastrar () {
        Scanner scanner = new Scanner(System.in);


        // INPUT DO TÍTULO DO LIVRO
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        // INPUT DO AUTOR DO LIVRO
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.next();
        scanner.nextLine();

       // INPUT DO GÊNERO DO LIVRO
        System.out.print("Digite o gênero literário (INFORMÁTICA, POESIA, AUTOAJUDA, FICÇÃO, INFANTIL, POLICIAL, SAÚDE, ROMANCE ou BIOGRAFIAS): ");
        String generoLiterarioInput = scanner.nextLine().toUpperCase();
        GeneroLiterario generoLiterario;

        // VALIDAÇÃO DO GÊNERO DO LIVRO
        try {
            generoLiterario = GeneroLiterario.valueOf(generoLiterarioInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Gênero literário inválido. Usando FICÇÃO como padrão.");
            generoLiterario = GeneroLiterario.FICÇÃO;
        }

        // CRIAÇÃO DO LIVRO
        Livro livro = new Livro(titulo, autor, generoLiterario);

        // ADICIONAR À LISTA
        livros.add(livro);
        System.out.println("##### LIVRO CADASTRADO COM SUCESSO #####");
    }
}
