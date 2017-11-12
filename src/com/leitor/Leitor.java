/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leitor;


/**
 *
 * @author Lelis
 */
public class Leitor {
    private int codigo;
    private String nome;
    private String apelido;
    private int data_nascimento;
    
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getApelido(){
        return apelido;
    }
    
    public void setApelido(String apelido){
        this.apelido = apelido;
    }

    public int getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(int data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    @Override
    public String toString() {
        return "Leitor{" + "codigo=" + codigo + ", nome=" + nome + ", nick=" + apelido + ", data_nascimento=" + data_nascimento + '}';
    }
        
    
}
