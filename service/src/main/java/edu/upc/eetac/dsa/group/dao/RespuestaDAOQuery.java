package edu.upc.eetac.dsa.group.dao;

/**
 * Created by kenshin on 29/10/15.
 */
public interface RespuestaDAOQuery {
    public final static String UUID = "select REPLACE(UUID(),'-','')";
    public final static String CREATE_RESPUESTA = "insert into respuesta (id, creator,temaid, content) values (UNHEX(?), unhex(?),unhex(?), ?)";
    public final static String GET_RESPUESTA_BY_ID = "select hex(s.id) as id, hex(s.creator) as creator, hex(s.temaid) as temaid, s.content, from respuesta s, users u where s.id=unhex(?) and u.id=s.creator";
    public final static String GET_RESPUESTA_BY_TEMA = "select hex(r.id) as id, hex(r.creator) as creator, hex(r.temaid) as temaid, r.content, from respuesta r WHERE r.temaid=unhex(?)";
    public final static String UPDATE_RESPUESTA = "update respuesta set content=? where id=unhex(?) ";
    public final static String DELETE_RESPUESTA = "delete from respuesta where id=unhex(?)";

}
