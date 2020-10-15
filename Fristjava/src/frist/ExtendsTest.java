package frist;

public class ExtendsTest {

	public static void main(String[] args) {


		child c1 = new child();
		child2 c2 = new child2("KING");
		GrandChild gc = new GrandChild("손흥민");
		
		System.out.println(c1.getMoney());
		System.out.println(c2.getMoney());
		System.out.println(c2.name);
		System.out.println(gc.getMoney());
		System.out.println(gc.name);


	}

}
