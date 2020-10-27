package thread;

public class Sum {
	
	int num;
	
	Sum(){
		num=0;
	}

	synchronized void addNum(int n) {  //synchronized  동시 접근 막음
		num+=n;
	}
	
    int getNum() {
		return num;
	}
}
