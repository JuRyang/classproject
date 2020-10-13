package frist;

public class ArrayBubbleSort {

	public static void main(String[] args) {
		
		//정수 데이터 10개를 저장하는 배열 생성
		int[] number = new int[10];
		
		//임의 숫자 0~9까지의 숫자를 배열의 각 요소에 저장(배열이 나오면 공식처럼 반복문 쓰임!)
		for(int i=0; i<number.length; i++) {
			number[i] = (int)(Math.random()*10);
			System.out.print(number[i]+" ");
		}
		
		System.out.println("\n=================================");
		
		for(int i=0; i<number.length; i++) {
			
			boolean changed = false;  //자리 바뀜이 발생했는지 체크
			
			//자리를 바꿈 처리
			for(int j=0; j<number.length-1-i;j++) {
				//왼쪽 인덱스의 값과 오른쪽 인덱스의 값을 비교하고,
				if(number[j]>number[j+1]) {
					//왼쪽 값이 크면 자리 변경
					int temp = number[j];
					number[j] = number[j+1];
					number[j+1] = temp;
					
					changed = true;
				}
				
			}
			
			if(!changed) {
				break;
			}
			for(int k :number) {
				System.out.print(k+" ");
			}
			System.out.println();
		}

	}

}