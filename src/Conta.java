public class Conta {

    private static final int AGENCIA = 0001;
    private static int SEQUENCIA = 1;

    private int agencia;
    private int numero;
    private Cliente cliente;
    private double saldo;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA;
        this.numero = SEQUENCIA++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void depositar (double valor){
        saldo += valor;
    }

    public void saque(double valor){
        saldo -= valor;
    }

    public void transferencia(double valor, Conta conta){
        this.saldo -= valor;
        conta.depositar(valor);
    }

    public void imprimirExtrato(){
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Agência: " + agencia);
        System.out.println("Número: " + numero);
        System.out.println(String.format("Saldo: R$%.2f%n", saldo));
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", cliente=" + cliente +
                '}';
    }
}
