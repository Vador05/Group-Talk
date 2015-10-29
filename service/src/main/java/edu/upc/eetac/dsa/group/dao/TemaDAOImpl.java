package edu.upc.eetac.dsa.group.dao;

import edu.upc.eetac.dsa.group.entity.Tema;
import edu.upc.eetac.dsa.group.entity.TemaCollection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kenshin on 29/10/15.
 */
public class TemaDAOImpl implements TemaDAO {

    @Override
    public Tema createTema(String userid, String subject, String content) throws SQLException {
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

            stmt = connection.prepareStatement(TemaDAOQuery.CREATE_TEMA);
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
        return getTemaById(id);
    }

    @Override
    public Tema getTemaById(String id) throws SQLException {
        Tema tm = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(TemaDAOQuery.GET_TEMA_BY_ID);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tm = new Tema();
                tm.setId(rs.getString("id"));
                tm.setCreator(rs.getString("userid"));
                tm.setCreator(rs.getString("fullname"));
                tm.setSubject(rs.getString("subject"));
                tm.setContent(rs.getString("content"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return tm;
    }

    @Override
    public TemaCollection getTema() throws SQLException {
        TemaCollection stingCollection = new TemaCollection();

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(TemaDAOQuery.GET_TEMA);

            ResultSet rs = stmt.executeQuery();
            boolean first = true;
            while (rs.next()) {
                Tema tm = new Tema();
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