package collection;

import java.util.Iterator;
import java.util.TreeSet;

public class Person2 implements Comparable<Person2> {

	String name;
	int age;

	Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name + "(" + age + ")";
	}

	@Override
	public int compareTo(Person2 o) {
		/*
		 * if(age>o.age) { return 1; //양수반환: 전달받은 객체의 값이 작을 때 }else if(age<o.age) {
		 * return -1; //음수 반환: 전달받은 객체의 값이 클 때 }else { return 0; }
		 */

		return age - o.age; // 기존 오름차순
		// return o.age-age;

	}

	public static void main(String[] args) {

		TreeSet<Person2> tSet = new TreeSet<Person2>();

		tSet.add(new Person2("son", 28));
		tSet.add(new Person2("Park", 40));
		tSet.add(new Person2("Lee", 20));

		Iterator<Person2> itr = tSet.iterator();

		while (itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}
