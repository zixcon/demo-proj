package com.learning.common.mybatis.generator;

import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by topaz on 2017/7/2.
 */
public class BatchInsertMethodGenerator extends AbstractJavaMapperMethodGenerator {

      	public BatchInsertMethodGenerator() {
      		super();
      	}

      	@Override
	public void addInterfaceElements(Interface interfaze) {
      		Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
      		Method method = new Method();
      		method.setVisibility(JavaVisibility.PUBLIC);

			FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getIntInstance();
      		method.setReturnType(returnType);
      		importedTypes.add(returnType);

			method.setName("batchInsert");// Map<String, Object>
      		FullyQualifiedJavaType queryType = introspectedTable.getRules().calculateAllFieldsClass();
      		//FullyQualifiedJavaType type = FullyQualifiedJavaType.getNewListInstance();
      		method.addParameter(new Parameter(queryType, "list")); //$NON-NLS-1$
      		addMapperAnnotations(interfaze, method);

			context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);

			if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, interfaze,
					introspectedTable)) {
				interfaze.addImportedTypes(importedTypes);
				interfaze.addMethod(method);
			}
      	}

      	public void addMapperAnnotations(Interface interfaze, Method method) {
      		return;
      	}
}