package com.trantor.addressbookapi.controller;

import com.trantor.addressbookapi.excelservice.impl.ExcelServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ExcelController {

    @Autowired
    ExcelServiceImpl contactExcelServiceImpl;

    @ApiOperation(value = "Download all contacts present in DB in excel_sheet File")
    @GetMapping("/download_addressBookFile")
    public ResponseEntity<Resource> downLoadFile() {

        String filename = "AddressBook.xlsx";
        InputStreamResource file = new InputStreamResource(contactExcelServiceImpl.load());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(file);


    }

    @ApiOperation(value = "Upload excel_sheet File to database")
    @PostMapping("/upload_addressBookFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        contactExcelServiceImpl.saveExcelFileToDatabase(file);
        return ResponseEntity.ok(("File is uploaded and data is saved to db"));


    }

}


