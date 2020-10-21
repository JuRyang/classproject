package ver06;

import java.util.Scanner;

public class MenuException extends Exception {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		try {
			square(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자가 아닙니다.");
		}
	}


private static void square(String s) throws NumberFormatException{
	int n= Integer.parseInt(s);
	System.out.println(n*n);
}
}
