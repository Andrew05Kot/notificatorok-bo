package com.kot.notificatorok.api.controller.price;

import com.kot.notificatorok.api.dto.price.DifferenceResponse;
import com.kot.notificatorok.api.dto.price.PriceResponse;
import com.kot.notificatorok.api.service.price.PriceAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(PriceController.API_URL)
public class PriceController {

    public static final String API_URL = "/price";

    @Autowired
    private PriceAPIService apiService;

    @GetMapping(path = "/current/{symbol}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public PriceResponse getRecord(@PathVariable(value = "symbol") String symbol,
                                     HttpServletResponse response,
                                     HttpServletRequest servletRequest) {
        return apiService.getCurrentPrice(symbol);
    }

    @GetMapping(path = "/difference/{symbol}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public DifferenceResponse getDifference(@PathVariable(value = "symbol") String symbol,
                                            HttpServletResponse response,
                                            HttpServletRequest servletRequest) {
        return apiService.getDifference(symbol);
    }

}
