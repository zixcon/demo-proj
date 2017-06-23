package com.learning.demo.web.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by topaz on 2017/6/23.
 */
@Data
public class HelloValidVO {

    @NotNull(message = "名称不能为空")
    private String name;

    @Length(max = 16, message = "长度范围在[0˜16]")
    private String length;
}
