package oleg.mikheev.currencyapp.common.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by Oleg on 20.05.2017.
 */
public class CurrencyDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    public CurrencyDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CurrencyDto{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
