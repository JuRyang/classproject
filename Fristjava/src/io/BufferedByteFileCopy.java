package io;

import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedByteFileCopy {
	
	public static void main(String[] args) throws IOException {
		                                   //bData = in.read();하니까 바뀜 (while문)
		                                   //throws FileNotFoundException
		    //파일을 읽어올 대상 InputStream (추성클래스)인스턴스를 생성 하위 FileInputStream
			InputStream in = new FileInputStream("org.pdf");
			//출력 대상 파일의 OutStream 인스턴스 생성
			OutputStream out = new FileOutputStream("org_copy.pdf"); 
			//해당 경로의 파일이 존재하지 않으면 파일을 생성해서  write출력한다.
			//해당 경로에 파이링 존재하면 덮어쓴다.
	
			//필터스트림 인스턴스 생성
			BufferedInputStream bin = new BufferedInputStream(in,1024*3);
			BufferedOutputStream bout = new BufferedOutputStream(out,1024*3);
			
			int copyByte=0; //복사한 사이즈 
			int bData=0;    //원본에서 복사한 byte 사이즈의 데이터 
			
			//byte[] buf = new byte[1024]; // 1kb버퍼 생성
			//int readLength = 0;
			
			System.out.println("복사를 시작합니다.");
			
			
			while(true) {
		
			//	readLength = in.read(buf); //더 이상 가져올 데이터가 없으면 -1을 반환
				bData = in.read(); //더 이상 가져올 데이터가 없으면 -1을 반환,배열 없이, 버퍼 없이 받는거
				
			//	if(readLength ==1) { 
				if(bData ==1) { 
					break;
				}
				out.write(bData);  //출력: 파일에 바이터리 코드를 쓴다.
			//	out.write(buf,0,readLength);
			//	copyByte += readLength;
				copyByte ++;
				
			}
			
			in.close(); // 스트림 인스턴스 소멸 시켜준다
			out.close();
			System.out.println("복사가 완료되었습니다.");
			System.out.println("복사된 사이즈: "+copyByte+"byte");
		
}

}