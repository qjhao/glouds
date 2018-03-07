package sin.glouds.util.oom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapperElement {
	public static final String TYPE_O2O = "object to object";//Y
	public static final String TYPE_O2F = "object to field";//Y
	public static final String TYPE_F2F = "field to field";//Y
	public static final String TYPE_L2L = "list to list";//Y
	public static final String TYPE_FOOL = "first object of list";//Y
	
	public String type() default TYPE_F2F;
	public String name() default "";
	public String defaultValue() default "";
}
