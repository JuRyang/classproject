package product;

public class Computer extends Product{

	public Computer(int price) {
		super(price);
	}

	//시프트 컨트롤 s 스티링
	@Override
	public String toString() {
		return "Computer ["+price+"]";
	}

}
