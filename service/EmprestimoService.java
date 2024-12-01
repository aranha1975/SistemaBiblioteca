package service;

import model.Emprestimo;
import model.Funcionario;
import model.Livro;
import model.Usuario;
import java.util.Scanner;
import java.util.ArrayList;


public class EmprestimoService {

    private static final ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void emprestar() {
        // EXIBIR A LISTA DE LIVROS
        System.out.println("\nLivros cadastrados:");
        for (int i = 0; i < LivroService.livros.size(); i++) {
            System.out.println(i + 1 + ". " + LivroService.livros.get(i).getTitulo());
        }

        // INPUT DO TÍTULO DO LIVRO
        System.out.print("\nEscolha o número do título do livro: ");
        int livroIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (livroIndex >= 0 && livroIndex < LivroService.livros.size()) {
            Livro livroSelecionado = LivroService.livros.get(livroIndex);

            // Verificar se o livro está disponível para empréstimo
            if (livroSelecionado.isDisponivel()) {
                // EXIBIR A LISTA DE USUÁRIOS
                System.out.println("\nUsuários cadastrados:");
                for (int i = 0; i < UsuarioService.usuarios.size(); i++) {
                    System.out.println(i + 1 + ". " + UsuarioService.usuarios.get(i).getNome());
                }

                // INPUT DO NOME DO USUÁRIO
                System.out.print("\nEscolha o número do usuário: ");
                int usuarioIndex = scanner.nextInt() - 1;
                scanner.nextLine();
                if (usuarioIndex >= 0 && usuarioIndex < UsuarioService.usuarios.size()) {
                    Usuario usuarioSelecionado = UsuarioService.usuarios.get(usuarioIndex);

                    // EXIBIR A LISTA DE FUNCIONÁRIOS
                    System.out.println("\nFuncionários cadastrados:");
                    for (int i = 0; i < FuncionarioService.funcionarios.size(); i++) {
                        System.out.println(i + 1 + ". " + FuncionarioService.funcionarios.get(i).getNome());
                    }

                    // INPUT DO NOME DO FUNCIONÁRIO
                    System.out.print("\nEscolha o número do funcionário: ");
                    int funcionarioIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (funcionarioIndex >= 0 && funcionarioIndex < FuncionarioService.funcionarios.size()) {
                        Funcionario funcionarioSelecionado = FuncionarioService.funcionarios.get(funcionarioIndex);

                        // O valor de diasEmprestimo agora é fixo em 30
                        int diasEmprestimo = 30;  // Definido como 30 automaticamente

                        // Criar o empréstimo
                        Emprestimo emprestimo = new Emprestimo(livroSelecionado, usuarioSelecionado, funcionarioSelecionado, diasEmprestimo);
                        emprestimos.add(emprestimo);  // Adicionar à lista de empréstimos
                        livroSelecionado.setDisponivel(false);  // Marcar o livro como não disponível
                        System.out.println("Empréstimo registrado: " + livroSelecionado.getTitulo() + ", para " + usuarioSelecionado.getNome() + ", por " + diasEmprestimo + " dias.");
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                } else {
                    System.out.println("Usuário não encontrado.");
                }
            } else {
                System.out.println("O livro não está disponível para empréstimo.");
            }
        } else {
            System.out.println("Livro não encontrado.");
        }
    }


    public void devolver() {

        // Exibir livros emprestados
        System.out.println("\n### LIVROS EMPRESTADOS ###");
        for (Emprestimo emprestimo : emprestimos) {
            // Exibe o título dos livros emprestados
            System.out.println(emprestimos.indexOf(emprestimo) + 1 + ". " + emprestimo.getLivro().getTitulo() + " - Emprestado a " + emprestimo.getUsuario().getNome());
        }

        // Solicitar o número do livro a ser devolvido
        System.out.print("Escolha o número do livro a ser devolvido: ");
        if (scanner.hasNextInt()) {

            int livroIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consumir a nova linha após o número

            if (livroIndex >= 0 && livroIndex < emprestimos.size()) {
                Emprestimo emprestimoSelecionado = emprestimos.get(livroIndex);
                Livro livroDevolvido = emprestimoSelecionado.getLivro();

                // Remover o empréstimo e marcar o livro como disponível
                livroDevolvido.setDisponivel(true);
                emprestimos.remove(emprestimoSelecionado);

                // Solicitar os dias de devolução
                System.out.print("Digite quantos dias o usuário ficou com o livro: ");
                int diasDevolucao = scanner.nextInt();
                scanner.nextLine();

                // Calcular multa por atraso
                int diasDeAtraso = diasDevolucao - emprestimoSelecionado.getDiasEmprestimo();
                if (diasDeAtraso > 0) {
                    double multa = diasDeAtraso * 0.8;
                    System.out.printf("Você fez a devolução com %d dias de atraso! Multa de: R$ %.2f%n", diasDeAtraso, multa);
                } else {
                    System.out.println("O livro foi devolvido sem atraso.");
                }

            }else {
                System.out.println("Opção inválida. Você não digitou um número inteiro.");

            }
        }
        else {
            System.out.println("Opção inválida. Você não digitou um número inteiro.");
        }





    }
}