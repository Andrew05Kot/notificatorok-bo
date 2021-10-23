package com.kot.notificatorok.core.repository.code;

import com.kot.notificatorok.core.entity.code.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeRepository extends JpaRepository <Code, Long> {

    Optional<Code> getByName(String name);

}
