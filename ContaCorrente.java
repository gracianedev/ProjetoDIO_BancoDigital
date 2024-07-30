/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodio;

import java.util.Random;

/**
 *
 * @author GFS_Mac
 */
public class ContaCorrente extends Conta {
    int min = 1;
    int max = 50;
            Random random = new Random();

    private double limite = 100*(random.nextInt((max - min) + 1) + min);
    
    public ContaCorrente(String agencia, String nomeCliente, int cpf) {
        super(agencia, nomeCliente, cpf);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    
    
     
   @Override
   public void imprimirDados (){
            super.imprimirDados();
            System.out.println("Limite aprovado: " + this.getLimite());

    }
   
    @Override
    public String getTipoConta() {
        return "Corrente";
    } 
  
}