package com.portal.quartz;

import com.portal.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by zhenghua.zhang on 2017/9/20.
 */
@Component
public class ShareTask {

    @Autowired
    private ShareService shareService;

    @Scheduled(cron = "0 */60 * * * ?")
    public void test() throws Exception{
        shareService.addResult();
    }

}
