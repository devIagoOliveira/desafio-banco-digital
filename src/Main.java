import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Cliente> listaClientes = new ArrayList<>();
    static List<Conta> listaContas = new ArrayList<>();
    static Banco bancoDigital = new Banco("IAGO", listaContas, listaClientes);

    static {
        Cliente joao = new Cliente("Joao", "119999999");
        listaClientes.add(joao);
        Cliente maria = new Cliente("Maria", "11934897184");
        listaClientes.add(maria);
        Conta contaJoao = new ContaPoupanca(joao);
        listaContas.add(contaJoao);
        Conta contaMaria = new ContaCorrente(maria);
        listaContas.add(contaMaria);
    }

    public static void main(String[] args) {


        int choice = -1;

        while (choice != 0) {

            System.out.println("\n==============================");
            System.out.println("      IAGO OLIVEIRA BANK      ");
            System.out.println("==============================");
            System.out.println("1. Criar uma conta");
            System.out.println("2. Imprimir Extrato");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Lista de Clientes");
            System.out.println("6. Lista de Contas");
            System.out.println("0. Sair");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    criarConta();
                    break;

                case 2:
                    imprimirExtrato();
                    break;

                case 3:
                    depositar();
                    break;

                case 4:
                    sacar();
                    break;

                case 5:
                    listarClientes();
                    break;

                case 6:
                    listarContas();
                    break;

                case 0:
                    System.out.println("DESLIGANDO O SISTEMA .........");
                    break;
            }

        }

    }

    private static void criarConta() {
        System.out.print("Digite seu nome: ");
        String name = sc.nextLine();
        System.out.print("Digite seu telefone: ");
        String telefone = sc.nextLine();
        Cliente novoCliente = new Cliente(name, telefone);
        listaClientes.add(novoCliente);


        Conta conta;
        System.out.print("Conta Corrente ou Poupança(c/p)? ");
        String tipoConta = sc.next();
        if (tipoConta.equalsIgnoreCase("c")) {
            conta = new ContaCorrente(novoCliente);
        } else if (tipoConta.equals("p")) {
            conta = new ContaPoupanca(novoCliente);
        } else {
            throw new RuntimeException("Opção Inválida");
        }
        listaContas.add(conta);


        System.out.println("Deseja realizar um deposito (s/n)?");
        String depositoInicial = sc.next();
        if (depositoInicial.equalsIgnoreCase("s")) {
            System.out.println("Qual valor do depósito?");
            double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
            conta.imprimirExtrato();
            System.out.println("Conta Criada com Sucesso!");
        } else if (depositoInicial.equals("n")) {
            System.out.println("Conta Criada com Sucesso!");
        } else {
            throw new RuntimeException("Opção Inválida");
        }

    }

    public static void imprimirExtrato() {
        System.out.println("Digite o nome do Cliente que deseja imprimir o extrato:");
        String name = sc.nextLine();

        for (Conta conta : listaContas) {
            if (conta.getCliente().getNome().equalsIgnoreCase(name)) {
                conta.imprimirExtrato();
                return;
            }
        }
    }

    public static void depositar() {
        System.out.println("Digite o nome do Cliente que deseja depositar:");
        String name = sc.nextLine();
        System.out.println("Qual valor do depósito?");
        double valorDeposito = sc.nextDouble();

        for (Conta conta : listaContas) {
            if (conta.getCliente().getNome().equalsIgnoreCase(name)) {
                conta.depositar(valorDeposito);
                System.out.println("=== DEPÓSITO REALIZADO ===");
                conta.imprimirExtrato();
                return;
            }
        }
    }

    public static void sacar() {
        System.out.println("Digite o nome do Cliente que deseja sacar:");
        String name = sc.nextLine();
        System.out.println("Qual valor do saque?");
        double valorSaque = sc.nextDouble();

        for (Conta conta : listaContas) {
            if (conta.getCliente().getNome().equalsIgnoreCase(name)) {
                conta.saque(valorSaque);
                System.out.println("=== SAQUE REALIZADO ===");
                conta.imprimirExtrato();
                return;
            }
        }
    }

    public static void listarClientes() {
        System.out.println(bancoDigital.getClientes());
    }

    public static void listarContas() {
        System.out.println(bancoDigital.getContas());
    }
}
