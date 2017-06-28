package com.learning.demo.biz.service.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by topaz on 2017/6/28.
 */
@Service
public class OpLogService {

    @Async("logExecutor")
    public void asyncSaveOpLog() {
        // do save
    }
}
