package com.portal.controller;

import com.portal.entity.ShareRecord;
import com.portal.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhenghua.zhang on 2017/9/21.
 */
@Controller
@RequestMapping("portal")
public class ShareRecordController {

    @Autowired
    private ShareService shareService;

    @RequestMapping(value = "/share", method = RequestMethod.GET)
//    @ResponseBody
    public void findTopOne(HttpServletRequest request, HttpServletResponse response) {
//        return shareService.findTopOne();
        try {
            ShareRecord shareRecord = shareService.findTopOne();
            String callback = (String) request.getParameter("callback");
            String jsonData = "{\"id\":\""+shareRecord.getId()+"\",\"resultDate\":\""+shareRecord.getResultDate()+
                    "\",\"resultNow\":\""+shareRecord.getResultNow()+
                    "\",\"resultOpen\":\""+shareRecord.getResultOpen()+
                    "\",\"resultUp\":\""+shareRecord.getResultUp()+
                    "\",\"resultDown\":\""+shareRecord.getResultDown()+"\"}";
            String retStr = callback + "(" + jsonData + ")";
            response.getWriter().print(retStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
