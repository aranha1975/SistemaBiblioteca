package service;

import model.Cadastravel;
import model.Funcionario;
import model.Pessoa;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncionarioService implements Cadastravel {

    // CRIAÇÃO DE LISTA DE FUNCIONÁRIOS
    public static ArrayList<Funcionario> funcionarios = new ArrayList<>(); static {{
        funcionarios.add(new Funcionario("Elis", "elis@gmail.com", "10986735987", 20249988));
        funcionarios.add(new Funcionario("Matheus", "matheus@hotmail.com", "06998376501", 20238765));
        funcionarios.add(new Funcionario("Cláudia", "claudia@hotmail.com", "18798308705", 20219875));
    }}


    // LISTAR TODOS OS FUNCIONÁRIOS
    @Override
    public void listar() {
        if (funcionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado.");
            return;
        }

        System.out.println("\nFuncionários cadastrados:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }


    // ATUALIZAR O NOME DE UM FUNCIONÁRIO
    @Override
    public void atualizar(String nome, String novoNome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionario.setNome(novoNome);
                System.out.println("##### FUNCIONÁRIO ATUALIZADO COM SUCESSO #####");
                System.out.println(funcionario);
                return;
            }
        }
        System.out.println("\nFuncionário não encontrado!");
    }


    // REMOVER UM FUNCIONÁRIO PELO NOME
    @Override
    public void remover(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionarios.remove(funcionario);
                System.out.println("###### FUNCIONÁRIO REMOVIDO COM SUCESSO ######");
                System.out.println(funcionario);
                return;
            }
        }
        System.out.println("\nFuncionário não encontrado!");
    }

    // CADASTRAR FUNCIONÁRIO
    @Override
    public void cadastrar () {
        Scanner scanner = new Scanner(System.in);


        // INPUT DO NOME DO FUNCIONÁRIO
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        // INPUT DO E-MAIL DO FUNCIONÁRIO
        System.out.print("Digite o e-mail do funcionário: ");
        String email = scanner.next();
        scanner.nextLine();

        // INPUT DA CPF DO FUNCIONÁRIO
        System.out.print("Digite a CPF do funcionário: ");
        String cpf = scanner.next();
        scanner.nextLine();

        // INPUT DA MATRÍCULA DO FUNCIONÁRIO
        System.out.print("Digite a Matrícula do funcionário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        // CRIAÇÃO DO FUNCIONÁRIO
        Pessoa funcionario = new Funcionario(nome, email, cpf, matricula);

        // ADICIONAR À LISTA
        funcionarios.add((Funcionario) funcionario);
        System.out.println("##### FUNCIONÁRIO CADASTRADO COM SUCESSO #####");
    }




}
