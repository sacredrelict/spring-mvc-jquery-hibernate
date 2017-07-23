package oleg.mikheev.currencyapp.common.service.impl;

import oleg.mikheev.currencyapp.common.dto.StatisticDto;
import oleg.mikheev.currencyapp.common.service.service.StatisticService;
import oleg.mikheev.currencyapp.data.entity.Currency;
import oleg.mikheev.currencyapp.data.entity.Statistic;
import oleg.mikheev.currencyapp.data.repository.dao.CurrencyCoefficientDao;
import oleg.mikheev.currencyapp.data.repository.dao.CurrencyDao;
import oleg.mikheev.currencyapp.data.repository.dao.StatisticDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
@Service("statisticService")
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticDao statisticDao;

    @Autowired
    private CurrencyDao currencyDao;

    @Autowired
    private CurrencyCoefficientDao currencyCoefficientDao;

    @Override
    public List<Statistic> getStatistics() {
        return statisticDao.findAll();
    }

    @Override
    public void addStatisticFromDto(StatisticDto statisticDto) {
        Currency currencyFirst = currencyDao.findById(statisticDto.getCurrencyFirstDto().getId());
        Currency currencySecond = currencyDao.findById(statisticDto.getCurrencySecondDto().getId());

        if (currencyFirst != null && currencySecond != null) {
            Statistic statistic = new Statistic();
            statistic.setTime(statisticDto.getTime());
            statistic.setIp(statisticDto.getIp());
            statistic.setCurrencyFirst(currencyFirst);
            statistic.setCurrencySecond(currencySecond);
            statisticDao.save(statistic);
        }
    }

    @Override
    public void removeStatistic(Long id) {
        Statistic statistic = statisticDao.findById(id);
        if (statistic != null) {
            statisticDao.delete(statistic);
        }
    }

    @Override
    public void updateStatisticFromDto(StatisticDto statisticDto) {
        Currency currencyFirst = currencyDao.findById(statisticDto.getCurrencyFirstDto().getId());
        Currency currencySecond = currencyDao.findById(statisticDto.getCurrencySecondDto().getId());

        if (currencyFirst != null && currencySecond != null) {
            Statistic statistic = statisticDao.findById(statisticDto.getId());
            if (statistic != null) {
                statistic.setTime(statisticDto.getTime());
                statistic.setIp(statisticDto.getIp());
                statistic.setCurrencyFirst(currencyFirst);
                statistic.setCurrencySecond(currencySecond);
                statisticDao.save(statistic);
            }
        }
    }

    @Override
    public void addStatisticFromRequest(String ip, Long currencyFirstId, Long currencySecondId) {
        Currency currencyFirst = currencyDao.findById(currencyFirstId);
        Currency currencySecond = currencyDao.findById(currencySecondId);

        if (currencyFirst != null && currencySecond != null) {
            Statistic statistic = new Statistic();
            statistic.setTime(new Date());
            statistic.setIp(ip);
            statistic.setCurrencyFirst(currencyFirst);
            statistic.setCurrencySecond(currencySecond);
            statisticDao.save(statistic);
        }
    }
}
