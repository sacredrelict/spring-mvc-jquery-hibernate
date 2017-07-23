package oleg.mikheev.currencyapp.common.service.impl;

import oleg.mikheev.currencyapp.common.dto.CurrencyCoefficientDto;
import oleg.mikheev.currencyapp.common.service.service.CurrencyCoefficientService;
import oleg.mikheev.currencyapp.data.entity.Currency;
import oleg.mikheev.currencyapp.data.entity.CurrencyCoefficient;
import oleg.mikheev.currencyapp.data.repository.dao.CurrencyCoefficientDao;
import oleg.mikheev.currencyapp.data.repository.dao.CurrencyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
@Service("currencyCoefficientService")
public class CurrencyCoefficientServiceImpl implements CurrencyCoefficientService {

    @Autowired
    private CurrencyCoefficientDao currencyCoefficientDao;

    @Autowired
    private CurrencyDao currencyDao;

    @Override
    public List<CurrencyCoefficient> getCurrencyCoefficients() {
        return currencyCoefficientDao.findAll();
    }

    @Override
    public List<CurrencyCoefficient> getCurrencyCoefficientsByCurrencyId(Long currencyId) {
        return currencyCoefficientDao.findByCurrencyId(currencyId);
    }

    @Override
    public List<CurrencyCoefficient> getByDataRangeAndCurrencies(Long currencyFirstId, Long currencySecondId, Date dateFrom, Date dateTo) {
        return currencyCoefficientDao.findByDateRangeAndCurrencies(currencyFirstId, currencySecondId, dateFrom, dateTo);
    }

    @Override
    public void addCurrencyCoefficientFromDto(CurrencyCoefficientDto currencyCoefficientDto) {
        Currency currencyFirst = currencyDao.findByName(currencyCoefficientDto.getCurrencyFirst().getName());
        Currency currencySecond = currencyDao.findByName(currencyCoefficientDto.getCurrencySecond().getName());
        if (currencyFirst != null && currencySecond != null) {
            CurrencyCoefficient currencyCoefficient = new CurrencyCoefficient();
            currencyCoefficient.setCurrencyFirst(currencyFirst);
            currencyCoefficient.setCurrencySecond(currencySecond);
            currencyCoefficient.setCoefficient(BigDecimal.valueOf(currencyCoefficientDto.getCoefficient()));
            currencyCoefficient.setTime(currencyCoefficientDto.getTime());
            currencyCoefficientDao.save(currencyCoefficient);
        }
    }

    @Override
    public void removeCurrencyCoefficient(Long id) {
        CurrencyCoefficient currencyCoefficient = currencyCoefficientDao.findById(id);
        if (currencyCoefficient != null) {
            currencyCoefficientDao.delete(currencyCoefficient);
        }
    }

    @Override
    public void updateCurrencyCoefficientFromDto(CurrencyCoefficientDto currencyCoefficientDto) {
        CurrencyCoefficient currencyCoefficient = currencyCoefficientDao.findById(currencyCoefficientDto.getId());
        if (currencyCoefficient != null) {
            Currency currencyFirst = currencyDao.findByName(currencyCoefficientDto.getCurrencyFirst().getName());
            Currency currencySecond = currencyDao.findByName(currencyCoefficientDto.getCurrencySecond().getName());
            if (currencyFirst != null && currencySecond != null) {
                currencyCoefficient.setCurrencyFirst(currencyFirst);
                currencyCoefficient.setCurrencySecond(currencySecond);
                currencyCoefficient.setCoefficient(BigDecimal.valueOf(currencyCoefficientDto.getCoefficient()));
                currencyCoefficient.setTime(currencyCoefficientDto.getTime());
                currencyCoefficientDao.save(currencyCoefficient);
            }
        }
    }
}
