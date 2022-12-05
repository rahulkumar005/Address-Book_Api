package com.trantor.addressbookapi.excelservice;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public interface ExcelService {
    ByteArrayInputStream load();

    void saveExcelFileToDatabase(MultipartFile file) throws IOException;
}
