package oleg.mikheev.currencyapp.data.repository.dao;

import oleg.mikheev.currencyapp.data.entity.Currency;

import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
public interface CurrencyDao extends BaseDao<Currency> {

    Currency findByName(String name);

    List<Currency> findWithoutOne(Long id);

}
