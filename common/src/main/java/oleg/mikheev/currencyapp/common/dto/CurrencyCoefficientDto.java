package oleg.mikheev.currencyapp.common.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Oleg on 20.05.2017.
 */
public class CurrencyCoefficientDto {

    @NotNull
    private Long id;

    @NotNull
    private CurrencyDto currencyFirst;

    @NotNull
    private CurrencyDto currencySecond;

    @NotNull
    private Date time;

    @NotNull
    private Float coefficient;

    public CurrencyCoefficientDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrencyDto getCurrencyFirst() {
        return currencyFirst;
    }

    public void setCurrencyFirst(CurrencyDto currencyFirst) {
        this.currencyFirst = currencyFirst;
    }

    public CurrencyDto getCurrencySecond() {
        return currencySecond;
    }

    public void setCurrencySecond(CurrencyDto currencySecond) {
        this.currencySecond = currencySecond;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "CurrencyCoefficientDto{" +
                "id=" + id +
                ", currencyFirst.id=" + currencyFirst +
                ", currencySecond.id=" + currencySecond +
                ", time=" + time +
                ", coefficient=" + coefficient +
                '}';
    }

}
