package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**自定义注解*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Controller{
	String value() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Service{
	String value() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Autowired{
	
}
@Service
class SysLogService{
	
}
@Controller("logController")
class SysLogController{
	@Autowired
	private SysLogService sysLogService;
}
public class TestAnnotation01 {
	public static void main(String[] args)
	throws Exception{
		Class<?> cls=
		Class.forName("annotation.SysLogController");
		
		boolean flag=
		cls.isAnnotationPresent(Controller.class);
		System.out.println(flag);
		
		Controller con=
		cls.getDeclaredAnnotation(Controller.class);
		
		System.out.println(con.value());
		//获取类中属性
		Field[] fs=cls.getDeclaredFields();
		for(Field f:fs){
			if(f.isAnnotationPresent(Autowired.class)){
				System.out.println("执行DI操作");
			}
		}	
	}
}
