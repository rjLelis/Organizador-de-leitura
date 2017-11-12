/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leitor_livro;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lelis
 */
public class ValidaLeitorLivro implements InterfaceLeitorLivro {

    @Override
    public void cadastrar(LeitorLivro l) throws SQLException, Exception {
        if(l.getLeitor_codigo() <= 0){
            throw new Exception("Favor criar um leitor");
        }
        if(l.getLivro_codigo() <= 0){
            throw new Exception("Favor criar um livro");
        }
        if(l.getEstado() == null){
            throw new Exception("Forneça um estado");
        }
        CrudLeitorLivro dados = new CrudLeitorLivro();
        dados.cadastrar(l);
    }

    @Override
    public void remover(LeitorLivro l) throws SQLException, Exception {
        CrudLeitorLivro dados = new CrudLeitorLivro();
        dados.remover(l);
    }

    @Override
    public void atualizar(LeitorLivro l) throws SQLException, Exception {
        CrudLeitorLivro dados = new CrudLeitorLivro();
        dados.atualizar(l);
    }

    @Override
    public ArrayList<LeitorLivro> listar(LeitorLivro filtro) throws SQLException, Exception {
        CrudLeitorLivro dados = new CrudLeitorLivro();
        return dados.listar(filtro);
    }

}
