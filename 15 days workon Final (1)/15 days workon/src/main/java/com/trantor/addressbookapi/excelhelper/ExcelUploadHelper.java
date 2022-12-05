package com.trantor.addressbookapi.excelhelper;

import com.trantor.addressbookapi.exception.custom.ParsingException;
import com.trantor.addressbookapi.model.ContactEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelUploadHelper {

    private ExcelUploadHelper() {
        throw new UnsupportedOperationException("Utility Class can not be Instantiated");
    }

    static String[] headers = {"ContactId", "FirstName", "LastName", "EmailAddress"};
    static String sheetName = "AddressBook";


    public static List<ContactEntity> excelToContactEntity(InputStream is) {
        List<ContactEntity> contactEntityList = new ArrayList<>();
        try {

            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowNumber = 0;
            Iterator<Row> rows = sheet.iterator();


            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                int cellIdx = 0;
                ContactEntity contact = new ContactEntity();
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            contact.setContactId((long) (currentCell.getNumericCellValue()));
                            break;
                        case 1:
                            contact.setFirstName(currentCell.getStringCellValue());
                            break;
                        case 2:
                            contact.setLastName(currentCell.getStringCellValue());
                            break;
                        case 3:
                            contact.setIsActive(currentCell.getStringCellValue());
                            break;
                        case 4:
                            contact.setEmailAddress(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                contactEntityList.add(contact);
            }
            workbook.close();

        } catch (IOException e) {
            throw new ParsingException("fail to parse the excel file");
        }
        return contactEntityList;

    }
}