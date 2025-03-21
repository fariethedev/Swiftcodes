package com.example.swift_codeApp.controller;

import com.example.swift_codeApp.model.SwiftCode;
import com.example.swift_codeApp.service.SwiftCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/swift-codes")
public class SwiftCodeController {

    @Autowired
    private SwiftCodeService service;

    @GetMapping("/{swiftCode}")
    public SwiftCode getSwiftCode(@PathVariable String swiftCode) {
        return service.getSwiftCode(swiftCode);
    }

    @GetMapping("/country/{countryISO2}")
    public List<SwiftCode> getSwiftCodesByCountry(@PathVariable String countryISO2) {
        return service.getSwiftCodesByCountry(countryISO2);
    }

    @PostMapping
    public SwiftCode addSwiftCode(@RequestBody SwiftCode swiftCode) {
        return service.addSwiftCode(swiftCode);
    }

    @DeleteMapping("/{swiftCode}")
    public void deleteSwiftCode(@PathVariable String swiftCode) {
        service.deleteSwiftCode(swiftCode);
    }
}