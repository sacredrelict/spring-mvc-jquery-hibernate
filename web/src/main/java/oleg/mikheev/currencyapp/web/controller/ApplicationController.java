package oleg.mikheev.currencyapp.web.controller;

import oleg.mikheev.currencyapp.common.service.service.CurrencyService;
import oleg.mikheev.currencyapp.common.service.service.UtilsService;
import oleg.mikheev.currencyapp.data.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Oleg on 20.05.2017.
 */
@Controller
public class ApplicationController {

    @Autowired
    private UtilsService utilsService;

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView showLoginPage() {
        // TODO remove this line if we don't want to add the default data.
        utilsService.addDefaultData();

        ModelAndView model = new ModelAndView("../pages/common/login");
        return model;
    }

    @RequestMapping("/")
    public ModelAndView addDefaultData(Model model) {
        // TODO remove this line if we don't want to add the default data.
        utilsService.addDefaultData();

        ModelAndView modelAndView = new ModelAndView("index");
        model.addAttribute("page", "index");

        List<Currency> currenciesFirst = currencyService.getCurrencies();
        modelAndView.addObject("currenciesFirst", currenciesFirst);

        return modelAndView;
    }
}
