package oleg.mikheev.currencyapp.data.repository.impl;

import oleg.mikheev.currencyapp.data.entity.CurrencyCoefficient;
import oleg.mikheev.currencyapp.data.repository.dao.CurrencyCoefficientDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
@Repository("currencyCoefficientDao")
public class CurrencyCoefficientDaoImpl extends BaseDaoImpl<CurrencyCoefficient> implements CurrencyCoefficientDao {

    @Override
    protected String getEntityName() {
        return CurrencyCoefficient.class.getSimpleName();
    }

    @Override
    public List<CurrencyCoefficient> findByCurrencyId(Long id) {
        String queryString = "FROM CurrencyCoefficient cc WHERE cc.currencyFirst.id = :id";
        final Query query = session().createQuery(queryString);
        query.setParameter("id", id);
        return query.list();
    }

    @Override
    public CurrencyCoefficient findByDataAndCurrencies(Long currencyFirstId, Long currencySecondId, Date data) {
        String queryString = "FROM CurrencyCoefficient cc " +
                "WHERE " +
                "((cc.currencyFirst.id = :currencyFirstId AND " +
                "cc.currencySecond.id = :currencySecondId) OR " +
                "(cc.currencyFirst.id = :currencySecondId AND " +
                "cc.currencySecond.id = :currencyFirstId)) AND " +
                "cc.time = :data ";
        final Query query = session().createQuery(queryString);
        query.setParameter("currencyFirstId", currencyFirstId);
        query.setParameter("currencySecondId", currencySecondId);
        query.setParameter("data", data);
        return (CurrencyCoefficient) query.uniqueResult();
    }

    @Override
    public List<CurrencyCoefficient> findByDateRangeAndCurrencies(Long currencyFirstId, Long currencySecondId, Date dateFrom, Date dateTo) {
        String queryString = "FROM CurrencyCoefficient cc " +
                "WHERE " +
                "((cc.currencyFirst.id = :currencyFirstId AND " +
                "cc.currencySecond.id = :currencySecondId) OR " +
                "(cc.currencyFirst.id = :currencySecondId AND " +
                "cc.currencySecond.id = :currencyFirstId)) AND " +
                "cc.time >= :dateFrom AND cc.time <= :dateTo";
        final Query query = session().createQuery(queryString);
        query.setParameter("currencyFirstId", currencyFirstId);
        query.setParameter("currencySecondId", currencySecondId);
        query.setParameter("dateFrom", dateFrom);
        query.setParameter("dateTo", dateTo);
        return query.list();
    }
}
