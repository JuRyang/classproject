package collection;

public class SimpleNumber {
	
	int num;
	
	public SimpleNumber(int num) {
		this.num = num;
	}
	

	
	@Override
	public String toString() {
		//return "SimpleNumber [num="+num+"]";
		return String.valueOf(num);
	}

	//Set 동등 비교를 위한 hscCode(), equals() 오버로딩
	
	@Override
	public int hashCode() {
	/*	final int prime = 31;
		int result = 1;
		result = prime * result + num;
		retur result;  */
		return num&3;  // 0 or 1 or2
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)  //참조 주소값 == 참조 주소값
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())  //클래스 이름 비교 (같은 타입인지 비교) 클래스 이름이 같아야 한다. 즉 같은 타입이어야한다.
			return false;
		SimpleNumber other = (SimpleNumber) obj; //같은 타입이면 형변화 해줘야 함
		if (num != other.num)
			return false;
		return true;
	}
	
	
	
	

}
