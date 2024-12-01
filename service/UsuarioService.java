package service;

import enums.TipoUsuario;
import model.Cadastravel;
import model.Pessoa;
import model.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioService implements Cadastravel {

    // CRIAÇÃO DE LISTA DE USUÁRIOS
    public static ArrayList<Usuario> usuarios = new ArrayList<>(); static {{
        usuarios.add(new Usuario("Márcio", "marcio@gmail.com", "09898765408", TipoUsuario.ALUNO));
        usuarios.add(new Usuario("Vítor", "vitor@gmail.com", "02588976502", TipoUsuario.ALUNO));
        usuarios.add(new Usuario("Lívia", "livia@gmail.com", "05598734501", TipoUsuario.PROFESSOR));
        usuarios.add(new Usuario("Jaime", "jaime@gmail.com", "08878362509", TipoUsuario.ADMINISTRADOR));
    }}


    // LISTAR TODOS OS USUÁRIOS
    @Override
    public void listar() {
        if (usuarios.isEmpty()) {
            System.out.println("\nNenhum usuário cadastrado.");
            return;
        }

        System.out.println("\nUsuários cadastrados:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }


    // ATUALIZAR O NOME DE UM USUÁRIO
    @Override
    public void atualizar(String nome, String novoNome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                usuario.setNome(novoNome);
                System.out.println("##### USUÁRIO ATUALIZADO COM SUCESSO #####");
                System.out.println(usuario);
                return;
            }
        }
        System.out.println("\nUsuário não encontrado!");
    }


    // REMOVER UM USUÁRIO PELO NOME
    @Override
    public void remover(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                usuarios.remove(usuario);
                System.out.println("###### USUÁRIO REMOVIDO COM SUCESSO ######");
                System.out.println(usuario);
                return;
            }
        }
        System.out.println("\nUsuário não encontrado!");
    }

    // CADASTRAR USUÁRIO
    @Override
    public void cadastrar () {
        Scanner scanner = new Scanner(System.in);


        // INPUT DO NOME DO USUÁRIO
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        // INPUT DO E-MAIL DO USUÁRIO
        System.out.print("Digite o e-mail do usuário: ");
        String email = scanner.next();
        scanner.nextLine();

        // INPUT DA CPF DO USUÁRIO
        System.out.print("Digite a CPF do usuário: ");
        String cpf = scanner.next();
        scanner.nextLine();

        // INPUT DO TIPO DO USUÁRIO
        System.out.print("Digite o tipo do Usuário (ALUNO, PROFESSOR, ADMINISTRADOR): ");
        String tipoUsuarioInput = scanner.nextLine().toUpperCase();
        TipoUsuario tipoUsuario;

        // VALIDAÇÃO DO TIPO DE USUÁRIO
        try {
            tipoUsuario = TipoUsuario.valueOf(tipoUsuarioInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de usuário inválido. Usando ALUNO como padrão.");
            tipoUsuario = TipoUsuario.ALUNO;
        }

        // CRIAÇÃO DO USUÁRIO
        Pessoa usuario = new Usuario(nome, email, cpf, tipoUsuario);

        // ADICIONAR À LISTA
        usuarios.add((Usuario) usuario);
        System.out.println("##### USUÁRIO CADASTRADO COM SUCESSO #####");

    }
}
