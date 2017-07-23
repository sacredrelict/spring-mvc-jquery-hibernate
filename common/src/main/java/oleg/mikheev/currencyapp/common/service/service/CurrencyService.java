package oleg.mikheev.currencyapp.common.service.service;

import oleg.mikheev.currencyapp.common.dto.CurrencyDto;
import oleg.mikheev.currencyapp.data.entity.Currency;

import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
public interface CurrencyService {

    List<Currency> getCurrencies();

    List<Currency> getCurrenciesWithoutOne(Long id);

    void addCurrencyFromDto(CurrencyDto currencyDto);

    void removeCurrency(Long id);

    void updateCurrencyFromDto(CurrencyDto currencyDto);

}
