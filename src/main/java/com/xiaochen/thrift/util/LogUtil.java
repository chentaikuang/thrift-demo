package com.xiaochen.thrift.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chentaikuang
 */
public class LogUtil {

    static ConcurrentHashMap<String, Logger> map = new ConcurrentHashMap();

    public static Logger get(Class T) {
        String clzName = T.getName();
        if (!map.containsKey(clzName)) {
            map.put(clzName, LoggerFactory.getLogger(clzName));
        }
        return map.get(clzName);
    }
}
