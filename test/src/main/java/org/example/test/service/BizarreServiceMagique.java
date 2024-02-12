package org.example.test.service;

import org.springframework.stereotype.Service;

@Service
public class BizarreServiceMagique implements BizarreService{

    @Override
    public String sayBizarre() {
        return "bloup";
    }
}
