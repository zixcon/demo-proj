package com.learning.common.mybatis.generator;

import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by topaz on 2017/7/2.
 */
public class BatchUpdateByPrimaryKeyMethodGenerator extends AbstractJavaMapperMethodGenerator {

      	public BatchUpdateByPrimaryKeyMethodGenerator() {
      		super();
      	}

    @Override
	public void addInterfaceElements(Interface interfaze) {
            /*      Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
              		Method method = new Method();
              		method.setVisibility(JavaVisibility.PUBLIC);

              		FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getIntInstance();
              		method.setReturnType(returnType);
              		importedTypes.add(returnType);

              		method.setName("batchUpdateByPrimaryKey");// Map<String, Object>
              		FullyQualifiedJavaType queryType = introspectedTable.getRules().calculateAllFieldsClass();
              		FullyQualifiedJavaType type = FullyQualifiedJavaType.getListInstance(queryType);
              		method.addParameter(new Parameter(type, "list")); //$NON-NLS-1$
              		addMapperAnnotations(interfaze, method);

                      		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);

                      		if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, interfaze,
                      				introspectedTable)) {
                      			interfaze.addImportedTypes(importedTypes);
                      			interfaze.addMethod(method);
                      		}
               */
            Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
            interfaze.addImportedType(new FullyQualifiedJavaType("java.util.List"));

            Method method = this.handleBatchMethod("updateBySelectiveBatch");
            interfaze.addMethod(method);
            this.addMapperAnnotations(interfaze,method);
            context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
            if (context.getPlugins().clientUpdateByExampleSelectiveMethodGenerated(method, interfaze,
                    introspectedTable)) {
                interfaze.addImportedTypes(importedTypes);
                interfaze.addMethod(method);
            }

            method = this.handleBatchMethod("updateByByPrimaryKeyBatch");
            interfaze.addMethod(method);
            this.addMapperAnnotations(interfaze,method);
            context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
            if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, interfaze,
                    introspectedTable)) {
                interfaze.addImportedTypes(importedTypes);
                interfaze.addMethod(method);
            }

        }

        private Method handleBatchMethod(String methodName) {
            Method method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setName(methodName);

            FullyQualifiedJavaType queryType = introspectedTable.getRules().calculateAllFieldsClass();
            method.addParameter(new Parameter(queryType,"list"));

            FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getIntInstance();
            method.setReturnType(returnType);
            return method;
        }

      	public void addMapperAnnotations(Interface interfaze, Method method) {
      		return;
      	}
}
