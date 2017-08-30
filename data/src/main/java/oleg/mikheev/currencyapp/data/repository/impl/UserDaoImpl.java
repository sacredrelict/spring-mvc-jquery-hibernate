package oleg.mikheev.currencyapp.data.repository.impl;

import oleg.mikheev.currencyapp.data.entity.User;
import oleg.mikheev.currencyapp.data.repository.dao.UserDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Oleg on 30.08.2017.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    protected String getEntityName() {
        return User.class.getSimpleName();
    }

    @Override
    public User findByLogin(String login) {
        String queryString = "SELECT * FROM user WHERE login = :login";
        final Query query = session().createSQLQuery(queryString).addEntity(User.class);
        query.setParameter("login", login);
        return (User) query.uniqueResult();
    }
}
