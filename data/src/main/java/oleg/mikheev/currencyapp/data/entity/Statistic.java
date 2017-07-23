package oleg.mikheev.currencyapp.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Oleg on 20.05.2017.
 */
@Entity
@Table(name = "statistic")
public class Statistic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time")
    @NotNull
    private Date time;

    @Column(name = "ip")
    @NotNull
    private String ip;

    @NotNull
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name="currency_first_id")
    private Currency currencyFirst;

    @NotNull
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name="currency_second_id")
    private Currency currencySecond;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getCurrencyFirst() {
        return currencyFirst;
    }

    public void setCurrencyFirst(Currency currencyFirst) {
        this.currencyFirst = currencyFirst;
    }

    public Currency getCurrencySecond() {
        return currencySecond;
    }

    public void setCurrencySecond(Currency currencySecond) {
        this.currencySecond = currencySecond;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", time=" + time +
                ", ip='" + ip + '\'' +
                ", currencyFirst.id=" + currencyFirst.getId() +
                ", currencySecond.id=" + currencySecond.getId() +
                '}';
    }
}
