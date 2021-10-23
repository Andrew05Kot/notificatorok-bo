package com.kot.notificatorok.repository.code;

import com.kot.notificatorok.entity.code.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeRepository extends JpaRepository <Code, Long> {

    Optional<Code> getByName(String name);

}
