package oleg.mikheev.currencyapp.data.repository.dao;

import oleg.mikheev.currencyapp.data.entity.CurrencyCoefficient;

import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
public interface CurrencyCoefficientDao extends BaseDao<CurrencyCoefficient> {

    List<CurrencyCoefficient> findByCurrencyId(Long id);

    CurrencyCoefficient findByDataAndCurrencies(Long currencyFirstId, Long currencySecondId, Date data);

    List<CurrencyCoefficient> findByDateRangeAndCurrencies(Long currencyFirstId, Long currencySecondId, Date dateFrom, Date dateTo);

}
