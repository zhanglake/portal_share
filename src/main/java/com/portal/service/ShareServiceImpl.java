package com.portal.service;

import com.portal.dao.ShareDao;
import com.portal.dto.ShareInsertDto;
import com.portal.entity.ShareRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenghua.zhang on 2017/9/20.
 */
@Service
public class ShareServiceImpl implements ShareService {

    @Autowired
    private ShareDao shareDao;

    @Override
    public void addResult() {
        ShareInsertDto dto = new ShareInsertDto();
        String result = this.doGet("http://hq.sinajs.cn/list=sz000581");
        System.out.println(result);
        String[] dataList = result.split("\"")[1].split(",");
        // 日期
        String date = new StringBuffer().append(dataList[30]).append(" ").append(dataList[31]).toString();
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateMiddle = sdf1.parse(date);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            date = sdf2.format(dateMiddle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 当前价格
        String now = dataList[3];
        // 开盘价
        String open = dataList[1];
        // 涨停
        String up = String.format("%.2f", Double.parseDouble(open) * 1.1d);
        // 跌停
        String down = String.format("%.2f", Double.parseDouble(open) * 0.9d);

        dto.setResultDate(date);
        dto.setResultNow(now);
        dto.setResultOpen(open);
        dto.setResultUp(up);
        dto.setResultDown(down);
        shareDao.insertOneRecord(dto);
    }

    @Override
    public ShareRecord findTopOne() {
        ShareRecord shareRecord = shareDao.selectTopOne();
        return shareRecord;
    }


    private String doGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
