/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livros;

import com.dados.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lelis
 */
public class CrudLivros extends Dados implements InterfaceLivros {

    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public void cadastrarLivro(Livros l) throws SQLException, Exception {
        //Instrução sql
        String sql = "INSERT INTO livros (titulo,autor,tema,numero_paginas) VALUES(?,?,?,?)";
        //Preparando a instrução
        pst = conectarComParametros().prepareStatement(sql);
        //Passando os valores para os paremetros
        pst.setString(1, l.getTitulo());
        pst.setString(2, l.getAutor());
        pst.setString(3, l.getTema());
        pst.setInt(4, l.getNumero_paginas());
        //Executar o insert
        pst.executeUpdate();
        desconectar();
    }

    @Override
    public void removerLivro(Livros l) throws SQLException, Exception {
        //Instrução a ser executada
        String sql = "DELETE FROM livros WHERE codigo = ?";
        //Preparando a instrução
        pst = conectarComParametros().prepareStatement(sql);
        //Passadi os valores para os paremetros
        pst.setInt(1, l.getCodigo());
        //Executando o delete
        pst.executeUpdate();
        desconectar();
    }

    @Override
    public void atualizarLivro(Livros l) throws SQLException, Exception {
        //Instrução a ser executada
        String sql = "UPDATE livros SET titulo = ?, autor = ?, tema = ?, numero_paginas = ? WHERE codigo = ?";
        //Preparando a instrução
        pst = conectarComParametros().prepareStatement(sql);
        //Passando os valores para os paremetros
        pst.setString(1, l.getTitulo());
        pst.setString(2, l.getAutor());
        pst.setString(3, l.getTema());
        pst.setInt(4, l.getNumero_paginas());
        pst.setInt(5, l.getCodigo());
        //Executar o delete
        pst.executeUpdate();
        desconectar();
    }

    @Override
    public ArrayList<Livros> listar(Livros filtro) throws SQLException, Exception {
        ArrayList<Livros> retorno = new ArrayList();
        //Instrução a ser executada
        String sql = "SELECT * FROM livros ORDER BY titulo";
        //Preparando a instrução
        pst = conectarComParametros().prepareStatement(sql);
        //Executando a instrução sql
        rs = pst.executeQuery();
        //Lendo resultados
        while (rs.next()) {
            Livros l = new Livros();
            l.setCodigo(rs.getInt("codigo"));
            l.setTitulo(rs.getString("titulo"));
            l.setAutor(rs.getString("autor"));
            l.setTema(rs.getString("tema"));
            l.setNumero_paginas(rs.getInt("numero_paginas"));
            retorno.add(l);
        }
        desconectar();
        return retorno;
    }

    public ArrayList<Livros> procurarlivros(Livros filtro) throws SQLException, Exception {
        ArrayList<Livros> retorno = new ArrayList();
        //Instrução a ser executada
        String sql = "SELECT * FROM livros WHERE titulo LIKE ?";
        //Preparando a instrução
        pst = conectarComParametros().prepareStatement(sql);
        pst.setString(1, filtro.getTitulo() + '%');
        //Executando a instrução sql
        rs = pst.executeQuery();
        //Lendo resultados
        while (rs.next()) {
            Livros l = new Livros();
            l.setCodigo(rs.getInt("codigo"));
            l.setTitulo(rs.getString("titulo"));
            l.setAutor(rs.getString("autor"));
            l.setTema(rs.getString("tema"));
            l.setNumero_paginas(rs.getInt("numero_paginas"));
            retorno.add(l);
        }
        desconectar();
        return retorno;
    }

}
