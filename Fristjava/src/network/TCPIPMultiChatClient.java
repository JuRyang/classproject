package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPIPMultiChatClient {

	public static void main(String[] args) {
		
		
		
		//Socket 연결
		try {
			
			String serverIP = "192.168.0.24"; //localhost -> 호스트 자신의 주소 (앞으로 웹 할때 이렇게 설정할때 많음 기억해두기)
			Socket socket = new Socket(serverIP,7777);
			
			//메시지를 받는 쓰래드
			Thread receiver = new ClientReceiver(socket);
			//메시지를 보내는 쓰래드
			Thread sender = new ClientSenderThread(socket,"집에 가고싶당");
			
			sender.start();
			receiver.start();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class ClientSenderThread extends Thread{
	
	//보내기 쓰래드는 Socket,OutPutStream, name
	
	Socket socket;
	DataOutputStream out;
	String name;
	
	public ClientSenderThread(Socket s, String name) {
		this.socket= s;
		
		try {
			
			
			out=new DataOutputStream(s.getOutputStream());
			this.name=name;

		} catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		
		Scanner sc = new Scanner(System.in);
		 
		try {
		//접속하면 바로 이름을 서버에 전송
		if(out !=null) {
				out .writeUTF(name);
		}
			while(out!=null) {
				out.writeUTF("["+name+"]"+sc.nextLine());
		
		}
			
		} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
	}


class ClientReceiver extends Thread{
	//메시지를 받아서 콘솔에 출력해주는 것 
	//Socket, InpitStream
	
	Socket socket;
	DataInputStream in;
	
	
	public ClientReceiver(Socket socket) {
		this.socket = socket;
		try {
		in = new DataInputStream(socket.getInputStream());
	}catch (IOException e) {
		
		e.printStackTrace();
	}
	}	

	



	@Override
	public void run() {
		while(in !=null) 
		try{
			System.out.println(in.readUTF());
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
	










	
	
	
