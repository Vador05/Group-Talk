package edu.upc.eetac.dsa.group.dao;

import edu.upc.eetac.dsa.group.entity.Respuesta;
import edu.upc.eetac.dsa.group.entity.RespuestaCollection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kenshin on 29/10/15.
 */
public class RespuestaDAOImpl {
    @Override
    public Respuesta createRes(String userid, String subject, String content) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String id = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(UserDAOQuery.UUID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                id = rs.getString(1);
            else
                throw new SQLException();

            stmt = connection.prepareStatement(RespuestaDAOQuery.CREATE_RESPUESTA);
            stmt.setString(1, id);
            stmt.setString(2, userid);
            stmt.setString(3, subject);
            stmt.setString(4, content);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
        return getResById(id);
    }

    @Override
    public Respuesta getResById(String id) throws SQLException {
        Respuesta rsp = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(RespuestaDAOQuery.GET_RESPUESTA_BY_ID);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rsp = new Respuesta();
                rsp.setId(rs.getString("id"));
                rsp.setCreator(rs.getString("creator"));
                rsp.setTemaid(rs.getString("temaid"));
                rsp.setContent(rs.getString("content"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return rsp;
    }

    @Override
    public RespuestaCollection getResByTema() throws SQLException {
        RespuestaCollection stingCollection = new RespuestaCollection();

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(RespuestaDAOQuery.GET_RESPUESTA_BY_TEMA);

            ResultSet rs = stmt.executeQuery();
            boolean first = true;
            while (rs.next()) {
                Respuesta tm = new Respuesta();
                tm.setId(rs.getString("id"));
                tm.setCreator(rs.getString("creator"));
                tm.setSubject(rs.getString("subject"));
                if (first) {
                    first = false;
                }
                stingCollection.gettemas().add(tm);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return stingCollection;
    }

    @Override
    public Tema updateTema(String id, String subject, String content) throws SQLException {
        Tema tm = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(TemaDAOQuery.UPDATE_TEMA);
            stmt.setString(1, subject);
            stmt.setString(2, content);
            stmt.setString(3, id);

            int rows = stmt.executeUpdate();
            if (rows == 1)
                tm =  getTemaById(id);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }

        return tm;
    }

    @Override
    public boolean deleteTema(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(TemaDAOQuery.DELETE_TEMA);
            stmt.setString(1, id);

            int rows = stmt.executeUpdate();
            return (rows == 1);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
}
