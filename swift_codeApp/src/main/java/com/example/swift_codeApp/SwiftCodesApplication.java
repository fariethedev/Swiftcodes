package com.example.swift_codeApp;

import com.example.swift_codeApp.model.SwiftCode;
import com.example.swift_codeApp.SwiftCodesRepository.SwiftCodeRepository;
import com.example.swift_codeApp.util.ExcelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SwiftCodesApplication implements CommandLineRunner {

	@Autowired
	private SwiftCodeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SwiftCodesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<SwiftCode> swiftCodes = ExcelParser.parseExcelFile("C:\\Users\\Admin\\Desktop\\swift_codeApp\\Interns_2025_SWIFT_CODES.xlsx");
		repository.saveAll(swiftCodes);
	}
}