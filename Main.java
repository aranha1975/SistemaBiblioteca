import model.Funcionario;
import model.Pessoa;
import model.Usuario;
import service.UsuarioService;
import service.FuncionarioService;
import service.LivroService;
import service.EmprestimoService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioService usuarioService = new UsuarioService();
        Pessoa usuario = new Usuario();
        FuncionarioService funcionarioService = new FuncionarioService();
        Pessoa funcionario = new Funcionario();
        LivroService livroService = new LivroService();
        EmprestimoService emprestimoService = new EmprestimoService();

        // MENU PRINCIPAL
        while (true) {
            System.out.println("### MENU PRINCIPAL ###");
            System.out.println("1. Cadastro de Usuários");
            System.out.println("2. Cadastro de Funcionários");
            System.out.println("3. Cadastro de Livros");
            System.out.println("4. Empréstimo e Devolução de Livros");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    //MENU DE USUÁRIOS
                    boolean MenuUsuario = true;
                    while (MenuUsuario) {
                        System.out.println("\n### CADASTRO DE USUÁRIOS ###");
                        System.out.println("1. Cadastrar Usuário");
                        System.out.println("2. Remover Usuário");
                        System.out.println("3. Alterar Nome de Usuários");
                        System.out.println("0. Voltar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");
                        String subOpcao = scanner.nextLine();

                        switch (subOpcao) {
                            case "1":
                                usuarioService.cadastrar();
                                break;

                            case "2":
                                // Exibir a lista de usuários antes de remover
                                usuarioService.listar();
                                System.out.print("Digite o nome do usuário a ser removido: ");
                                String nomeRemover = scanner.nextLine();
                                usuarioService.remover(nomeRemover);
                                break;

                            case "3":
                                // Exibir a lista de usuários antes de alterar o nome
                                usuarioService.listar();
                                System.out.print("Digite o nome do usuário a ser alterado: ");
                                String nomeAntigo = scanner.nextLine();
                                System.out.print("Digite o novo nome: ");
                                String nomeNovo = scanner.nextLine();
                                usuarioService.atualizar(nomeAntigo, nomeNovo);
                                break;

                            case "0":
                                MenuUsuario = false;
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }
                    }
                    break;

                case 2:
                    //MENU DE FUNCIONÁRIOS
                    boolean MenuFuncionario = true;
                    while (MenuFuncionario) {
                        System.out.println("\n### CADASTRO DE FUNCIONÁRIOS ###");
                        System.out.println("1. Cadastrar Funcionário");
                        System.out.println("2. Remover Funcionário");
                        System.out.println("3. Alterar Nome de Funcionário");
                        System.out.println("0. Voltar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");
                        String subOpcaoFuncionario = scanner.nextLine();

                        switch (subOpcaoFuncionario) {
                            case "1":
                                funcionarioService.cadastrar();
                                break;

                            case "2":
                                // Exibir a lista de funcionários antes de remover
                                funcionarioService.listar();
                                System.out.print("Digite o nome do funcionário a ser removido: ");
                                String nomeFuncionarioRemover = scanner.nextLine();
                                funcionarioService.remover(nomeFuncionarioRemover);
                                break;

                            case "3":
                                // Exibir a lista de funcionários antes de alterar o nome
                                funcionarioService.listar();
                                System.out.print("Digite o nome do funcionário a ser alterado: ");
                                String nomeFuncionarioAntigo = scanner.nextLine();
                                System.out.print("Digite o novo nome: ");
                                String nomeFuncionarioNovo = scanner.nextLine();
                                funcionarioService.atualizar(nomeFuncionarioAntigo, nomeFuncionarioNovo);
                                break;

                            case "0":
                                MenuFuncionario = false;
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }
                    }
                    break;

                case 3:
                    //MENU DE LIVROS
                    boolean MenuLivro = true;
                    while (MenuLivro) {
                        System.out.println("\n### CADASTRO DE LIVROS ###");
                        System.out.println("1. Cadastrar Livro");
                        System.out.println("2. Remover Livro");
                        System.out.println("3. Alterar Título de Livro");
                        System.out.println("0. Voltar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");
                        String subOpcaoLivro = scanner.nextLine();

                        switch (subOpcaoLivro) {
                            case "1":
                                livroService.cadastrar();
                                break;

                            case "2":
                                // Exibir a lista de livros antes de remover
                                livroService.listar();
                                System.out.print("Digite o título do livro a ser removido: ");
                                String tituloRemover = scanner.nextLine();
                                livroService.remover(tituloRemover);
                                break;

                            case "3":
                                // Exibir a lista de livros antes de alterar
                                livroService.listar();
                                System.out.print("Digite o título do livro a ser alterado: ");
                                String tituloAntigo = scanner.nextLine();
                                System.out.print("Digite o novo título: ");
                                String tituloNovo = scanner.nextLine();
                                livroService.atualizar(tituloAntigo, tituloNovo);
                                break;

                            case "0":
                                MenuLivro = false;
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }
                    }
                    break;

                case 4:
                    //MENU DE EMPRÉSTIMO E DEVOLUÇÃO
                    while (true) {
                        System.out.println("\n### EMPRÉSTIMO E DEVOLUÇÃO DE LIVROS ###");
                        System.out.println("1. Empréstimo de Livros");
                        System.out.println("2. Devolução de Livros");
                        System.out.println("0. Voltar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");
                        int subOpcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (subOpcao) {
                            case 1:
                                // Empréstimo de livros
                                emprestimoService.emprestar();
                                break;

                            case 2:
                                // Devolução de livros
                                emprestimoService.devolver();
                                System.out.println("\n######################## FEEDBACK ########################\n" +
                                        "Deixe o seu feedback sobre a utilização do nosso sistema: ");
                                String feedback = scanner.nextLine();
                                usuario.avaliarFeedback(feedback);
                                funcionario.avaliarFeedback(feedback);

                                break;

                            case 0:
                                // Voltar ao menu principal
                                break;

                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }

                        if (subOpcao == 0) {
                            break;
                        }
                    }
                    break;

                case 5:
                    //SAIR DO SISTEMA
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
