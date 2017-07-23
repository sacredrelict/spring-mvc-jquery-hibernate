package oleg.mikheev.currencyapp.web.controller;

import oleg.mikheev.currencyapp.common.dto.StatisticDto;
import oleg.mikheev.currencyapp.common.service.service.StatisticService;
import oleg.mikheev.currencyapp.data.entity.Statistic;
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
@RequestMapping(value = "statistics")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = "", method = { RequestMethod.GET })
    @ResponseBody
    public ModelAndView getStatistics() {
        ModelAndView modelAndView = new ModelAndView("statistics");
        List<Statistic> statistics = statisticService.getStatistics();
        modelAndView.addObject("statistics", statistics);
        modelAndView.addObject("page", "statistics");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseEntity addStatistic(@Valid @RequestBody StatisticDto statisticDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bindingResult.getFieldErrors());
        }
        statisticService.addStatisticFromDto(statisticDto);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/update", method = { RequestMethod.POST })
    @ResponseBody
    public ResponseEntity updateStatistic(@Valid @RequestBody StatisticDto statisticDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bindingResult.getFieldErrors());
        }
        statisticService.updateStatisticFromDto(statisticDto);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/remove/{id}", method = { RequestMethod.DELETE })
    @ResponseBody
    public ResponseEntity removeStatistic(@PathVariable("id") Long id) {
        statisticService.removeStatistic(id);
        return ResponseEntity.ok().build();
    }
}
