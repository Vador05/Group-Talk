package edu.upc.eetac.dsa.group.dao;

import edu.upc.eetac.dsa.group.entity.Group;
import edu.upc.eetac.dsa.group.entity.GroupCollection;
import edu.upc.eetac.dsa.group.entity.Tema;
import edu.upc.eetac.dsa.group.entity.TemaCollection;

import java.sql.SQLException;

/**
 * Created by kenshin on 29/10/15.
 */
public interface GroupDAO {
    public Group createGroup(String subject) throws SQLException;
    public Group getGroupById(String id) throws SQLException;
    public GroupCollection getGroup() throws SQLException;
    public Group updateGroup(String id, String subject) throws SQLException;
    public boolean deleteGroup(String id) throws SQLException;
    public Group JoinGroup(String id, String user) throws SQLException ;
    public Group LeaveGroup(String id, String user) throws SQLException ;

    }
