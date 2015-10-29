package edu.upc.eetac.dsa.group.dao;

import edu.upc.eetac.dsa.group.entity.Respuesta;
import edu.upc.eetac.dsa.group.entity.RespuestaCollection;

import java.sql.SQLException;

/**
 * Created by kenshin on 29/10/15.
 */
public interface RespuestaDAO {
        public Respuesta createRes(String creator, String Temaid, String content) throws SQLException;
        public Respuesta getResById(String id) throws SQLException;
        public RespuestaCollection getRes() throws SQLException;
        public Respuesta updateRes(String id, String content) throws SQLException;
        public boolean deleteRes(String id) throws SQLException;
    }
