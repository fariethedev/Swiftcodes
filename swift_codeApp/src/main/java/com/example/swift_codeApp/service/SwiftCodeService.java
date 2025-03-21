package com.example.swift_codeApp.service;

import com.example.swift_codeApp.model.SwiftCode;
import com.example.swift_codeApp.SwiftCodesRepository.SwiftCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwiftCodeService {

    @Autowired
    private SwiftCodeRepository repository;

    public SwiftCode getSwiftCode(String swiftCode) {
        return repository.findById(swiftCode).orElse(null);
    }

    public List<SwiftCode> getSwiftCodesByCountry(String countryISO2) {
        return repository.findByCountryISO2(countryISO2);
    }

    public SwiftCode addSwiftCode(SwiftCode swiftCode) {
        return repository.save(swiftCode);
    }

    public void deleteSwiftCode(String swiftCode) {
        repository.deleteById(swiftCode);
    }
}