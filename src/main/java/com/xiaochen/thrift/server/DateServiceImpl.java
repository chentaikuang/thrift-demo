package com.xiaochen.thrift.server;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.xiaochen.thrift.DateService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;

@Controller
public class DateServiceImpl implements DateService.Iface {

    @Override
    public String getToday(String userName) throws TException {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = sdf.format(now);
        return "hi " + userName + ",today is " + nowTime;
    }
}
