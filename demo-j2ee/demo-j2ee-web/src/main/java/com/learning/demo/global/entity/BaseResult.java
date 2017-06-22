package com.learning.demo.global.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by topaz on 2017/6/22.
 */
@Data
public class BaseResult<T> implements Serializable{

    private Boolean success = true;
    private String code;
    private String message;
    private T data;

}
