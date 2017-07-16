package com.learning.thrift;

/**
 * Created by topaz on 2017/7/16.
 */
public class ThriftException extends RuntimeException{

    public ThriftException() {
        super();
    }

    public ThriftException(String message) {
        super(message);
    }

    public ThriftException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThriftException(Throwable cause) {
        super(cause);
    }

    public ThriftException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
