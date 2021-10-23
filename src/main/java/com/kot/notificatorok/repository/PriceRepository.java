package com.kot.notificatorok.repository;

import com.kot.notificatorok.entity.code.Code;
import com.kot.notificatorok.entity.price.Price;
import com.kot.notificatorok.entity.price.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, PriceId> {

    List<Price> findAllByTimeLessThan(LocalDateTime time);

    Optional<Price> findFirstByCodeOrderByTimeDesc(Code code);

}
