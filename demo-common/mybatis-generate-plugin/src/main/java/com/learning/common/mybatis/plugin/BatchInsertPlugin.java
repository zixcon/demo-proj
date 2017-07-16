package com.learning.common.mybatis.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * Created by topaz on 2017/7/7.
 */
public class BatchInsertPlugin extends PluginAdapter{


    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapInsertElementGenerated(element, introspectedTable);
    }
}
