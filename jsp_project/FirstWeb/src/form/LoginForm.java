package form;


//전송되는 데이터를 저장하는 beans 정의
public class LoginForm {
	
	

		private String id; //사용자 아이디
		private String pw; //사용자 비밀번호
		
		//기본생성자
		public LoginForm() {
			
		}

		public LoginForm(String id, String pw) {
			this.id = id;
			this.pw = pw;
		}

		//변수들의 getter, setter 
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPw() {
			return pw;
		}

		public void setPw(String pw) {
			this.pw = pw;
		}

		@Override
		public String toString() {
			return "LoginForm [id=" + id + ", pw=" + pw + "]";
		}
		
		
		
	}


