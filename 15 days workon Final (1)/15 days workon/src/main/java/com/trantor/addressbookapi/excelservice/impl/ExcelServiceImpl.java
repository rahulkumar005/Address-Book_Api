package com.trantor.addressbookapi.excelservice.impl;

import com.trantor.addressbookapi.bulksave.JdbcTemplateBulkSave;
import com.trantor.addressbookapi.excelhelper.ExcelDownloadHelper;
import com.trantor.addressbookapi.excelhelper.ExcelUploadHelper;
import com.trantor.addressbookapi.excelservice.ExcelService;
import com.trantor.addressbookapi.exception.custom.EmptyDatabaseException;
import com.trantor.addressbookapi.model.ContactEntity;
import com.trantor.addressbookapi.repositories.ContactRepository;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import static org.jboss.logging.Logger.Level.INFO;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    JdbcTemplateBulkSave jdbcTemplateBulkSave;

    @Override
    public ByteArrayInputStream load() {
        List<ContactEntity> contactList = contactRepository.findAll();
        if (contactList.isEmpty()) {
            throw new EmptyDatabaseException();
        }
        return ExcelDownloadHelper.contactEntityToExcel(contactList);

    }

    @Override
    public void saveExcelFileToDatabase(MultipartFile file) throws IOException {
            List<ContactEntity> contactEntityList = ExcelUploadHelper.excelToContactEntity(file.getInputStream());
        Logger logger = LoggerFactory.logger(ExcelServiceImpl.class);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        jdbcTemplateBulkSave.bulkDataSave((contactEntityList));
        stopWatch.stop();
        logger.log(INFO,stopWatch.getTotalTimeSeconds());

    }


}
