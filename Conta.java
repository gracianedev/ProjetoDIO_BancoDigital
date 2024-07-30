/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodio;

/**
 *
 * @author GFS_Mac
 */
public class Conta extends Cliente {

    private String agencia;
    private static int SEQUENCIAL = 1;
    private int numeroConta;
    private static final String NOMEBANCO = "Banco Robin Hood";
    private String nomeCliente;
    private int cpf;

    private double saldo = 0;
    private double valor = 0;
    private String banco;

    public Conta(String agencia, String nomeCliente, int cpf) {
        super(nomeCliente, cpf);
        this.banco = NOMEBANCO;
        this.agencia = agencia;
        this.numeroConta = SEQUENCIAL++;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
       

    }

    public double sacar(double valor) {
        return saldo -= valor;
    }

    public double depositar(double valor) {
        return saldo += valor;
    }

    public void transferir(Conta numero, double valor) {
        this.sacar(valor);
        numero.depositar(valor);
    }

    public String getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public static String getNOMEBANCO() {
        return NOMEBANCO;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getCpf() {
        return cpf;
    }

    

    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
    public String getTipoConta() {
        return "Conta Genérica";
    }

    
    public void imprimirDados() {
        System.out.println("Nome do cliente: " + this.getNomeCliente());
        System.out.println("CPF cliente: " + this.getCpf() );
        System.out.println("Banco: " + this.getNOMEBANCO());
        System.out.println("Agência: " + this.getAgencia() + " Conta: " + this.getNumeroConta());

    }
    
    public void imprimirExtrato() {
        System.out.println("Nome do cliente: " + this.getNomeCliente());
        System.out.println("Banco: " + this.getNOMEBANCO());
        System.out.println("Agência: " + this.getAgencia() + " Conta: " + this.getNumeroConta());
        System.out.println("Tipo de conta: " + this.getTipoConta());
        System.out.println("SALDO: " + this.getSaldo() );


    }
    
    
     
     public void exibirDadosContas() {
            System.out.println("\n-----------------------------");
            System.out.println("Tipo de conta: " + this.getTipoConta());
            System.out.println("Nome do cliente: " + this.getNomeCliente());
            System.out.println("CPF cliente: " + this.getCpf());
            System.out.println("Banco: " + this.getNOMEBANCO());
            System.out.println("Agência: " + this.getAgencia());
            System.out.println("Conta: " + this.getNumeroConta());
            System.out.println("Saldo: " + this.getSaldo());
        }
    

}
