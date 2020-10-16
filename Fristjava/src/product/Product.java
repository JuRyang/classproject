package product;
                           // 무조건 Object를 상속한다 (생략일뿐)
public class Product extends Object {
	
	 int price;
	 int bonusPoint;
	
	//생성자
	public Product(int price) {
		// super(); //Object클래스는 멤버변수가 없어 생략가능함
		this.price = price;
		this.bonusPoint = (int)(price*0.1f);
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", bonusPoint=" + bonusPoint + "]";
	}


	
	
	
	

}
