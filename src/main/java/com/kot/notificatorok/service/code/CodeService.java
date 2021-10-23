package com.kot.notificatorok.service.code;

import com.kot.notificatorok.entity.code.Code;
import com.kot.notificatorok.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
//
//    @Autowired
//    private CodeRepository codeRepository;

    public Code save(String codeName) {
        Code code = new Code();
//        code.setName(codeName);
//        return codeRepository.save(code);
        return code;
    }

    public Code get(String codeName) {
        // or find code or save if not exist
        return null;
//        return codeRepository.getByName(codeName).orElse(save(codeName));
    }

}
