package oleg.mikheev.currencyapp.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Oleg on 20.05.2017.
 */
@Entity
@Table(name = "currency_coefficient")
public class CurrencyCoefficient implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "currency_first_id")
    private Currency currencyFirst;

    @NotNull
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "currency_second_id")
    private Currency currencySecond;

    @Column(name = "time")
    @NotNull
    private Date time;

    @NotNull
    @Column(name = "coefficient")
    private BigDecimal coefficient;

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

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CurrencyCoefficient{" +
                "id=" + id +
                ", currencyFirst.id=" + currencyFirst.getId() +
                ", currencySecond.id=" + currencySecond.getId() +
                ", coefficient=" + coefficient +
                ", time=" + time +
                '}';
    }
}
