package oleg.mikheev.currencyapp.common.service.impl;

import oleg.mikheev.currencyapp.common.service.service.UtilsService;
import oleg.mikheev.currencyapp.data.Utils;
import oleg.mikheev.currencyapp.data.entity.Currency;
import oleg.mikheev.currencyapp.data.entity.CurrencyCoefficient;
import oleg.mikheev.currencyapp.data.entity.User;
import oleg.mikheev.currencyapp.data.repository.dao.CurrencyCoefficientDao;
import oleg.mikheev.currencyapp.data.repository.dao.CurrencyDao;
import oleg.mikheev.currencyapp.data.repository.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * Created by Oleg on 20.05.2017.
 */
@Service("utilsService")
public class UtilsServiceImpl implements UtilsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CurrencyDao currencyDao;

    @Autowired
    private CurrencyCoefficientDao currencyCoefficientDao;

    @Override
    public void addDefaultData() {
        addDefaultUser();
        addDefaultCurrencies();
    }

    private void addDefaultUser() {
        User tempUser = userDao.findByLogin("admin");
        if (tempUser == null) {
            User user = new User();
            user.setLogin("admin");
            user.setPassword("2bd07dcdb89b841216ba52a92c5b37c9f38760a8");
            user.setEmail("admin@admin.com");
            user.setActive(true);
            userDao.save(user);
        }
    }

    /**
     * Add default currencies and currency coefficients,
     * if they not already added.
     */
    private void addDefaultCurrencies() {
        Currency currencyUSD = currencyDao.findByName("USD");
        if (currencyUSD == null) {
            if (currencyUSD == null) {
                currencyUSD = new Currency();
                currencyUSD.setName("USD");
                currencyDao.save(currencyUSD);
            }

            Currency currencyEUR = currencyDao.findByName("EUR");
            if (currencyEUR == null) {
                currencyEUR = new Currency();
                currencyEUR.setName("EUR");
                currencyDao.save(currencyEUR);
            }

            Currency currencyRUB = currencyDao.findByName("RUB");
            if (currencyRUB == null) {
                currencyRUB = new Currency();
                currencyRUB.setName("RUB");
                currencyDao.save(currencyRUB);
            }

            addDefaultCurrencyCoefficients(currencyUSD, currencyEUR);
            addDefaultCurrencyCoefficients(currencyUSD, currencyRUB);
            addDefaultCurrencyCoefficients(currencyEUR, currencyRUB);
        }
    }

    /**
     * Add default currency coefficients.
     * Generate random days till 7 to 14.
     * Check if they not already added.
     */
    private void addDefaultCurrencyCoefficients(Currency currencyFirst, Currency currencySecond) {
        for(int i=7; i<=14; i++) {
            String dateStr = getDateString(i);
            Date date = Utils.getFormattedDate(dateStr);
            CurrencyCoefficient currencyCoefficient = currencyCoefficientDao.findByDataAndCurrencies(currencyFirst.getId(), currencySecond.getId(), date);
            if (currencyCoefficient == null) {
                Random r = new Random();
                double randomValue = 0.91 + (1.32  - 0.91) * r.nextDouble();
                BigDecimal number = new BigDecimal(randomValue);
                currencyCoefficient = new CurrencyCoefficient();
                currencyCoefficient.setCurrencyFirst(currencyFirst);
                currencyCoefficient.setCurrencySecond(currencySecond);
                currencyCoefficient.setTime(date);
                currencyCoefficient.setCoefficient(number);
                currencyCoefficientDao.save(currencyCoefficient);
            }
        }
    }

    /**
     * Generate random date in String type.
     */
    private String getDateString(int i) {
        String dayStr = "";
        if (i <= 9) {
            dayStr = "0" + i;
        } else {
            dayStr = "" + i;
        }
        String date = "2017-05-" + dayStr;
        return date;
    }
}
