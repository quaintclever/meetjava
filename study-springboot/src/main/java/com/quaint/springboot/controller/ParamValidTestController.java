package com.quaint.springboot.controller;

import com.quaint.springboot.dto.ParamValidDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author quaint
 * @since 2023/6/14 22:52
 */
@Tag(name = "参数校验测试")
@RestController
@RequestMapping("paramValid")
@Validated
public class ParamValidTestController {

    // http://localhost:8080/doc.html#/-v3-api-docs/%E5%8F%82%E6%95%B0%E6%A0%A1%E9%AA%8C%E6%B5%8B%E8%AF%95/timeParamTest
    @PostMapping("time")
    @Operation(summary = "时间格式化测试")
    public ParamValidDto.TimeChild timeParamTest(@Valid @RequestBody ParamValidDto.TimeChild param) {
        System.out.println(param);
        return param;
    }

}
