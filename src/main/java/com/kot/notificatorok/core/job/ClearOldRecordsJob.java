package com.kot.notificatorok.core.job;

import com.kot.notificatorok.core.binance.service.price.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class ClearOldRecordsJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClearOldRecordsJob.class);

    @Autowired
    private PriceService priceService;


}
