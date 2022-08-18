package com.vipindubey.springrestjpa.controller;

import com.vipindubey.springrestjpa.model.SplitBuildingLimit;
import com.vipindubey.springrestjpa.service.SplitBuildingLimitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/splitbuildinglimit")
public class SplitBuildingLimitController {

    @Autowired
    SplitBuildingLimitServiceImpl splitBuildingLimitService;

    @GetMapping
    public @ResponseBody
    Iterable<SplitBuildingLimit> getAllSplitBuildingLimits() {
        return splitBuildingLimitService.getAllSplitBuildingLimits();
    }
}
