package generic;

public class Apple {
	
	private int weight;  //사과의 무게
	
	Apple(int weight){
		this.weight = weight;
	}
	
	public void showWegiht() {
		System.out.println("사과의 무게는:" +weight);
	}

}
