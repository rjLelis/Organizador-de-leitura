package com.dados;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lelis
 */
public class Dados {

    private static Statement stmt;
    private static Connection conn;

    
    public Statement conectar() throws ClassNotFoundException, SQLException{
        return Dados.conectarBanco();
    }
    
    public static Connection conectarComParametros() throws ClassNotFoundException, SQLException{
        Dados.conectarBanco();
        return conn;
    }
    
    public static void desconectar() throws SQLException{
        conn.close();
    }
    
    private static Statement conectarBanco() throws ClassNotFoundException, SQLException {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String dataBaseName = "projetolivrosdb";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            String usuario = "root";
            String senha = "";
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, usuario, senha);
            stmt = conn.createStatement();
            return stmt;
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new SQLException(ex.getMessage());
        }

    }

}
