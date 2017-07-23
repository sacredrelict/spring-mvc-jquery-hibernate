package oleg.mikheev.currencyapp.common.service.impl;

import oleg.mikheev.currencyapp.common.dto.CurrencyDto;
import oleg.mikheev.currencyapp.common.service.service.CurrencyService;
import oleg.mikheev.currencyapp.data.entity.Currency;
import oleg.mikheev.currencyapp.data.repository.dao.CurrencyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
@Service("currencyService")
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDao currencyDao;

    @Override
    public List<Currency> getCurrencies() {
        return currencyDao.findAll();
    }

    @Override
    public List<Currency> getCurrenciesWithoutOne(Long id) {
        return currencyDao.findWithoutOne(id);
    }

    @Override
    public void addCurrencyFromDto(CurrencyDto currencyDto) {
        Currency currency = currencyDao.findByName(currencyDto.getName());
        if (currency == null) {
            currency = new Currency();
            currency.setName(currencyDto.getName());
            currencyDao.save(currency);
        }
    }

    @Override
    public void removeCurrency(Long id) {
        Currency currency = currencyDao.findById(id);
        if (currency != null) {
            currencyDao.delete(currency);
        }
    }

    @Override
    public void updateCurrencyFromDto(CurrencyDto currencyDto) {
        Currency currency = currencyDao.findById(currencyDto.getId());
        if (currency != null) {
            currency.setName(currencyDto.getName());
            currencyDao.save(currency);
        }
    }
}

