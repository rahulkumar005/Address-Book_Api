package com.trantor.addressbookapi.bulksave;

import com.trantor.addressbookapi.model.ContactEntity;

import java.util.List;

public interface InsertBulkData {
    void bulkDataSave(List<ContactEntity> entityList);
}
