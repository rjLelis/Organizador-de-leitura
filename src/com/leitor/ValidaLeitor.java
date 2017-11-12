package com.leitor;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lelis
 */
public class ValidaLeitor implements InterfaceLeitor {

    @Override
    public void cadastrarLeitor(Leitor l) throws Exception {
        if (l == null) {
            throw new Exception("Favor criar um leitor");
        }
        if (l.getNome() == null) {
            throw new Exception("Informar o nome do Leitor");
        }
        if (l.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do Leitor");
        }
        CrudLeitor dados = new CrudLeitor();
        dados.cadastrarLeitor(l);
    }

    @Override
    public void removerLeitor(Leitor l) throws SQLException, Exception {
        CrudLeitor dados = new CrudLeitor();
        dados.removerLeitor(l);
    }

    @Override
    public void atualizarLeitor(Leitor l) throws SQLException, Exception {
        CrudLeitor dados = new CrudLeitor();
        dados.atualizarLeitor(l);
    }

    @Override
    public ArrayList<Leitor> listar(Leitor filtro) throws Exception {
        CrudLeitor dados = new CrudLeitor();
        return dados.listar(filtro);
    }

}
