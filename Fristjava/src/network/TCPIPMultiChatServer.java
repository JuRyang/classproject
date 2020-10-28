package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TCPIPMultiChatServer {
	
	//접속 사용자 정보를 저장: 메시지를 전체에게 보내기 위해서
	//저장 정보: name,outputStream
	//Map<String, Object>
	HashMap<String, Object> clients;
	
	public TCPIPMultiChatServer() {
		clients = new HashMap<String, Object>();
		Collections.synchronizedMap(clients);  //쓰래드 동기화에 안전하게 사용하도록 해주는 메서드 synchronizedMap
	}

	public void start() throws IOException {
		
		//ServerSocket실행
		//사용자의 요청이 있으면 Socket을 생성해서 
		// 연결 -> clients 사용자 정보를 저장해줘야 함. -> 쓰래드로 처리
		//왜 쓰래드로?? 쓰래드를 안 만들면 대기시간이 길다.동시에 처리하면 시간 절약
		
		//서버소켓 생성
	
			ServerSocket serverSocket = new ServerSocket(7777);
			System.out.println("Chattin server Start...!!");
			
			Socket socket = null;
			
			while(true) {
			//요청이 들어올때까지 대기...요청이 들어오면 새로운socket을 생성해서 반환
			socket = serverSocket.accept();
			//map에 정보저장, 접속한 사용자들에게 메시지를 전송
			
			System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]사용자 접속");
				
			ServerReceiver receiver = new ServerReceiver(socket);
			receiver.start();
			}
	
	}
	
	void sendToAll(String msg) {
		//일괄 처리 , Map은 순서가 없다 -> Map이 가지고 있는 Key를 Set으로 만들자 (키값만 셋)
		Set<String> keys = clients.keySet(); //set은 줄세울 수 있음
		Iterator<String> itr = keys.iterator();
		
		while(itr.hasNext()) {
			DataOutputStream out = (DataOutputStream)clients.get(itr.hasNext());//전송할 메세지를 만들고 있는거 DataOutputStream으로 저장??
		
		try {
			out.writeUTF(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
	
	//내부클래스 (이벤트처리 할때 많이 쓰임 , 안드로이드) : 데이터 받아서 메시지 저장하고, 메시지 전체 발송
	class ServerReceiver extends Thread{
		//socket,InputStream,OutputStream
		Socket socket;
		DataOutputStream out;
		DataInputStream in;
		public ServerReceiver(Socket socket) {
			super();
			this.socket = socket;
			
			try {
				in = new DataInputStream(socket.getInputStream());
				out= new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			
			String name =null; //접속한 사용자의 이름
			
			try {
				name = in.readUTF();    //이름을 스트림을 통해 받는다.
				clients.put(name,out);  //Map에 사용자 정보저장.
				sendToAll(">>>>>>>>"+name+"님이 접속하셨습니다.");//내부 클래스는  아웃터 클래스의 멤버를 참조할 수 있다.(변수도 메서드도 참조 가능)
			
				while(in !=null) {
					sendToAll(in.readUTF());
				}
			
			
			
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				clients.remove(name);
				System.out.println(name+"님이 나가셨습니다.");
			}
			
			
			
		}
	}
	
	

	
	public static void main(String[] args) throws IOException {
		new TCPIPMultiChatServer().start();//인스턴스 생성  스타트 메서드
	
	}
	
	
	
}
