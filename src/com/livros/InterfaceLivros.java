/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livros;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Lelis
 */
public interface InterfaceLivros {

    public void cadastrarLivro(Livros l) throws SQLException, Exception;
    
    public void removerLivro(Livros l) throws SQLException, Exception;
    
    public void atualizarLivro(Livros l) throws SQLException, Exception;
    
    public ArrayList<Livros> listar(Livros filtro) throws SQLException, Exception;

    

}
