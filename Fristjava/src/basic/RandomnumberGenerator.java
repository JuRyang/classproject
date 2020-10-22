package basic;

import java.util.Random;

public class RandomnumberGenerator {

	public static void main(String[] args) {
		
		
		Random r = new Random();
		
		System.out.println(r.nextBoolean());
		System.out.println(r.nextInt());
		System.out.println(r.nextLong());
		System.out.println(r.nextFloat());
		System.out.println(r.nextDouble());
		
		
		System.out.println("이번 주 번호 예상");
		for(int i=0; i<6; i++) {
			System.out.print(r.nextInt(45)+1+"\t");  //0~44 +1
		}
		System.out.println();
		
		
		Random r2 = new Random(10);
		System.out.println("이번 주 번호 예상");
		for(int i=0; i<6; i++) {
			System.out.print(r2.nextInt(45)+1+"\t");  //0~44 +1
		}
		
		System.out.println();
		
		System.out.println("System.currentTimeMillis() :"+System.currentTimeMillis());//현재 시간을 구하는 메서드
		System.out.println("System.nanoTime() :"+System.nanoTime()); //수행시간속도
		Random r3 =new Random(System.currentTimeMillis()); 
		System.out.println("이번 주 번호 예상");
		for(int i=0; i<6; i++) {
			System.out.print(r3.nextInt(45)+1+"\t");  //0~44 +1
		}
		
	

	}

}
