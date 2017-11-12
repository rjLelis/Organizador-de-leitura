/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livros;

/**
 *
 * @author Lelis
 */
public class Livros {
    
    private int codigo;
    private String titulo;
    private String autor;
    private String tema;
    private int numero_paginas;
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public String getTema(){
        return tema;
    }
    
    public void setTema(String tema){
        this.tema = tema;
    }
    
    public int getNumero_paginas(){
        return numero_paginas;
    }
    
    public void setNumero_paginas(int numero_paginas){
        this.numero_paginas = numero_paginas;
    }
    
}
