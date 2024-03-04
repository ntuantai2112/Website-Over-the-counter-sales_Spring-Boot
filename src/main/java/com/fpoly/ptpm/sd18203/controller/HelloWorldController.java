package com.fpoly.ptpm.sd18203.controller;

import com.fpoly.ptpm.sd18203.dto.MauSacDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @Autowired
    @Qualifier("red")
    private MauSacDTO mauSacDTO;


    @RequestMapping("hello")
    public String helloWord() {

        System.out.println(mauSacDTO.getId());
        System.out.println(mauSacDTO.getMa());
        System.out.println(mauSacDTO.getTen());

        return "index";
    }


}
