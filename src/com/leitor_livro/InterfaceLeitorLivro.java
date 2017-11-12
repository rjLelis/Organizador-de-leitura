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
public interface InterfaceLeitorLivro {
    
    public void cadastrar(LeitorLivro l) throws SQLException, Exception;

    public void remover(LeitorLivro l) throws SQLException, Exception;

    public void atualizar(LeitorLivro l) throws SQLException, Exception;

    public ArrayList<LeitorLivro> listar(LeitorLivro filtro) throws Exception;
    
}
