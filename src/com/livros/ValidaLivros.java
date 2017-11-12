package com.livros;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lelis
 */
public class ValidaLivros implements InterfaceLivros {

    @Override
    public void cadastrarLivro(Livros l) throws Exception {
        if (l == null) {
            throw new Exception("Favor criar um livro");
        }
        if (l.getTitulo() == null) {
            throw new Exception("Informar o titulo do livro");
        }
        if (l.getAutor() == null) {
            throw new Exception("Informar o nome do autor");
        }
        if (l.getNumero_paginas() <= 0) {
            throw new Exception("Informar o numero de paginas do livro");
        }
        CrudLivros dados = new CrudLivros();
        dados.cadastrarLivro(l);
    }

    @Override
    public void removerLivro(Livros l) throws SQLException, Exception {
        CrudLivros dados = new CrudLivros();
        dados.removerLivro(l);
    }

    @Override
    public void atualizarLivro(Livros l) throws SQLException, Exception {
        CrudLivros dados = new CrudLivros();
        dados.atualizarLivro(l);
    }

    @Override
    public ArrayList<Livros> listar(Livros filtro) throws Exception {
        CrudLivros dados = new CrudLivros();
        return dados.listar(filtro);
    }

    public ArrayList<Livros> procurarlivros(Livros filtro) throws SQLException, Exception {
        CrudLivros dados = new CrudLivros();
        return dados.procurarlivros(filtro);
    }
}
