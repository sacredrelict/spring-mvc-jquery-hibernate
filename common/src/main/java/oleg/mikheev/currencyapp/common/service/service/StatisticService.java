package oleg.mikheev.currencyapp.common.service.service;

import oleg.mikheev.currencyapp.common.dto.StatisticDto;
import oleg.mikheev.currencyapp.data.entity.Statistic;

import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
public interface StatisticService {

    List<Statistic> getStatistics();

    void addStatisticFromDto(StatisticDto statisticDto);

    void removeStatistic(Long id);

    void updateStatisticFromDto(StatisticDto statisticDto);

    void addStatisticFromRequest(String ip, Long currencyFirstId, Long currencySecondId);

}
