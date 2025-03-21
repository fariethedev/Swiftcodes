package com.example.swift_codeApp.SwiftCodesRepository;

import com.example.swift_codeApp.model.SwiftCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SwiftCodeRepository extends JpaRepository<SwiftCode, String> {
    List<SwiftCode> findByCountryISO2(String countryISO2);
}