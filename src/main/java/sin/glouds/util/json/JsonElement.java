package sin.glouds.util.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonElement {
	
	public static final String TYPE_OBJECT = "object";
	public static final String TYPE_FIELD = "field";
	
	public String type() default "field";
	public boolean nullable() default true;
	public int length() default 6000;
	public String regex() default "";
	public String name() default "";
}
