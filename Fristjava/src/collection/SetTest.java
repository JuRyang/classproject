package collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
	
		// Set: 집합, 저장순서 유지하지않는다. 저장되는 값의 중복을 허용하지 않는다.
		// HashSet 인스턴스 생성: 인스턴스를 저장하기위한 저장공간 생성
		HashSet<String> set = new HashSet<String>();
		
		set.add("First");
		set.add("Second");
		set.add("Third");
		set.add("First"); //저장 안됨
		
		System.out.println("set 요소의 개수:"+set.size());
		
		//Set<e>은 저장하는 순서를 가지지 않기 때문에 
		//일괄 처리를 위해서는 Iterator<E>인스턴스를 이용해서 처리한다.
		//Collection<E>iterator()메서드 -> Iterator<E>를 반환
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		
		}
	

	}
}

