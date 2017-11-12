package com.leitor_livro;

import com.livros.Livros;

/**
 *
 * @author Lelis
 */
public class LeitorLivro extends Livros {

    private int leitor_codigo;
    private int livro_codigo;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getLeitor_codigo() {
        return leitor_codigo;
    }

    public void setLeitor_codigo(int leitor_codigo) {
        this.leitor_codigo = leitor_codigo;
    }

    public int getLivro_codigo() {
        return livro_codigo;
    }

    public void setLivro_codigo(int livro_codigo) {
        this.livro_codigo = livro_codigo;
    }

}
