package com.kot.notificatorok.service.price;

import com.kot.notificatorok.entity.code.Code;
import com.kot.notificatorok.repository.PriceRepository;
import com.kot.notificatorok.entity.price.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

//    @Autowired
//    private PriceRepository priceRepository;

    public Optional<Price> getLastPrice(Code code) {
        return null;
//        return priceRepository.findFirstByCodeOrderByTimeDesc(code);
    }

    public void clear(LocalDateTime upTo) {
        // TODO optimize
//        List<Price> toDelete = this.priceRepository.findAllByTimeLessThan(upTo);
//        toDelete.forEach(this.priceRepository::delete);
    }

    public Price save(Code code, BigDecimal priceVal, LocalDateTime time) {
        Price price = new Price();
        price.setCode(code);
        price.setVal(priceVal);
        price.setTime(time);
//        return priceRepository.save(price);
    return null;
    }


}
