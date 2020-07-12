package com.quaint.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * desc: 简单控制器
 * </p>
 *
 * @author quaint
 * @since 12 July 2020
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

}
