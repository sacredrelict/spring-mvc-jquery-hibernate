package oleg.mikheev.currencyapp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Oleg on 20.05.2017.
 */
@Controller("baseController")
public class BaseController {

    private final transient Logger logger = LoggerFactory.getLogger(getClass());

    public ModelAndView show403Page() {
        return new ModelAndView("403");
    }

    public ModelAndView show404Page() {
        return new ModelAndView("404");
    }

    public ModelAndView show500Page() {
        return new ModelAndView("500");
    }

}
