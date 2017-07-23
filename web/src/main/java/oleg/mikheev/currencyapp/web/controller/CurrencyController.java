package oleg.mikheev.currencyapp.web.controller;

import oleg.mikheev.currencyapp.common.dto.CurrencyDto;
import oleg.mikheev.currencyapp.common.service.service.CurrencyService;
import oleg.mikheev.currencyapp.data.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
@Controller
@RequestMapping(value = "currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping(value = "", method = { RequestMethod.GET })
    @ResponseBody
    public ModelAndView getCurrencies() {
        ModelAndView modelAndView = new ModelAndView("currencies");
        List<Currency> currencies = currencyService.getCurrencies();
        modelAndView.addObject("currencies", currencies);
        modelAndView.addObject("page", "currencies");
        return modelAndView;
    }

    @RequestMapping(value = "/without/{id}", method = { RequestMethod.GET })
    @ResponseBody
    public List<Currency> getCurrencies(@PathVariable("id") Long id) {
        List<Currency> currencies = currencyService.getCurrenciesWithoutOne(id);
        return currencies;
    }

    @RequestMapping(value = "/add", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseEntity addCurrency(@Valid @RequestBody CurrencyDto currencyDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bindingResult.getFieldErrors());
        }
        currencyService.addCurrencyFromDto(currencyDto);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/update", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseEntity updateCurrency(@Valid @RequestBody CurrencyDto currencyDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bindingResult.getFieldErrors());
        }
        currencyService.updateCurrencyFromDto(currencyDto);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/remove/{id}", method = { RequestMethod.DELETE })
    @ResponseBody
    public ResponseEntity removeCurrency(@PathVariable("id") Long id) {
        currencyService.removeCurrency(id);
        return ResponseEntity.ok().build();
    }

}
