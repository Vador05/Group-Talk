package edu.upc.eetac.dsa.group.dao;

/**
 * Created by kenshin on 29/10/15.
 */
public interface TemaDAOQuery {
        public final static String UUID = "select REPLACE(UUID(),'-','')";
        public final static String CREATE_TEMA = "insert into tema (id, groupid,creator, subject, content) values (UNHEX(?), unhex(?),unhex(?), ?, ?)";
        public final static String GET_TEMA_BY_ID = "select hex(s.id) as id, hex(s.groupid) as groupid, hex(s.creator) as creator, s.content, s.subject from tema s, users u where s.id=unhex(?) and u.id=s.creator";
        public final static String GET_TEMA = "select hex(id) as id, hex(groupid) as groupid, hex(creator) as creator, subject, content from tema";
        public final static String UPDATE_TEMA = "update tema set subject=?, content=? where id=unhex(?) ";
        public final static String DELETE_TEMA = "delete from tema where id=unhex(?)";

}
