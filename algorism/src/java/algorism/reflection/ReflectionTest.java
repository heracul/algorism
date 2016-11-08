package algorism.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException, InstantiationException, ClassNotFoundException {
		Class clazz = Class.forName("algorism.reflection.ReflectionVO");
		Object instance = clazz.newInstance();
		Method[] methods = clazz.getDeclaredMethods();
		Method method = clazz.getDeclaredMethod("toString");
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields) {
			if(Modifier.isPrivate(field.getModifiers())) {
				System.out.println(field.getName()+"메소드 접근제어자 변경 ");
				field.setAccessible(true);
				Class type = field.getType();
				if("name".equals(field.getName())) {
					field.set(instance, "박세일");
				} else if("home".equals(field.getName())) {
					field.set(instance, "청담동");
				} else if("age".equals(field.getName())) {
					field.setInt(instance, 37);
				} else {
					
				}
			}
		}
		System.out.println(method.invoke(instance));
	}

}
