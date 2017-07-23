package oleg.mikheev.currencyapp.common.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Oleg on 20.05.2017.
 */
public class StatisticDto {

    private Long id;

    @NotNull
    private Date time;

    @NotNull
    private String ip;

    @NotNull
    private CurrencyDto currencyFirstDto;

    @NotNull
    private CurrencyDto currencySecondDto;

    public StatisticDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public CurrencyDto getCurrencyFirstDto() {
        return currencyFirstDto;
    }

    public void setCurrencyFirstDto(CurrencyDto currencyFirstDto) {
        this.currencyFirstDto = currencyFirstDto;
    }

    public CurrencyDto getCurrencySecondDto() {
        return currencySecondDto;
    }

    public void setCurrencySecondDto(CurrencyDto currencySecondDto) {
        this.currencySecondDto = currencySecondDto;
    }

    @Override
    public String toString() {
        return "StatisticDto{" +
                "id=" + id +
                ", time=" + time +
                ", ip='" + ip + '\'' +
                ", currencyFirstDto.id=" + currencyFirstDto.getId() +
                ", currencySecondDto.id=" + currencySecondDto.getId() +
                '}';
    }
}
