package com.fpoly.ptpm.sd18203.config;

import com.fpoly.ptpm.sd18203.dto.MauSacDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class BeanConfig {

    @Bean("white")
    public MauSacDTO mauSacBean(){
        MauSacDTO mauSacDTO = new MauSacDTO(1,"#0000","White","Action");
        return mauSacDTO;

    }

    @Bean("red")
    public MauSacDTO mauSacBean2(){
        MauSacDTO mauSacDTO = new MauSacDTO(1,"#ftf","Red","Action");
        return mauSacDTO;

    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }



}
