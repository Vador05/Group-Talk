package edu.upc.eetac.dsa.group.dao;

import edu.upc.eetac.dsa.group.entity.Group;
import edu.upc.eetac.dsa.group.entity.GroupCollection;
import edu.upc.eetac.dsa.group.entity.Tema;
import edu.upc.eetac.dsa.group.entity.TemaCollection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kenshin on 29/10/15.
 */
public class GroupDAOImpl implements  GroupDAO {
    @Override
    public Group createGroup( String subject) throws SQLException {
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
            stmt.setString(2, subject);
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
        return getGroupById(id);
    }

    @Override
    public Group getGroupById(String id) throws SQLException {
        Group gr = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(TemaDAOQuery.GET_TEMA_BY_ID);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                gr = new Group();
                gr.setId(rs.getString("id"));
                gr.setTitle(rs.getString("Title"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return gr;
    }

    @Override
    public GroupCollection getGroup() throws SQLException {
        GroupCollection stingCollection = new GroupCollection();

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(TemaDAOQuery.GET_TEMA);

            ResultSet rs = stmt.executeQuery();
            boolean first = true;
            while (rs.next()) {
                Group gr = new Group();
                gr.setId(rs.getString("id"));
                gr.setTitle(rs.getString("Title"));
                if (first) {
                    first = false;
                }
                stingCollection.getgroups().add(gr);
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
    public Group updateGroup(String id, String Title) throws SQLException {
        Group gr = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(GroupDAOQuery.UPDATE_GROUP);
            stmt.setString(2, id);
            stmt.setString(1, Title);


            int rows = stmt.executeUpdate();
            if (rows == 1)
                gr = getGroupById(id);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }

        return gr;
    }

    @Override
    public Group JoinGroup(String id, String user) throws SQLException {
        Group gr = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(GroupDAOQuery.JOIN_GROUP);
            stmt.setString(2, id);
            stmt.setString(1, user);


            int rows = stmt.executeUpdate();
            if (rows == 1)
                gr = getGroupById(id);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }

        return gr;
    }

    @Override
    public Group LeaveGroup(String id, String user) throws SQLException {
        Group gr = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(GroupDAOQuery.LEAVE_GROUP);
            stmt.setString(2, id);
            stmt.setString(1, user);


            int rows = stmt.executeUpdate();
            if (rows == 1)
                gr = getGroupById(id);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }

        return gr;
    }

    @Override
    public boolean deleteGroup(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(GroupDAOQuery.DELETE_GROUP);
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
