package sin.glouds.util.check;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckElement {
	
	public static final String TYPE_OBJECT = "object";
	public static final String TYPE_FIELD = "field";
	public static final String TYPE_LIST = "list";
	
	public String type() default TYPE_FIELD;
	public boolean nullable() default true;
	public int length() default -1;
	public String regex() default "";
	public String name() default "";
}
