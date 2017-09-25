package com.portal.dao;

import com.portal.dto.ShareInsertDto;
import com.portal.entity.ShareRecord;
import org.springframework.stereotype.Repository;

/**
 * Created by zhenghua.zhang on 2017/9/20.
 */
@Repository
public interface ShareDao {
    Integer insertOneRecord(ShareInsertDto dto);

    ShareRecord selectTopOne();
}
