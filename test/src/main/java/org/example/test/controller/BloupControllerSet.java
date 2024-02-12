package org.example.test.controller;

import org.example.test.service.BizarreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BloupControllerSet {

    private final BizarreService bizarreService;

    @Autowired
    public BloupControllerSet(BizarreService bizarreService) {
        this.bizarreService = bizarreService;
    }

    @RequestMapping(value = "/bloup-set")
    public String sayBloup() {
        System.out.println(bizarreService.sayBizarre());
        return "home";
    }
}
