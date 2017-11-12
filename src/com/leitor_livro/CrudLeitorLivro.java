package com.leitor_livro;

import com.dados.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lelis
 */
public class CrudLeitorLivro extends Dados implements InterfaceLeitorLivro {

    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public void cadastrar(LeitorLivro l) throws SQLException, Exception {
        //Instrução a ser executada
        String sql = "INSERT INTO leitor_livro(cod_leitor,cod_livro,estado) VALUES (?, ?, ?)";
        //Preparando instrução
        pst = conectarComParametros().prepareStatement(sql);
        //Passando os valores para os parametros
        pst.setInt(1, l.getLeitor_codigo());
        pst.setInt(2, l.getLivro_codigo());
        pst.setString(3, l.getEstado());
        //Executar o insert
        pst.executeUpdate();
        desconectar();
    }

    @Override
    public void remover(LeitorLivro l) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(LeitorLivro l) throws SQLException, Exception {
        //Instrução a ser executada
        String sql = "UPDATE leitor_livro SET estado = ? WHERE cod_leitor = ? and cod_livro = ?";
        //Preparando a instrução
        pst = conectarComParametros().prepareStatement(sql);
        //Passando os valores para os paremetros
        pst.setString(1, l.getEstado());
        pst.setInt(2, l.getLeitor_codigo());
        pst.setInt(3, l.getLivro_codigo());
        //Executar o update
        pst.executeUpdate();
        desconectar();
    }

    @Override
    public ArrayList<LeitorLivro> listar(LeitorLivro filtro) throws Exception {
        ArrayList<LeitorLivro> retorno = new ArrayList();
        //Instrução a ser executada
        String sql = "SELECT livros.codigo, livros.titulo, leitor_livro.estado FROM livros "
                + "JOIN leitor_livro ON livros.codigo = leitor_livro.cod_livro "
                + "JOIN leitor ON leitor.codigo = leitor_livro.cod_leitor "
                + "WHERE leitor.codigo = ?";
        //Preparando a instrução
        pst = conectarComParametros().prepareStatement(sql);
        //Passando os valores para os parametros
        pst.setInt(1, filtro.getLeitor_codigo());
        //Executando o comando sql
        rs = pst.executeQuery();
        //Lendo resultados
        while (rs.next()) {
            LeitorLivro ll = new LeitorLivro();
            ll.setLivro_codigo(rs.getInt("livros.codigo"));
            ll.setTitulo(rs.getString("livros.titulo"));
            ll.setEstado(rs.getString("leitor_livro.estado"));
            retorno.add(0, ll);
        }
        desconectar();
        return retorno;
    }

}
