package com.learning.demo.web.global.converter;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.beans.PropertyEditorSupport;

/**
 * change "" to null of String type parameter
 *
 * Created by topaz on 2017/6/24.
 */
@ControllerAdvice
public class StringPropertyConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text instanceof String) {
            if (null != text && "".equals(String.valueOf(text).trim())) {
                super.setValue(null);
            } else {
                super.setValue(text);
            }
            return;
        }
        super.setValue(text);
    }
}