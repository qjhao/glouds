package sin.glouds.gen.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import sin.glouds.util.StringUtil;

public class JsonGen {
	
	public static void main(String[] args) throws FileNotFoundException {
		String jsonStr = "{\"name\":\"glouds\",\"age\":25,\"books\":[{\"math\":true},{\"computer\":false}],\"male\":false,\"sal\":2.2,\"brother\":{\"name\":\"jemmy\"},\"isDel\":'1'}";
		File file = new File("F://gen/json");
		jsonToJavaBeanFile(jsonStr,file,"user","sin.glouds.bean.gen");
	}

	public static void jsonToJavaBeanFile(String json, File file, String className, String packageName) throws FileNotFoundException {
		
		JSONObject jsonObject = new JSONObject(json);
		JsonInfo info = parseJsonObject(jsonObject, className, true, Type.OBJECT);
		genBean(info,file, className, packageName);
	}
	
	public static void genBean(JsonInfo info, File path, String className, String packageName) throws FileNotFoundException {
		if(!path.exists())
			path.mkdirs();
		PrintWriter writer;
		if(info.getType() == Type.ARRAY || info.getType() == Type.OBJECT) {
			File file = new File(path, StringUtil.toFirstUpperCase(className) + ".java");
			writer = new PrintWriter(file);
			
			if(StringUtil.isNotEmpty(packageName))
				writer.println("package " + packageName + ";\n");
			if(info.getInfos().stream().anyMatch(obj -> obj.getType() == Type.ARRAY)) {
				writer.println("import java.util.List;\n");
			}
			writer.println("public class " + StringUtil.toFirstUpperCase(className) + " {\n");
			
			//写入属性
			for(JsonInfo inf : info.getInfos()) {
				switch (inf.getValueType()) {
				case ARRAY:
					writer.println("\tprivate List<" + StringUtil.toFirstUpperCase(inf.getName()) + "> " + inf.getName() + "s;");
					break;
				case OBJECT:
					writer.println("\tprivate " + StringUtil.toFirstUpperCase(inf.getName()) + " " + inf.getName() + ";");
					break;
				case STRING:
					writer.println("\tprivate String " + inf.getName() + ";");
					break;
				case INTEGER:
					writer.println("\tprivate Integer " + inf.getName() + ";");
					break;
				case DOUBLE:
					writer.println("\tprivate Double " + inf.getName() + ";");
					break;
				case BOOLEAN:
					writer.println("\tprivate Boolean " + inf.getName() + ";");
					break;

				default:
					break;
				}
			}
			
			writer.println();
			
			//写入方法
			for(JsonInfo inf : info.getInfos()) {
				switch (inf.getValueType()) {
				case ARRAY:
					writer.println("\tpublic List<" + StringUtil.toFirstUpperCase(inf.getName()) + "> get" + StringUtil.toFirstUpperCase(inf.getName()) + "() {");
					writer.println("\t\treturn " + inf.getName() + "s;");
					writer.println("\t}");
					writer.println("\tpublic void set" + StringUtil.toFirstUpperCase(inf.getName()) + "(List<" + StringUtil.toFirstUpperCase(inf.getName()) + ">" + inf.getName() + "s) {");
					writer.println("\t\tthis." + inf.getName() + "s = " + inf.getName() + "s;");
					writer.println("\t}");
					break;
				case OBJECT:
					writer.println("\tpublic " + StringUtil.toFirstUpperCase(inf.getName()) + " get" + StringUtil.toFirstUpperCase(inf.getName()) + "() {");
					writer.println("\t\treturn " + inf.getName() + ";");
					writer.println("\t}");
					writer.println("\tpublic void set" + StringUtil.toFirstUpperCase(inf.getName()) + "(" + StringUtil.toFirstUpperCase(inf.getName()) + " " + inf.getName() + ") {");
					writer.println("\t\tthis." + inf.getName() + " = " + inf.getName() + ";");
					writer.println("\t}");
					break;
				case STRING:
					writer.println("\tpublic String get" + StringUtil.toFirstUpperCase(inf.getName()) + "() {");
					writer.println("\t\treturn " + inf.getName() + ";");
					writer.println("\t}");
					writer.println("\tpublic void set" + StringUtil.toFirstUpperCase(inf.getName()) + "(String " + inf.getName() + ") {");
					writer.println("\t\tthis." + inf.getName() + " = " + inf.getName() + ";");
					writer.println("\t}");
					break;
				case INTEGER:
					writer.println("\tpublic Integer get" + StringUtil.toFirstUpperCase(inf.getName()) + "() {");
					writer.println("\t\treturn " + inf.getName() + ";");
					writer.println("\t}");
					writer.println("\tpublic void set" + StringUtil.toFirstUpperCase(inf.getName()) + "(Integer " + inf.getName() + ") {");
					writer.println("\t\tthis." + inf.getName() + " = " + inf.getName() + ";");
					writer.println("\t}");
					break;
				case DOUBLE:
					writer.println("\tpublic Double get" + StringUtil.toFirstUpperCase(inf.getName()) + "() {");
					writer.println("\t\treturn " + inf.getName() + ";");
					writer.println("\t}");
					writer.println("\tpublic void set" + StringUtil.toFirstUpperCase(inf.getName()) + "(Double " + inf.getName() + ") {");
					writer.println("\t\tthis." + inf.getName() + " = " + inf.getName() + ";");
					writer.println("\t}");
					break;
				case BOOLEAN:
					writer.println("\tpublic Boolean get" + StringUtil.toFirstUpperCase(inf.getName()) + "() {");
					writer.println("\t\treturn " + inf.getName() + ";");
					writer.println("\t}");
					writer.println("\tpublic void set" + StringUtil.toFirstUpperCase(inf.getName()) + "(Boolean " + inf.getName() + ") {");
					writer.println("\t\tthis." + inf.getName() + " = " + inf.getName() + ";");
					writer.println("\t}");
					break;

				default:
					break;
				}
			}
			writer.print("}");
			writer.flush();
			writer.close();
			
			//生成子对象
			for(JsonInfo inf : info.getInfos()) {
				genBean(inf, path, inf.getName(), packageName);
			}
		}
	}
	
	public static JsonInfo parseJsonObject(JSONObject obj, String name, boolean root, Type type) {
		
		JsonInfo info = new JsonInfo();
		
		info.setName(name.endsWith("s")?name.substring(0, name.length() -1):name);
		info.setRoot(root);
		info.setType(type);
		
		List<JsonInfo> infos = new ArrayList<>();
		
		Set<?> keys = obj.keySet();

		for (Object key : keys) {
			Object value = obj.get(key.toString());
			JsonInfo inf = new JsonInfo();
			switch (value.getClass().getName()) {
			case "org.json.JSONArray":
				inf = parseJsonObject((JSONObject)((JSONArray)value).get(0), key.toString(), false, Type.ARRAY);
				inf.setValueType(ValueType.ARRAY);
				break;
			case "java.lang.String":
				inf.setName(key.toString());
				inf.setRoot(false);
				inf.setType(Type.VALUE);
				inf.setValue(value.toString());
				inf.setValueType(ValueType.STRING);
				break;
			case "org.json.JSONObject":
				inf = parseJsonObject((JSONObject)value, key.toString(), false, Type.ARRAY);
				inf.setValueType(ValueType.OBJECT);
				break;
			case "java.lang.Integer":
				inf.setName(key.toString());
				inf.setRoot(false);
				inf.setType(Type.VALUE);
				inf.setValue(value.toString());
				inf.setValueType(ValueType.INTEGER);
				break;
			case "java.lang.Boolean":
				inf.setName(key.toString());
				inf.setRoot(false);
				inf.setType(Type.VALUE);
				inf.setValue(value.toString());
				inf.setValueType(ValueType.BOOLEAN);
				break;
			case "java.lang.Double":
				inf.setName(key.toString());
				inf.setRoot(false);
				inf.setType(Type.VALUE);
				inf.setValue(value.toString());
				inf.setValueType(ValueType.DOUBLE);
				break;
			default:
				break;
			}
			infos.add(inf);
		}
		info.setInfos(infos);
		
		return info;
	}
	
	@SuppressWarnings("serial")
	public static Map<ValueType, String> valueTypeMap = new HashMap<ValueType, String>() {
		{
			put(ValueType.ARRAY, "List");
			put(ValueType.OBJECT, "List");
			put(ValueType.ARRAY, "List");
			put(ValueType.ARRAY, "List");
			put(ValueType.ARRAY, "List");
			put(ValueType.ARRAY, "List");
		}
	};
}
