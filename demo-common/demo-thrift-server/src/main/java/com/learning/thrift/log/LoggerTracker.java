package com.learning.thrift.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by topaz on 2017/7/16.
 */
public class LoggerTracker {

    private static final Logger rpcLogger = LoggerFactory.getLogger("rpc");


    public static final ThreadLocal<StringBuilder> threadLocals = new ThreadLocal<StringBuilder>();


    public static void beforeInvoke() {
        StringBuilder sb = threadLocals.get();
        if (sb == null) {
            sb = new StringBuilder();
            threadLocals.set(sb);
        }
        sb.delete(0, sb.length());
    }


    public static void returnInvoke() {
        StringBuilder sb = threadLocals.get();
        if (sb != null) {
            rpcLogger.info(sb.toString());
        }
    }


    public static void throwableInvode(String fmt, Object... args) {
        StringBuilder sb = threadLocals.get();
        if (sb != null) {
            rpcLogger.info(sb.toString() + " " + String.format(fmt, args));
        }
    }


    public static void noticeLog(String fmt, Object... args) {
        StringBuilder sb = threadLocals.get();
        if (sb != null) {
            sb.append(String.format(fmt, args));
        }
    }

}
