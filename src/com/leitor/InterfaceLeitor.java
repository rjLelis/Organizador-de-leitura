package com.leitor;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lelis
 */
public interface InterfaceLeitor {

    public void cadastrarLeitor(Leitor l) throws SQLException, Exception;

    public void removerLeitor(Leitor l) throws SQLException, Exception;

    public void atualizarLeitor(Leitor l) throws SQLException, Exception;

    public ArrayList<Leitor> listar(Leitor filtro) throws Exception;

}
