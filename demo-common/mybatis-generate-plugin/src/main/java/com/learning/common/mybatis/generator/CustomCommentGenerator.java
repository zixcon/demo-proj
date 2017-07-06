package com.learning.common.mybatis.generator;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import javafx.util.converter.LocalDateStringConverter;
import org.joda.time.format.DateTimeFormat;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.DefaultCommentGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

/**
 * 自定义注解
 * Created by topaz on 2017/7/1.
 */
public class CustomCommentGenerator extends DefaultCommentGenerator{

    private static final String STR_SEPRATOR = " * ";

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        field.addJavaDocLine("/**");
        StringBuilder sb = new StringBuilder();
        sb.append(STR_SEPRATOR);
        sb.append("最大长度：");
        sb.append(Integer.toString(introspectedColumn.getLength()));
        field.addJavaDocLine(sb.toString());
        sb.setLength(0);
        sb.append(STR_SEPRATOR);
        sb.append("字段说明：");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString());
        sb.setLength(0);
        sb.append(STR_SEPRATOR);
        sb.append("默认值 ：");
        sb.append(introspectedColumn.getDefaultValue());
        field.addJavaDocLine(sb.toString());sb.setLength(0);
        sb.append(STR_SEPRATOR);
        sb.append("允许null：");
        sb.append(Boolean.toString(introspectedColumn.isNullable()));
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
    }

    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        this.addClassComment(innerClass,introspectedTable,false);
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        innerClass.addJavaDocLine("/**");
        StringBuilder sb = new StringBuilder();
        sb.append(STR_SEPRATOR);
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());
        sb.setLength(0);
        sb.append(STR_SEPRATOR);
        sb.append(introspectedTable.getRemarks());
        innerClass.addJavaDocLine(sb.toString());
        sb.setLength(0);
        sb.append(STR_SEPRATOR);
        sb.append("创建于：");
        sb.append(dateFormat.format(new Date()));
        innerClass.addJavaDocLine(sb.toString());
        innerClass.addJavaDocLine("*/");
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.addClassComment(topLevelClass,introspectedTable,false);
    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        //super.addGeneralMethodComment(method, introspectedTable);
    }

}
