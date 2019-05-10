package com.xiaochen.thrift.client;

import com.xiaochen.thrift.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private Client client;

    @RequestMapping(value = "/today", method = RequestMethod.GET)
    public String getToday() {
        String rst = null;
        try {
            client.open();
            rst = client.getRPCThriftService().getToday(new Random().nextInt(88888) + "");
        } catch (Exception e) {
            e.getMessage();
            rst = "error:" + e.getMessage();
        } finally {
            client.close();
        }

        LogUtil.get(this.getClass()).info("【rst msg】{}", rst);

        return rst;
    }
}
