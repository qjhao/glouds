package sin.glouds.gen.table2;

import java.util.ArrayList;
import java.util.List;

import sin.glouds.gen.table2.bean.GenModel;
import sin.glouds.gen.table2.bean.GenTable;
import sin.glouds.gen.table2.bean.GenTableColumn;
import sin.glouds.util.FreemarkerUtil;

public class Test {

	public static void main(String[] args) throws Exception {
		GenModel model = new GenModel();
		model.setBasePackage("sin.glouds");
		GenTable table = new GenTable();
		table.setClassName("User");
		table.setComments("");
		List<GenTableColumn> columns = new ArrayList<>();
		GenTableColumn column1 = new GenTableColumn();
		column1.setFieldName("id");
		column1.setFieldNameInFunction("Id");
		column1.setFieldType("Integer");
		columns.add(column1);
		GenTableColumn column2 = new GenTableColumn();
		column2.setFieldName("name");
		column2.setFieldNameInFunction("Name");
		column2.setFieldType("String");
		columns.add(column2);
		GenTableColumn column3 = new GenTableColumn();
		column3.setFieldName("age");
		column3.setFieldNameInFunction("Age");
		column3.setFieldType("Integer");
		columns.add(column1);
		table.setGenTableColumns(columns);
		model.setGenTable(table);
		FreemarkerUtil.generate("test/entity.ftl", model, "H://temp/User.java");
	}
}
