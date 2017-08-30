package oleg.mikheev.currencyapp.common.service.service;

import oleg.mikheev.currencyapp.data.entity.User;

/**
 * Created by Oleg on 30.08.2017.
 */
public interface UserService {

    User getById(Long id);

    User getByLogin(String login);

}
