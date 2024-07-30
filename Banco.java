/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetodio;

import java.util.ArrayList;

/**
 *
 * @author GFS_Mac
 */
public class Banco {
    private String nome;
    private int cnpj;

    @Override
    public String toString() {
        return nome ;
    }

    public Banco(String nome, int cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    

    public String getNome() {
        return nome;
    }

    public int getCnpj() {
        return cnpj;
    }
    
   
    
}
