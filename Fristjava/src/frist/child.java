package frist;

public class child extends Parent{
	

	public static void main(String[] arg) {
		child c = new child();
		
		// System.out.println(c.money); Parent int money앞에 private이 있기때문에 오류
		System.out.println(c.getMoney());
	
	}

}
