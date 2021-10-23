package com.kot.notificatorok.job;

import com.kot.notificatorok.entity.price.Price;
import com.kot.notificatorok.service.price.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class ClearOldRecordsJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClearOldRecordsJob.class);

    @Autowired
    private PriceService priceService;

//    @Scheduled(fixedRate = 24000)
    private void clear24After() {
        priceService.clear(LocalDateTime.now().minusHours(24));
    }


}
