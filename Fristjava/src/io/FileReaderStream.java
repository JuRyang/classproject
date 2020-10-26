package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderStream {

	public static void main(String[] args) throws IOException {
		
		char[] cbuf = new char[10];
		
		int readCnt=0;
		
		Reader in = new FileReader("paper.txt");
		
		//cbuf에 받을거고 0부터 길이만큼 읽겠다
		readCnt =in.read(cbuf, 0, cbuf.length);
		
		//toString 하게 되면 문자열로 받게 된다.
		System.out.println(new String(cbuf));
		
		in.close();

	}

}
