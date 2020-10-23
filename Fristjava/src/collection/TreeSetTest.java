package collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		
		//TreeSet : 트리구조 저장하는 자료구조, 2진 트리
		//TreeSet 인스턴스를 생성
		TreeSet<Integer> tSet = new TreeSet<Integer>();
		
		tSet.add(1);
		tSet.add(5);
		tSet.add(2);
		tSet.add(4);
		tSet.add(3);
		tSet.add(2);
		
		System.out.println("TreeSet 요소의 개수:"+tSet.size());
		
		Iterator<Integer> itr = tSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());  // 1 2 3 4 5 출력
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
