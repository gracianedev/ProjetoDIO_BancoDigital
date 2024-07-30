/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodio;

/**
 *
 * @author GFS_Mac
 */
public class ContaPoupanca extends Conta {
    
    public ContaPoupanca(String agencia, String nomeCliente, int cpf) {
        super(agencia, nomeCliente, cpf);
    }
    
    @Override
    public String getTipoConta() {
        return "Poupança";
    } 
  
   
}
