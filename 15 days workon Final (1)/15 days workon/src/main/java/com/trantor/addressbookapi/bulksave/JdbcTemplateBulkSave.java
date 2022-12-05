package com.trantor.addressbookapi.bulksave;

import com.trantor.addressbookapi.model.ContactEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Configuration
public class JdbcTemplateBulkSave implements InsertBulkData {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateBulkSave(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void bulkDataSave(List<ContactEntity> entityList) {

        String query = "insert into CONTACT_TABLE (CONTACT_ID, FIRST_NAME, LAST_NAME,EMAIL_ADDRESS,IS_ACTIVE) values(?,?,?,?,?)";
        jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ContactEntity contactEntity = entityList.get(i);
                ps.setLong(1, contactEntity.getContactId());
                ps.setString(2, contactEntity.getFirstName());
                ps.setString(3, contactEntity.getLastName());
                ps.setString(4, contactEntity.getIsActive());
                ps.setString(5, contactEntity.getEmailAddress());


            }

            @Override
            public int getBatchSize() {
                return entityList.size();
            }


        });
    }
}
