import java.util.List;

public class Banco {

    private String nomeBanco;
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco(String nomeBanco, List<Conta> contas, List<Cliente> clientes) {
        this.nomeBanco = nomeBanco;
        this.contas = contas;
        this.clientes = clientes;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
