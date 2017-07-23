package oleg.mikheev.currencyapp.common.service.service;

import oleg.mikheev.currencyapp.common.dto.CurrencyCoefficientDto;
import oleg.mikheev.currencyapp.data.entity.CurrencyCoefficient;

import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
public interface CurrencyCoefficientService {

    List<CurrencyCoefficient> getCurrencyCoefficients();

    List<CurrencyCoefficient> getCurrencyCoefficientsByCurrencyId(Long currencyId);

    List<CurrencyCoefficient> getByDataRangeAndCurrencies(Long currencyFirstId, Long currencySecondId, Date dateFrom, Date dateTo);

    void addCurrencyCoefficientFromDto(CurrencyCoefficientDto currencyCoefficientDto);

    void removeCurrencyCoefficient(Long id);

    void updateCurrencyCoefficientFromDto(CurrencyCoefficientDto currencyCoefficientDto);
}
