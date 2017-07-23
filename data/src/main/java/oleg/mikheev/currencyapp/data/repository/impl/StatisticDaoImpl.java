package oleg.mikheev.currencyapp.data.repository.impl;

import oleg.mikheev.currencyapp.data.entity.Statistic;
import oleg.mikheev.currencyapp.data.repository.dao.StatisticDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Oleg on 20.05.2017.
 */
@Repository("statisticDao")
public class StatisticDaoImpl extends BaseDaoImpl<Statistic> implements StatisticDao {

    @Override
    protected String getEntityName() {
        return Statistic.class.getSimpleName();
    }

}

