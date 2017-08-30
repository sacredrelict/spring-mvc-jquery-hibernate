package oleg.mikheev.currencyapp.data.repository.dao;

import oleg.mikheev.currencyapp.data.entity.User;

/**
 * Created by Oleg on 30.08.2017.
 */
public interface UserDao extends BaseDao<User> {

    User findByLogin(String login);

}
