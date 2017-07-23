package oleg.mikheev.currencyapp.web.controller;

import oleg.mikheev.currencyapp.common.dto.CurrencyCoefficientDto;
import oleg.mikheev.currencyapp.common.service.service.CurrencyCoefficientService;
import oleg.mikheev.currencyapp.common.service.service.StatisticService;
import oleg.mikheev.currencyapp.data.entity.CurrencyCoefficient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
@Controller
@RequestMapping(value = "currencyCoefficients")
public class CurrencyCoefficientController {

    @Autowired
    private CurrencyCoefficientService currencyCoefficientService;

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = "", method = { RequestMethod.GET })
    @ResponseBody
    public ModelAndView getCurrencyCoefficients() {
        ModelAndView modelAndView = new ModelAndView("currencyCoefficients");
        List<CurrencyCoefficient> currencyCoefficients = currencyCoefficientService.getCurrencyCoefficients();
        modelAndView.addObject("currencyCoefficients", currencyCoefficients);
        modelAndView.addObject("page", "currencyCoefficients");
        return modelAndView;
    }

    @RequestMapping(value = "/currencyPair", method = { RequestMethod.POST })
    @ResponseBody
    public List<CurrencyCoefficient> getCurrencyPairCoefficients(@RequestParam(value = "currencyFirst", required = true) Long currencyFirst,
                                                      @RequestParam(value = "currencySecond", required = true) Long currencySecond,
                                                      @RequestParam(value = "dateFrom", required = true) Date dateFrom,
                                                      @RequestParam(value = "dateTo", required = true) Date dateTo,
                                                      HttpServletRequest request) {
        List<CurrencyCoefficient> currencyCoefficients = currencyCoefficientService.getByDataRangeAndCurrencies(currencyFirst, currencySecond, dateFrom, dateTo);
        statisticService.addStatisticFromRequest(request.getRemoteAddr(), currencyFirst, currencySecond);
        return currencyCoefficients;
    }

    @RequestMapping(value = "/add", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseEntity addCurrencyCoefficient(@Valid @RequestBody CurrencyCoefficientDto currencyCoefficientDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bindingResult.getFieldErrors());
        }
        currencyCoefficientService.addCurrencyCoefficientFromDto(currencyCoefficientDto);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/update", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseEntity updateCurrencyCoefficient(@Valid @RequestBody CurrencyCoefficientDto currencyCoefficientDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bindingResult.getFieldErrors());
        }
        currencyCoefficientService.updateCurrencyCoefficientFromDto(currencyCoefficientDto);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/remove/{id}", method = { RequestMethod.DELETE })
    @ResponseBody
    public ResponseEntity removeCurrencyCoefficient(@PathVariable("id") Long id) {
        currencyCoefficientService.removeCurrencyCoefficient(id);
        return ResponseEntity.ok().build();
    }

}
