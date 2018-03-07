package sin.glouds.gen.table;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sin.glouds.gen.table.bean.Row;
import sin.glouds.gen.table.bean.Table;
import sin.glouds.util.FileUtil;
import sin.glouds.util.StringUtil;

public class CodeGen {

	private static List<String> imports = new ArrayList<>();
	
	public static void main(String[] args) {
		
		try {
			Table table = TableInfo.getTableInfo("novel_chapter");
			System.out.println(table);
			String packageName = "sin.glouds";
			String filePath = "F://temp/";
			if(genEntity(packageName, filePath, table) && genDao(packageName, filePath, table) && genService(packageName, filePath, table) && genController(packageName, filePath, table)) {
				System.out.println("生成成功");
			}else{
				System.out.println("生成失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void gen(String packageName, String filePath, Table table) {
		genEntity(packageName, filePath, table);
		imports.clear();
		genDao(packageName, filePath, table);
		imports.clear();
		genService(packageName,filePath, table);
		imports.clear();
		genController(packageName, filePath, table);
		imports.clear();
	}
	
	public static void gen(String packageName, String filePath, String tableName) throws Exception {
		gen(packageName, filePath, TableInfo.getTableInfo(tableName));
	}
	
	public static void gen(String tableName) throws Exception {
		gen("sin.glouds", "F://gen/", tableName);
	}
	
	public static void gen(String packageName, String filePath, String ... tableNames) throws Exception {
		for(Table table : TableInfo.getTablesInfo(tableNames)) {
			gen(packageName, filePath, table);
		}
	}
	
//	public static void gen(String ... tableNames) throws Exception {
//		for(Table table : TableInfo.getTablesInfo(tableNames)) {
//			gen(table);
//		}
//	}
	
	public static void gen(Table table) {
		gen("sin.glouds", "F://gen/", table);
	}
	
	public static void gen(String packageName, String filePath, List<String> tableNames) throws Exception {
		for(Table table : TableInfo.getTablesInfo(tableNames)) {
			gen(packageName, filePath, table);
		}
	}
	
	public static void gen(List<String> tableNames) throws Exception {
		for(Table table : TableInfo.getTablesInfo(tableNames)) {
			gen(table);
		}
	}
	
	private static boolean genService(String packageName, String filePath, Table table) {
		File file;
		File dir;
		PrintWriter writer;
		try {
			dir = new File(filePath + getPackDir(packageName + ".service"));
			file = new File(filePath + getPackDir(packageName + ".service") + table.getEntityName() + "Service.java");
			
			FileUtil.makeDirs(dir);
			
			if(!file.exists()) {
				file.createNewFile();
			}else if(!file.isFile()) {
				file.createNewFile();
			}
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		initServiceImports(table, packageName);
		genService(writer, packageName, table);
		writer.flush();
		writer.close();
		return true;
	}
	
	private static void genController(PrintWriter writer, String packageName, Table table) {
		writer.println("package " + packageName + ".controller;");
		writer.println();
		printImports(writer, imports);
		writer.println("@Controller");
		writer.println("public class " + table.getEntityName() + "Controller extends BaseController {");
		writer.println("\t");
		writer.println("\t@Resource");
		writer.println("\tprivate " + table.getEntityName() + "Service " + StringUtil.toFirstLowerCase(table.getEntityName() + "Service;"));
		writer.println("\t");
		writer.println("}");
	}
	
	private static void initControllerImports(Table table, String packageName) {
		imports.clear();
		imports.add("org.springframework.stereotype.Controller");
		imports.add("javax.annotation.Resource");
		if(!"sin.glouds".equals(packageName))
			imports.add("sin.glouds.controller.BaseController");
		imports.add(packageName + ".service." + table.getEntityName() + "Service");
	}
	
	private static boolean genController(String packageName, String filePath, Table table) {
		File file;
		File dir;
		PrintWriter writer;
		try {
			dir = new File(filePath + getPackDir(packageName + ".controller"));
			file = new File(filePath + getPackDir(packageName + ".controller") + table.getEntityName() + "Controller.java");
			
			FileUtil.makeDirs(dir);
			
			if(!file.exists()) {
				file.createNewFile();
			}else if(!file.isFile()) {
				file.createNewFile();
			}
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		 
		initControllerImports(table, packageName);
		genController(writer, packageName, table);
		writer.flush();
		writer.close();
		return true;
	}
	
	private static void genService(PrintWriter writer, String packageName, Table table) {
		
		String daoClassName = table.getEntityName() + "Dao",
				entityClassName = table.getEntityName(),
				daoName = StringUtil.toFirstLowerCase(daoClassName),
				entityName = StringUtil.toFirstLowerCase(entityClassName);
		
		writer.println("package " + packageName + ".service;");
		writer.println();
		printImports(writer, imports);
		writer.println("@Service");
		writer.println("@Transactional");
		writer.println("public class " + table.getEntityName() + "Service {");
		writer.println("\t");
		writer.println("\t@Resource");
		writer.println("\tprivate " + daoClassName + " " + daoName + ";");
		writer.println("\t");
		writer.println("\tpublic void save(" + entityClassName + " " + entityName + ") {");
		writer.println("\t\t" + daoName + ".save(" + entityName + ");");
		writer.println("\t}");
		writer.println();
		writer.println("\tpublic List<" + entityClassName + "> getAll() {");
		writer.println("\t\treturn " + daoName + ".getAllObjects();");
		writer.println("\t}");
		writer.println();
		writer.println("\tpublic List<" + entityClassName + "> findBy(String propName, String propValue) {");
		writer.println("\t\treturn " + daoName + ".findBy(propName, propValue);");
		writer.println("\t}");
		writer.println("}");
	}
	
	private static void initServiceImports(Table table, String packageName) {
		imports.clear();
		imports.add("org.springframework.stereotype.Service");
		imports.add("javax.annotation.Resource");
		imports.add(packageName + ".dao." + table.getEntityName() + "Dao");
		imports.add(packageName + ".entity." + table.getEntityName());
		imports.add("java.util.List");
		imports.add("org.springframework.transaction.annotation.Transactional");
	}
	
	private static boolean genDao(String packageName, String filePath, Table table) {
		File file;
		File dir;
		PrintWriter writer;
		try {
			dir = new File(filePath + getPackDir(packageName + ".dao"));
			file = new File(filePath + getPackDir(packageName + ".dao") + table.getEntityName() + "Dao.java");

			FileUtil.makeDirs(dir);
			
			if(!file.exists()) {
				file.createNewFile();
			}else if(!file.isFile()) {
				file.createNewFile();
			}
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		initDaoImports(table, packageName);
		genDao(writer, packageName, table);
		writer.flush();
		writer.close();
		return true;
	}
	
	private static void initDaoImports(Table table, String packageName) {
		imports.clear();
		imports.add("org.springframework.stereotype.Repository");
		imports.add(packageName + ".entity." + table.getEntityName());
		imports.add("sin.glouds.dao.BaseDao");
	}
	
	private static void genDao(PrintWriter writer, String packageName, Table table) {
		writer.println("package " + packageName + ".dao;");
		writer.println();
		printImports(writer, imports);
		writer.println("@Repository");
		writer.println("public class " + table.getEntityName() + "Dao extends BaseDao<" + table.getEntityName() + ", " + table.getRows().stream().filter((row)-> row.getColName().equals(table.getPrimaryKeys().get(0).getColumnName())).findFirst().get().getPropType() + "> {");
		writer.println("\t");
		writer.println("}");
	}
	
	public static boolean genEntity(String packageName, String filePath, Table table) {
		File file;
		File dir;
		PrintWriter writer;
		try {
			dir = new File(filePath + getPackDir(packageName + ".entity"));
			file = new File(filePath + getPackDir(packageName + ".entity") + table.getEntityName() + ".java");
			
			FileUtil.makeDirs(dir);
			
			if(!file.exists()) {
				file.createNewFile();
			}else if(!file.isFile()) {
				file.createNewFile();
			}
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		initEntityImports(table);
		genEntity(writer, packageName, table);
		writer.flush();
		writer.close();
		return true;
	}
	
	private static String getPackDir(String packageName) {
		StringBuilder sb = new StringBuilder();
		for(String str : packageName.split("\\.")) {
			sb.append(str).append("/");
		}
		return sb.toString();
	}
	
	private static void initEntityImports(Table table) {
		for(Row row : table.getRows()) {
			switch (row.getPropType()) {
//			case "String":
//				if(!imports.contains("java.lang.String"))
//					imports.add("java.lang.String");
//				break;
//			case "java.lang.String":
//				if(!imports.contains("java.lang.String"))
//					imports.add("java.lang.String");
//				break;
//			case "Integer":
//				if(!imports.contains("java.lang.Integer"))
//					imports.add("java.lang.Integer");
//				break;
//			case "java.lang.Integer":
//				if(!imports.contains("java.lang.Integer"))
//					imports.add("java.lang.Integer");
//				break;
//			case "Double":
//				if(!imports.contains("java.lang.Double"))
//					imports.add("java.lang.Double");
//				break;
//			case "java.lang.Double":
//				if(!imports.contains("java.lang.Double"))
//					imports.add("java.lang.Double");
//				break;
//			case "Long":
//				if(!imports.contains("java.lang.Long"))
//					imports.add("java.lang.Long");
//				break;
//			case "java.lang.Long":
//				if(!imports.contains("java.lang.Long"))
//					imports.add("java.lang.Long");
//				break;
			case "Date":
				if(!imports.contains("java.util.Date"))
					imports.add("java.util.Date");
				break;
			case "java.util.Date":
				if(!imports.contains("java.util.Date"))
					imports.add("java.util.Date");
				break;
			case "BigDecimal":
				if(!imports.contains("java.math.BigDecimal"))
					imports.add("java.math.BigDecimal");
				break;
			default:
				break;
			}
		}
		imports.add("javax.persistence.Column");
		imports.add("javax.persistence.Entity");
		imports.add("javax.persistence.Table");
		if(table.getPrimaryKeys() != null && table.getPrimaryKeys().size() != 0) {
			imports.add("javax.persistence.Id");
			if(table.getRows().stream().anyMatch((obj) -> obj.isPrimaryKey())) {
				imports.add("org.hibernate.annotations.GenericGenerator");
				imports.add("javax.persistence.GeneratedValue");
			}
		}
	}
	
	private static void genEntity(PrintWriter writer,String packageName, Table table) {
		writer.println("package " + packageName + ".entity;");
		writer.println("");
		
		printImports(writer, imports);
		writer.println("@Entity");
		writer.println("@Table(name = \"" + table.getTableName() + "\")");
		writer.println("public class " + table.getEntityName() + " {");
		writer.println();
		printFields(writer, table);
		writer.println();
		printMethods(writer, table);
		writer.println();
		writer.println("}");
		
	}
	
	private static void printImports(PrintWriter writer, List<String> imports2) {
		Collections.sort(imports);
		String start = "____";
		for(String imp : imports) {
			if(start != "____" && imp.startsWith(start)) {
				writer.println("");
				start = imp.substring(0, 4);
			}
			if(!imp.startsWith("java.lang"))
				writer.println("import " + imp + ";");
		}
		
		writer.println();
	}

	private static void printFields(PrintWriter writer, Table table) {
		for(Row row : table.getRows()) {
			if(row.isPrimaryKey()) {
				writer.println("\t@Id");
				writer.println("\t@GeneratedValue(generator = \"increment\")");
				writer.println("\t@GenericGenerator(name = \"increment\", strategy = \"increment\")");
			}
			writer.println("\t@Column(name = \"" + row.getColName() + "\")");
			switch (row.getPropType()) {
			case "String":
				writer.println("\tprivate String " + row.getPropName() + ";");
				break;
			case "java.lang.String":
				writer.println("\tprivate String " + row.getPropName() + ";");
				break;
			case "Integer":
				writer.println("\tprivate Integer " + row.getPropName() + ";");
				break;
			case "java.lang.Integer":
				writer.println("\tprivate Integer " + row.getPropName() + ";");
				break;
			case "Boolean":
				writer.println("\tprivate Boolean " + row.getPropName() + ";");
				break;
			case "java.lang.Boolean":
				writer.println("\tprivate Boolean " + row.getPropName() + ";");
				break;
			case "BigDecimal":
				writer.println("\tprivate BigDecimal " + row.getPropName() + ";");
				break;
			case "java.math.BigDecimal":
				writer.println("\tprivate BigDecimal " + row.getPropName() + ";");
				break;
			case "Double":
				writer.println("\tprivate Double " + row.getPropName() + ";");
				break;
			case "java.lang.Double":
				writer.println("\tprivate Double " + row.getPropName() + ";");
				break;
			case "Long":
				writer.println("\tprivate Long " + row.getPropName() + ";");
				break;
			case "java.lang.Long":
				writer.println("\tprivate Long " + row.getPropName() + ";");
				break;
			case "Date":
				writer.println("\tprivate Date " + row.getPropName() + ";");
				break;
			case "java.util.Date":
				writer.println("\tprivate Date " + row.getPropName() + ";");
				break;

			default:
				break;
			}
		}
	}
	
	private static void printMethods(PrintWriter writer, Table table) {
		
		writer.println("\tpublic " + table.getEntityName() + " () {");
		writer.println("\t");
		writer.println("\t}");
		
		for(Row row : table.getRows()) {
			switch (row.getPropType()) {
			case "String":
				writer.println("\tpublic String get" + StringUtil.toFirstUpperCase(row.getPropName()) + "() {");
				writer.println("\t\treturn this." + row.getPropName() + ";");
				writer.println("\t}");
				writer.println("\tpublic " + table.getEntityName() + " set" + StringUtil.toFirstUpperCase(row.getPropName()) + "(String " + row.getPropName() +" ) {");
				writer.println("\t\tthis." + row.getPropName() + " = " + row.getPropName() + ";");
				writer.println("\t\treturn this;");
				writer.println("\t}");
				break;
			case "java.lang.String":
				writer.println("\tpublic String get" + StringUtil.toFirstUpperCase(row.getPropName()) + "() {");
				writer.println("\t\treturn this." + row.getPropName() + ";");
				writer.println("\t\t}");
				writer.println("\tpublic " + table.getEntityName() + " set" + StringUtil.toFirstUpperCase(row.getPropName()) + "(String " + row.getPropName() +" ) {");
				writer.println("\t\tthis." + row.getPropName() + " = " + row.getPropName() + ";");
				writer.println("\t\treturn this;");
				writer.println("\t}");
				break;
			case "Integer":
				writer.println("\tpublic Integer get" + StringUtil.toFirstUpperCase(row.getPropName()) + "() {");
				writer.println("\t\treturn this." + row.getPropName() + ";");
				writer.println("\t}");
				writer.println("\tpublic " + table.getEntityName() + " set" + StringUtil.toFirstUpperCase(row.getPropName()) + "(Integer " + row.getPropName() +" ) {");
				writer.println("\t\tthis." + row.getPropName() + " = " + row.getPropName() + ";");
				writer.println("\t\treturn this;");
				writer.println("\t}");
				break;
			case "java.lang.Integer":
				writer.println("\tpublic Integer get" + StringUtil.toFirstUpperCase(row.getPropName()) + "() {");
				writer.println("\t\treturn this." + row.getPropName() + ";");
				writer.println("\t}");
				writer.println("\tpublic " + table.getEntityName() + " set" + StringUtil.toFirstUpperCase(row.getPropName()) + "(Integer " + row.getPropName() +" ) {");
				writer.println("\t\tthis." + row.getPropName() + " = " + row.getPropName() + ";");
				writer.println("\t\treturn this;");
				writer.println("}");
				break;
			case "Double":
				writer.println("\tpublic Double get" + StringUtil.toFirstUpperCase(row.getPropName()) + "() {");
				writer.println("\t\treturn this." + row.getPropName() + ";");
				writer.println("\t}");
				writer.println("\tpublic " + table.getEntityName() + " set" + StringUtil.toFirstUpperCase(row.getPropName()) + "(Double " + row.getPropName() +" ) {");
				writer.println("\t\tthis." + row.getPropName() + " = " + row.getPropName() + ";");
				writer.println("\t\treturn this;");
				writer.println("}");
				break;
			case "java.lang.Double":
				writer.println("\tpublic Double get" + StringUtil.toFirstUpperCase(row.getPropName()) + "() {");
				writer.println("\t\treturn this." + row.getPropName() + ";");
				writer.println("\t}");
				writer.println("\tpublic " + table.getEntityName() + " set" + StringUtil.toFirstUpperCase(row.getPropName()) + "(Double " + row.getPropName() +" ) {");
				writer.println("\t\tthis." + row.getPropName() + " = " + row.getPropName() + ";");
				writer.println("\t\treturn this;");
				writer.println("}");
				break;
			case "Long":
				writer.println("\tpublic Long get" + StringUtil.toFirstUpperCase(row.getPropName()) + "() {");
				writer.println("\t\treturn this." + row.getPropName() + ";");
				writer.println("\t}");
				writer.println("\t\tpublic " + table.getEntityName() + " set" + StringUtil.toFirstUpperCase(row.getPropName()) + "(Long " + row.getPropName() +" ) {");
				writer.println("\t\tthis." + row.getPropName() + " = " + row.getPropName() + ";");
				writer.println("\treturn this;");
				writer.println("}");
				break;
			case "java.lang.Long":
				writer.println("\tpublic Long get" + StringUtil.toFirstUpperCase(row.getPropName()) + "() {");
				writer.println("\t\treturn this." + row.getPropName() + ";");
				writer.println("\t}");
				writer.println("\tpublic " + table.getEntityName() + " set" + StringUtil.toFirstUpperCase(row.getPropName()) + "(Long " + row.getPropName() +" ) {");
				writer.println("\t\tthis." + row.getPropName() + " = " + row.getPropName() + ";");
				writer.println("\t\treturn this;");
				writer.println("}");
				break;
			case "Date":
				writer.println("\tpublic Date get" + StringUtil.toFirstUpperCase(row.getPropName()) + "() {");
				writer.println("\t\treturn this." + row.getPropName() + ";");
				writer.println("\t}");
				writer.println("\tpublic " + table.getEntityName() + " set" + StringUtil.toFirstUpperCase(row.getPropName()) + "(Date " + row.getPropName() +" ) {");
				writer.println("\t\tthis." + row.getPropName() + " = " + row.getPropName() + ";");
				writer.println("\t\treturn this;");
				writer.println("}");
				break;
			case "java.util.Date":
				writer.println("\tpublic Date get" + StringUtil.toFirstUpperCase(row.getPropName()) + "() {");
				writer.println("\t\treturn this." + row.getPropName() + ";");
				writer.println("\t}");
				writer.println("\tpublic " + table.getEntityName() + " set" + StringUtil.toFirstUpperCase(row.getPropName()) + "(Date " + row.getPropName() +" ) {");
				writer.println("\t\tthis." + row.getPropName() + " = " + row.getPropName() + ";");
				writer.println("\t\treturn this;");
				writer.println("}");
				break;
			default:
				break;
			}
		}
	}
}
