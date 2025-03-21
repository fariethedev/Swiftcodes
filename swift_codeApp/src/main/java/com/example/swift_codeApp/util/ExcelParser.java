package com.example.swift_codeApp.util;

import com.example.swift_codeApp.model.SwiftCode;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelParser {

    public static List<SwiftCode> parseExcelFile(String filePath) throws IOException {
        List<SwiftCode> swiftCodes = new ArrayList<>();
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row.getRowNum() == 0) continue; // Skip header row

            SwiftCode swiftCode = new SwiftCode();
            swiftCode.setSwiftCode(row.getCell(0).getStringCellValue());
            swiftCode.setAddress(row.getCell(1).getStringCellValue());
            swiftCode.setBankName(row.getCell(2).getStringCellValue());
            swiftCode.setCountryISO2(row.getCell(3).getStringCellValue().toUpperCase());
            swiftCode.setCountryName(row.getCell(4).getStringCellValue().toUpperCase());
            swiftCode.setHeadquarter(row.getCell(0).getStringCellValue().endsWith("XXX"));

            swiftCodes.add(swiftCode);
        }

        workbook.close();
        file.close();
        return swiftCodes;
    }
}