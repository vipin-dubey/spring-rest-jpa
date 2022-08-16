package com.vipindubey.springrestjpa.controller;

import com.vipindubey.springrestjpa.model.SplitBuildingLimit;
import com.vipindubey.springrestjpa.service.SplitBuildingLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SplitBuildingLimitController {

    @Autowired
    SplitBuildingLimitService splitBuildingLimitService;

    @GetMapping(path="/splitbuildinglimits")
    public @ResponseBody
    Iterable<SplitBuildingLimit> getAllSplitBuildingLimits() {
        return splitBuildingLimitService.list();
    }
}
