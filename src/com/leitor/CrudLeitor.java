package com.leitor;

import com.dados.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lelis
 */
public class CrudLeitor extends Dados implements InterfaceLeitor {

    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public void cadastrarLeitor(Leitor l) throws SQLException, Exception {
        //Instrução a ser executada
        String sql = "INSERT INTO leitor (nome, data_nascimento, nick) VALUES(?, ?, ?)";
        //Preparando a instrução
        pst = conectarComParametros().prepareStatement(sql);
        //Passando os valores para os parametros
        pst.setString(1, l.getNome());
        pst.setInt(2, l.getData_nascimento());
        pst.setString(3,l.getApelido());
        //Executar o insert 
        pst.executeUpdate();
        desconectar();
    }

    @Override
    public void removerLeitor(Leitor l) throws SQLException, Exception {
        //Instrução a ser executada
        String sql = "DELETE FROM leitor WHERE codigo = ?";
        //Preparando a instrução
        pst = conectarComParametros().prepareStatement(sql);
        //Passando os valores para os parametros
        pst.setInt(1, l.getCodigo());
        //Executar o delete 
        pst.executeUpdate();
        desconectar();
    }

    @Override
    public void atualizarLeitor(Leitor l) throws SQLException, Exception {
        //Instrução a ser executada
        String sql = "UPDATE leitor SET nome = ?, data_nascimento = ? WHERE codigo = ?";
        //Preparando a instrução
        pst = conectarComParametros().prepareStatement(sql);
        //Passando os valores para os parametros
        pst.setString(1, l.getNome());
        pst.setInt(2, l.getData_nascimento());
        pst.setInt(3, l.getCodigo());
        //Executar o update 
        pst.executeUpdate();
        desconectar();

    }

    @Override
    public ArrayList<Leitor> listar(Leitor filtro) throws Exception {
        ArrayList<Leitor> retorno = new ArrayList();
        //Instrução a ser executada
        String sql = "SELECT codigo, nome, data_nascimento FROM leitor WHERE nick = ? ORDER BY nome";
        //Preparando a instrução
        pst = conectarComParametros().prepareStatement(sql);
        //Passando os valores para os parametros
        pst.setString(1, filtro.getApelido());
        //Executando a instrução sql
        rs = pst.executeQuery();
        //Lendo resultados
        while(rs.next()){
            Leitor l = new Leitor();
            l.setCodigo(rs.getInt("codigo"));
            l.setNome(rs.getString("nome"));
            l.setData_nascimento(rs.getInt("data_nascimento"));
            retorno.add(l);
        }
        desconectar();
        return retorno;
    }

    

}
