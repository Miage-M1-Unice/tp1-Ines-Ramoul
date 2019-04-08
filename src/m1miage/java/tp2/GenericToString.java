package m1miage.java.tp2;
import java.lang.reflect.*;
import java.awt.Point;
import java.awt.Polygon;

public class GenericToString {


	public void toString(Object o, int p) throws IllegalArgumentException, IllegalAccessException {
		Class obj = o.getClass();
		String str= obj.getName();
		System.out.println(str + "[");
		for (Field field : o.getClass().getDeclaredFields()) {
			if (field.getType().isPrimitive()) {
				field.setAccessible(true);
				String name = field.getName();
				Object value = field.get(o);
				System.out.printf("%s= %s%n", name, value);
			}
			else if (field.getType().isArray()) {
				Object gf = field.get(o);
				Class arrClass = gf.getClass();
				Class componentType = arrClass.getComponentType();
				if (componentType != null) {
					System.out.println(field.getName()+"=" + componentType.toString());
					if (componentType.getDeclaredFields().length==0) {
						System.out.println("Array = 0" );
					}
					//Field[] fields : ((Class) gf).getDeclaredFields();
					for(Field f1: componentType.getDeclaredFields()) {
						

						//f1.setAccessible(true);
						System.out.println("field");
						System.out.println(f1.get(o));
					}
					//System.out.printf(componentType.getName());
				}
			}
			else {
				System.out.println("autre chose");
			}
		}
		System.out.println("]");
	}

	public void arrayCase() {

	}

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		GenericToString t = new GenericToString();
		//t.toString(new Point(12,24),1); 
		Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3); 
		t.toString(pol,2);
	}

}
