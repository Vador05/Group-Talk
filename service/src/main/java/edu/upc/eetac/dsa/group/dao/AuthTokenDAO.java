package edu.upc.eetac.dsa.group.dao;

import edu.upc.eetac.dsa.group.auth.UserInfo;
import edu.upc.eetac.dsa.group.entity.AuthToken;

import java.sql.SQLException;

/**
 * Created by kenshin on 29/10/15.
 */
public interface AuthTokenDAO {
    public UserInfo getUserByAuthToken(String token) throws SQLException;
    public AuthToken createAuthToken(String userid) throws SQLException;
    public void deleteToken(String userid) throws  SQLException;
}