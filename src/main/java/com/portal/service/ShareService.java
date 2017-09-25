package com.portal.service;

import com.portal.entity.ShareRecord;

/**
 * Created by zhenghua.zhang on 2017/9/20.
 */
public interface ShareService {
    void addResult();

    ShareRecord findTopOne();
}
