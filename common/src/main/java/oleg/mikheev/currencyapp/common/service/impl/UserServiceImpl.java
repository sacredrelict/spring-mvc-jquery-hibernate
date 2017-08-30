package oleg.mikheev.currencyapp.common.service.impl;

import oleg.mikheev.currencyapp.common.service.service.UserService;
import oleg.mikheev.currencyapp.data.entity.User;
import oleg.mikheev.currencyapp.data.repository.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oleg on 30.08.2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User getByLogin(String login) {
        return userDao.findByLogin(login);
    }

}
