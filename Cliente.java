/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodio;

/**
 *
 * @author GFS_Mac
 */
public class Cliente {
    private String nomeCliente;
    private int cpf;

    public Cliente(String nomeCliente, int cpf) {
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getCpf() {
        return cpf;
    }
    
    
}
