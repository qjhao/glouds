package ${basePackage }.entity;

<#if genTable.imports?? >
<#list genTable.imports as ips>
import ${ips};
</#list>

</#if>
/**
 *
 *
 *
 */
public class ${genTable.className } {
	
	<#list genTable.genTableColumns as column>
	private ${column.fieldType} ${column.fieldName};
	</#list>
	
	<#list genTable.genTableColumns as column>
	public ${column.fieldType} get${column.fieldNameInFunction }() {
		return ${column.fieldName};
	}
	
	public void set${column.fieldNameInFunction}(${column.fieldType} ${column.fieldName}) {
		this.${column.fieldName } = ${column.fieldName};
	}
	</#list>
}