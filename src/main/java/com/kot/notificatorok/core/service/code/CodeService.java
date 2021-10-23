package com.kot.notificatorok.core.service.code;

import com.kot.notificatorok.core.entity.code.Code;
import com.kot.notificatorok.core.repository.code.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {

    @Autowired
    private CodeRepository repository;

    public Code save(String codeName) {
        Code code = new Code();
        code.setName(codeName);
        return repository.save(code);
    }

    public Code get(String codeName) {
        // or find code or save if not exist
        return repository.getByName(codeName).orElse(save(codeName));
    }

}
