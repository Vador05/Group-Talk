package edu.upc.eetac.dsa.group.dao;

/**
 * Created by kenshin on 29/10/15.
 */
public interface GroupDAOQuery {
    public final static String UUID = "select REPLACE(UUID(),'-','')";
    public final static String CREATE_GROUP = "insert into groups (id, Title) values (UNHEX(?), ?)";
    public final static String GET_GROUP_BY_ID = "select hex(s.id) as id, s.Title from groups s, users u where s.id=unhex(?)";
    public final static String GET_GROUP = "select hex(s.id) as id, s.Title from groups s";
    public final static String UPDATE_GROUP = "update groups set Title=? id=unhex(?) ";
    public final static String DELETE_GROUP = "delete from groups where id=unhex(?)";
    public final static String JOIN_GROUP = "insert into relUserGroup (user,grup) values (UNHEX(?),UNHEX(?))";
    public final static String LEAVE_GROUP = "delete from relUserGroup where user=unhex(?) and grup = unhex(?)";
}

