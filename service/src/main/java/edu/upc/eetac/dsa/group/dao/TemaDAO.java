package edu.upc.eetac.dsa.group.dao;

import edu.upc.eetac.dsa.group.entity.Tema;
import edu.upc.eetac.dsa.group.entity.TemaCollection;

import java.sql.SQLException;

/**
 * Created by kenshin on 29/10/15.
 */
public interface TemaDAO {
    public Tema createTema(String userid, String subject, String content) throws SQLException;
    public Tema getTemaById(String id) throws SQLException;
    public TemaCollection getTema() throws SQLException;
    public Tema updateTema(String id, String subject, String content) throws SQLException;
    public boolean deleteTema(String id) throws SQLException;
}
