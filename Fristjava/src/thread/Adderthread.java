package thread;

public class Adderthread  extends Sum implements Runnable {

	int start;
	int end;
	
	Adderthread(int n1,int n2){
		start =n1;
		end=n2;
	}

	
	@Override
	public void run() {
		for(int i=0; i<=100; i++) {
		addNum(i);
		
	}
	

	}
	
}
