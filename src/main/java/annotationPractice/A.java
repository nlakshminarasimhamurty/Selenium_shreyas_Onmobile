package annotationPractice;

import java.lang.reflect.Method;

public class A {

	private static Method method;

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		A a1 = new A();
		System.out.println(a1.getClass().getMethod("run").getAnnotation(Testmyapp.class).app());
		;

		System.out.println(a1.getClass().getMethod("run").getAnnotation(Testmyapp.class).news());
		;

	}

	@Testmyapp(app = "shreyas", news = "abcd")
	public void run() {
		System.out.println("hello run method");

	}

}
