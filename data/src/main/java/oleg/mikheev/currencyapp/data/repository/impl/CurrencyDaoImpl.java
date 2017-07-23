package oleg.mikheev.currencyapp.data.repository.impl;

import oleg.mikheev.currencyapp.data.entity.Currency;
import oleg.mikheev.currencyapp.data.repository.dao.CurrencyDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
@Repository("currencyDao")
public class CurrencyDaoImpl extends BaseDaoImpl<Currency> implements CurrencyDao {

    @Override
    protected String getEntityName() {
        return Currency.class.getSimpleName();
    }

    @Override
    public Currency findByName(String name) {
        String queryString = "SELECT * FROM currency WHERE name = :name";
        final Query query = session().createSQLQuery(queryString).addEntity(Currency.class);
        query.setParameter("name", name);
        return (Currency) query.uniqueResult();
    }

    public List<Currency> findWithoutOne(Long id) {
        String queryString = "FROM Currency WHERE id != :id";
        final Query query = session().createQuery(queryString);
        query.setParameter("id", id);
        return query.list();
    }

}
